package com.pkrm.cric.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class DisplayAvalibilityAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm playerform = (DynaActionForm)form;
		
		/*String playerName = request.getParameter("playerName");
		String tuesdayNets = request.getParameter("tuesdayNets");
		String thursdayNets = request.getParameter("thursdayNets");
		String saturdaymatch = request.getParameter("saturdaymatch");
		
		Map<String,String> playerAvaliMap = new HashMap<String,String>();
		playerAvaliMap.put("playerName", playerName);
		playerAvaliMap.put("tuesdayNets", tuesdayNets);
		playerAvaliMap.put("thursdayNets", thursdayNets);
		playerAvaliMap.put("saturdaymatch", saturdaymatch);*/
		
		//String currentWeek = request.getParameter("currentweek");
		
		String currentPlayer = request.getParameter("currentPlayer");
		if(currentPlayer != null && !currentPlayer.equals("")){
			playerform.set("currentPlayer", currentPlayer);
		}else{
			playerform.set("currentPlayer", "Maddula");
		}
				
		
		return mapping.findForward("success");
	}

}
