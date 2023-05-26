<%--
  Created by IntelliJ IDEA.
  User: khoam
  Date: 2023-04-18
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculate</h1>
<form id="calculateForm" action="" method="post">
    Num 1: <input type="text" name="num1">
    Num 2: <input type="text" name="num2">
    <input type="submit" value="addition (+)" formaction="addition">
    <input type="submit" value="subtraction (-)" formaction="subtraction">
    <input type="submit" value="multiplication (X)" formaction="multiplication">
    <input type="submit" value="division (/)" formaction="division">
</form>
</body>
</html>
