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
import poly.bean.phongban;

@Repository
@Transactional
public class departsDAO {
	@Autowired
	SessionFactory factory;

	public List<phongban> getAllPhongbans() {

		Session session = factory.getCurrentSession();
		String hql = "from phongban p ORDER BY p.maphong DESC";
		Query query = session.createQuery(hql);
		List<phongban> list = query.list();

		return list;
	}

	public boolean checkCodeId(String id) {
		Session session = this.factory.openSession();
		String hql = "from phongban p where p.maphong like '" + id + "'";
		List<phongban> list = session.createQuery(hql).list();
		if (list.isEmpty()) {
			return true;
		}

		return false;
	}

	public boolean checkId(String id) {
		Session session = this.factory.openSession();
		String hql = "from NhanVien n where n.departid like '" + id + "'";
		List<NhanVien> list = session.createQuery(hql).list();
		if (list.isEmpty()) {
			return true;
		}

		return false;
	}

	public boolean Save(phongban phongban) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(phongban);
			t.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			System.out.print(e);
		} finally {
			session.close();
		}
		return false;
	}

	public phongban getPhongBanByID(String id) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		phongban pb = new phongban();
		try {

			pb = (phongban) session.get(phongban.class, id);

			t.commit();

		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			System.out.print(e);
		} finally {
			session.close();
		}
		return pb;

	}

	public boolean update(phongban phongban) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(phongban);
			t.commit();
			return true;
		} catch (Exception e) {

			t.rollback();
			System.out.print(e);
		} finally {
			session.close();
		}
		return false;
	}

	public boolean delete(phongban phongban) {
		if (!checkCodeId(phongban.getMaphong())) {
			if (checkId(phongban.getMaphong())) {
				Session session = factory.openSession();
				Transaction t = session.beginTransaction();
				try {
					session.delete(phongban);
					t.commit();
					return true;
				} catch (Exception e) {
					t.rollback();
					System.out.print(e);
				} finally {
					session.close();
				}
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteTest(String maphong) {
		Session session = this.factory.openSession();
		String sql = "DELETE FROM phongban p where p.maphong like '" + maphong + "'";
		int line = session.createQuery(sql).executeUpdate();
		if (line > 0) {
			return true;
		}
		return false;
	}

}
