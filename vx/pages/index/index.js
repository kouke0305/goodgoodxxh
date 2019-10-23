var config = require('../../config')
var util = require('../../utils/util.js')

Page({
  data: {
    //判断小程序的API，回调，参数，组件等是否在当前版本可用。
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    isHide: false
  },

  onLoad: function () {
    var that = this;
    // 查看是否授权
    wx.getSetting({
      success: function (res) {
        if (res.authSetting['scope.userInfo']) {
          wx.getUserInfo({
            success: function (res) {
              // 判断session 是否过期
              // wx.checkSession({
              //   success: () => {//如果成功并过期了,走if,如果成功没过期,走else,授权时走过一遍已经又skey了,所以不走了
              //     that.login();
              //   },
              //   fail: () => {
              //     that.login();
              //   }
              // });
              that.login();
              console.log("程序加载！")
            }
          });
        } else {
          // 用户没有授权
          // 改变 isHide 的值，显示授权页面
          that.setData({
            isHide: true
          });
        }
      }
    });
  },

  bindGetUserInfo: function (e) {
    if (e.detail.userInfo) {
      //用户按了允许授权按钮
      var that = this;
      // 获取到用户的信息了，打印到控制台上看下
      console.log("用户的信息如下：");
      console.log(e.detail.userInfo);
      wx.setStorageSync('nickName', e.detail.userInfo.nickName);
      // 判断session 是否过期
      wx.checkSession({
        success: () => {
          if (!wx.getStorageSync("sKey")) {
            that.login();
            console.log("过期了")
          }
        },
        fail: () => {
          console.log("没过期")
          that.login();
        }
      });
    } else {
      //用户按了拒绝按钮
      wx.showModal({
        title: '警告',
        content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
        showCancel: false,
        confirmText: '返回授权',
        success: function (res) {
          // 用户没有授权成功，不需要改变 isHide 的值
          if (res.confirm) {
            console.log('用户点击了“返回授权”');
          }
        }
      });
    }
  },

  // 微信登录
  login: function () {
    console.log("我到登陆了")
    let that = this;
    wx.login({
      success: res => {
        util.requestPromise({
          url: config.service.loginUrl,
          method: "GET",
          data: {
            code: res.code
          },
        }).then(res => {
          console.log("userid", res.data.data.userid)
          wx.setStorageSync("sKey", res.data.data.skey);
          wx.setStorageSync("userid", res.data.data.userid);
          if (res.data.data.userid == 0) {
            wx.redirectTo({
              url: '../binding/binding'
            })
          } else {
            that.getUserInfo();
            // that.getlocatin();
          }
        }).catch(err => {
          console.log(err)
        })
        console.log("res", res)
      }
    });
  },

  // 获取用户资料 //分绑定之后获取,和没绑定获取
  getUserInfo: function () {

    console.log("userid", wx.getStorageSync('userid'))
    util.requestPromise({
      url: config.service.host + '/weapp/getUserInfo',
      method: "GET",
      data: {
        userid: wx.getStorageSync('userid')
      }
    }).then(res => {
      console.log("res", res)
      wx.setStorageSync("user", res.data.data);
      wx.reLaunch({
        url: '../my/my'
      })
    }).catch(err => {
      console.log(err)
    })
  }
})