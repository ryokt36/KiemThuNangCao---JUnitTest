package Unittest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.transaction.annotation.Transactional;

import poly.DAO.safftDAO;
import poly.bean.NhanVien;
@Transactional
@Controller
@ContextConfiguration({ "classpath:*/configs/spring-config-hibernate.xml",
		"classpath:*/configs/spring-config-mvc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Update_StafftTest {
 private NhanVien nhanvien;
 
@Autowired
 safftDAO SafftDao;
 
 @BeforeClass 
 public static void setUpBeforeClass() throws Exception{
	 
 }
 
 @AfterClass
public static void tearDownAfterClass() throws Exception{
	 
 }
 
 @Before
 public void SetUp() throws Exception{
	 nhanvien = new NhanVien();
 }
 
 @After
 public void tearDow() throws Exception{
	 
 }
 

 //Kiểm tra với dữ liệu đúng 
 @Test
 public void STF_UPD_01() {
	 boolean kq;
	 nhanvien.setMaNV("NV04");
	 nhanvien.setTenNV("Phước");
	 nhanvien.setAnh("anh1.jpg");
	 nhanvien.setSodt("0389202805");
	 nhanvien.setNgaysinh("12/25/2000");
	 nhanvien.setMail("luchkjd@gmail.com");
	 nhanvien.setLuong("9000000");
	 nhanvien.setGhiChu("bkxnnckncd");
	 nhanvien.setGioitinh(true);
	 nhanvien.setDepartid("pb04");
	 kq = SafftDao.update(nhanvien);
	 assertEquals(true, kq);
	 
 }
 //Để trống các trường
 @Test
 public void STF_UDP_02() {
	 boolean kq;
	 nhanvien.setMaNV(null);
	 nhanvien.setTenNV(null);
	 nhanvien.setAnh(null);
	 nhanvien.setSodt(null);
	 nhanvien.setNgaysinh(null);
	 nhanvien.setMail(null);
	 nhanvien.setLuong(null);
	 nhanvien.setGhiChu(null);
	 nhanvien.setGioitinh(true);
	 nhanvien.setDepartid(null);
	 kq = SafftDao.update(nhanvien);
	 assertEquals(false, kq);
	 
 }
 //Mã NV để trống
 @Test
 public void STF_UPD_03() {
	 boolean kq;
	 nhanvien.setMaNV(null);
	 nhanvien.setTenNV("Phước");
	 nhanvien.setAnh("anh1.jpg");
	 nhanvien.setSodt("0389202805");
	 nhanvien.setNgaysinh("12/25/2000");
	 nhanvien.setMail("luchkjd@gmail.com");
	 nhanvien.setLuong("9000000");
	 nhanvien.setGhiChu("bkxnnckncd");
	 nhanvien.setGioitinh(true);
	 nhanvien.setDepartid("pb04");
	 kq = SafftDao.update(nhanvien);
	 assertEquals(false, kq);
	 
 }
 //Mã NV không tồn tại
 @Test
 public void STF_UPD_04() {
	 boolean kq;
	 nhanvien.setMaNV("TTT");
	 nhanvien.setTenNV("Phước");
	 nhanvien.setAnh("anh1.jpg");
	 nhanvien.setSodt("0389202805");
	 nhanvien.setNgaysinh("12/25/2000");
	 nhanvien.setMail("luchkjd@gmail.com");
	 nhanvien.setLuong("9000000");
	 nhanvien.setGhiChu("bkxnnckncd");
	 nhanvien.setGioitinh(true);
	 nhanvien.setDepartid("pb04");
	 kq = SafftDao.update(nhanvien);
	 assertEquals(false, kq);
	 
 }
 //Mã PB để trống
 @Test
 public void STF_UPD_05() {
	 boolean kq;
	 nhanvien.setMaNV("NV04");
	 nhanvien.setTenNV("Phước");
	 nhanvien.setAnh("anh1.jpg");
	 nhanvien.setSodt("0389202805");
	 nhanvien.setNgaysinh("12/25/2000");
	 nhanvien.setMail("luchkjd@gmail.com");
	 nhanvien.setLuong("9000000");
	 nhanvien.setGhiChu("bkxnnckncd");
	 nhanvien.setGioitinh(true);
	 nhanvien.setDepartid(null);
	 kq = SafftDao.update(nhanvien);
	 assertEquals(false, kq);
	 
 }
 //Mã PB không tồn tại
 @Test
 public void STF_UPD_06() {
	 boolean kq;
	 nhanvien.setMaNV("NV04");
	 nhanvien.setTenNV("Phước");
	 nhanvien.setAnh("anh1.jpg");
	 nhanvien.setSodt("0389202805");
	 nhanvien.setNgaysinh("12/25/2000");
	 nhanvien.setMail("luchkjd@gmail.com");
	 nhanvien.setLuong("9000000");
	 nhanvien.setGhiChu("bkxnnckncd");
	 nhanvien.setGioitinh(true);
	 nhanvien.setDepartid("pbCC");
	 kq = SafftDao.update(nhanvien);
	 assertEquals(false, kq);
 }
 //Sai định dạng ngày
 @Test
 public void STF_UPD_07() {
	 boolean kq;
	 nhanvien.setMaNV("NV04");
	 nhanvien.setTenNV("Phước");
	 nhanvien.setAnh("anh1.jpg");
	 nhanvien.setSodt("0389202805");
	 nhanvien.setNgaysinh("2000/25/12");
	 nhanvien.setMail("luchkjd@gmail.com");
	 nhanvien.setLuong("9000000");
	 nhanvien.setGhiChu("bkxnnckncd");
	 nhanvien.setGioitinh(true);
	 nhanvien.setDepartid("pb04");
	 kq = SafftDao.update(nhanvien);
	 assertEquals(false, kq);
	 
 }
 //mail để trống
 @Test
 public void STF_UPD_08() {
	 boolean kq;
	 nhanvien.setMaNV("NV04");
	 nhanvien.setTenNV("Phước");
	 nhanvien.setAnh("anh1.jpg");
	 nhanvien.setSodt("0389202805");
	 nhanvien.setNgaysinh("12/25/2000");
	 nhanvien.setMail(null);
	 nhanvien.setLuong("9000000");
	 nhanvien.setGhiChu("bkxnnckncd");
	 nhanvien.setGioitinh(true);
	 nhanvien.setDepartid("pb04");
	 kq = SafftDao.update(nhanvien);
	 assertEquals(false, kq);
	 
 }
 //Sai định dạng lương
 @Test
 public void STF_UPD_09() {
	 boolean kq;
	 nhanvien.setMaNV("NV04");
	 nhanvien.setTenNV("Phước");
	 nhanvien.setAnh("anh1.jpg");
	 nhanvien.setSodt("0389202805");
	 nhanvien.setNgaysinh("12/25/2000");
	 nhanvien.setMail("luchkjd@gmail.com");
	 nhanvien.setLuong("khongcoluong");
	 nhanvien.setGhiChu("bkxnnckncd");
	 nhanvien.setGioitinh(true);
	 nhanvien.setDepartid("pb04");
	 kq = SafftDao.update(nhanvien);
	 assertEquals(false, kq);
	 
 }
 //để trống ngày sinh
 @Test
 public void STF_UPD_10() {
	 boolean kq;
	 nhanvien.setMaNV("NV04");
	 nhanvien.setTenNV("Phước");
	 nhanvien.setAnh("anh1.jpg");
	 nhanvien.setSodt("0389202805");
	 nhanvien.setNgaysinh(null);
	 nhanvien.setMail("luchkjd@gmail.com");
	 nhanvien.setLuong("9000000");
	 nhanvien.setGhiChu("bkxnnckncd");
	 nhanvien.setGioitinh(true);
	 nhanvien.setDepartid("pb04");
	 kq = SafftDao.update(nhanvien);
	 assertEquals(false, kq);
	 
 }
//để trống sđt
@Test
public void STF_UPD_11() {
	 boolean kq;
	 nhanvien.setMaNV("NV04");
	 nhanvien.setTenNV("Phước");
	 nhanvien.setAnh("anh1.jpg");
	 nhanvien.setSodt(null);
	 nhanvien.setNgaysinh("12/25/2000");
	 nhanvien.setMail("luchkjd@gmail.com");
	 nhanvien.setLuong("9000000");
	 nhanvien.setGhiChu("bkxnnckncd");
	 nhanvien.setGioitinh(true);
	 nhanvien.setDepartid("pb04");
	 kq = SafftDao.update(nhanvien);
	 assertEquals(false, kq);
	 
}
}
