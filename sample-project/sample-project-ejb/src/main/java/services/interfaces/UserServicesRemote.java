package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServicesRemote {
	void addUser(User user);

	List<User> finsAllUsers();
}
