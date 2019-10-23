//app.js
var config = require('./config')
var util = require('./utils/util.js')


App({
  onLaunch: function () {
    
    let that = this;
    // 判断session 是否过期
    // wx.navigateTo({
    //   url: 'pages/index/index'
    // })

    // wx.checkSession({
    //   success: () => {
    //     if (!wx.getStorageSync("sKey")) {
    //       // that.login();
    //     }
    //   },
    //   fail: () => {
    //     // that.login();
    //   }
    // });
    // console.log("程序加载！")

  },

  // // 获取位置坐标
  // getlocatin: function () {
  //   // 获取经纬度坐标
  //   setInterval(function () {
  //     wx.getLocation({
  //       type: 'wgs84',
  //       success(res) {
  //         util.requestPromise({
  //           url: config.service.host + '/employee/updateEmpCoord',
  //           method: "GET",
  //           data: {
  //             empid: wx.getStorageSync('empid'),
  //             coord: res.latitude + "," + res.longitude
  //           }
  //         }).then(res => {
  //           console.log(res)
  //         })
  //       }
  //     })
  //   }, 600000)
  // },

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
      wx.setStorageSync("user", res.data.data);
    }).catch(err => {
      console.log(err)
    })
  },

  // 微信登录
  login: function () {
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
          console.log("将skey与绑定状态userid存储到Storage...")
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
  globalData: {
    userInfo: null,
    khname: null,
    khphone: null,
    jbosscid: null
  }
})
