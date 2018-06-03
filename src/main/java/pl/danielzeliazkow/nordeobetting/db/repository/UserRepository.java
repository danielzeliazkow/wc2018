package pl.danielzeliazkow.nordeobetting.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.danielzeliazkow.nordeobetting.db.entity.Users;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users findByLogin(String login);
}
