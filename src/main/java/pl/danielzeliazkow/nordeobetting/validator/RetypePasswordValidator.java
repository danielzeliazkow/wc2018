package pl.danielzeliazkow.nordeobetting.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.danielzeliazkow.nordeobetting.db.entity.Users;

public class RetypePasswordValidator implements Validator{

	
	@Override
	public boolean supports(Class<?> arg0) {
		return Users.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Users user = (Users) target;
		if (!user.getPassword().equals(user.getRetypePassword())) {
			errors.rejectValue("retypePassword", "msg.validation.error.password.not.same" );
			
		}		
	}

}
