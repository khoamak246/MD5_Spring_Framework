<%--
  Created by IntelliJ IDEA.
  User: khoam
  Date: 2023-04-19
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Show setting</h1>
languages: ${showSetting.languages} <br>
Page Size: ${showSetting.pageSize}<br>
Spam Filter: ${showSetting.spamFilter ? "Yes" : "No"}<br>
Signature: ${showSetting.signature}

</body>
</html>
