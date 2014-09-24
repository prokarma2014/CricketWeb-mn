package com.pkrm.cric.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pkrm.cric.model.Player;
import com.pkrm.cric.services.EnrollService;
import com.pkrm.cric.services.EnrollServiceImpl;

public class EnrollDetails extends Action {

	private HttpSession session;
	private EnrollService enrollService;
	private Player player;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		session =request.getSession();
		enrollService=new EnrollServiceImpl();
		int employeeId=(Integer) session.getAttribute("employeeId");
		player= enrollService.getPlayerDetails(employeeId);
		request.setAttribute("name", player.getName());
		request.setAttribute("Id",player.getEmployeeId());
		request.setAttribute("personalHighscore",player.getPersonalHighscore());
		request.setAttribute("designation",player.getDesignation());
		request.setAttribute("bowlingBest",player.getBowlingBest());
		request.setAttribute("projectName",player.getProjectName());
		request.setAttribute("petName",player.getPetName());
		return mapping.findForward("success");
	}
}
