package com.pkrm.cric.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mysql.jdbc.Blob;

public class TeamLogoAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("image/jpg");

		// PlayerDAO playerDAO = MyDAOFactory.getPlayerDAO();
		PlayerDAOImplDB daoImplDB = new PlayerDAOImplDB();
	
		HttpSession session=request.getSession(true);
		Integer teamId = null;
		if(session!=null)
		teamId= (Integer) session.getAttribute("teamId");
		System.out.println(teamId);
		Blob blob = daoImplDB.getImage(teamId);
		byte[] imageBytes = blob.getBytes(1, (int) blob.length());
		response.getOutputStream().write(imageBytes); 
		return mapping.findForward("success");
	}

}
