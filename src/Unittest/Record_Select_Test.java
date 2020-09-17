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
import poly.DAO.recordsDAO;
import poly.bean.danhgia;

@Transactional
@Controller
@ContextConfiguration({ "classpath:*/configs/spring-config-hibernate.xml",
		"classpath:*/configs/spring-config-mvc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Record_Select_Test {
	
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
	
	//Kiểm tra hàm Select tất cả dữ liệu
	@Test
	public void REC_Select_01() {
		boolean kq = true;
		List<danhgia> list = RecordDAO.getALLDanhgias();
		if(list.isEmpty()) {
			kq = false;
		}
		Assert.assertEquals(true, kq);
	}
	
	//Kiểm tra hàm Select 1 bản ghi
		@Test
		public void REC_Select_02() {
			boolean kq = true;
			Danhgia = RecordDAO.getDanhgiaID("DG01");
			if(Danhgia.getId().equals("")) {
				kq = false;
			}
			Assert.assertEquals(true, kq);
		}
}
