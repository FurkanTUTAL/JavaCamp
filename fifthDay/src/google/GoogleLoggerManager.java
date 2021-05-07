package google;

import entities.concretes.User;

public class GoogleLoggerManager {
	
	public void logInWithGoogleAccount(String message) {
		System.out.println("GOOGLE İLE GİRİŞ YAPILDI. " + message);
	}
	public void register(User user){ 
        System.out.println("KULLANICI GOOGLEYE BAŞARILI BİR ŞEKİLDE EKLENDİ : " + user.getFirstName() + 
        		" " + user.getLastName().toUpperCase());
    } 
}
