<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<h3>글보기</h3>
	<i>${bdto.num }</i>. <b>${bdto.title }</b>
	<br/><br/>
	<pre>${bdto.content }</pre>
	<hr/>
	<c:choose>
		<c:when test="${flist ne null }">
			<c:forEach var="t" items="${flist }">
				첨부파일 : <a href="/download.it?fnum=${t.fnum }">${t.realfile }</a> (다운로드 횟수 : ${t.cnt })<br/>
			</c:forEach>
		</c:when>
		<c:otherwise>
			첨부파일 없음
		</c:otherwise>
	</c:choose>
</div>

