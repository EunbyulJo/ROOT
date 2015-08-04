<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
	타일즈로 영역 4개 세팅
 --%>
 
 <html>
 <body>
 	<div style="height: 80">
 		<tiles:insertAttribute name="header"/>
 	</div>
 	<div style="height: 50">
 		<tiles:insertAttribute name="nav"/>
 	</div>
 	<div align="center">
 		<tiles:insertAttribute name="body"/>
 	</div>
 	<div>
 		<tiles:insertAttribute name="footer"/>
 	</div>
 </body>
 </html>
