package Unittest;

import static org.junit.Assert.*;

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

import poly.DAO.safftDAO;
import poly.bean.NhanVien;

@Transactional
@Controller
@ContextConfiguration({ "classpath:*/configs/spring-config-hibernate.xml",
		"classpath:*/configs/spring-config-mvc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Safft_Delete_Test {
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
	public void TearDown() throws Exception {
	}
	
	//Test Delete với dữ liệu tồn tại
	@Test
	public void STF_delete_01() {
		boolean kq;
		nhanvien = SafftDao.getNhanvienID("NV04");
		SafftDao.delete(nhanvien);
		SafftDao.Save(nhanvien);
		kq = SafftDao.SelectTestID("NV04");
		Assert.assertEquals(true, kq);
	}
	//Test Delete với dữ liệu không tồn tại
	@Test
	public void STF_delete_02() {
		boolean kq;
		nhanvien = SafftDao.getNhanvienID("123");
		SafftDao.delete(nhanvien);
		SafftDao.Save(nhanvien);
		kq = SafftDao.SelectTestID("123");
		Assert.assertEquals(false, kq);
	}
	//Để trống Mã NV
	@Test
	public void STF_delete_03() {
		boolean kq;
		nhanvien = SafftDao.getNhanvienID(null);
		SafftDao.delete(nhanvien);
		SafftDao.Save(nhanvien);
		kq = SafftDao.SelectTestID(null);
		Assert.assertEquals(false, kq);
	}
}
