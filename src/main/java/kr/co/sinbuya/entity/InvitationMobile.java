package kr.co.sinbuya.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@SuppressWarnings("serial")
@Entity
@Table(name = "invitation_mobile")
@Where(clause = "`enabled` = 1")
public class InvitationMobile implements Serializable{

	private long id;
	private Account account;
	private ProductArticle productArticle;
	private String title;
	private String url;
	private Date marryAt;
	private String hall;
	private String mname;
	private String mtel;
	private Long mprofile;
	private String fname;
	private String ftel;
	private Long fprofile;
	private boolean parentActive;
	private String parent;
	private String address1;
	private String address2;
	private String addrDetails;
	private String galleries;
	private Long galleriesCover;
	private Long galleriesMain;
	private String bus;
	private String metro;
	private String car;
	private String mediaUrl;
	private String content;
	private String notice;
	private String accountInfo;
	private boolean celebration;
	private boolean kakao;
	private boolean facebook;
	private boolean band;
	private boolean kakaoStory;
	private Date maxDate;
	private Date createdAt;
	private boolean enabled;

	
	public InvitationMobile() {
		
	}
	public InvitationMobile(long id) {
		this.id = id;
	}

	@Id
	@Column(name = "id", unique = true)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "article_id")
	public ProductArticle getProductArticle() {
		return productArticle;
	}
	public void setProductArticle(ProductArticle productArticle) {
		this.productArticle = productArticle;
	}
	
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name = "marry_at")
	public Date getMarryAt() {
		return marryAt;
	}
	public void setMarryAt(Date marryAt) {
		this.marryAt = marryAt;
	}
	
	@Column(name = "hall")
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
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
	
	@Column(name = "parent_active")
	public boolean isParentActive() {
		return parentActive;
	}
	public void setParentActive(boolean parentActive) {
		this.parentActive = parentActive;
	}
	
	@Column(name = "parent")
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	@Column(name = "address1")
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	@Column(name = "address2")
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name = "addr_details")
	public String getAddrDetails() {
		return addrDetails;
	}
	public void setAddrDetails(String addrDetails) {
		this.addrDetails = addrDetails;
	}
	
	@Column(name = "galleries")
	public String getGalleries() {
		return galleries;
	}
	public void setGalleries(String galleries) {
		this.galleries = galleries;
	}
	
	@Column(name = "galleries_cover")
	public Long getGalleriesCover() {
		return galleriesCover;
	}
	public void setGalleriesCover(Long galleriesCover) {
		this.galleriesCover = galleriesCover;
	}
	
	@Column(name = "galleries_main")
	public Long getGalleriesMain() {
		return galleriesMain;
	}
	public void setGalleriesMain(Long galleriesMain) {
		this.galleriesMain = galleriesMain;
	}
	
	@Column(name = "bus")
	public String getBus() {
		return bus;
	}
	public void setBus(String bus) {
		this.bus = bus;
	}
	
	@Column(name = "metro")
	public String getMetro() {
		return metro;
	}
	public void setMetro(String metro) {
		this.metro = metro;
	}
	
	@Column(name = "car")
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	
	@Column(name = "media_url")
	public String getMediaUrl() {
		return mediaUrl;
	}
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	
	@Column(name = "content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "notice")
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	
	@Column(name = "account_info")
	public String getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(String accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	@Column(name = "celebration")
	public boolean isCelebration() {
		return celebration;
	}
	public void setCelebration(boolean celebration) {
		this.celebration = celebration;
	}
	
	@Column(name = "kakao")
	public boolean isKakao() {
		return kakao;
	}
	public void setKakao(boolean kakao) {
		this.kakao = kakao;
	}
	
	@Column(name = "facebook")
	public boolean isFacebook() {
		return facebook;
	}
	public void setFacebook(boolean facebook) {
		this.facebook = facebook;
	}
	
	@Column(name = "band")
	public boolean isBand() {
		return band;
	}
	public void setBand(boolean band) {
		this.band = band;
	}
	
	@Column(name = "kakao_story")
	public boolean isKakaoStory() {
		return kakaoStory;
	}

	public void setKakaoStory(boolean kakaoStory) {
		this.kakaoStory = kakaoStory;
	}
	
	@Column(name = "max_date")
	public Date getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
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
	
	@Column(name = "mprofile")
	public Long getMprofile() {
		return mprofile;
	}

	public void setMprofile(Long mprofile) {
		this.mprofile = mprofile;
	}

	@Column(name = "fprofile")
	public Long getFprofile() {
		return fprofile;
	}

	public void setFprofile(Long fprofile) {
		this.fprofile = fprofile;
	}
	
}
