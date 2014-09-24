package com.pkrm.cric.action;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pkrm.cric.model.MatchDetails;
import com.pkrm.cric.services.ScoreDetailsService;
import com.pkrm.cric.services.ScoreDetailsServiceImpl;


public class ProccessScoreDetails extends Action {



	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ScoreDetailsService scoreDetailsService=new ScoreDetailsServiceImpl();
		int year=request.getParameter("selectedYear")!=null?Integer.parseInt(request.getParameter("selectedYear")):0;
		String place=request.getParameter("selectedPlace");
		String match=request.getParameter("selectedMatch");
		MatchDetails details=scoreDetailsService.getMatchDetails(year, place, match);
		request.setAttribute("matchdetails", details);
		List<Integer> years=scoreDetailsService.getPlayedYears();
	
		request.setAttribute("PlayedYears", years);
		List<String> places=scoreDetailsService.getPlaces(year);
		request.setAttribute("Places", places);
		List<String> matches=scoreDetailsService.getMatches(year, place);
		request.setAttribute("matches", matches);
		return mapping.findForward("success");
	}
}
