package kr.co.sinbuya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.sinbuya.entity.InvitationCelebrationMessage;


public interface InvitationCelebrationMessageRepository extends JpaRepository<InvitationCelebrationMessage, Long>{
	
	List<InvitationCelebrationMessage> findByInvitationMobileIdOrderByCreatedAtDesc(long id);
	
}
