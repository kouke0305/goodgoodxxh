var config = require('../../config.js')
var util = require('../../utils/util.js')
Page({
  /**
   * 页面的初始数据
   */
  data: {
    phone: '',//手机号
    code: '',//验证码
    iscode: null,//用于存放验证码接口里获取到的code
    codename: '获取验证码',
    username: wx.getStorageSync('nickName')
  },
  //获取input输入框的值
  getPhoneValue: function (event) {
    this.setData({
      phone: event.detail.detail.value
    })
  },
  getCodeValue: function (event) {
    this.setData({
      code: event.detail.detail.value
    })
  },
  getCode: function () {
    console.log(this.data)
    var a = this.data.phone;
    var _this = this;
    var myreg = /^(14[0-9]|13[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$$/;
    if (this.data.phone == "") {
      wx.showToast({
        title: '手机号不能为空',
        icon: 'none',
        duration: 1000,
      })
      return false;
    } else if (!myreg.test(this.data.phone)) {
      wx.showToast({
        title: '请输入正确的手机号',
        icon: 'none',
        duration: 1000,
      })
      return false;
    } else {
      var num = 61;
      var timer = setInterval(function () {
        num--;
        if (num <= 0) {
          clearInterval(timer);
          _this.setData({
            codename: '重新发送',
            disabled: false
          })

        } else {
          _this.setData({
            codename: num + "s",
            disabled: true
          })
        }
      }, 1000)
      wx.request({
        'url': config.service.host + '/weapp/sendSMS',
        data: {
          phone: this.data.phone,
        },
        success(res) {
          console.log("返回验证码", res.data.data)
          _this.setData({
            iscode: res.data.data
          })
        }
      })
    }
  },
  //获取验证码
  getVerificationCode() {
    console.log("获取验证码")
    this.getCode();
    var _this = this
    _this.setData({
      disabled: false
    })
  },
  //提交表单信息
  onBinding: function () {
    var myreg = /^(14[0-9]|13[0-9]|15[0-9]|17[0-9]|18[0-9])\d{8}$$/;
    if (this.data.phone == "") {
      wx.showToast({
        title: '手机号不能为空',
        icon: 'none',
        duration: 1000
      })
      return false;
    } else if (!myreg.test(this.data.phone)) {
      wx.showToast({
        title: '请输入正确的手机号',
        icon: 'none',
        duration: 1000
      })
      return false;
    }
    if (this.data.code == "") {
      wx.showToast({
        title: '验证码不能为空',
        icon: 'none',
        duration: 1000
      })
      return false;
    } else if (this.data.code != this.data.iscode) {
      wx.showToast({
        title: '验证码错误',
        icon: 'none',
        duration: 1000
      })
      return false;
    } else {
      console.log("登陆:" + wx.getStorageSync('nickName'))
    util.requestPromise({
      url: config.service.host + '/weapp/bindingUserCode',
      method: "GET",
      data: {
        phone: this.data.phone,
        username: wx.getStorageSync('nickName')
      },
    }).then(res => {
      console.log("res", res)
      if(res.data.data!=0){
        util.showSuccess("绑定成功");
        wx.setStorageSync("userid", res.data.data);
        this.getUserInfo();
        wx.reLaunch({
          url: '../my/my'
        })
      }else{
        util.showModel("绑定失败","请检查手机号或绑定码是否正确")
      }
    }).catch(err => {
      console.log(err)
    })
    }
  },



  //获取用户信息
  getUserInfo: function () {
    util.requestPromise({
      url: config.service.host + '/weapp/getUserInfo',
      method: "GET",
      data: {
        userid: wx.getStorageSync('userid')
      }
    }).then(res => {
      console.log("getUserInfo_res", res)
      wx.setStorageSync("user", res.data.data);
    }).catch(err => {
      console.log(err)
    })
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
