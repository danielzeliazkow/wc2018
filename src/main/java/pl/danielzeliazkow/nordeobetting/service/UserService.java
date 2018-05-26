package pl.danielzeliazkow.nordeobetting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.danielzeliazkow.nordeobetting.db.entity.User;
import pl.danielzeliazkow.nordeobetting.db.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;	
	
	public User findUserByLogin(String login) {
		return userRepository.findByLogin(login);
	}
	
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setAdmin(false);
		userRepository.save(user);
	}
}
