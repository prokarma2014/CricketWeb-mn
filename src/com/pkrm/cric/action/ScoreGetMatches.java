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

public class ScoreGetMatches extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ScoreDetailsService scoreDetailsService = new ScoreDetailsServiceImpl();
		List<String> showMatches=new ArrayList<String>();
		showMatches.add("  ");
		String year = request.getParameter("selYear");
		int selectedYear = 0;
		if (year != null) {
			try {
				selectedYear = Integer.parseInt(year);
			} catch (Exception e) {
				
			}
		}
	String place=request.getParameter("selPlace");
	showMatches.addAll(scoreDetailsService.getMatches(selectedYear, place));
		request.setAttribute("showMatches", showMatches);
		return  mapping.findForward("success");
	}		 
}
