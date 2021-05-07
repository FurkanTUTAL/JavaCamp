import business.abstracts.UserService;
import business.concretes.UserManager;
import core.concretes.GoogleLoggerManagerAdapter;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		
		UserService userService = new UserManager(new InMemoryUserDao(),new GoogleLoggerManagerAdapter());
	        userService.register(new User("Yusuf Enes","Aras","enesaras551@gmail.com","1234enes")); // Dogrulandi!
		userService.register(new User("Yusuf Enes","Aras","enesaras551","1234enes")); // Yanlis girildi ve hata alindi.
		
		User user1 = new User("FURKAN","TUTAL","frknttl@gmail.com","qwer1234qwer");
		User user2 = new User("FATÝH","BAYCU","fatbay@gmail.com","*131$qwea");
		userService.login(user1); //Google ile giris islemi yapýlýyor
		userService.login(user2); // sisteme kayýt olmadýðý için hata ekraný.
		userService.delete(user1); // silme islemi.
		
		//
	}

}