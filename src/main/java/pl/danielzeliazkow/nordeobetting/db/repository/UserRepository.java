package pl.danielzeliazkow.nordeobetting.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.danielzeliazkow.nordeobetting.db.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByLogin(String login);
}
