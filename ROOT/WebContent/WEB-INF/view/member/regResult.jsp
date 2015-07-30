<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="color: #D4F4FA">
	<h2>회원가입 결과</h2>
	<c:choose>
		<c:when test="${result  eq true}">
			가입되었습니다.	
		</c:when>
		<c:otherwise>
			가입되지 않았습니다.
		</c:otherwise>
	</c:choose>
</div>
