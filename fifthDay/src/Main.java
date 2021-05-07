import business.abstracts.UserService;
import business.concretes.UserManager;
import core.concretes.GoogleLoggerManagerAdapter;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		
		UserService userService = new UserManager(new InMemoryUserDao(),new GoogleLoggerManagerAdapter());
	        userService.register(new User("Furkan","Tutal","frkn75@gmail.com","75frkn75")); // Dogrulandi!
		userService.register(new User("Fatih","Baycu","fatihbay@gmail.com","*/131/qwes")); // Yanlis girildi ve hata alindi.
		
		User user1 = new User("Furkan","Tutal","frkn75@gmail.com","75frkn75");
		User user2 = new User("Fatih","Baycu","fatihbay@gmail.com","*/131/qwes");
		userService.login(user1); //Google ile giris islemi yap�l�yor
		userService.login(user2); // sisteme kay�t olmad��� i�in hata ekran�.
		userService.delete(user1); // silme islemi.
		
		//
	}

}