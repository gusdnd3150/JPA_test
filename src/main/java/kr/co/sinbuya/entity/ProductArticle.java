package kr.co.sinbuya.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@SuppressWarnings("serial")
@Entity
@Table(name = "product_article")
public class ProductArticle implements Serializable {

	private long id;

	private Long thumb;
	private String galleries;
	private String tagArray;
	
	private Area area;

	private long categoryId;
	private String title;
	private String description;
	private String content;
	
	private String pcode;
	private String address;
	private String phone;
	private String worktime;
	private String homepage;
	private String visit;
	private String area1;
	private String area2;

	private String reportTxt;
	private String mtype;

	private String price;
	private String exPrice;
	private String margin;

	private String hallMenu;
	private String hallType;

	private Double lat;
	private Double lng;

	private int status;
	private long commentSize;

	private boolean priceHaving;
	private boolean thumbHaving;
	private boolean active;
	private boolean enabled;
	private Date createdAt;
	private int stars;
	
	private long optionSize;
	
	private Boolean coverActive;
	private Boolean profileActive;

	public ProductArticle() {
	}

	public ProductArticle(long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@JsonProperty("area_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "area_id")
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Column(name = "thumb")
	public Long getThumb() {
		return thumb;
	}

	public void setThumb(Long thumb) {
		this.thumb = thumb;
	}

	@Column(name = "galleries")
	public String getGalleries() {
		return galleries;
	}

	public void setGalleries(String galleries) {
		this.galleries = galleries;
	}
	
	@Column(name = "tag_array")
	public String getTagArray() {
		return tagArray;
	}

	public void setTagArray(String tagArray) {
		this.tagArray = tagArray;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "worktime")
	public String getWorktime() {
		return worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	@Column(name = "homepage")
	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@Column(name = "visit")
	public String getVisit() {
		return visit;
	}

	public void setVisit(String visit) {
		this.visit = visit;
	}

	@Column(name = "area1")
	public String getArea1() {
		return area1;
	}

	public void setArea1(String area1) {
		this.area1 = area1;
	}

	@Column(name = "area2")
	public String getArea2() {
		return area2;
	}

	public void setArea2(String area2) {
		this.area2 = area2;
	}

	@Column(name = "report_txt")
	public String getReportTxt() {
		return reportTxt;
	}

	public void setReportTxt(String reportTxt) {
		this.reportTxt = reportTxt;
	}

	@Column(name = "mtype")
	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	@Column(name = "price")
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "ex_price")
	public String getExPrice() {
		return exPrice;
	}

	public void setExPrice(String exPrice) {
		this.exPrice = exPrice;
	}

	@Column(name = "margin", nullable = true)
	public String getMargin() {
		return margin;
	}

	public void setMargin(String margin) {
		this.margin = margin;
	}

	@Column(name = "hall_menu")
	public String getHallMenu() {
		return hallMenu;
	}

	public void setHallMenu(String hallMenu) {
		this.hallMenu = hallMenu;
	}

	@Column(name = "hall_type")
	public String getHallType() {
		return hallType;
	}

	public void setHallType(String hallType) {
		this.hallType = hallType;
	}

	@Column(name = "lat")
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	@Column(name = "lng")
	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "active")
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "created_at")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "enabled")
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "category_id")
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name = "pcode")
	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	@Column(name = "stars")
	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}
	
	@Column(name = "cover_active")
	public Boolean getCoverActive() {
		return coverActive;
	}

	public void setCoverActive(Boolean coverActive) {
		this.coverActive = coverActive;
	}

	@Formula("IFNULL((SELECT count(r.id) FROM review r WHERE r.article_id = id and r.enabled = 1 and r.status >= 0), 0)")
	public long getCommentSize() {
		return commentSize;
	}

	public void setCommentSize(long commentSize) {
		this.commentSize = commentSize;
	}

	@Formula("IF(thumb is null, 0, 1)")
	public boolean isThumbHaving() {
		return thumbHaving;
	}

	public void setThumbHaving(boolean thumbHaving) {
		this.thumbHaving = thumbHaving;
	}

	@Formula("IF((SELECT count(r.id) FROM product_option r WHERE r.article_id = id and r.enabled = 1) > 0, 1, 0)")
	public boolean isPriceHaving() {
		return priceHaving;
	}

	public void setPriceHaving(boolean priceHaving) {
		this.priceHaving = priceHaving;
	}
	
	@Formula("IFNULL((SELECT count(r.id) FROM product_option r WHERE r.article_id = id and r.enabled = 1), 0)")
	public long getOptionSize() {
		return optionSize;
	}

	public void setOptionSize(long optionSize) {
		this.optionSize = optionSize;
	}
	
	@Column(name = "profile_active")
	public Boolean getProfileActive() {
		return profileActive;
	}

	public void setProfileActive(Boolean profileActive) {
		this.profileActive = profileActive;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name = "product_article_categories", joinColumns = {
			@JoinColumn(name = "article_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "category_id", nullable = false, updatable = false) })

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProductArticle && ((ProductArticle) obj).getId() == this.id)
			return true;
		return super.equals(obj);
	}
}