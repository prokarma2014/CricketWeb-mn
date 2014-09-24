package com.pkrm.cric.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pkrm.cric.services.ScoreDetailsService;
import com.pkrm.cric.services.ScoreDetailsServiceImpl;

public class SocreGetPlaces extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ScoreDetailsService scoreDetailsService = new ScoreDetailsServiceImpl();
		List<String> showPlaces = new ArrayList<String>();
		String year = request.getParameter("selYear");
		int selectedYear = 0;
		if (year != null) {
			try {
				selectedYear = Integer.parseInt(year);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		showPlaces.add("");
		showPlaces.addAll(scoreDetailsService.getPlaces(selectedYear));
		request.setAttribute("showplaces", showPlaces);
		return mapping.findForward("success");
	}
}
