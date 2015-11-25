package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.UserServicesLocal;
import entities.User;

@ManagedBean
@SessionScoped
public class UserBean {
	// models
	private User user = new User();
	private List<User> users = new ArrayList<>();
	private User userSelected = new User();
	private Boolean displayForm = false;
	// injection of the proxy
	@EJB
	private UserServicesLocal userServicesLocal;

	// methods
	public String doAddUser() {
		userServicesLocal.addUser(user);
		return "/list-users?faces-redirect=true";
	}

	public String doDeleteUser() {
		userServicesLocal.deleteUser(userSelected);
		displayForm = false;
		return "";
	}

	public String doUpdateUser() {
		userServicesLocal.updateUser(userSelected);
		displayForm = false;
		return "";
	}

	public void dislay() {
		displayForm = true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		users = userServicesLocal.finsAllUsers();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(User userSelected) {
		this.userSelected = userSelected;
	}

	public Boolean getDisplayForm() {
		return displayForm;
	}

	public void setDisplayForm(Boolean displayForm) {
		this.displayForm = displayForm;
	}

}
