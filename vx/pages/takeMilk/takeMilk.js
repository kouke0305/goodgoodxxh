var util = require('../../utils/util.js')
var config = require('../../config.js')
var QRCode = require('../../utils/weapp-qrcode.js')
const app = getApp();
const W = wx.getSystemInfoSync().windowWidth;
const rate = 750.0 / W;
// 300rpx 在6s上为 150px
const qrcode_w = 300 / rate;
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id:1,
    list:[],
    current: [],
    position: 'right',
    animal: '熊猫',
    checked: false,
    disabled: false,
    qrcodes : ""
  },
  handleFruitChange({ detail = {} }) {
    const index = this.data.current.indexOf(detail.value);
    index === -1 ? this.data.current.push(detail.value) : this.data.current.splice(index, 1);
    // console.log(this.data.current)
    this.setData({
      current: this.data.current
    });

    // console.log(this.data)
  },
  handleClick() {
    this.setData({
      position: this.data.position.indexOf('left') !== -1 ? 'right' : 'left',
    });
  },
  handleDisabled() {
    this.setData({
      disabled: !this.data.disabled
    });
  },
  handleAnimalChange({ detail = {} }) {
    this.setData({
      checked: detail.current
    });
},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    util.requestPromise({
      url: "https://rw.srong.shop/wxuser/orderlist",
      method: "GET",
      data: { phone: 17753106807}
    }).then(res => {
      console.log("res", res)
      that.setData({
        list: res.data.data,
      })
    }).catch(err => {
      console.log(err)
    }) 
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.setData({
      pitch: "未选中"
    })
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    console.log('订单列表页面显示')
    let that = this;
    // that.getOrders(0);
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
    this.setData({
      result: event.detail
    });
  },

  //生成二维码
  generateCode: function (e) {
    let that = this;
    var id = that.data.id;
    // var dataArr = that.data.current;
    // var aaaaa = res.data.data;
    let arr = [];
    console.log(that.data.current)
    for (var i = 0; i < that.data.current.length;i++){
      var numbers = that.data.current[i].substring(3);
      var number = {'snumber':numbers}
      arr.push(number)
      // console.log(numbers)
    }
    console.log(arr)

    let curpage = null;
    util.requestPromise({
      url: "https://rw.srong.shop/takemilk/takemilk/geneQrcode",
      method: "GET",
      data: { qrcodeString: arr }
    }).then(res => {
    that.setData({
      
    },
    console.log(res.data));
    var qrcodes=res.data.data;
    
    //二维码
    var qrcode = new QRCode('canvas', {
      text: res.data.data,
      width: qrcode_w,
      height: qrcode_w,
      colorDark: "#000000",
      colorLight: "#ffffff",
      correctLevel: QRCode.CorrectLevel.H,
    });
    // qrcode.makeCode('http://www.daqianduan.com/?p=6518&preview=true')
    qrcode.makeCode(res.data.data); //用元素对应的code更新二维码

      if (qrcodes.length == 0) {
        console.log("没有数据")
      } else {
        wx.navigateTo({
          url: '/pages/QRcode/QRcode?id=' + id + "&dataArr=" + qrcodes
        });
      };
    }).catch(err => {
      console.log(err)
    });

   
  },
})
