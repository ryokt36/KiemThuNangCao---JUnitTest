<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý nhân viên</title>
<!-- <!-- <style type="text/css">
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


<!-- 	<div class="layout"> -->

		<!-- <header>

			<a  style="float: right; margin-right: 20px; margin-top: 10px ;font-variant: time new roman;font-size: large;font-weight: bold; color:silver;"
				href="login.jsp">Đăng xuất</a> <br> <br>
			<h1 style="color: white;font-size: 150px;margin-top: -55px; margin-left: -100px;" align="center">Group</h1>
			<h1 style="color: white;font-size: 50px;margin-top: -130px;margin-right: -600px;" align="center">Entertainment</h1>
		</header>

		<nav>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="out" href="user/QLTK">Tài khoản</a> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="out" href="user/QLPB">Quản lý phòng ban</a> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="out" href="safft/QLNV">Quản lý nhân viên </a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a id="out" href="records/DG">Đánh giá</a>
		</nav>  -->




		<aside>
			<div>
			
				<br> <br>

				<f:form  action="safft" modelAttribute="NV" method="POST" enctype="multipart/form-data">

					<div class="nhom">
					<h1 style="color: red; font-weight: bold;margin-left: 200px;" >${message}</h1>
							<div>
							<input name="timkiem" style="margin-left:800px; width: 400px;" placeholder="Tìm kiếm......"   type="text" class="control"
							 />
							 <button  name="tim" style="color: black;font-weight: bold;width: 100px; height:30px;" type="submit" class="button">Tìm Kiếm</button>
							</div>


						<div>
							<label style="margin-left: 90px;"><s:message code="staff.manhanvien"/>: </label>
							
						</div>
						<br>
						<f:input id="ma" placeholder="NV0....." type="text" class="control"
								path="maNV" />

					
					<br><br>
					
					<div>
						<label style="margin-left: 90px;"><s:message code="staff.ten"/>: </label>
						
					</div>
					<br>
					<f:input placeholder="Nguyễn Văn A" id="ten"  type="text" class="control"
							path="tenNV" />
					<br><br>
					
					<div>
						<label style="margin-left: 90px;"><s:message code="staff.gioitinh"/>: </label>
						<f:radiobutton style="margin-left: 50px;"  id="sex" path="gioitinh" value="true" /><label><s:message code="staff.nam"/></label>
						<f:radiobutton style="margin-left: 50px;" id="sex" path="gioitinh" value="false" /><label><s:message code="staff.nu"/></label>
					</div>

					
					<br><br>
					
							<div>
							<label style="margin-left: 90px;"><s:message code="staff.ngaysinh"/>: </label>
							
						</div>
						<br>
								<f:input id="date" placeholder="Tháng / Ngày / Năm ..."  type="text" class="control"
								path="ngaysinh" />
								<br><br>
					
							<div>
							<label style="margin-left: 90px;"><s:message code="staff.anh"/>: </label>
							<input type="file" name="photo"/><button name="upload" style="color: black;font-weight: bold" type="submit" class="button"><s:message code="staff.tailen"/></button>
						</div>
						
							<f:input id="anh"  type="text" class="control"
								 value="${anh}" placeholder="xxx.jpg" path="anh" />
				
					<br><br>
					<div>
						<label style="margin-left: 90px;"><s:message code="staff.email"/>: </label>
						
					</div>
					<br>
					<f:input id="mail" placeholder="abc123@gmail.com"  type="text" class="control"
							path="mail" />

					<br><br>
					
							<div>
							<label style="margin-left: 90px;"><s:message code="staff.sdt"/>: </label>
							
						</div>
						<br>
						<f:input id="SDT" placeholder="0398xxxxxx"  type="text" class="control"
								path="sodt" />
					<br><br>
					<div>
						<label style="margin-left: 90px;"><s:message code="staff.luong"/>: </label>
						
					</div>
					<br>
						<f:input id="luong" placeholder="500000"  type="text" class="control"
							path="luong" />
					<br><br>
					
							<div>
							<label style="margin-left: 90px;"><s:message code="staff.ghichu"/>: </label>
							
					
					</div>
					<br>
							<f:input id="note" placeholder="Nhập ghi chú........"  type="text" class="control"
								path="ghiChu" />
					<br><br>
					
					
				
					 <div>
						<label style="margin-left: 90px;"><s:message code="staff.phongban"/>: </label>
						
					</div>
					<br>
						<f:select path="departid"   class="control" items="${phong}" itemValue="maphong" itemLabel="tenphong" />
					<br><br>
					<br><br>
					<br><br>
					<br><br>
					<div align="center">
					<button name="clear" onclick="click()" style="color: black;font-weight: bold" type="submit" class="button"><s:message code="staff.xoatrang"/></button>
					<button  name="save" style="color: black;font-weight: bold" type="submit" class="button"><s:message code="staff.luu"/></button>
					<button  name="update" style="color: black;font-weight: bold" type="submit" class="button"><s:message code="staff.sua"/></button>
					<button  name="delete" style="color: black;font-weight: bold" type="submit" class="button"><s:message code="staff.xoa"/></button>
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
					<th><s:message code="staff.chon"/></th>
					<th><s:message code="staff.manhanvien"/></th>
					<th><s:message code="staff.ten"/></th>
					<th><s:message code="staff.gioitinh"/></th>
					<th><s:message code="staff.ngaysinh"/></th>
					<th><s:message code="staff.anh"/></th>
					<th><s:message code="staff.email"/></th>
					<th><s:message code="staff.sdt"/></th>
					<th><s:message code="staff.luong"/></th>
					<th><s:message code="staff.ghichu"/></th>
					<th><s:message code="staff.phongban"/></th>
					

				</tr>
				<c:forEach var="n" items="${nhanvien}">
					<tr>
						<td><a href="safft/QLNV/${n.maNV}"><s:message code="staff.chon"/></a></td>
						<td>${n.maNV}</td>
						<td>${n.tenNV}</td>
						<td>${n.gioitinh?'Nam':'Nữ'}</td>
						<td>${n.ngaysinh}</td>
						<td><img src="images/${n.anh}"></td>
						<td>${n.mail}</td>
						<td>${n.sodt}</td>
						<td>${n.luong}</td>
						<td>${n.ghiChu}</td>
						<td>${n.departid}</td>

					</tr>
				</c:forEach>
			</table>
			
			<script type="text/javascript">
			var MaNV=document.getElementById("ma");
			var TenNV=document.getElementById("ten");
			var SEX=document.getElementById("sex");
			var Ngay=document.getElementById("date");
			var Anh=document.getElementById("anh");
			var Mail=document.getElementById("mail");
			var Sdt=document.getElementById("SDT");
			var Salary=document.getElementById("luong");
			var Note=document.getElementById("notes");
			
			
			
			function click() {
				MaNV.value="";
				TenNV.value="";
				SEX.value="";
				Ngay.value="";
				Anh.value="";
				Mail.value="";
				Sdt.value="";
				Salary.value="";
				Note.value="";
				
			}
			</script>
		</div>

		<br> <br>



		
</body>
</html>