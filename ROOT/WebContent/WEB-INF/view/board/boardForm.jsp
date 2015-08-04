<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
<div align="center">
<h1>글쓰기</h1>
<hr/>
<form action="/board/write.it" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>제목 : </td>
			<td><input type="text" name="title"/></td>
		</tr>
		<tr>
			<td>내용 : </td>
			<td>
				<textarea name="content" rows="10" cols="40"></textarea>
				<script type="text/javascript">
					CKEDITOR.replace('content');
				</script>
			</td>
		</tr>
		<tr>
			<td>첨부 : </td>
			<td><input type="file" name="mpf"/></td>
		</tr>
	</table>
	<input type="submit" value="등록"/>
</form>
</div>