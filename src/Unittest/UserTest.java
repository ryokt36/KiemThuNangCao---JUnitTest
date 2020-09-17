package Unittest;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

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
import org.springframework.test.context.web.WebAppConfiguration;

import poly.DAO.userDAO;

import poly.bean.nguoidung;

@Transactional
@Controller
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:*/configs/spring-config-hibernate.xml",
	"classpath:*/configs/spring-config-mvc.xml"})
public class UserTest {
	private nguoidung user;
	

	@Autowired
	userDAO UserDao;
	
	@BeforeClass
	public static void setBeforeClass() throws Exception{
		
	}@AfterClass
	public static void tearAfterClass() throws Exception{
		
	}
	 @Before
	 public void SetUp() throws Exception{
		user = new nguoidung();
	 }
	 
	 @After
	 public void tearDow() throws Exception{
	 }
	 //Đăng nhập đúng
	@Test
	public void LG_login_01() {		
		boolean result;
		user.setUsername("luc");
		user.setPassword("456");
		result = UserDao.checkUser(user.getUsername(), user.getPassword());
		assertEquals(true, result);
		
	}
	 //Đăng nhập sai tài khoản, đúng mật khẩu
		@Test
		public void LG_login_02() {		
			boolean result;
			user.setUsername("lucnt");
			user.setPassword("456");
			result = UserDao.checkUser(user.getUsername(), user.getPassword());
			assertEquals(false, result);
			
		}
		//Đăng nhập đúng tài khoản, sai mật khẩu
		@Test
		public void LG_login_03() {		
			boolean result;
			user.setUsername("luc");
			user.setPassword("123");
			result = UserDao.checkUser(user.getUsername(), user.getPassword());
			assertEquals(false, result);
		
		}
		//Trống tài khoản
		@Test
		public void LG_login_04() {		
			boolean result;
			user.setUsername("");
			user.setPassword("123");
			result = UserDao.checkUser(user.getUsername(), user.getPassword());
			assertEquals(false, result);
			
		}
		//Trống mật khẩu
		@Test
		public void LG_login_05() {		
			boolean result;
			user.setUsername("luc");
			user.setPassword(null);
			result = UserDao.checkUser(user.getUsername(), user.getPassword());
			assertEquals(false, result);
			
		}
		//Đăng nhập với tài khoản và mật khẩu rỗng
		@Test
		public void LG_login_06() {		
			boolean result;
			user.setUsername(null);
			user.setPassword(null);
			result = UserDao.checkUser(user.getUsername(), user.getPassword());
			assertEquals(false, result);
					
		}
		//tài khoản khác
		@Test
		public void LG_login_07() {		
			boolean result;
			user.setUsername("Luong");
			user.setPassword("456");
			result = UserDao.checkUser(user.getUsername(), user.getPassword());
			assertEquals(false, result);
					
		}
		//Mật khẩu khác
		@Test
		public void LG_login_08() {		
			boolean result;
			user.setUsername("luc");
			user.setPassword("123");
			result = UserDao.checkUser(user.getUsername(), user.getPassword());
			assertEquals(false, result);
					
		}
		//Sai tài khoản, sai mật khẩu
		@Test
		public void LG_login_09() {		
			boolean result;
			user.setUsername("lucnt");
			user.setPassword("1234");
			result = UserDao.checkUser(user.getUsername(), user.getPassword());
			assertEquals(false, result);
					
		}



}
