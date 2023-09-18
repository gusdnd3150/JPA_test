package kr.co.sinbuya.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import kr.co.sinbuya.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
	
	Account findFirstByPhoneNumber(String phoneNumber);
	Account findFirstBySckey(String sckey);
	
	// 아이디 비밀번호 찾기
	Account findByPhoneNumberAndSignname(String phoneNumber,String signname);
	Account findByPhoneNumberAndUsername(String phoneNumber,String username);
	
	// 아이디 중복확인
	Account findBySignname(String signname);
	
	
	// 매니저 찾기
	
	interface AccountSimple {
		String getUsername();
		String KakaoId();
		Long Thumbnail();
	}


	Account findFirst1BySckey(String sckey);
	
	Account findFirst1ByMailAddress(String mailAddress);
	
	List<Account> findByGuestId(Long gid);
	Account findBySignnameAndPassword(String signname, String password);


	
	
}
