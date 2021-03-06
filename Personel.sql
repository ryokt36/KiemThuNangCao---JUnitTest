USE master
GO
--Tạo CSDL Personel
CREATE DATABASE Personel
GO
--Chọn CSDL làm việc
USE Personel
GO
--Tạo bảng User lưu thông tin người sử dụng
CREATE TABLE Users(
	Username nvarchar(50) NOT NULL,
	Password nvarchar(50) NOT NULL,
	ROLE nvarchar(5) NOT NULL,
	PRIMARY KEY(Username)
)
delete from Users where Username='minh'

insert into Users values('luc','456','AD')
insert into Users values('long','456','USER')
insert into Users values('phuoc','456','USER')
insert into Users values('minh','456','USER')
select *from Users 
update Users u set u.Password where Username='?'
GO
--Tạo bảng Departs lưu thông tin phòng ban
drop table Users
CREATE TABLE Departs(
	Id nvarchar(5) NOT NULL,
	Name nvarchar(50) NOT NULL,
	PRIMARY KEY(Id)
)
insert into Departs values('pb01',N'nhân sự')
insert into Departs values('pb02',N'kế toán')
insert into Departs values('pb03',N'bảo vệ')
insert into Departs values('pb04',N'hành chính')
select *from Departs
GO
--Tạo bảng Staffs lưu thông tin nhân viên
drop table Staffs
CREATE TABLE Staffs(
	Id nvarchar(5) NOT NULL,
	Name nvarchar(50) NOT NULL,
	Gender bit NOT NULL,
	Birthday date NOT NULL,
	Photo nvarchar(50) NOT NULL,
	Email nvarchar(50) NOT NULL,
	Phone nvarchar(25) NOT NULL,
	Salary float NOT NULL,
	Notes nvarchar(500) NULL,
	DepartId nvarchar(5) NOT NULL,
	PRIMARY KEY(Id),
	FOREIGN KEY(DepartId) REFERENCES Departs(Id) ON DELETE CASCADE ON UPDATE CASCADE
)
insert into Staffs values('NV01',N'Nguyễn Tiến Lực',1,'12/25/2000','anh.jpg','luc@gmail.com','0389202805','9000000',N'lực đẹp trai','pb01')
insert into Staffs values('NV02',N'Nguyễn Xuân Long',1,'11/25/2000','anh1.jpg','long@gmail.com','0389202805','9000000',N'OK','pb02')
insert into Staffs values('NV03',N'Nguyễn Bình Minh',1,'12/25/2000','anh2.jpg','minh@gmail.com','0389202805','9000000',N'lực đẹp trai','pb03')
insert into Staffs values('NV04',N'Nghiêm Đình Phước',1,'12/25/2000','anh3.jpg','phuoc@gmail.com','0389202805','9000000',N'lực đẹp trai','pb04')
select *from Staffs

 
GO
--Tạo bảng Records lưu thông tin thành tích và kỷ luật của nhân viên
drop table Records

CREATE TABLE Records(
	Id nvarchar(5) NOT NULL,
	Type bit,
	Reason nvarchar(200) NOT NULL,
	Date date NOT NULL,
	StaffId nvarchar(5) NOT NULL,
	PRIMARY KEY(Id),
	FOREIGN KEY(StaffId) REFERENCES Staffs(Id) ON DELETE NO ACTION ON UPDATE CASCADE
 )
 select *from Records
 insert into Records values('DG01',1,'jhgsjgskg','12/25/2019','NV04')
 insert into Records values('DG02',1,'jhgsjgskg','12/25/2019','NV01')
 insert into Records values('DG03',1,'jhgsjgskg','12/25/2019','NV02')
 insert into Records values('DG04',0,'jhgsjgskg','12/25/2019','NV03')
 update   Records set type='0' where id='4'
 delete from Departs where Id='pb05'
 
 select Staffs.Id,Staffs.Name,Staffs.Gender,Staffs.Birthday,Staffs.Photo,Staffs.Email,Staffs.Salary,Staffs.Notes, Departs.Id from Staffs inner join  Departs on Staffs.DepartId= Departs.Id order by Staffs.Id desc
 select *from Staffs inner join  Departs on Staffs.DepartId= Departs.Id order by Staffs.Id desc 
 
 select Staffs.Id  SUM( case when type=1 then 1 else 0 end),SUM(case when type=0 then 1 else 0 end),from danhgia GROUP BY Staffs.Id