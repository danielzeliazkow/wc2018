package pl.danielzeliazkow.nordeobetting.db.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cascade;


@Table(name = "USERS")
@Entity
public class Users {
	
	public Users() {
		userStatistics = new UserStatistics();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	@NotEmpty
	private String login;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String email;
		
	@NotEmpty
	private String password;
	
	@Transient
	@NotEmpty
	private String retypePassword;
	
	private boolean isAdmin;
	
	@OneToOne(cascade=CascadeType.ALL)
	private UserStatistics userStatistics;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public UserStatistics getUserStatistics() {
		return userStatistics;
	}

	public void setUserStatistics(UserStatistics userStatistics) {
		this.userStatistics = userStatistics;
	}


	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

	
}
