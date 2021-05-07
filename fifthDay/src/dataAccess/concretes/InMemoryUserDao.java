package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	
	List<User> users = new ArrayList<User>(); 
	
	@Override
	public void add(User user) {
		System.out.println("Google ile uye olundu. " + user.getFirstName());
		users.add(user);
		
	}

	@Override
	public void delete(User user) {
		users.removeIf(obj->obj.getFirstName() == user.getFirstName());
		System.out.println("Kullanici silindi. " + user.getFirstName());
		
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanici guncellendi. " + user.getFirstName());
	}

	@Override
	public User getByEmail(String email) {
		
		for(User user : users) {
			if(user.getEmail() == email)
				return user;
		}
		return null;
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		for(User user : users) {
			if(user.getEmail() == email && user.getPassword() == password)
				return user;
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}

	@Override
	public void add(dataAccess.abstracts.User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(dataAccess.abstracts.User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(dataAccess.abstracts.User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public dataAccess.abstracts.User getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public dataAccess.abstracts.User getByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add1(User user) {
		// TODO Auto-generated method stub
		
	}
	
	
}
