var util = require('../../utils/util.js')
var config = require('../../config.js')

const W = wx.getSystemInfoSync().windowWidth;
const rate = 750.0 / W;

// 300rpx 在6s上为 150px
const qrcode_w = 300 / rate;

var QRCode = require('../../utils/weapp-qrcode.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    active: 0,
    show: false,
    avatarUrl: null,
    nickName: null,
    logged: false,
  },
  onChange(event) {
  },

  // 用户授权登录
  doLogin: function (e) {
    let _this = this
    util.showBusy('正在获取')

    _this.setData({
      logged: true,
      avatarUrl: e.detail.userInfo.avatarUrl,
      nickName: wx.getStorageSync('user').name,

    })
    util.showSuccess("获取成功");

  },

  onLoad: function (options) {
    let _this = this;
    wx.getStorage({
      key: 'user',
      success: function (res) {
        _this.setData({
          nickName: res.data.name,
          roleid: (wx.getStorageSync('user').roleid),
        })
      },
    })
    // 查看是否授权
    wx.getSetting({
      success(res) {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称
          wx.getUserInfo({
            success(res) {
              console.log('wx.getUserInfo', res.userInfo)
              _this.setData({
                logged: true,
                avatarUrl: res.userInfo.avatarUrl
              })
            }
          })
        }
      }
    })
  },

//我要停止
  stopOrder:function(a) {
    wx.navigateTo({
      url: "/pages/my-contact/my-contact"
    })
  }, 
  // 我要取奶
  acceptOrder: function (a) {
    wx.navigateTo({
      url:"../takeMilk/takeMilk"
    })
  }, 
  // 我的订单
  myOrder: function (a) {
    wx.navigateTo({
      url: "../myOrder/myOrder"
    })
  },

  //获取补奶
  fillMilk: function (a) {
    let that = this;
    wx.navigateTo({
      url: "../fillMilk/fillMilk"
    })
  },

  contactUs:function(a){
    wx.navigateTo({
      url: "../my-contact/my-contact"
    })
  },

  //左上角的返回按钮事件
  closePop(e) {
    let that = this;
    that.setData({
      show: false
    })
  },





  // 菜单切换
  onToBarChange: function (event) {
    let pageurl = null;
    switch (event.detail) {
      case 0:
        pageurl = "../myOrder/myOrder"
        break;
    }
    wx.redirectTo({
      url: pageurl
    })
  }
})