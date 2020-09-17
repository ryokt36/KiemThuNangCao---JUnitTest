<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin lịch diễn</title>
  <style type="text/css">
 .layout
body {
	padding: 0px;
	margin: 0px;
	width: 100%;
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
	margin-left: 100px;
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
	height: 30px;
	width: 20px;
}
</style> 
<base href="${pageContext.servletContext.contextPath}/">
</head>
<body style="margin: 0px;">

	
	  <div class="layout">
		<header>
		<!-- <a  style="float: right; margin-right: 20px; margin-top: 10px ;font-variant: time new roman;font-size: large;font-weight: bold; color:silver;"
				href="login.jsp">Đăng xuất</a> --> <br> <br>
			<h1 style="color: white;font-size: 150px;margin-top: -55px; margin-left: -100px;" align="center">Group</h1>
			<h1 style="color: white;font-size: 50px;margin-top: -130px;margin-right: -600px;" align="center">Entertainment</h1>
		</header>
		<!-- <nav >
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="user/QLTK">Tài khoản</a>
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="user/QLPB">Quản lý phòng ban</a>
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="safft/QLNV">Quản lý nhân viên </a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="records/DG">Đánh giá</a>
			
			
		</nav> --> 
		
		<!-- <video src=""></video> -->
		<br><br>
		<div>
		
		<table align="center" >
			<tr>
				<th>Tên nghệ sĩ</th>
				<th >Ảnh</th>
				<th>Ngày diễn</th>
				<th>Địa chỉ</th>
				
			</tr>
			
	
				
			<tr>
				<td>Sơn Tùng M-tp</td>
				<td><img src="images/sontung.jpg"></td>
				<td>08/03/2020</td>
				<td>SDV Mỹ Đình - Hà Nội</td>
				
			</tr>
			
			<tr>
				<td>Trúc Nhân</td>
				<td><img style="height: 236px;width: 236px;" src="images/trucnhan.jpg"></td>
				<td>08/03/2020</td>
				<td>SDV Hàng Đẫy - Hà Nội</td>
				
			</tr>
			
			<tr>
				<td>Hari won</td>
				<td><img  style="height: 236px;width: 236px;"  src="images/hari.jpg"></td>
				<td>08/03/2020</td>
				<td>Trường quay s1 -TP.HCM</td>
				
			</tr>
			<tr>
				<td>Trấn Thành</td>
				<td><img  style="height: 236px;width: 236px;"  src="images/tranthanh.jpg"></td>
				<td>08/03/2020</td>
				<td>Trường quay s1 -TP.HCM</td>
				
			</tr>
			<tr>
				<td>Trường Giang</td>
				<td><img  style="height: 236px;width: 236px;"  src="images/truonggiang.jpg"></td>
				<td>08/03/2020</td>
				<td>Trường quay s1 -TP.HCM</td>
				
			</tr>
			
			<tr>
				<td>Đông Nhi</td>
				<td><img  style="height: 236px;width: 236px;"  src="images/dongnhi.jpg"></td>
				<td>08/03/2020</td>
				<td>Trường quay s1 -TP.HCM</td>
				
			</tr>
			
			
	</table>
		</div>
		
		<br><br>
		
		
		
		 <footer style=" color: white; "  >
	Group Entertainment
</footer> 
</div>
</body>
</html>