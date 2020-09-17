package poly.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Records")
public class danhgia {

	@Id

	private String id;

	private boolean type;
	private String reason;

	
	private String date;



	private String staffId;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public boolean getType() {
		return type;
	}


	public void setType(boolean type) {
		this.type = type;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getDate() {
		return date;
	}


	public String getStaffId() {
		return staffId;
	}


	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}


	public void setDate(String date) {
		this.date = date;
	}



}
