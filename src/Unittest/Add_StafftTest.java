package Unittest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
public class Add_StafftTest {
	private NhanVien nhanvien;

	@Autowired
	safftDAO SafftDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void SetUp() throws Exception {
		nhanvien = new NhanVien();
	}

	@After
	public void tearDow() throws Exception {
		SafftDao.deleteTest(nhanvien.getMaNV());
	}

//Nhập đầy đủ các trường
	@Test
	public void STF_Add_01() {
		boolean kq;
		nhanvien.setMaNV("NV05");
		nhanvien.setTenNV("Nguyễn Tiến Lực");
		nhanvien.setAnh("anh1.jpg");
		nhanvien.setSodt("0389202805");
		nhanvien.setNgaysinh("12/25/2000");
		nhanvien.setMail("luchkjd@gmail.com");
		nhanvien.setLuong("9000000");
		nhanvien.setGhiChu("Đây là nhân viên 5");
		nhanvien.setGioitinh(true);
		nhanvien.setDepartid("pb04");
		kq = SafftDao.Save(nhanvien);
//		if (kq) {
//			
//		}
		assertEquals(true, kq);
		

	}

	// để trống trường , chọn giới tính
	@Test
	public void STF_Add_02() {
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
		System.out.println(SafftDao);
		kq = SafftDao.Save(nhanvien);
		assertEquals(false, kq);

	}

//	 //để mail trống
	@Test
	public void STF_Add_03() {
		boolean kq;
		nhanvien.setMaNV("NV05");
		nhanvien.setTenNV("Lực đẹp trai");
		nhanvien.setAnh("anh1.jpg");
		nhanvien.setSodt("0389202805");
		nhanvien.setNgaysinh("12/25/2000");
		nhanvien.setMail(null);
		nhanvien.setLuong("9000000");
		nhanvien.setGhiChu("bkxnnckncd");
		nhanvien.setGioitinh(true);
		nhanvien.setDepartid("pb04");
		kq = SafftDao.Save(nhanvien);
		assertEquals(false, kq);

	}

	// nhập mã nv đã tồn tại
	@Ignore
	@Test
	public void STF_Add_04() {
		boolean kq;
		nhanvien.setMaNV("NV04");
		nhanvien.setTenNV("Lực đẹp trai");
		nhanvien.setAnh("anh1.jpg");
		nhanvien.setSodt("0389202805");
		nhanvien.setNgaysinh("12/25/2000");
		nhanvien.setMail("luchkjd@gmail.com");
		nhanvien.setLuong("9000000");
		nhanvien.setGhiChu("bkxnnckncd");
		nhanvien.setGioitinh(true);
		nhanvien.setDepartid("pb04");
		kq = SafftDao.Save(nhanvien);
		assertEquals(true, kq);

	}

	// để trống mã nhân viên
	@Test
	public void STF_Add_05() {
		boolean kq;
		nhanvien.setMaNV(null);
		nhanvien.setTenNV("Lực đẹp trai");
		nhanvien.setAnh("anh1.jpg");
		nhanvien.setSodt("0389202805");
		nhanvien.setNgaysinh("12/25/2000");
		nhanvien.setMail("luchkjd@gmail.com");
		nhanvien.setLuong("9000000");
		nhanvien.setGhiChu("bkxnnckncd");
		nhanvien.setGioitinh(true);
		nhanvien.setDepartid("pb04");
		kq = SafftDao.Save(nhanvien);
		assertEquals(false, kq);

	}

	// số điện thoại để trống
	@Test
	public void STF_Add_06() {
		boolean kq;
		nhanvien.setMaNV("NV05");
		nhanvien.setTenNV("Lực đẹp trai");
		nhanvien.setAnh("anh1.jpg");
		nhanvien.setSodt(null);
		nhanvien.setNgaysinh("12/25/2000");
		nhanvien.setMail("luchkjd@gmail.com");
		nhanvien.setLuong("9000000");
		nhanvien.setGhiChu("bkxnnckncd");
		nhanvien.setGioitinh(true);
		nhanvien.setDepartid("pb04");
		kq = SafftDao.Save(nhanvien);
		assertEquals(false, kq);

	}

	// nhập ngày tháng sai định dạng tháng/ngày/năm
	@Test
	public void STF_Add_07() {
		boolean kq;
		nhanvien.setMaNV("NV05");
		nhanvien.setTenNV("Lực đẹp trai");
		nhanvien.setAnh("anh1.jpg");
		nhanvien.setSodt("0389202805");
		nhanvien.setNgaysinh("1225/2000");
		nhanvien.setMail("luchkjd@gmail.com");
		nhanvien.setLuong("9000000");
		nhanvien.setGhiChu("bkxnnckncd");
		nhanvien.setGioitinh(true);
		nhanvien.setDepartid("pb04");
		kq = SafftDao.Save(nhanvien);
		assertEquals(false, kq);

	}

	// nhập lương sai định dạng
	@Test
	public void STF_Add_08() {
		boolean kq;
		nhanvien.setMaNV("NV05");
		nhanvien.setTenNV("Lực đẹp trai");
		nhanvien.setAnh("anh1.jpg");
		nhanvien.setSodt("0389202805");
		nhanvien.setNgaysinh("12/25/2000");
		nhanvien.setMail("luchkjd@gmail.com");
		nhanvien.setLuong("90c00000");
		nhanvien.setGhiChu("bkxnnckncd");
		nhanvien.setGioitinh(true);
		nhanvien.setDepartid("pb04");
		kq = SafftDao.Save(nhanvien);
		assertEquals(false, kq);

	}

	// nhập mã phòng ban không tồn tại
	@Test
	public void STF_Add_09() {
		boolean kq;
		nhanvien.setMaNV("NV05");
		nhanvien.setTenNV("Lực đẹp trai");
		nhanvien.setAnh("anh1.jpg");
		nhanvien.setSodt("0389202805");
		nhanvien.setNgaysinh("12/25/2000");
		nhanvien.setMail("luchkjd@gmail.com");
		nhanvien.setLuong("9000000");
		nhanvien.setGhiChu("bkxnnckncd");
		nhanvien.setGioitinh(true);
		nhanvien.setDepartid("pb06");
		kq = SafftDao.Save(nhanvien);
		assertEquals(false, kq);

	}

	// không nhập họ tên
	@Test
	public void STF_Add_10() {
		boolean kq;
		nhanvien.setMaNV("NV05");
		nhanvien.setTenNV(null);
		nhanvien.setAnh("anh1.jpg");
		nhanvien.setSodt("0389202805");
		nhanvien.setNgaysinh("12/25/2000");
		nhanvien.setMail("luchkjd@gmail.com");
		nhanvien.setLuong("9000000");
		nhanvien.setGhiChu("bkxnnckncd");
		nhanvien.setGioitinh(true);
		nhanvien.setDepartid("pb01");
		kq = SafftDao.Save(nhanvien);
		assertEquals(false, kq);

	}


}
