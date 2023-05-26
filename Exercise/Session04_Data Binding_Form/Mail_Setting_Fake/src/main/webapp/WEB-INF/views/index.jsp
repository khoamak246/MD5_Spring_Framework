<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Setting</h1>
<form:form action="/setSetting" method="post" modelAttribute="setting" id="settingForm">
    <table>
        <tr>
            <td>
                <form:label path="languages"> languages: </form:label>
            </td>
            <td>
                <form:select path="languages">
                    <form:option value="English"/>
                    <form:option value="Vietnamese"/>
                    <form:option value="Japanese"/>
                    <form:option value="Chinese"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="pageSize">Page Size:</form:label>
            </td>
            <td>
                Show 
                <form:select path="pageSize">
                    <form:option value="5"/>
                    <form:option value="10"/>
                    <form:option value="15"/>
                    <form:option value="25"/>
                    <form:option value="50"/>
                    <form:option value="100 "/>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td><form:checkbox path="spamFilter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
            <td><input type="button" value="Cancel" onclick="document.getElementById('settingForm').reset()"></td>
        </tr>
    </table>

</form:form>


</body>
</html>