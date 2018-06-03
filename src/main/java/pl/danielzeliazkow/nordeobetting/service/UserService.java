package pl.danielzeliazkow.nordeobetting.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.danielzeliazkow.nordeobetting.db.entity.Users;
import pl.danielzeliazkow.nordeobetting.db.repository.MatchBetRepository;
import pl.danielzeliazkow.nordeobetting.db.repository.MatchRepository;
import pl.danielzeliazkow.nordeobetting.db.repository.UserRepository;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MatchBetService matchBetService;
		
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;	
	
	@Transactional(readOnly=true)
	public Users findUserByLogin(String login) {
		return userRepository.findByLogin(login);
	}	
	
	public void registerNewUser(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setAdmin(false);
		userRepository.save(user);
		matchBetService.createMatchBetsForUser(user);
	}
	
}
