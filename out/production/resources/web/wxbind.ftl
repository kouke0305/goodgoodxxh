<!DOCTYPE html>
<html>

<head>
 <!-- Standard Meta -->
 <meta charset="utf-8" />
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
 <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
 <!-- Site Properties -->
 <title>账户绑定</title>
 <script src="https://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>
 <!-- head 中 -->
 <link rel="stylesheet" href="https://cdn.bootcss.com/weui/1.1.3/style/weui.min.css">
 <link rel="stylesheet" href="https://cdn.bootcss.com/jquery-weui/1.2.1/css/jquery-weui.min.css">
</head>

<body>


<div class="weui-cells weui-cells_form" style="margin-top: 0px">

 <input type="hidden" name="openid" id="openid" value="${openid}">

 <div class="weui-cell">
  <div class="weui-cell__hd"><label class="weui-label">手机号：</label></div>
  <div class="weui-cell__bd">
   <input class="weui-input" type="text" name="phone" id="phone" placeholder="请输入手机号">
  </div>
 </div>

 <div class="weui-cell">
  <div class="weui-cell__hd"><label class="weui-label">绑定码：</label></div>
  <div class="weui-cell__bd">
   <input class="weui-input" type="text" name="bcode" id="bcode" placeholder="请输入绑定码">
  </div>
 </div>

 <button class="weui-btn weui-btn_primary" type="button" onclick="bind()">绑定</button>
</div>

<div class="weui-footer">
 <p class="weui-footer_fixed-bottom">Copyright © 2019 济南奥维信息科技有限公司</p>
</div>

</body>
<script type="text/javascript">
 function bind(){
  var openid = $("#openid").val();
  var phone = $("#phone").val();
  var bcode = $("#bcode").val();
  $.ajax({
   type: "get",
   url: "http://jiabao.jnaw.top/backend/wxlogin/bind",
   data: {openid:openid,phone:phone,bcode:bcode},
   contentType: "application/json",
   dataType: "json",
   success: function (data)
   {
    if (data.success)
    {
     alert("绑定成功");
    }else{
     alert(data.data);
    }
   },
   error: function (err)
   {
    alert("绑定失败");
   }
  });
 }
</script>
<!-- body 最后 -->
<#--<script src="https://cdn.bootcss.com/jquery/1.11.0/jquery.min.js"></script>-->
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-weui/1.2.1/js/jquery-weui.min.js"></script>
</html>