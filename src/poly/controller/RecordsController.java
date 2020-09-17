package poly.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.DAO.recordsDAO;
import poly.bean.NhanVien;
import poly.bean.danhgia;

@Transactional
@Controller
@RequestMapping("/records")
public class RecordsController {

	@Autowired
	recordsDAO RecosrdsDao;
	private String message;
	
	
	@RequestMapping("DG")
	public String danhgia(ModelMap model) {
		List<danhgia> list=RecosrdsDao.getALLDanhgias();
		danhgia danhgia= new danhgia();
		
		model.addAttribute("danhgia", danhgia);
		model.addAttribute("ListDG", list);
		model.addAttribute("message",message);
		message="";
		return"Danhgia";
	}
	
	@ModelAttribute("nhanvien")
	public List<NhanVien> getNhanViens(){
		List<NhanVien> list= RecosrdsDao.getNhanViens();
		return list;
		
	}
	//edit
	
	@RequestMapping(value = "DG/{id}" ,method =  RequestMethod.GET)
	public String edit(ModelMap model, @PathVariable("id") String id) {
		System.out.print("edit");
		System.out.print("id danh gia"+id);
		
		danhgia dg= RecosrdsDao.getDanhgiaID(id);
		List<danhgia> list=RecosrdsDao.getALLDanhgias();
		danhgia DG= new danhgia();
		model.addAttribute("danhgia", dg);
		model.addAttribute("ListDG", list);
		
		return"Danhgia";
	}
	
//	xóa trắng
	
	@RequestMapping(params = "clear", method = RequestMethod.POST)
	public String clear() {
		System.out.print("xoa trang");
		return"redirect:/records/DG";
	}
	
	// SAVE
	@RequestMapping("SAVE")
	public String save(ModelMap model) {
		model.addAttribute("danhgia", new danhgia());
		return"Danhgia";
	}
	
	@RequestMapping(params = "save" ,method = RequestMethod.POST)
	public String save(@ModelAttribute("danhgia") danhgia danhgia) {
		
		
//		System.out.println("dg:"+danhgia.getId());
//		System.out.println("dg:"+danhgia.getType());
//		System.out.println("dg:"+danhgia.getReason());
//		System.out.println("dg:"+danhgia.getDate());
//		System.out.println("dg:"+danhgia.getStaffId());
////		
////		boolean check=RecosrdsDao.checkCodeId(danhgia.getId());
////		
////		if(check) {
////			RecosrdsDao.Save(danhgia);
////			System.out.print("luu duoc roi");
////			
////		}else {
////			System.out.print("failse ");
////		}
		if(check(danhgia)) {
		try {
			if(RecosrdsDao.checkCodeId(danhgia.getId())) {
				if(RecosrdsDao.Save(danhgia)) {
					System.out.print("luu duoc roi");
					message="Đánh giá đã được lưu";
				}
			}else {
				System.out.print("đánh giá đã tồn tại");
				message="Đánh giá đã tồn tại";
			}
		} catch (Exception e) {
			System.out.print("failse "+e);
			message="Lưu thất bại";
		}
		}
//		System.out.print("luu duoc roi");
		return"redirect:/records/DG";
	}
	
	
	
	//Update
	@RequestMapping(params = "update" ,method = RequestMethod.POST)
	public String update(@ModelAttribute("danhgia") danhgia danhgia) {
		
		
//		System.out.println("dg:"+danhgia.getId());
//		System.out.println("dg:"+danhgia.getType());
//		System.out.println("dg:"+danhgia.getReason());
//		System.out.println("dg:"+danhgia.getDate());
//		System.out.println("dg:"+danhgia.getStaffId());
////		
////		boolean check=RecosrdsDao.checkCodeId(danhgia.getId());
////		
////		if(check) {
////			RecosrdsDao.Save(danhgia);
////			System.out.print("luu duoc roi");
////			
////		}else {
////			System.out.print("failse ");
////		}
		if(check(danhgia)) {
		try {
			
				if(RecosrdsDao.update(danhgia)) {
					System.out.print("luu duoc roi");
					message="Đánh giá đã được lưu";
				}
			else {
				System.out.print("mã đánh giá sai ");
				message="Mã đánh giá sai ";
			}
		} catch (Exception e) {
			System.out.print("failse "+e);
			message="Lưu thất bại";
		}
		}
//		System.out.print("luu duoc roi");
		return"redirect:/records/DG";
	}
	
	
	
	//delete
	@RequestMapping(params = "delete" ,method = RequestMethod.POST)
	public String del(@ModelAttribute("danhgia") danhgia danhgia) {
		
		
//		System.out.println("dg:"+danhgia.getId());
//		System.out.println("dg:"+danhgia.getType());
//		System.out.println("dg:"+danhgia.getReason());
//		System.out.println("dg:"+danhgia.getDate());
//		System.out.println("dg:"+danhgia.getStaffId());
////		
////		boolean check=RecosrdsDao.checkCodeId(danhgia.getId());
////		
////		if(check) {
////			RecosrdsDao.Save(danhgia);
////			System.out.print("luu duoc roi");
////			
////		}else {
////			System.out.print("failse ");
////		}
//		
		
		if(danhgia.getId().equals("")) {
			message="kiểm tra lại thông tin nhập vào, mã đánh giá đang rỗng hoặc không tồn tại";
		}else {
		try {
			if(!RecosrdsDao.checkCodeId(danhgia.getId())) {
				if(RecosrdsDao.delete(danhgia)) {
					System.out.print("luu duoc roi");
					message="Đánh giá đã xóa";
				}
				}
			else {
				message="Không có dữ liệu để xóa";
			}
		
		} catch (Exception e) {
			System.out.print("failse "+e);
			message="Lưu thất bại";
		}
		}
//		System.out.print("luu duoc roi");
		return"redirect:/records/DG";
	}
	
	//check
	
	public boolean check(danhgia danhgia) {
		if(danhgia.getId().equals("")) {
			message="Vui lòng nhập đầy đủ mã đánh giá";
			return false;
		}
		if(danhgia.getReason().equals("")) {
			message="Vui lòng nhập đầy đủ ghi chú";
			return false;
		}
		if(danhgia.getDate().equals("")) {
			message="Vui lòng nhập đầy đủ ngày đánh giá";
			return false;
		}
		else {
			try {
				 SimpleDateFormat form = new SimpleDateFormat("MM/dd/yyyy");
	             form.setLenient(false);
	             Date date = form.parse(danhgia.getDate());
	             
			} catch (Exception e) {
				// TODO: handle exception
				message="Ngày sinh phải định dạng Tháng/Ngày/Năm";
				return false;
			}
		}
		
		return true;
	}
}
