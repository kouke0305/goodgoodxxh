var util = require('../../utils/util.js')
var config = require('../../config.js')
const app = getApp();
var QRCode = require('../../utils/weapp-qrcode.js')

// 300rpx 在6s上为 150px


Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: [],
    result: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    that.setData({
      list: [],
      // result: ['a', 'b']
    });
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


  onChange(event) {
    let that = this;
    this.setData({
      result: event.detail
    });
  },

// 我要补奶复选框选择
  // toggle(event) {
  //   const { name } = event.currentTarget.dataset;
  //   const checkbox = this.selectComponent(`.checkboxes-${name}`);
  //   checkbox.toggle();
  // },
  // noop() { },

  handleClick: function (e) {
    let that = this;
    var id = that.data.id;
    var tu = that.data.id

    wx.navigateTo({
      url: '/pages/QRcode/QRcode?id=' + 2 + "&tu=" + 'a.jpg'
    });
    // let result = that.data.result;
    // that.setData({
    //   show: true
    // });
    // var qrcode = new QRCode('canvas', {
    //   text: "佳宝高钙奶 3瓶",
    //   width: 150,
    //   height: 150,
    //   colorDark: "#000000",
    //   colorLight: "#ffffff",
    //   correctLevel: QRCode.CorrectLevel.H,
    // });
    // qrcode.makeCode(e.target.dataset.code); //用元素对应的code更新二维码

  },


  getOrders: function (active) {
    let that = this;
    let curpage = null;
    if (active == 0) {
      util.requestPromise({

        url: "https://rw.srong.shop/wxuser/orderlist",
        method: "GET",
        data: {
          phone: 13173044213
        }
      }).then(res => {
        console.log("res", res)
        that.setData({
          list: res.data.data,
          unsureHasMoreData: (res.data.data.length < that.data.pageSize ? false : true)
        })
      }).catch(err => {
        console.log(err)
      })
    }
  },

})