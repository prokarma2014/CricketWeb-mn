package com.pkrm.cric.action.lgoin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;


public class LoginAction extends Action {

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Login loginModal = new Login();
		DynaActionForm actionForm= (DynaActionForm) form;
		String username = actionForm.getString("userName");
		String password = actionForm.getString("password");
		ActionErrors errors= new ActionErrors();
	 if(username.isEmpty()){
			errors.add("userName", new ActionMessage("form.invalid.userName"));
		}
		if(password.isEmpty()){
			errors.add("password", new ActionMessage("form.invalid.password"));
		}
		loginModal.setPassword(password);
		loginModal.setUserName(username);
		
		if(errors.isEmpty() ){
			if(loginModal.isvalidUser()){
			HttpSession session = request.getSession();
			session.setAttribute("userName", loginModal.getName());
			session.setAttribute("daystogo", 9);
			session.setAttribute("employeeId",loginModal.getEmployeeId() );
			return mapping.findForward("success");
			}else{
				errors.add("password",new ActionMessage("password.not.match"));
			}
		}saveErrors(request, errors);
			return mapping.findForward("failure");
		
		
	}
}
