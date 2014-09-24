package com.pkrm.cric.enrollment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;

import com.pkrm.cric.model.Player;
import com.pkrm.cric.services.EnrollService;
import com.pkrm.cric.services.EnrollServiceImpl;

public class EnrollmentAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Player player = new Player();

		BeanUtils.copyProperties(player, form);
		DynaActionForm dynaf = (DynaActionForm) form;
		String name = (String) dynaf.get("name");
		System.out.println(name);
		ActionErrors errors = new ActionErrors();
		EnrollService enrollService = new EnrollServiceImpl();
		if (player.getName().isEmpty()) {
			errors.add("name", new ActionMessage("player.name.error"));
		}
		if (player.getEmployeeId() <= 0) {
			errors.add("employeeId", new ActionMessage("player.id.error"));
		}
		if (player.getDesignation().isEmpty()) {
			errors.add("designation", new ActionMessage(
					"palyer.designation.error"));
		}
		if (player.getProjectName().isEmpty()) {
			errors.add("projectName", new ActionMessage(
					"player.project.name.error"));
		}
		if (player.getPetName().isEmpty()) {
			errors.add("petName", new ActionMessage("player.pet.name.error"));
		}

		if (errors.isEmpty() && enrollService.enrollPlayer(player)) {
			return mapping.findForward("success");
		} else if (errors.isEmpty()) {

			errors.add("", new ActionMessage("already.enroll.error"));

		}
		saveErrors(request, errors);
		return mapping.findForward("failure");

	}
}
