<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="/script.js"></script>
<script type="text/javascript">

	var request;
	
	function check() {
		request=openRequest();
		request.onreadystatechange=reciever;
		var id = document.mem_reg.id.value;
		request.open("GET", "/check.it?id="+id, true);
		request.send(null);
	}

	function reciever() {
		if(request.readyState==4) {
			if(request.status==200) {
				<%--var msg = request.responseText;
				alert(msg);--%>
				document.getElementById("ids").innerHTML=request.responseText;
			}
		}
	}
	
</script>




<center>
<br/>
<h1>회원가입</h1>
<hr/><br/>
<form action="/member/reg.it" method="post" name="mem_reg">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" onblur="check()"/>
					<span id="ids"></span></td>
		</tr>
		<tr>
			<td>PASSWORD</td>
			<td><input type="password" name="pass"/></td>
		</tr>
		<tr>
			<td>NAME</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>GENDER</td>
			<td>
				<input type="radio" value="woman" name="gender"/>woman
				<input type="radio" value="man" name="gender"/>man
			</td>
		</tr>
		<tr>
			<td>EMAIL</td>
			<td><input type="email" name="email"></td>
		</tr>
		<tr>
			<td>ADDRESS</td>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<td></td>
			<td align="right"><input type="submit" value="Register"/></td>
		</tr>
	</table>
</form>
</center>