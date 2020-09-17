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
public class Record_Delete_Test {

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
	
	
	//Kiểm tra hàm Delete với dữ liệu tồn tại
	@Test
	public void REC_Delete_01() {
		boolean kq;
		Danhgia = RecordDAO.getDanhgiaID("DG01");
		RecordDAO.delete(Danhgia);
		RecordDAO.Save(Danhgia);
		kq = RecordDAO.SelectTestID("DG01");
		Assert.assertEquals(true, kq);
	}
	
	//Kiểm tra hàm Delete với dữ liệu không tồn tại
		@Test
		public void REC_Delete_02() {
			boolean kq;
			Danhgia = RecordDAO.getDanhgiaID("123");
			RecordDAO.delete(Danhgia);
			RecordDAO.Save(Danhgia);
			kq = RecordDAO.SelectTestID("123");
			Assert.assertEquals(false, kq);
		}
}
