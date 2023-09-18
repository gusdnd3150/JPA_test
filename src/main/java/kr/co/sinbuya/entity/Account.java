package kr.co.sinbuya.entity;

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

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
@Where(clause = "`enabled` = 1")
public class Account implements java.io.Serializable {

	private long id;
	private Guest guest;
	private String type;

	private String signname;
	private String password;

	private String username;
	private String phoneNumber;
	private String mailAddress;

	private String kakaoId;
	private String blog;

	private String role;

	private Long thumbnail;
	private String description;

	private String sckey;
	private String referer;
	private String refererCookie;

	private boolean visible;
	private boolean active;
	private boolean enabled;
	private boolean grade;
	private Date createdAt;
	private Date updatedOn;
	private Date lastSignedAt;
	private Date marryAt;
	private String marriable;
	private long point;
	private String checkList;

	private Long hallPerson;

	public Account() {

	}

	public Account(long id) {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guest_id", nullable = true)
	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "signname")
	public String getSignname() {
		return signname;
	}

	public void setSignname(String signname) {
		this.signname = signname;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "mail_address")
	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	@Column(name = "kakao_id")
	public String getKakaoId() {
		return kakaoId;
	}

	public void setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
	}

	@Column(name = "blog")
	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "thumbnail")
	public Long getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Long thumbnail) {
		this.thumbnail = thumbnail;
	}

	@Column(name = "hall_person")
	public Long getHallPerson() {
		return hallPerson;
	}

	public void setHallPerson(Long hallPerson) {
		this.hallPerson = hallPerson;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "sckey")
	public String getSckey() {
		return sckey;
	}

	public void setSckey(String sckey) {
		this.sckey = sckey;
	}

	@Column(name = "referer")
	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	@Column(name = "referer_cookie")
	public String getRefererCookie() {
		return refererCookie;
	}

	public void setRefererCookie(String refererCookie) {
		this.refererCookie = refererCookie;
	}

	@Column(name = "visible")
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Column(name = "active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "enabled")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@CreatedDate
	@Column(name = "created_at")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "updated_on")
	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Column(name = "last_signed_at")
	public Date getLastSignedAt() {
		return lastSignedAt;
	}

	public void setLastSignedAt(Date lastSignedAt) {
		this.lastSignedAt = lastSignedAt;
	}

	@Formula("( select IFNULL(sum(am.money), 0) from account_money am where am.account_id = id and am.enabled = 1 and am.active = 1 )")
	public long getPoint() {
		return point;
	}

	public void setPoint(long point) {
		this.point = point;
	}

	@Column(name = "marry_at")
	public Date getMarryAt() {
		return marryAt;
	}

	public void setMarryAt(Date marryAt) {
		this.marryAt = marryAt;
	}

	@Column(name = "marriable")
	public String getMarriable() {
		return marriable;
	}

	public void setMarriable(String marriable) {
		this.marriable = marriable;
	}

	@Column(name = "check_list")
	public String getCheckList() {
		return checkList;
	}

	public void setCheckList(String checkList) {
		this.checkList = checkList;
	}

	@Column(name = "grade")
	public boolean isGrade() {
		return grade;
	}

	public void setGrade(boolean grade) {
		this.grade = grade;
	}

}
