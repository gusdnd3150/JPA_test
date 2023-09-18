package kr.co.sinbuya.www.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import kr.co.sinbuya.entity.Account;
import kr.co.sinbuya.repository.AccountRepository;
import kr.co.sinbuya.www.vo.SignedDetails;
import net.sf.json.JSONObject;

@Component
public class UserDetailService implements UserDetailsService {

	@Autowired private AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (username == null || username.isEmpty()) return null;
		
		Account account = accountRepository.findBySignname(username);

		
		if (account == null) throw new UsernameNotFoundException("NOT_FOUND_USER");

		JSONObject userData = new JSONObject();
		userData.put("id", account.getId());
		userData.put("name", account.getUsername());
		userData.put("gender", account.getType().startsWith("user:") ? account.getType() : "");

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		for(String role : account.getRole().split("\\|")) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		
		return new SignedDetails(account.getSignname(), account.getPassword(), authorities, userData);
		
	}
	
	

}
