<!DOCTYPE html>
<html>

<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <!-- Site Properties -->
    <title>佳宝专送分单系统登录</title>
    <link rel="stylesheet" type="text/css" href="/Semantic/semantic.min.css">

    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script src="/Semantic/semantic.min.js"></script>
    <script src="https://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>

    <style type="text/css">
        body {
            background-color: #DADADA;
            background-image: url('http://www.jiabaoruye.com.cn/img/three.jpg')
        }

        body>.grid {
            height: 100%;
        }

        .image {
            margin-top: -100px;
        }

        .column {
            max-width: 450px;
        }
    </style>
</head>

<body>
<div class="ui middle aligned center aligned grid">
    <div class="column">
        <h2 class="ui black image header">
            <img src="/img/logo_zong.png" class="image">
            <div class="content">
                佳宝专送分单系统
            </div>
        </h2>

        <div class="ui  segment">
            <div id="login_container"></div>
        </div>
        <#--<div class="ui message">-->
        <#--使用历史账号登录?-->
        <#--</div>-->
    </div>
</div>
<script>
    var obj = new WxLogin({
        self_redirect: false,
        id: "login_container",
        appid: "wx8d7cae0acebfa17a",
        scope: "snsapi_login",
        redirect_uri: encodeURI("https://jiabao.jnaw.top/getUserInfo"),
        //redirect_uri: encodeURI("http://127.0.0.1:8080/getUserInfo"),
        state: "2019",
        style: "black",
        href: ""
    });
</script>
</body>

</html>