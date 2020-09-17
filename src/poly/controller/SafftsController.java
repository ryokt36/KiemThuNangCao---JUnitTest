package poly.controller;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.DAO.safftDAO;
import poly.bean.NhanVien;

import poly.bean.phongban;

@Transactional
@Controller
@RequestMapping("/safft")
public class SafftsController {
@Autowired

safftDAO SafftDAO;
private  String message;
private  String anh;

//lấy dữ liệu
@RequestMapping("QLNV") 
public String DSnhanvien(ModelMap model) {
	List<NhanVien> list= SafftDAO.getALLNhanviens();
	NhanVien NV= new NhanVien();
	model.addAttribute("NV",NV);
	model.addAttribute("nhanvien", list);
	model.addAttribute("message", message);
	model.addAttribute("anh", anh);
	message="";
	anh="";
	return"QLnhanvien";
}

//SELECT thông tin phong ban
@ModelAttribute("phong")
public List<phongban> getPhongbans(){
	List<phongban> list=SafftDAO.getPhongbans();
	
	return list;
}

//EDIT
@RequestMapping(value="QLNV/{id}" , method = RequestMethod.GET)
public String edit(ModelMap model, @PathVariable("id") String maNV) {
	
	System.out.print("Edit");
	System.out.print("ma nhan vien" +maNV);
	
	NhanVien nv = SafftDAO.getNhanvienID(maNV);
	
	List<NhanVien> list=SafftDAO.getALLNhanviens();
	
	NhanVien NV= new NhanVien();
	
	model.addAttribute("NV",nv);
	model.addAttribute("nhanvien", list);

	return"QLnhanvien";

}
@RequestMapping(params = "tim" ,method = RequestMethod.POST)
public String timkiem(ModelMap model,HttpServletRequest request,@ModelAttribute("NV") NhanVien nhanvien) {
	String tim = request.getParameter("timkiem");
	

	SafftDAO.timkiem(tim);

//	NhanVien NV= new NhanVien();
//	model.addAttribute("NV",NV);
//	model.addAttribute("nhanvien", list);


	return"redirect:/safft/QLNV";
}
//CLEAR
@RequestMapping(params = "clear", method = RequestMethod.POST)
public String clears() {
	System.out.print("xóa trắng ");
	return"redirect:/safft/QLNV";
}


//SAVE
@RequestMapping("SAVE")
public String luu(ModelMap model) {
	model.addAttribute("NV", new NhanVien());
	return"QLnhanvien";
}


//@InitBinder
//public void initBinder(WebDataBinder binder) {
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
//    sdf.setLenient(true);
//    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//}





@RequestMapping(params = "save" ,method = RequestMethod.POST)
public String luu(@ModelAttribute("NV") NhanVien nhanvien) {
	
	if(check(nhanvien)){

		try {
			System.out.println(SafftDAO);
			if (SafftDAO.checkCodeId(nhanvien.getMaNV())) {
				if(SafftDAO.Save(nhanvien)) {
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
	
	
	return "redirect:/safft/QLNV";
}


//UPDATE

@RequestMapping(params = "update" ,method = RequestMethod.POST)
public String update(@ModelAttribute("NV") NhanVien nhanvien) {

	if(check(nhanvien)) {
		
		try {
			
			if(SafftDAO.update(nhanvien)) {
				message = "Cập nhật thàng công";
				System.out.print("ok");
			}
		
			else {
				message = "Sai mã nhân viên";
				System.out.print(" sai mã rồi");
			}
		
	} catch (Exception e) {
		// TODO: handle exception
		message = "Cập nhật thất bại";
		System.out.print(" failse"+e);
	}
}	
	return "redirect:/safft/QLNV";
}


//DELETE

@RequestMapping(params = "delete", method = RequestMethod.POST)
public String del(@ModelAttribute("NV") NhanVien nhanVien) {
	if(nhanVien.getMaNV().equals("")) {
		message="kiểm tra lại thông tin nhập vào, mã nhân viên đang rỗng hoặc không tồn tại";
	}else {
		
	try {
		if (!SafftDAO.checkCodeId(nhanVien.getMaNV())) {
		if(SafftDAO.checkId(nhanVien.getMaNV())) {	
		if(SafftDAO.delete(nhanVien)) {
			message="Xóa thành công";
			System.out.print("ok");
		}
		}else {
			message="Đánh giá của nhân viên này đang tồi tại, không thể xóa nhân viên này";
		}
		}else {
			message="Không có dữ liệu để xóa";
		}

	} catch (Exception e) {
		// TODO: handle exception
		message="Xóa thất bại";
		System.out.print("toang rồi "+e);
	}
	}
	return "redirect:/safft/QLNV";
}


//UPLOAD

@RequestMapping(params = "upload" ,method = RequestMethod.POST)
public String upload(ModelMap model ,@RequestParam("photo") MultipartFile photo) {
	System.out.println("ảnh đây");
	if(photo.isEmpty()) {
		message="vui long tron file";
	}else {
		try {
			String photopath = "C:\\Users\\ADMIN\\eclipse-workspace\\AssignmentHT_lucntph07957_java5\\WebContent\\images\\"+photo.getOriginalFilename();
			photo.transferTo(new File(photopath));
			anh= photo.getOriginalFilename();
			return "redirect:/safft/QLNV";
		} catch (Exception e) {
			message="loi tai file";
		}
		
	}
	
	return "redirect:/safft/QLNV";
}

//CHECK

public boolean check(NhanVien nhanvien) {
	if(nhanvien.getMaNV().equals("")) {
		message="Vui lòng nhập đầy đủ mã nhân viên";
		return false;
	}
	if(nhanvien.getTenNV().equals("")) {
		message="Vui lòng nhập đầy đủ tên nhân viên";
		return false;
	}
	if(nhanvien.getNgaysinh().equals("")) {
		message="Vui lòng nhập đầy đủ ngày sinh nhân viên";
		return false;
	}
	else {
		try {
			 SimpleDateFormat form = new SimpleDateFormat("MM/dd/yyyy");
             form.setLenient(false);
             Date date = form.parse(nhanvien.getNgaysinh());
             Calendar cal = Calendar.getInstance();
             String nam = nhanvien.getNgaysinh().substring(6, 10);
             if ((cal.get(Calendar.YEAR) - Integer.parseInt(nam)) < 16) {
                 message= "Phải nhập năm trước 16 năm";
                 return false;
             }
           
		} catch (Exception e) {
			// TODO: handle exception
			message="Ngày sinh phải định dạng Tháng/Ngày/Năm";
			return false;
		}
	}
	if(nhanvien.getAnh().equals("")) {
		message="file ảnh chưa được chọn";
		return false;
	}
	if(nhanvien.getMail().equals("")) {
		message="Vui lòng nhập đầy đủ email";
		return false;
	}
	else if (!(nhanvien.getMail()).matches("\\w+@\\w+\\.\\w+")) {
        message= "Sai định dạng email";
        return false;
        }
	if(nhanvien.getSodt().equals("")) {
		message="Vui lòng nhập đầy đủ số điện thoại";
		return false;
	}
	else if(!nhanvien.getSodt().matches("[0-9]+")){
       message= "Số điện thoại phải ở dạng số";
        return false;
    }
	else if(!(nhanvien.getSodt().length()==10)){
	       message= "Số điện thoại phải 10 số";
	        return false;
	    }
	if(nhanvien.getLuong().equals("")) {
		message="vui lòng nhập đầy đủ tiền lương";
		return false;
	}
	else if(!nhanvien.getLuong().matches("[0-9]+")){
        message="lương phải ở dạng số";
        return false;
    }
	if(nhanvien.getGhiChu().equals("") )
			   {
				message="Vui lòng đặt đầy đủ  ghi chú";
				return false;
			}
	return true;
}



}
