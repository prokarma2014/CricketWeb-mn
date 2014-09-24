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

public class ScoreDetails extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ScoreDetailsService scoreDetailsService=new ScoreDetailsServiceImpl();
		List<Integer> years=scoreDetailsService.getPlayedYears();
		request.setAttribute("PlayedYears", years);
		List<String> places=new ArrayList<String>();
		request.setAttribute("Places", places);
		List<String> matches=new ArrayList<String>();
		request.setAttribute("matches", matches);
		// TODO get played years places and matches from database
		return mapping.findForward("success");
	}
}
