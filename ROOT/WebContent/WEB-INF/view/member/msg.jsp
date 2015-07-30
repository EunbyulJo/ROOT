<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
<c:when test="${result ne null }">
	<font color="red" size="2"> 존재하는 아이디입니다.</font>
</c:when>
<c:otherwise>
	<font color="blue" size="2"> 사용가능한 아이디입니다.</font>
</c:otherwise>
</c:choose>