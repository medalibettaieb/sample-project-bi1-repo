package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserServicesLocal {
	void addUser(User user);

	List<User> finsAllUsers();

	void deleteUser(User user);

	User findUserById(Integer idUser);

	void updateUser(User user);
}
