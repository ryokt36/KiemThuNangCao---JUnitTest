package poly.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import poly.bean.NhanVien;
import poly.bean.nguoidung;

@Repository
@Transactional
public class userDAO {
	@Autowired
	SessionFactory factory;
	public List<nguoidung> getAllNguoidung(){
		Session session= factory.getCurrentSession();
		String hql="FROM nguoidung";
		Query query= session.createQuery(hql);
		List<nguoidung> list= query.list();
		return list;
	}
	
	public boolean checkUser(String username , String password) {
		Session	session = this.factory.getCurrentSession();	
		nguoidung User = (nguoidung) session.get(nguoidung.class, username);
		if (User == null) {
			return false; 
		}
		if (User.getUsername().equals(username) && User.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
//	public nguoidung getUser(String user) {
//		Session session= factory.getCurrentSession();
//		String hql="FROM nguoidung where username like " + user;
//		Query query= session.createQuery(hql);
//		nguoidung user = query.
//	}
}
