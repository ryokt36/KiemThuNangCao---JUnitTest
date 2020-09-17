package poly.DAO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poly.bean.NhanVien;
import poly.bean.danhgia;
import poly.bean.phongban;

@Repository
@Transactional
public class safftDAO {
@Autowired
SessionFactory factory;
private Object sessionFactory;

public List<NhanVien> getALLNhanviens(){
	Session session=factory.getCurrentSession();
	String hql="FROM NhanVien n ORDER BY n.maNV DESC";
	Query query=session.createQuery(hql);
	List<NhanVien> list= query.list();
	return list;
}



public NhanVien getNhanvienID(String id) {
	Session session= factory.openSession();
	Transaction t=session.beginTransaction();
	NhanVien nv= new NhanVien();
	try {
		nv= (NhanVien) session.get(NhanVien.class, id);
		t.commit();
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		System.out.print(e);
	}
	finally {
		session.close();
	
	}
	return nv;
}

public List<phongban> getPhongbans(){
	Session session=factory.getCurrentSession();
	String hql="from phongban";
	Query query= session.createQuery(hql);
	List<phongban> list=query.list();
	return list;
}

public boolean checkCodeId(String id) {
	Session session = this.factory.openSession();
	String hql = "from NhanVien n where n.maNV like '" + id + "'";
	List<NhanVien> list = session.createQuery(hql).list();
	if (list.isEmpty()) {
		return true;
	}
	System.out.println("mã nhân viên đã tồi tại: " + id);
	return false;
}

public boolean checkId(String ma) {
	Session session = this.factory.openSession();
	String hql = "from danhgia n where n.staffId like '" + ma + "'";
	List<danhgia> list = session.createQuery(hql).list();
	if (list.isEmpty()) {
		return true;
	}
	
	return false;
}



public List<NhanVien> timkiem(String tenNV){
	Session session=this.factory.openSession();
	String hql = "from NhanVien n where n.tenNV like '" + tenNV + "'";
	List<NhanVien> list= session.createQuery(hql).list();
	return list;
}


public boolean Save(NhanVien nhanvien) {
//	if(check(nhanvien)) {
//		if(checkCodeId(nhanvien.getMaNV())) {
	Session session= factory.openSession();
	Transaction t= session.beginTransaction();
	try {
		session.save(nhanvien);
		t.commit();
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		System.out.print(e);
	}
	
	finally {
		session.close();
		
	}
//		}
//	}
	return false;
	
}

public boolean update(NhanVien nhanVien){
	Session session= factory.openSession();
	Transaction t= session.beginTransaction();
	try {
		session.update(nhanVien);
		t.commit();
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		System.out.print(e);
	}
	finally {
		session.close();
	}
	return false;
}

public boolean delete(NhanVien nhanVien) {
	Session session=factory.openSession();
	Transaction t=session.beginTransaction();
	try {
		session.delete(nhanVien);
		t.commit();
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		t.rollback();
		System.out.print(e);
	}
	finally {
		session.close();
	}
	return false;
}

@SuppressWarnings("unchecked")
public boolean deleteTest(String maNV) {
	Session session=this.factory.openSession();
	String sql = "DELETE FROM NhanVien n where n.maNV like '" + maNV + "'";
	int line = session.createQuery(sql).executeUpdate();
	if (line > 0) {
		return true;
	}
	return false;
}

public boolean check(NhanVien nhanvien) {
	if(nhanvien.getMaNV().equals("")) {
		System.out.println("Vui lòng nhập đầy đủ mã nhân viên");
		return false;
	}
	if(nhanvien.getTenNV().equals("")) {
		System.out.println("Vui lòng nhập đầy đủ tên nhân viên");
		return false;
	}
	if(nhanvien.getNgaysinh().equals("")) {
		System.out.println("Vui lòng nhập đầy đủ ngày sinh nhân viên");
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
                 System.out.println("Phải nhập năm trước 16 năm");
                 return false;
             }
           
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ngày sinh phải định dạng Tháng/Ngày/Năm");
			return false;
		}
	}
	if(nhanvien.getAnh().equals("")) {
		System.out.println("file ảnh chưa được chọn");
		return false;
	}
	if(nhanvien.getMail().equals("")) {
		System.out.println("Vui lòng nhập đầy đủ email");
		return false;
	}
	else if (!(nhanvien.getMail()).matches("\\w+@\\w+\\.\\w+")) {
      System.out.println("Sai định dạng email");
        return false;
        }
	if(nhanvien.getSodt().equals("")) {
		System.out.println("Vui lòng nhập đầy đủ số điện thoại");
		return false;
	}
	else if(!nhanvien.getSodt().matches("[0-9]+")){
      System.out.println("Số điện thoại phải ở dạng số");
        return false;
    }
	else if(!(nhanvien.getSodt().length()==10)){
	       System.out.println("Số điện thoại phải 10 số");
	        return false;
	    }
	if(nhanvien.getLuong().equals("")) {
		System.out.println("vui lòng nhập đầy đủ tiền lương");
		return false;
	}
	else if(!nhanvien.getLuong().matches("[0-9]+")){
        System.out.println("lương phải ở dạng số");
        return false;
    }
//	if(nhanvien.getGhiChu().equals("") )
//			   {
//				message="Vui lòng đặt đầy đủ  ghi chú";
//				return false;
//			}
	return true;
}
@SuppressWarnings("unchecked")
public boolean SelectTestID(String manv) {
	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	NhanVien nv = new NhanVien();
	boolean kq;
	try {
		nv =  (NhanVien) session.get(NhanVien.class, manv);
		if(!nv.getMaNV().equals(null)) {
			kq = true;
		}else
			kq = false;
		t.commit();
	} catch (Exception e) {
		kq=false;
		t.rollback();
		System.out.println(e);
	}
	finally {
		session.close();
	}
	return kq;
	}

}
