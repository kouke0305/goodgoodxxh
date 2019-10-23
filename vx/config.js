/**
 * 小程序配置文件
 */
// var host = 'http://yusu.rw.srong.shop/wxbackend';

var host = 'http://127.0.0.1:8080';
// var host = 'https://wgff.utools.club';

var config = {

  service: {
    host,
    // 登录地址，用于建立会话
    loginUrl: `${host}/weapp/login`,

    // 测试的请求地址，用于测试会话
    requestUrl: `${host}/weapp/auth/getUser`,

    // 测试的信道服务地址
    tunnelUrl: `${host}/weapp/tunnel`,

    // 上传图片接口
    uploadUrl: `${host}/weapp/file/upload`
  }
};

module.exports = config;