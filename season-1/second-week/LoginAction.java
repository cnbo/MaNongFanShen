
public class LoginAction {
	
	private String userName;
	
	private String password;
	
	private String loginMessage;
	
	public String execute() {
		if ("admin".equals(userName) && "123".equals(password)) {
			loginMessage = "Login Success!";
			return "success";
		} else {
			loginMessage = "Your UserName or Password error!";
			return "error";
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

}
