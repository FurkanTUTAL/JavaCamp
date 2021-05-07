package dataAccess.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserDao {
	
	void add(User user);
    void delete(User user);
    void update(User user);
    User getByEmail(String email);
    User getByEmailAndPassword(String email,String password);
    List<User> getAll();
	void add1(entities.concretes.User user);
}