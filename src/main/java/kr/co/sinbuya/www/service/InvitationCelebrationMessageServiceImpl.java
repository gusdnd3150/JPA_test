package kr.co.sinbuya.www.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sinbuya.common.XPasswordEncoder;
import kr.co.sinbuya.entity.InvitationCelebrationMessage;
import kr.co.sinbuya.entity.InvitationMobile;
import kr.co.sinbuya.repository.InvitationCelebrationMessageRepository;
import kr.co.sinbuya.www.vo.InvitationCelebrationMessageVO;

@Service("InvitationCelebrationMessageService")
public class InvitationCelebrationMessageServiceImpl implements InvitationCelebrationMessageService{
	
	@Autowired private InvitationCelebrationMessageRepository invitationCelebrationMessageRepository;
	@Autowired private XPasswordEncoder oSecurity;
	
	@Transactional	//축하메시지 저장
	@Override
	public InvitationCelebrationMessage saveMessage(InvitationCelebrationMessageVO messageVO) {
		
		InvitationCelebrationMessage result = new InvitationCelebrationMessage(); 

		result.setInvitationMobile(new InvitationMobile(Long.parseLong(messageVO.getInvitationId())));
		result.setName(messageVO.getName());
		result.setPassword(oSecurity.encode(messageVO.getPassword()));
		result.setContent(messageVO.getContent());
		result.setCreatedAt(new Date());
		result.setEnabled(true);
		
		return invitationCelebrationMessageRepository.save(result);
	}
	
	
	@Transactional	//축하메시지 출력
	@Override
	public List<InvitationCelebrationMessage> findAll() {
		
		return invitationCelebrationMessageRepository.findAll();
	}

	
	@Transactional	//메시지 삭제(enabled=false)
	@Override
	public InvitationCelebrationMessage deleteMessage(long id) {
		
		InvitationCelebrationMessage result = invitationCelebrationMessageRepository.findOne(id);

		
		if(result != null) {
			result.setEnabled(false);
			invitationCelebrationMessageRepository.save(result);
		}
		return result;
	}
	
	
	@Transactional
	@Override
	public List<InvitationCelebrationMessage> findByInvitationMobileId(long id) {
		
		return invitationCelebrationMessageRepository.findByInvitationMobileIdOrderByCreatedAtDesc(id);
	}


	@Transactional
	@Override
	public InvitationCelebrationMessage findById(long id) {
		return invitationCelebrationMessageRepository.findOne(id);
	}
	

}
