package Unittest;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import poly.DAO.recordsDAO;
import poly.bean.danhgia;

//@Transactional
//@Controller
@ContextConfiguration({ "classpath:*/configs/spring-config-hibernate.xml",
		"classpath:*/configs/spring-config-mvc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Record_Add_Test {

	private danhgia Danhgia;

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
	}

	@After
	public void TearDown() throws Exception {
	}

	// Kiểm tra hàm Save với dữ liệu đúng
	@Test
	public void REC_Add_01() {
		boolean kq;
		Danhgia.setId("123");
		Danhgia.setType(true);
		Danhgia.setReason("Abc");
		Danhgia.setDate("12/12/2020");
		Danhgia.setStaffId("NV01");
		kq = RecordDAO.Save(Danhgia);
		if (kq) {
			RecordDAO.DeleteTest(Danhgia.getId());
		}
		Assert.assertEquals(true, kq);
	}

	// Kiểm tra hàm Save với Id trùng
	@Test
	public void REC_Add_02() {
		boolean kq;
		Danhgia.setId("DG01");
		Danhgia.setType(true);
		Danhgia.setReason("Abc");
		Danhgia.setDate("12/12/2020");
		Danhgia.setStaffId("NV01");
		kq = RecordDAO.Save(Danhgia);
		if (kq) {
			RecordDAO.DeleteTest(Danhgia.getId());
		}
		Assert.assertEquals(false, kq);
	}

	// Kiểm tra hàm Save với Reason trống
	@Test
	public void REC_Add_03() {
		boolean kq;
		Danhgia.setId("123");
		Danhgia.setType(true);
		Danhgia.setDate("12/12/2020");
		Danhgia.setStaffId("NV01");
		kq = RecordDAO.Save(Danhgia);
		if (kq) {
			RecordDAO.DeleteTest(Danhgia.getId());
		}
		Assert.assertEquals(false, kq);
	}

	// Kiểm tra hàm Save với ngày không đúng định dạng
	@Test
	public void REC_Add_04() {
		boolean kq;
		Danhgia.setId("123");
		Danhgia.setType(true);
		Danhgia.setReason("Abc");
		Danhgia.setDate("13/14/5678");
		Danhgia.setStaffId("NV01");
		kq = RecordDAO.Save(Danhgia);
		if (kq) {
			RecordDAO.DeleteTest(Danhgia.getId());
		}
		Assert.assertEquals(false, kq);
	}

	// Kiểm tra hàm Save với StaffId không tồn tại
	@Test
	public void REC_Add_05() {
		boolean kq;
		Danhgia.setId("123");
		Danhgia.setType(true);
		Danhgia.setReason("Abc");
		Danhgia.setDate("13/14/5678");
		Danhgia.setStaffId("123");
		kq = RecordDAO.Save(Danhgia);
		if (kq) {
			RecordDAO.DeleteTest(Danhgia.getId());
		}
		Assert.assertEquals(false, kq);
	}
}
