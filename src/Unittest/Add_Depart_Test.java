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
public class Add_Depart_Test {
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
		DAO.deleteTest(DP.getMaphong());
		
	}
	
	// thêm phòng ban mới
	
	@Test
	public void DP_Add_01() {
		boolean result;
		DP.setMaphong("pb06");
		DP.setTenphong("abc");
		result = DAO.Save(DP);
		assertEquals(true, result);
//		if(result) {
//			DAO.deleteTest(DP.getMaphong());
//		}
	}
	
	// nhập mã phòng đã tồn tại
	@Test
	public void DP_Add_02() {
		boolean result;
		DP.setMaphong("pb01");
		DP.setTenphong("xyz");
		result = DAO.Save(DP);
		assertEquals(false, result);
		//Pass
	}
	
	//để trống id
	@Test
	public void DP_Add_03() {
		boolean result;
		DP.setMaphong(null);
		DP.setTenphong("abc");
		result = DAO.Save(DP);
		assertEquals(false, result);
	}
	
	//để trống tên phòng
	@Test
	public void DP_Add_04() {
		boolean result;
		DP.setMaphong("pb05");
		DP.setTenphong(null);
		result = DAO.Save(DP);
		assertEquals(false, result);
	}
	
	//để trống cả 2
	@Test
	public void DP_Add_05() {
		boolean result;
		DP.setMaphong(null);
		DP.setTenphong(null);
		result = DAO.Save(DP);
		assertEquals(false, result);
	}
	

	
}
