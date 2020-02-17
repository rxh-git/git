<%@ page import="entity.MeetingRoom" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 86151
  Date: 2020/2/16
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<%
    List<MeetingRoom> list=(List<MeetingRoom>)request.getAttribute("list");
    if (list==null){
        response.sendRedirect("Servlet?opr=addquery");
        return;
    }
%>
<body>
<table border="1px" style="border: black solid 1px; text-align: center">
    <form action="Servlet?opr=add" method="post">
        <tr><td colspan="3" style="">会议室预定</td></tr>
        <tr>
            <td>会议室 ：</td>
            <td colspan="2" style="text-align: left"><select name="" id="">
                <c:forEach items="${list}" var="temp" varStatus="status">
                    <option value="${temp.meeting_name}" name="meeting_name">${temp.meeting_name}</option>
                </c:forEach>
            </select></td></tr>
        <tr>
            <td>申请人：</td>
            <td colspan="2" style="text-align: left"> <input type="text" name="advance_name"></td>
        </tr>
        <tr>
            <td>预定日期：</td>
            <td><input type="text" name="meeting_order"></td>
            <td>日期格式：yyyy-mm-dd</td>
        </tr>
        <tr><td colspan="3"><input type="submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="重置"></td></tr>
    </form>
</table>
</body>
</html>
