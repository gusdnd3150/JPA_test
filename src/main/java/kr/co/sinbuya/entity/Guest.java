package kr.co.sinbuya.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@SuppressWarnings("serial")
@Entity
@Table(name = "guest")
@Where(clause="`enabled` = 1")
public class Guest implements Serializable {

	private long id;
	private String mode;
	private Area area;
	private String from;
	private Staff account;
	private String mname;
	private String mtel;
	private String mmail;
	private String fname;
	private String ftel;
	private String fmail;
	private Date rehearsalDate;
	private Date marryDate;
	private int status;
	private Integer vstatus;
	private String extraStatus;
	private boolean enabled;
	private Date createdAt;
	private Date updatedOn;
	private Integer lastSigned;


	public Guest() {

	}

	public Guest(long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "mode")
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	@Column(name = "`from`")
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	public Staff getAccount() {
		return account;
	}

	public void setAccount(Staff account) {
		this.account = account;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "area_id")
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}	

	@Column(name = "mname")
	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Column(name = "mtel")
	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	@Column(name = "mmail")
	public String getMmail() {
		return mmail;
	}

	public void setMmail(String mmail) {
		this.mmail = mmail;
	}

	@Column(name = "fname")
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column(name = "ftel")
	public String getFtel() {
		return ftel;
	}

	public void setFtel(String ftel) {
		this.ftel = ftel;
	}

	@Column(name = "fmail")
	public String getFmail() {
		return fmail;
	}

	public void setFmail(String fmail) {
		this.fmail = fmail;
	}

	@Column(name = "rehearsal_date")
	public Date getRehearsalDate() {
		return rehearsalDate;
	}

	public void setRehearsalDate(Date rehearsalDate) {
		this.rehearsalDate = rehearsalDate;
	}

	@Column(name = "marry_date")
	public Date getMarryDate() {
		return marryDate;
	}

	public void setMarryDate(Date marryDate) {
		this.marryDate = marryDate;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	@Formula("( SELECT v.status FROM voucher v WHERE v.id = id )")
	public Integer getVstatus() {
		return vstatus;
	}

	public void setVstatus(Integer vstatus) {
		this.vstatus = vstatus;
	}

	@Column(name = "extra_status")
	public String getExtraStatus() {
		return extraStatus;
	}

	public void setExtraStatus(String extraStatus) {
		this.extraStatus = extraStatus;
	}

	@Column(name = "enabled")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "created_at")
	@CreatedDate
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "updated_on")
	@LastModifiedDate
	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	@Column(name = "last_signed")
	public Integer getLastSigned() {
		return lastSigned;
	}

	public void setLastSigned(Integer lastSigned) {
		this.lastSigned = lastSigned;
	}

	@Transient
	public String getTitle() {
		if (this.mode.equals("M")) {
			return this.mname + " 신랑님";
		} else if (this.mode.equals("F")) {
			return this.fname + " 신부님";
		} else {
			return this.mname + " 신랑 / " + this.fname + " 신부님";
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guest other = (Guest) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
