package kr.co.sinbuya.www.service;

import java.util.List;

import kr.co.sinbuya.entity.InvitationCelebrationMessage;
import kr.co.sinbuya.www.vo.InvitationCelebrationMessageVO;

public interface InvitationCelebrationMessageService {
	
	InvitationCelebrationMessage saveMessage(InvitationCelebrationMessageVO messageVO);
	
	List<InvitationCelebrationMessage> findAll();
	
	InvitationCelebrationMessage deleteMessage(long id);
	
	List<InvitationCelebrationMessage> findByInvitationMobileId(long id);

	InvitationCelebrationMessage findById(long id);
	
}
