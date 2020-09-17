package Unittest;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import poly.DAO.safftDAO;
import poly.bean.NhanVien;

@Transactional
@Controller
@ContextConfiguration({ "classpath:*/configs/spring-config-hibernate.xml",
		"classpath:*/configs/spring-config-mvc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Staff_Select_Test {

	private NhanVien nhanvien;

	@Autowired
	safftDAO StaffDao;

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
	public void TearDown() throws Exception {
	}

	// Truy suất tất cả dữ liệu
	@Test
	public void Select_01() {
		boolean kq = true;
		List<NhanVien> list = StaffDao.getALLNhanviens();
		if (list.isEmpty()) {
			kq = false;
		}
		Assert.assertEquals(true, kq);
	}

	// Truy suất 1 bản ghi
	@Test
	public void Select_02() {
		boolean kq = true;
		List<NhanVien> list = StaffDao.getALLNhanviens();
		nhanvien = StaffDao.getNhanvienID("nv01");
		if (nhanvien.getMaNV().equals("")) {
			kq = false;
		}
		Assert.assertEquals(true, kq);
	}
	// Truy suất mã nhân viên không tồn tại 
	@Test
	public void Select_03() {
		boolean kq = true;
		List<NhanVien> list = StaffDao.getALLNhanviens();
		nhanvien = StaffDao.getNhanvienID("nv08");
		if (nhanvien.getMaNV().equals("")) {
			kq = false;
		}
		Assert.assertEquals(true, kq);
	}
}
