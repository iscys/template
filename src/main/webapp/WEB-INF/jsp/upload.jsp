
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
    <title>Title</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <script src="static/js/jquery.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
    <style type="text/css">

    </style>
</head>

<body>
    <form action="main/upload" method="post" name="Form" id="Form" enctype="multipart/form-data">
        <input type="file" name =file>
        <input type="submit">

    </form>

</body>
</html>
