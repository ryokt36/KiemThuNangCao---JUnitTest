<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý phòng ban</title>
 <!-- <style type="text/css">
.layout
body {
	padding: 0px;
	margin: 0px;
}

.layout {
	width: auto;
	margin: auto;
	background-color: white;
}

.layout
  header {
	background-size: 100% 100%;
	background-color: black;
	height: 60px;
	padding-bottom: 10%;
	font-variant: Calibri;
}

.layout
 nav {
	line-height: 50px;
	background-color: yellow;
	color: black;
	font-variant: Calibri;
		font-size: large;
		font-weight: bold;
}

/* .layout
 article {
	height: auto;
	width: 50%;
	background-color: white;
	float: right;
	font-variant: time new roman;
}
 */
.layout
  aside {
	height: auto;
	width: 100%;
	background-color: white;
	float: left;
	font-variant: Calibri;
}

.layout
 footer {
	line-height: 45px;
	background-color: black;
	text-align: center;
	clear: both;
	border-top: 5px;
	font-variant: Calibri;
		font-size: large;
		font-weight: bold;
}


.layout
 a {
	color: black;
	text-decoration: none;
	margin: 0 5px;
	transition: 0.2s;
    
    text-decoration: none;
    padding:0px 15px;
}
 

 a:hover{
    background-color: #ffffff;
    color: black;
    padding: 12px 15px 13px;
}
img {
	padding: 20px 0px 0px 20px;
}

.layout {
	width: auto;
	margin: 0 auto;
}

.notes {
	text-align: center;
	font-size: 12pt;
	color: black;
}


table {
	margin: 0 auto;
	width: 95%;
	border-collapse: collapse;
	background-color: white;
	font-variant: Calibri;
		font-size: large;
		font-weight: bold;
}

th {
	height: 50px;
	background-color: black;
	color:white;
	font-size: large;
}

td {
	height: 40px;
	text-align: center;
}

form {
font-variant: Calibri;
		font-size: large;
		font-weight: bold;
}

.nhom {
	margin: 10px 0px;
}

.control {
	width: 80%;
	padding: 5px;
	border-radius: 3px;
	border: 1px solid gray;
	outline: none;
	margin-left: 130px;
	font-variant: Calibri;
		font-size: large;
		font-weight: bold;
}

/* .control {
	width: 100%;
	padding: 5px;
	border-radius: 3px;
	border: 1px solid gray;
	outline: none;
	margin-left: 50px;
}
 */
.button {
	 margin: 20px 0 30px 20px; 
    width: 200px;
    height: 40px;
    font-variant: Calibri;
 	margin-left: 50px;
    color: #000;
    /* background-size: 54px 204px; */
  	font-size:10px;
  	font-size: large;
    border-radius: 2em;
    border: 0.15em solid #F9C23C;
    cursor: pointer;
    background: #FFFF;
}

.button:hover{    
    color: #fff;
    background-color: #EAA502;
    border-color: #EAA502;
    background-position: 0.75em bottom;
    -webkit-transition: all 0.3s ease;
    -ms-transition: all 0.3s ease;
    transition: all 0.3s ease;
}
.anhgh {
	float: right;
}

.anhgh img {
	margin-top: -60px;
}
</style>  -->
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>


	<!-- <div class="layout">

		<header>
<a  style="float: right; margin-right: 20px; margin-top: 10px ;font-variant: time new roman;font-size: large;font-weight: bold; color:silver;"
				href="login.jsp">Đăng xuất</a> <br> <br>
			<h1 style="color: white;font-size: 150px;margin-top: -55px; margin-left: -100px;" align="center">Group</h1>
			<h1 style="color: white;font-size: 50px;margin-top: -130px;margin-right: -600px;" align="center">Entertainment</h1>
		</header>

		<nav>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="user/QLTK">Tài
				khoản</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="user/QLPB">Quản
				lý phòng ban</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="safft/QLNV">Quản lý nhân viên </a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="records/DG">Đánh giá</a>
		</nav> 

		
 -->


		<aside>
			<div>
			
				<br> <br>

				<f:form  action="User" modelAttribute="PB" method="POST">

					<div class="nhom">
					<h1 style="color: red; font-weight: bold;margin-left: 200px;" >${message}</h1>
						<br>

						<div>
							<label style="margin-left: 90px;"><s:message code="depart.maphongban"/>: </label>
							
						</div>
					<br>
						<f:input id="ma"  placeholder="PB0....." name="ma"  type="text" class="control" path="maphong" />
					<br>
					<br>
					<div>
						<label style="margin-left: 90px;"><s:message code="depart.tenphongban"/>: </label>
						
					</div>
					<br>
						<f:input id="ten"  placeholder="XXXX" name="ten" type="text" class="control" path="tenphong" />
					<br>
					<br>
					<br>


						<div align="center">
					<button name="clear" onclick="click()" style="color: black;font-weight: bold" type="submit" class="button"><s:message code="depart.xoatrang"/></button>
					<button  name="save" style="color: black;font-weight: bold" type="submit" class="button"><s:message code="depart.luu"/></button>
					<button  name="update" style="color: black;font-weight: bold" type="submit" class="button"><s:message code="depart.sua"/></button>
					<button  name="delete" style="color: black;font-weight: bold" type="submit" class="button"><s:message code="depart.xoa"/></button>
					</div>
					<br>
					
					</div>
				</f:form>
			</div>
		</aside>

		<br> <br> <br> <br>
		<div>
		
			
			<table align="center" >
				<tr>
					<th><s:message code="depart.chon"/></th>
					<th><s:message code="depart.maphongban"/></th>
					<th><s:message code="depart.tenphongban"/></th>
					

				</tr>
				<c:forEach var="p" items="${phongban}">
					<tr>
						<td><a href="User/QLPB/${p.maphong}"><s:message code="depart.chon"/></a></td>
						<td>${p.maphong}</td>
						<td>${p.tenphong}</td>
						

					</tr>
				</c:forEach>
			</table>
			
			<script type="text/javascript">
			var mapb=document.getElementById("ma");
			var tenpb=document.getElementById("ten");
			
		
			function click() {
				mapb.value="";
				tenpb.value="";
			}
			</script>
		</div>

		<br> <br>



	<%-- 	<footer style="color: white;"> Group Entertainment </footer>
	</div> --%>
</body>
</html>