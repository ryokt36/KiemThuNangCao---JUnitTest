package poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jdk.nashorn.internal.objects.annotations.Getter;
import poly.DAO.userDAO;
import poly.bean.nguoidung;

@Transactional
@Controller
@RequestMapping("/login")

public class LoginController {
	@Autowired
	userDAO userdao;
	SessionFactory factory;
	private String message;
	
	
	
	
	@RequestMapping(params = "login", method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username"); 
		String password = request.getParameter("password");
		if(userdao.checkUser(username, password)) {
		session.setAttribute("User", username);
			return"redirect:/user/QLTK"; 
		}else {
			return"redirect:/clien.jsp";
		}
		
	}
	
	
//	@RequestMapping(params = "logout", method=RequestMethod.GET)
//	public String logout(HttpSession session) {
//		session.removeAttribute("User");
//		return "redirect:/login.jsp";
//	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("User");
		return "redirect:/login.jsp";
	}
	/*
	 * @RequestMapping("dangky") public String dangky() { return"DangKy"; }
	 */
	
	/*
	 * @RequestMapping(params = "signup", method=RequestMethod.GET) public String
	 * dangki(HttpServletRequest request, HttpSession session) {
	 * 
	 * return"redirect:/DangKy.jsp"; }
	 * 
	 * @RequestMapping(params = "cancer", method=RequestMethod.GET) public String
	 * back(HttpServletRequest request, HttpSession session) {
	 * 
	 * return"redirect:/login.jsp"; }
	 */
	/*
	 * @RequestMapping("changepass") public String changePass() {
	 * return"ChangePass"; }
	 * 
	 * @RequestMapping(params = "changepass",method = RequestMethod.POST) public
	 * String changePass( @ModelAttribute("user") nguoidung nguoidung,
	 * 
	 * @RequestParam("username") String username,
	 * 
	 * @RequestParam("password") String password,
	 * 
	 * @RequestParam("password1") String newpass1,
	 * 
	 * @RequestParam("password2") String newpass2) { try {
	 * if(!nguoidung.getUsername().equals(username)) { message="Sai tên đăng nhập";
	 * }if (!nguoidung.getPassword().equals(password)) { message="Sai mật khẩu cũ";
	 * }if (password.equals(newpass1)) {
	 * message="mật khẩu mới và cũ không được trùng nhau"; }if
	 * (!newpass1.equals(newpass2)) {
	 * message="mật khẩu mới và xác nhận mật khẩu không trùng nhau"; }
	 * nguoidung.setPassword(newpass2); if(userdao.editUser(nguoidung)) {
	 * message="Đổi mật khẩu thành công"; } } catch (Exception e) { // TODO: handle
	 * exception message="Đổi mật khẩu thất bại"; }
	 * return"redirect:/ChangePass.jsp"; }
	 */
}
