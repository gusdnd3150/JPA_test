package kr.co.sinbuya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.co.sinbuya.entity.InvitationMobile;


public interface InvitationMobileRepository extends JpaRepository<InvitationMobile, Long>{

	@Query("select i from InvitationMobile i where i.url like :url")
	InvitationMobile getByUrl(@Param("url") String url);
	
}
