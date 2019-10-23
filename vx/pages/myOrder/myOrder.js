var util = require('../../utils/util.js')
var config = require('../../config.js')
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    active: 0,
    list: [], //待确认订单
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    console.log('我的订单列表页面显示')
    let that = this;
    that.getOrders(0);
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

   // 获取订单列表
  getOrders: function (active) {
    let that = this;
    let curpage = null;
    if (active == 0) {
      util.requestPromise({
        url: "https://rw.srong.shop/wxuser/orderlist",
        method: "GET",
        data: { phone: 17753106807}
      }).then(res => {
        console.log("res",res)
        // console.log("111")
        // console.log(res.data.data[0].address)
        that.setData({
          list: that.data.list.concat(res.data.data),
          unsureHasMoreData: (res.data.data.length < that.data.pageSize ? false : true)
        },()=>{
          this;
        })
      }).catch(err => {
        // console.log(err)
      })
    }
  },
})