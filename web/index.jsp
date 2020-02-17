<%@ page import="java.util.List" %>
<%@ page import="entity.MeetingRoom" %><%--
  Created by IntelliJ IDEA.
  User: 86151
  Date: 2020/2/16
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <%
    List<MeetingRoom> list=(List<MeetingRoom>)request.getAttribute("list");
    if (list==null){
      response.sendRedirect("Servlet?opr=query");
      return;
    }
  %>
  <body>
<div style="margin: 0px auto">
  <table border="1px" style="border: black solid 1px">
    <tr><td>预定编号</td>
      <td>会议室</td>
      <td>预定人</td>
      <td>预定日期</td></tr>
    <c:forEach items="${list}" var="temp" varStatus="status">
      <tr <c:if test="${status.index%2==1}">style="background: darkgrey;" </c:if>>
        <td>${temp.id}</td>
        <td>${temp.meeting_name}</td>
        <td>${temp.advance_name}</td>
        <td>${temp.meeting_order}</td></tr>
    </c:forEach>
  </table>
  <a href="add.jsp">添加预定</a>
</div>
  </body>
</html>
