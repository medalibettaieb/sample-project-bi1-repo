package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MrBean {
	private String name;
	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;

	public String doDisplayNameOfTheSelectedUser() {
		name = userBean.getUserSelected().getName();
		return "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

}
