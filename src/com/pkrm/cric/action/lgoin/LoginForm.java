package com.pkrm.cric.action.lgoin;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9140154259382491385L;
	private Login login = new Login();


	public final Login getLogin() {
		return login;
	}

	public final void setLogin(Login login) {
		this.login = login;
	}

	public final String getUserName() {
		return login.getUserName();
	}

	public final void setUserName(String userName) {
		login.setUserName(userName);
	}

	public final String getPassword() {
		return login.getPassword();
	}

	public final void setPassword(String password) {
		login.setPassword(password);
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.login=new Login();
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if(login.getUserName()==null){
			errors.add("userName", new ActionMessage("form.invalid.userName"));
		}
		if(login.getPassword()==null){
			errors.add("password", new ActionMessage("form.invalid.password"));
		}
		return errors;
	}
}
