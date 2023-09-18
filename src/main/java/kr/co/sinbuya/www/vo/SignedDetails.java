package kr.co.sinbuya.www.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class SignedDetails extends User  {

	private JSONObject userData;

	public SignedDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public SignedDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	

	public SignedDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, JSONObject userData) {
		super(username, password, authorities);
		this.userData = userData;
	}

	public SignedDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, JSONObject userData) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.userData = userData;
	}
	
	public Object get(String key) {
		return userData.get(key);
	}

	public long getLong(String key) {
		return userData.getLong(key);
	}

	public String getString(String key) {
		return userData.getString(key);
	}

	public JSONObject getUserData() {
		return this.userData;
	}

}
