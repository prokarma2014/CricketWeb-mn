package com.pkrm.cric.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;

import com.pkrm.cric.dao.User;
import com.pkrm.cric.services.SignUpService;
import com.pkrm.cric.services.SignUpServiceImpl;

public class SignUpAction extends Action {
	private String firstName;
	private String lastName;
	private String emailId;
	private String userName;
	private String password;
	private String repeatPassword;
	private String employeeId;
	private int id;
	private ActionErrors errors;
	private User user;
	private SignUpService signUpService;
	private boolean signedup;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		user = new User();
		 errors = new ActionErrors();
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		firstName = (String) dynaActionForm.get("firstName");
		lastName = (String) dynaActionForm.get("lastName");
		emailId = (String) dynaActionForm.get("emailId");
		userName = (String) dynaActionForm.get("userName");
		password = (String) dynaActionForm.get("password");
		repeatPassword = (String) dynaActionForm.get("repeatPassword");
		employeeId = (String) dynaActionForm.get("employeeId");
		if (validate()) {
			setUser();
			try {
				signUpService = new SignUpServiceImpl();
				
				signedup=signUpService.signUp(user);
			} catch (Exception e) {

				if (e.getMessage().equals("UserId Alredy exist")) {
					errors.add("all", new ActionMessage("player.id.already.in.use"));
				}else if(e.getMessage().equals("UserName Alredy exist")){
					errors.add("userName", new ActionMessage("userName.already.present.error"));
				}else{
					errors.add("", new ActionMessage("form.unable.get.database"));
				}
			}
		}
		saveErrors(request, errors);
if(signedup){
	return mapping.findForward("success");
}else{
	
	return mapping.findForward("failure");
}
		
	}

	private void setUser() {
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(emailId);
		user.setId(id);
		user.setPassword(password);
		user.setRole("user");
		user.setUserName(userName);

	}

	private boolean validate() {
		boolean valid = false;
		if (firstName.isEmpty()) {
			errors.add("firstName", new ActionMessage("firstName.error"));
		}
		if (userName.isEmpty()) {
			errors.add("userName", new ActionMessage("form.invalid.userName"));
		}
		if (password.isEmpty()) {
			errors.add("password", new ActionMessage("form.invalid.password"));
		}
		if (emailId.isEmpty()) {
			errors.add("emailId", new ActionMessage("emailId.error"));
		}

		if (repeatPassword.isEmpty()) {
			errors.add("repeatPassword", new ActionMessage(
					"form.invalid.password"));
		} else if (!repeatPassword.equals(password)) {
			errors.add("repeatPassword", new ActionMessage(
					"login.password.repeat.error"));
		}
		if (employeeId.isEmpty()) {
			errors.add("employeeId", new ActionMessage("player.id.error"));
		} else {
			try {
				id = Integer.parseInt(employeeId);
			} catch (Exception e) {
				errors.add("employeeId", new ActionMessage(
						"player.id.not.number.error"));
			}
		}
		if (errors.size() == 0) {
			return true;
		}

		return valid;
	}

}
