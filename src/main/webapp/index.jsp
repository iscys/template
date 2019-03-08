
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head>
    <!--所有的地址会基于此地址进行拼接-->
    <base href="<%=basePath%>">
    <title>点录</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <style type="text/css">
        video {
            position: fixed;
            right:0;
            bottom: 0;
            min-width: 100%;
            min-height: 100%;
            width: auto;
            height: auto;
            z-index: -9999;
            /*灰色调*/
            /*-webkit-filter:grayscale(100%)*/
        }
    </style>
</head>

<body>

<!--autoplay用来使其自动播放，muted用来使其静音，loop为循环播放-->
<video src="http://s3.bytecdn.cn/aweme/resource/web/static/image/index/tvc-v2_30097df.mp4" type="video/mp4" autoplay muted loop class="video-bg" >
    很抱歉，你的浏览器不支持播放视频
</video>
<nav class="navbar  clearFloat my-navbar"    role="navigation">
    <div class="container-fluid" id="navbar">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="color: whitesmoke">Acoustic</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav" id="mytab">
                <li class="" id=""><a href="" style="color: whitesmoke">开始旅程</a></li>
                <li class="" id=""><a href="" style="color: whitesmoke">关于live</a></li>
                <li class="" id="AboutUs"><a style="color: whitesmoke">关于我们</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a  style="color: whitesmoke">登录</a></li>
                <li><a  style="color: whitesmoke">注册</a> </li>

            </ul>
        </div>

    </div>
</nav>
<div class="container my-content" >
    <h1 style="background-color: rgba(255,255,255,0);color: whitesmoke;padding-bottom: 25px";>点录，点滴记录</h1>
    <div style="padding: 15px 50px 10px;">
        <form class="bs-example bs-example-form" role="form">
            <div class="input-group input-group-lg col-lg-6" style="left: 25%">
                <input type="text" class="form-control" placeholder="开启点录！">
                <div class="input-group-btn">
                    <button type="button" class="btn my-btn">GO</button>
                </div>
            </div>
    </div>

</div>

</div>
</footer>
</body>
</html>
