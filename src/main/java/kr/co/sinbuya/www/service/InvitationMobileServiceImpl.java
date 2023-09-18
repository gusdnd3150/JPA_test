package kr.co.sinbuya.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sinbuya.repository.InvitationMobileRepository;

@Service("InvitationMobileService")
public class InvitationMobileServiceImpl implements InvitationMobileService {

	@Autowired InvitationMobileRepository invitationMobileRepository;
	
	
	
	
}
