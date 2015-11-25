package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.UserServicesLocal;
import services.interfaces.UserServicesRemote;
import entities.User;

/**
 * Session Bean implementation class UserServices
 */
@SuppressWarnings("unchecked")
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);

	}

	@Override
	public List<User> finsAllUsers() {
		return entityManager.createQuery("select u from User u")
				.getResultList();
	}

	@Override
	public void deleteUser(User user) {
		entityManager.remove(findUserById(user.getId()));

	}

	@Override
	public User findUserById(Integer idUser) {
		return entityManager.find(User.class, idUser);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);

	}

}
