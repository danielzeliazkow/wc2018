package pl.danielzeliazkow.nordeobetting;

public class BetTooLateException extends RuntimeException {

	
	public BetTooLateException() {
		super("One of the bets is placed too late. ");
	}
}
