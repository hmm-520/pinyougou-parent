<%--
  Created by IntelliJ IDEA.
  User: huangmeng
  Date: 2019/9/4
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/bootstrap-fileinput/js/fileinput.js"></script>
    <script src="../js/bootstrap-fileinput/js/locales/zh.js"></script>
    <link rel="stylesheet" href="../js/bootstrap-fileinput/css/fileinput.css">
</head>
<body>

<div class="container-fluid">
    <form class="form-horizontal" id="BookForm">
         <div class="form-group">
            <label for="Typename" class="col-sm-2 control-label">
                品牌名称
            </label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="Typename" name="typename"/>
            </div>
        </div>

        <div class="form-group">
        <label for="Brand" class="col-sm-2 control-label">
            品牌首字母
        </label>
        <div class="col-sm-4">
            <input type="text" class="form-control" id="Brand" name="brand"/>
        </div>
        </div>

    </form>
</div>

</body>
<script>


</script>
</html>
