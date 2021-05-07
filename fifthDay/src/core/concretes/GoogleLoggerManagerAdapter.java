package core.concretes;

import core.abstracts.GoogleLoggerService;
import google.GoogleLoggerManager;

public class GoogleLoggerManagerAdapter implements GoogleLoggerService{

	@Override
	public void logToSystem(String message) {
		GoogleLoggerManager googleLoggerManager = new GoogleLoggerManager();
		googleLoggerManager.logInWithGoogleAccount(message);
		 
	}

}
