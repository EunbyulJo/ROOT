<%@page import="org.it.guest.model.GuestDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%System.out.println("data.jsp"); 
	List<GuestDto> list = (List<GuestDto>)(request.getAttribute("list"));
	System.out.println(list.get(0).getWritedate());
%>
<guestlist>
	<c:forEach items="${list }" var="dto">
		<guest>
			<writer>${dto.writer }</writer>
			<content>${dto.content }</content>
			<writedate>${dto.writedate }</writedate>
		</guest>
	</c:forEach>
</guestlist>
