<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 로그인 전 -->
<c:if test="${sessionScope.log eq null }">
<div style="color: #FFFFFF; background-color: #FFA7A7">
	<form action="/mem/log.it" method="post">
	<table style="width: 100%;" border="1">
		<tr>
			<td rowspan="3" width="680"><h1 style="color: #FFFFFF">Header - login</h1></td>
		</tr>
		<tr>
			
			<td style="color: #FFFFFF">ID :</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td style="color: #FFFFFF">PASSWORD : </td>
			<td><input type="password" name="pass" /></td>
			<td><input type="submit" value="로그인"/></td>
		</tr>
	</table>
	</form>
</div>
</c:if>
<!-- 로그인 후 -->
<c:if test="${sessionScope.log ne null }">
	<div style="color: #FFFFFF; background-color: #FFA7A7">
	<table style="width: 100%;" border="1">
		<tr>
			<td rowspan="3" width="680"><h1 style="color: #FFFFFF">Header - login</h1></td>
		</tr>
		<tr>
			<td style="color: #FFFFFF">${log.id }님 로그인중</td>
			<td><input type="button" value="로그아웃" onclick="location.href='/mem/logout.it'"/></td>
		</tr>
	</table>
</div>
</c:if>