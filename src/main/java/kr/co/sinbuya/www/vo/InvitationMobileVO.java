package kr.co.sinbuya.www.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvitationMobileVO {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	private int id;
	private String title;
	private String url;
	private Date marryAt;
	private Timestamp marryTime;
	
	private String hall;
	private String maleName;
	private String malePhone;
	private String femaleName;
	private String femalePhone;
	private String parent;
	private String address1;
	private String address2;
	private String addrDetails;
	private String galleries;
	private int galleriesCover;
	private int galleriesMain;
	private String bus;
	private String metro;
	private String car;
	private String mediaUrl;
	private String content;
	private String notice;
	private String thanksto;
	private String accountInfo;
	private boolean celebration;
	private boolean kakao;
	private boolean facebook;
	private boolean band;
	private boolean twitter;
	private Date createdAt;
	private boolean enabled;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Date getMarryAt() {
		return marryAt;
	}
	public void setMarryAt(Date marryAt) {
		this.marryAt = marryAt;
	}
	
	public Timestamp getMarryTime() {
		return marryTime;
	}
	public void setMarryTime(Timestamp marryTime) {
		this.marryTime = marryTime;
	}
	public Date getMarryAtByDate() {
		try {
			return dateFormat.parse(this.marryAt + " " + this.marryTime);
		}catch(Exception e) {
			return null;
		}
	}
	
	
	
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public String getMaleName() {
		return maleName;
	}
	public void setMaleName(String maleName) {
		this.maleName = maleName;
	}
	public String getMalePhone() {
		return malePhone;
	}
	public void setMalePhone(String malePhone) {
		this.malePhone = malePhone;
	}
	public String getFemaleName() {
		return femaleName;
	}
	public void setFemaleName(String femaleName) {
		this.femaleName = femaleName;
	}
	public String getFemalePhone() {
		return femalePhone;
	}
	public void setFemalePhone(String femalePhone) {
		this.femalePhone = femalePhone;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddrDetails() {
		return addrDetails;
	}
	public void setAddrDetails(String addrDetails) {
		this.addrDetails = addrDetails;
	}
	public String getGalleries() {
		return galleries;
	}
	public void setGalleries(String galleries) {
		this.galleries = galleries;
	}
	public int getGalleriesCover() {
		return galleriesCover;
	}
	public void setGalleriesCover(int galleriesCover) {
		this.galleriesCover = galleriesCover;
	}
	public int getGalleriesMain() {
		return galleriesMain;
	}
	public void setGalleriesMain(int galleriesMain) {
		this.galleriesMain = galleriesMain;
	}
	public String getBus() {
		return bus;
	}
	public void setBus(String bus) {
		this.bus = bus;
	}
	public String getMetro() {
		return metro;
	}
	public void setMetro(String metro) {
		this.metro = metro;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getMediaUrl() {
		return mediaUrl;
	}
	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getThanksto() {
		return thanksto;
	}
	public void setThanksto(String thanksto) {
		this.thanksto = thanksto;
	}
	public String getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(String accountInfo) {
		this.accountInfo = accountInfo;
	}
	public boolean isCelebration() {
		return celebration;
	}
	public void setCelebration(boolean celebration) {
		this.celebration = celebration;
	}
	public boolean isKakao() {
		return kakao;
	}
	public void setKakao(boolean kakao) {
		this.kakao = kakao;
	}
	public boolean isFacebook() {
		return facebook;
	}
	public void setFacebook(boolean facebook) {
		this.facebook = facebook;
	}
	public boolean isBand() {
		return band;
	}
	public void setBand(boolean band) {
		this.band = band;
	}
	public boolean isTwitter() {
		return twitter;
	}
	public void setTwitter(boolean twitter) {
		this.twitter = twitter;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
	
	
}
