package poly.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import poly.DAO.departsDAO;



@Transactional
@Controller
@RequestMapping("/User")
public class DepartsController {
@Autowired
departsDAO DepartsDao;

private String message;

@RequestMapping("QLPB")
public String phongban(ModelMap model) {
	
	List<poly.bean.phongban> list=DepartsDao.getAllPhongbans();
	 poly.bean.phongban PB =new poly.bean.phongban();
	
	
	model.addAttribute("PB", PB);
	model.addAttribute("phongban", list);
	model.addAttribute("message", message);
	message= "";
	return"QLphongban";
	
}

@RequestMapping("SAVE")
public String luu(ModelMap model) {
	model.addAttribute("PB", new poly.bean.phongban());
	return"QLphongban";
}



@RequestMapping(params = "save" ,method = RequestMethod.POST)
public String luu(@ModelAttribute("PB") poly.bean.phongban phongban
		) {
	if(phongban.getMaphong().equals("")||phongban.getTenphong().equals("")) {
		message="nhập thiếu thông tin";
	}else {
		
	try {
		if (DepartsDao.checkCodeId(phongban.getMaphong())) {
			if(DepartsDao.Save(phongban)) {
				message = "Lưu thành công";
				System.out.print("ok");
			}
			}
			else {
				message = "Đã Tồn Tại";
				System.out.print(" da ton tai");
			}
		
	} catch (Exception e) {
		// TODO: handle exception
		message = "lưu thất bại";
		System.out.print(" failse");
	}
	}
	
	return"redirect:/User/QLPB";
}


@RequestMapping(params = "clear" ,method = RequestMethod.POST)
public String clear() {
	return"redirect:/User/QLPB";
}


@RequestMapping(value="QLPB/{maphong}" , method = RequestMethod.GET)
public String edit(ModelMap model, @PathVariable("maphong") String maphong) {
	
	System.out.print("Edit");
	System.out.print("Ma phong ban:" +maphong);
	poly.bean.phongban pb = DepartsDao.getPhongBanByID(maphong);

	List<poly.bean.phongban> list=DepartsDao.getAllPhongbans();
	 poly.bean.phongban PB =new poly.bean.phongban();
	
	model.addAttribute("PB", pb);
	model.addAttribute("phongban", list);
	
	
	return"QLphongban";

}


	
@RequestMapping(params = "update" ,method = RequestMethod.POST)
public String update(@ModelAttribute("PB") poly.bean.phongban phongban) {
	if(phongban.getMaphong().equals("")||phongban.getTenphong().equals("")) {
		message="Nhập thiếu thông tin";
	}else {
	try {
	
			if(DepartsDao.update(phongban)) {
				message = "Cập nhật thàng công";
				System.out.print("ok");
			}
		
			else {
				message = "Sai mã phòng ban";
				System.out.print(" sai mã rồi");
			}
		
	} catch (Exception e) {
		// TODO: handle exception
		message = "Cập nhật thất bại";
		System.out.print(" failse"+e);
	}
	}
	
	
	return"redirect:/User/QLPB";
}

@RequestMapping(params = "delete", method = RequestMethod.POST)
public String del(@ModelAttribute("PB") poly.bean.phongban phongban) {
	if(phongban.getMaphong().equals("")||phongban.getTenphong().equals("")) {
		message="Kiểm tra lại thông tin nhập vào, mã phòng ban rỗng hoặc không tồn tại";
	}else {
	try {
		if (!DepartsDao.checkCodeId(phongban.getMaphong())) {
		if(DepartsDao.checkId(phongban.getMaphong())) {	
		if(DepartsDao.delete(phongban)) {
			message="Xóa thành công";
			System.out.print("ok");
		}
		}else {
			message="Có nhân viên đang tồn tại trong phòng ban, không thể xóa phòng ban này";
		}
		}
		else {
			message="Không có dữ liệu để xóa";
			System.out.print("làm gì có mã mà xóa");
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		message="Xóa thất bại";
		System.out.print("toang rồi "+e);
	}}
	return"redirect:/User/QLPB";
}

}









