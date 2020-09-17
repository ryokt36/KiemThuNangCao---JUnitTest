package poly.bean;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Departs")
public class phongban {
	@Id
	@Column(name = "Id")

	private String maphong;
	
	@Column(name = "Name")
	private String tenphong;
	


	public String getMaphong() {
		return maphong;
	}

	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}

	public String getTenphong() {
		return tenphong;
	}

	public void setTenphong(String tenphong) {
		this.tenphong = tenphong;
	}

	
}
