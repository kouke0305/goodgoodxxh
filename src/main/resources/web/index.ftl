<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>佳宝分单系统</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="/Semantic/semantic.min.css">
    <link rel="stylesheet" type="text/css" href="/site/custom.css">
    <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=F4FGjTpeFwoiPKHRprOtTKcWB8ueMDWg"></script>
    <!--加载百度地图鼠标绘制工具-->
    <script type="text/javascript" src="https://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
    <link rel="stylesheet" href="https://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
    <link rel="stylesheet" href="/Semantic/semantic-ui-calendar/calendar.min.css">
</head>

<body>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script src="/Semantic/semantic.min.js"></script>
<!-- 自定义js -->
<script type="text/javascript" src="/hrframe/js-yaml.min.js"></script>
<script type="text/javascript" src="/hrframe/hrframe.js"></script>
<script type="text/javascript" src="/hrframe/template-web.js"></script>
<!--分页-->
<script type="text/javascript" src="/hrframe/extendPagination.js"></script>
<script src="/site/index.js"></script>
<script src="/Semantic/semantic-ui-calendar/calendar.js" ></script>

</body>
<script type="text/javascript">
    $(document).ready(function() {
        var errorMsg = "${errorMsg!}";
        var successMsg = "${successMsg!}";
        console.log(successMsg);
        console.log(errorMsg);
    })
</script>

</html>