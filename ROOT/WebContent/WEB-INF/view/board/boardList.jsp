<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
	function showDetail(num) {
		var locPop = "/board/detailPop.it?num=" + num;
		var locMove = "/board/detailMove.it?num=" + num;
		//location.href=locMove;     // 페이지이동
		window
				.open(
						locPop,
						"dts",
						"width=600,height=400, scrollbars=yes,resizable=yes, left=500,top=250",
						false); // 새창
		// 띄울경로, 윈도우프레임이름, 기타옵션
	}
</script>

<h1>게시판</h1>
<a href="/board/write.it">새글쓰기</a>
<br />
<br />
<table style="width: 100%;" border="1">
	<tr>
		<td>글번호</td>
		<td align="center">제목</td>
		<td align="center">작성자</td>
		<td align="center">날짜</td>
	</tr>
	<c:forEach items="${list }" var="bdto">
		<tr>
			<td>${bdto.num }</td>
			<td><a href="javascript:showDetail('${bdto.num }')">${bdto.title }</a></td>
			<td>${bdto.writer}</td>
			<td><fmt:formatDate value="${bdto.writedate }"
					pattern="yyyy.MM.dd HH:mm" /></td>
		</tr>
	</c:forEach>
</table>
<!-- p=1 or p=2 이런식으로 갈 수 있게 링크 만들기 -->
<c:forEach var="num" begin="1" end="${page}">
	<c:choose>
		<c:when test="${param.p eq null and num eq 1}">
			<b>${num }</b>
		</c:when>
		<c:when test="${num ne param.p}">
			<a href="/board/list.it?p=${num }">${num }</a>
		</c:when>
		<c:otherwise>
			<b>${num }</b>
		</c:otherwise>
	</c:choose>
</c:forEach>