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

import poly.DAO.recordsDAO;
import poly.bean.danhgia;

@Transactional
@Controller
@ContextConfiguration({ "classpath:*/configs/spring-config-hibernate.xml",
		"classpath:*/configs/spring-config-mvc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Record_Update_Test {

	private danhgia Danhgia;
	private danhgia Danhgia_cu;

	@Autowired
	recordsDAO RecordDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void SetUp() throws Exception {
		Danhgia = new danhgia();
		Danhgia_cu = new danhgia();
	}

	@After
	public void TearDown() throws Exception {
	}

	// Kiểm tra hàm Update với Id có tồn tại, dữ liệu đúng
	@Test
	public void REC_Update_01() {
		boolean kq;
		Danhgia.setId("DG01");
		Danhgia.setType(true);
		Danhgia.setReason("Abc");
		Danhgia.setDate("12/12/2020");
		Danhgia.setStaffId("NV01");
		Danhgia_cu = RecordDAO.getDanhgiaID("DG01");
		kq = RecordDAO.update(Danhgia);
		if (kq) {
			RecordDAO.update(Danhgia_cu);
		}
		Assert.assertEquals(true, kq);
	}

	// Kiểm tra hàm Update với Id có tồn tại, Reason trống
	@Test
	public void REC_Update_02() {
		boolean kq;
		Danhgia.setId("DG01");
		Danhgia.setType(true);
		Danhgia.setDate("12/12/2020");
		Danhgia.setStaffId("NV01");
		Danhgia_cu = RecordDAO.getDanhgiaID("DG01");
		kq = RecordDAO.update(Danhgia);
		if (kq) {
			RecordDAO.update(Danhgia_cu);
		}
		Assert.assertEquals(false, kq);
	}

	// Kiểm tra hàm Update với Id không tồn tại
	@Test
	public void REC_Update_03() {
		boolean kq;
		Danhgia.setId("123");
		Danhgia.setType(true);
		Danhgia.setReason("Abc");
		Danhgia.setDate("12/12/2020");
		Danhgia.setStaffId("NV01");
		Danhgia_cu = RecordDAO.getDanhgiaID("123");
		kq = RecordDAO.update(Danhgia);
		if (kq) {
			RecordDAO.update(Danhgia_cu);
		}
		Assert.assertEquals(false, kq);
	}
}
