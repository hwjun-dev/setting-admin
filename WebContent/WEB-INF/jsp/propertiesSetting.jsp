<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Properties 설정</title>
</head>
<body>
<h2>Properties 설정</h2>
<div>
<table border="1" style="border-collapse: collapse;">
<tr>      
	<td>KEY</td>
	<td>VALUE</td>
	<td></td>
</tr>
<c:forEach items="${list}" var="list">
      <c:forEach var="entry" items="${list}" varStatus="status">
	    <tr>
	      <form action="" method="post">
		      <td><input readonly name="key" type="text" size="30" value="${entry.key}" style="border:none"/></td>
		      <td><input name="value" type="text" size="80" value="${entry.value}"/></td>
		      <td><input type="submit" value="저장"/></td>
	      </form>
	    </tr>
	  </c:forEach>
</c:forEach>
</table>
</div>
${result}
</body>
</html>