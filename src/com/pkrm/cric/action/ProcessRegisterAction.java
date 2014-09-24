package com.pkrm.cric.action;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.pkrm.cric.model.TeamRegistration;

public class ProcessRegisterAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse respone)
			throws MyDAOException {
		//DynaActionForm searchForm = (DynaActionForm) form;
		TeamRegistration teamRegistration = new TeamRegistration();
		try {
			BeanUtils.copyProperties(teamRegistration, form);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		HttpSession session=request.getSession();
		session.setAttribute("teamId",teamRegistration.getTeamID());
		FormFile formFile=teamRegistration.getTeamLogo();
		if(formFile.getFileSize()<15000){
			System.out.println("sizze is" +formFile.getFileSize());
		}
		request.setAttribute("teamId", teamRegistration.getTeamID());
		PlayerDAO playerDAO = MyDAOFactory.getPlayerDAO();
		playerDAO.insertTeamDetails(teamRegistration);
		return mapping.findForward("success");
	}

}
