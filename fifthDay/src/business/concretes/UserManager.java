package business.concretes;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import business.abstracts.UserService;
import core.abstracts.GoogleLoggerService;
import core.concretes.GoogleLoggerManagerAdapter;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private GoogleLoggerService googleLoggerService;
	
	public static final Pattern Email_Regex = 
			Pattern.compile("^[A-Z0-9._%+-]\"*>/A-Zx-z0-9+_.-]+@(.+)$'&\"+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public UserManager(UserDao userDao, GoogleLoggerManagerAdapter googleLoggerManagerAdapter) {
		super();
		this.userDao = userDao;
		this.googleLoggerService = (GoogleLoggerService) googleLoggerManagerAdapter;
	} 

	public UserManager(InMemoryUserDao userDao2, GoogleLoggerManagerAdapter googleLoggerManagerAdapter) {
		// TODO Auto-generated constructor stub
	}

	public UserDao getUserDao() {
		return userDao; 
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public GoogleLoggerService getgoogleLoggerService() {
		return googleLoggerService;
	}

	public void setgoogleLoggerService(GoogleLoggerService googleLoggerService) {
		this.googleLoggerService = googleLoggerService;
	}

	@Override
	public void register(User user) {
		if (user.getPassword().length() < 6) {
            System.out.println("Sifreniz en az 6 karakter uzunlugunda olmalidir.");
            return;
        }
		
        String regex = "*>/A-Zx-z0-9+_.-]+@(.+)$'&";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getEmail());
        if (!matcher.matches()) {
            System.out.println("Mail adresi e posta formatinda olmalidir örnek: example@example.com");
            return;
        }
        
        if (userDao.getByEmail(user.getEmail()) != null){
            System.out.println("Kullanici mevcut!");
            return;
        }
        
        if (user.getFirstName().length() < 2 || user.getLastName().length() < 2){
            System.out.println("Ad ve Soyad en az 2 karakterden fazla olmalıdır.");
            return;
        }
        
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("e-Maili doğrulamak için 1'e basın.");
			int  selecetion = scanner.nextInt();
			if (selecetion != 1){
			    System.out.println("Hata:  dogrulama basarisiz oldu.");
			    return;
			}
		}
        
        userDao.add(user);


	}

	@Override
	public void login(User user) {
		 if (user.getEmail() == null || user.getPassword() == null){
	            System.out.println("Email ve şifre zorunludur");
	            return;
	        }
		 
	        if (userDao.getByEmail(user.getEmail()) == null){
	            System.out.println("Kullanici bulunamadi.");
	            return;
	        }
	        
	        this.userDao.add(user);
	        this.googleLoggerService.logToSystem("Giris basarili : Google");
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
		
	}

	@Override
	public User getByMail(String mail) {
		 return userDao.getByEmail(mail);
		 
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

}
