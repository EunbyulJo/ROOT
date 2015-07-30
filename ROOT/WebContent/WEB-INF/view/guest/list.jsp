<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/script.js"></script>
<script type="text/javascript">
	
<%System.out.println("list.jsp");%>
	function send() {
		var request = openRequest();
		request.open("GET", "/guest/latest.it", true);
		request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {	
			var xml = request.responseXML;
			var request2 = openRequest();
			request2.open("GET", "/guestbook.xsl", true);
			request2.onreadystatechange = function() {
				if (request2.readyState == 4 && request2.status == 200) {
					var xsl = request2.responseXML;
					var div = document.getElementById("guestList");
					if (window.ActiveXObject != null) {
						div.innerHTML = xml.transformNode(xsl);
					} else {
						var trans = new XSLTProcessor();
						trans.importStylesheet(xsl);
						var frg = trans.transformToFragment(xml, document);
						div.innerHTML="";
						div.appendChild(frg);
					}
				}
			}
			request2.send(null);
		}}
		request.send(null);
		setTimeout("send();", 5000);
	}
	window.onload = function() {
		send();
	}
</script>


<div id="guestInsert">
	<form name="guest" action="/guest/write.it" method="post">
		<ul>
			<li>작성자 <input type="text" name="writer" /></li>
			<li>내용 <input type="text" name="content" size="50" /></li>
		</ul>
		<input type="submit" value="등록" />
	</form>
</div>
<hr />
<div id="guestList"></div>
