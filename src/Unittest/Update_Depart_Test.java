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

import poly.DAO.departsDAO;
import poly.bean.phongban;

@Transactional
@Controller
@ContextConfiguration({ "classpath:*/configs/spring-config-hibernate.xml",
		"classpath:*/configs/spring-config-mvc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Update_Depart_Test {
private phongban DP;
	
	@Autowired
	departsDAO DAO;
	
	@BeforeClass
	public static void SetUpBFClass() throws Exception{
		
	}
	
	@AfterClass
	public static void TearDownATClass() throws Exception{
		
	}
	
	@Before
	public void SetUp() throws Exception{
		DP = new phongban();
	}
	@After
	public void TearDown() throws Exception{
//		DAO.deleteTest(DP.getMaphong());
		
	}
	
	//Update tên phòng ban(nhân sự => bảo vệ)
	@Test
	public void DP_Update_01() {
		boolean result;
		DP.setMaphong("pb01");
		DP.setTenphong("bảo vệ");
		result = DAO.update(DP);
		assertEquals(true, result);
	}

	//Update dể trống tên phòng ban 
	@Test
	public void DP_Update_02() {
		boolean result;
		DP.setMaphong("pb01");
		DP.setTenphong(null);
		result = DAO.update(DP);
		assertEquals(false, result);
	}
	//mã phòng ban trống 
	@Test
	public void DP_Update_03() {
		boolean result;
		DP.setMaphong(null);
		DP.setTenphong("bảo vệ");
		result = DAO.update(DP);
		assertEquals(false, result);
	}
	//Update PB không tồn tại
	@Test
	public void DP_Update_04() {
		boolean result;
		DP.setMaphong("pb06");
		DP.setTenphong("bảo vệ");
		result = DAO.update(DP);
		assertEquals(false, result);
	}
	
	
}
