package kr.co.sinbuya.www.vo;

public class InvitationCelebrationMessageVO {

	private String name;		// 이름
	private String password;	// 비밀번호
	private String content;		// 글내용
	private String InvitationId;// 청첩장 번호
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getInvitationId() {
		return InvitationId;
	}
	public void setInvitationId(String invitationId) {
		this.InvitationId = invitationId;
	}
	
	
	
}
