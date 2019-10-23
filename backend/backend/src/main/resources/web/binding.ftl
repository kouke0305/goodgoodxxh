<!DOCTYPE html>
<html>

<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <!-- Site Properties -->
    <title>佳宝专送分单系统账户绑定</title>
    <link rel="stylesheet" type="text/css" href="/Semantic/semantic.min.css">

    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
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
        <h2 class="ui teal image header">
            <img src="/img/logo_zong.png" class="image">
            <div class="content">
                绑定账户
            </div>
        </h2>
        <form class="ui large form" method="post" action="/backend/binding" role="form">
            <div class="ui stacked segment">
                <input type="hidden" value= "${openid!}" name="openid">
                <div class="field">
                    <div class="ui left icon input">
                        <i class="user icon"></i>
                        <input type="phone" name="phone" placeholder="手机号">
                    </div>
                </div>
                <div class="field">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <input type="text" name="bcode" placeholder="绑定码">
                    </div>
                </div>
                <button type="submit" class="ui fluid large teal submit button">绑定</button>
            </div>

            <div class="ui error message" id="binding-error-msg" style="display: block"></div>

        </form>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function() {
        var errorMsg = "${errorMsg!}";
        var successMsg = "${successMsg!}";
        console.log("${openid!}")
        if (errorMsg) {
            $("#binding-error-msg").html(errorMsg)
        }

    })
</script>

</body>

</html>