package poly.DAO;

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
public class recordsDAO {
	@Autowired
	SessionFactory factory;
	
	public List<danhgia> getALLDanhgias(){
		Session session=factory.getCurrentSession();
		String hql="FROM danhgia d ORDER BY d.id DESC";
		Query query=session.createQuery(hql);
		List<danhgia> list= query.list();
		return list;
	}
	
	public danhgia getDanhgiaID(String id) {
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		danhgia dg=new danhgia();
		try {
			dg=(danhgia) session.get(danhgia.class, id);
			t.commit();
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			System.out.print(e);
		}
		finally {
			session.close();
		}
		return dg;
	}
	
	public List<NhanVien> getNhanViens(){
		Session session= factory.getCurrentSession();
		String hql="from NhanVien";
		Query query=session.createQuery(hql);
		List<NhanVien> list=query.list();
		return list;
	}
	
	public boolean checkCodeId(String ma) {
		Session session = this.factory.openSession();
		String hql = "from danhgia n where n.id like '" + ma + "'";
		List<danhgia> list = session.createQuery(hql).list();
		if (list.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	public boolean Save(danhgia danhgia) {
		
		Session session= factory.openSession();
		Transaction t= session.beginTransaction();
		try {
			session.save(danhgia);
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

	public boolean update(danhgia danhgia){
		Session session= factory.openSession();
		Transaction t= session.beginTransaction();
		try {
			session.update(danhgia);
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
	
	
	public boolean delete(danhgia danhgia) {
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		try {
			session.delete(danhgia);
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
	public boolean DeleteTest(String Id) {
		Session session=this.factory.openSession();
		String sql = "DELETE FROM danhgia d where d.id like '" + Id + "'";
		int line = session.createQuery(sql).executeUpdate();
		if (line > 0) {
			return true;
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public boolean SelectTestID(String id) {
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		danhgia dg=new danhgia();
		boolean kq;
		try {
			dg=(danhgia) session.get(danhgia.class, id);
			if(!dg.getId().equals(null)) {
				kq = true;
			}
			else kq = false;
			t.commit();
		} catch (Exception e) {
			kq = false;
			t.rollback();
			System.out.print(e);
		}
		finally {
			session.close();
		}
		return kq;
	}
	
}
