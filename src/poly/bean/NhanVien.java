package poly.bean;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Staffs")
public class NhanVien {
@Id
@Column(name = "Id")
private String maNV;

@Column(name = "Name")
private String tenNV;


@Column(name = "Gender")
private boolean gioitinh;


@Column(name = "Birthday")
private String ngaysinh;

@Column(name = "Photo")
private String anh;

@Column(name = "Email")
private String Mail;

@Column(name = "Phone")
private String Sodt;

@Column(name = "Salary")
private String Luong;

@Column(name = "Notes")
private String GhiChu;


public String getDepartid() {
	return departid;
}

public void setDepartid(String departid) {
	this.departid = departid;
}

@Column(name = "DepartId")
private String departid;


public String getMaNV() {
	return maNV;
}

public void setMaNV(String maNV) {
	this.maNV = maNV;
}

public String getTenNV() {
	return tenNV;
}

public void setTenNV(String tenNV) {
	this.tenNV = tenNV;
}

public boolean isGioitinh() {
	return gioitinh;
}

public void setGioitinh(boolean gioitinh) {
	this.gioitinh = gioitinh;
}

public String getNgaysinh() {
	return ngaysinh;
}

public void setNgaysinh(String ngaysinh) {
	this.ngaysinh = ngaysinh;
}

public String getAnh() {
	return anh;
}

public void setAnh(String anh) {
	this.anh = anh;
}

public String getMail() {
	return Mail;
}

public void setMail(String mail) {
	Mail = mail;
}

public String getSodt() {
	return Sodt;
}

public void setSodt(String sodt) {
	Sodt = sodt;
}

public String getLuong() {
	return Luong;
}

public void setLuong(String luong) {
	Luong = luong;
}

public String getGhiChu() {
	return GhiChu;
}

public void setGhiChu(String ghiChu) {
	GhiChu = ghiChu;
}


}
