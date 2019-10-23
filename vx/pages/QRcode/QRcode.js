var util = require('../../utils/util.js')
var config = require('../../config.js')
const app = getApp();
var QRCode = require('../../utils/weapp-qrcode.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    var that = this;
    if (options.id=="1"){
      that.setData({                             //this.setData的方法用于把传递过来的id转化成小程序模板语言
        // b_id: options.id,     //id是a页面传递过来的名称，a_id是保存在本页面的全局变量   {{b_id}}方法使用
        // b_tu: options.tu,
      })
      console.log("我是取奶")
    }else{
      console.log("我是补奶")
    }
    var qrcode = new QRCode('canvas', {
      text: options.dataArr,
      width: 150,
      height: 150,
      colorDark: "#000000",
      colorLight: "#ffffff",
      correctLevel: QRCode.CorrectLevel.H,
    });
    // qrcode.makeCode(e.target.dataset.code); //用元素对应的code更新二维码
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

  }
})