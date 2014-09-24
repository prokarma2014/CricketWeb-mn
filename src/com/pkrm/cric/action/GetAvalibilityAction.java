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

import com.pkrm.cric.dao.PlayerAvailibilityDAO;

public class GetAvalibilityAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm playerform = (DynaActionForm)form;
		
		String playerName = playerform.getString("playerName");
		String tuesdayNets = playerform.getString("tuesdayNets");
		String thursdayNets = playerform.getString("thursdayNets");
		String saturdaymatch = playerform.getString("saturdaymatch");
		String currentPlayer = playerform.getString("currentPlayer");
		
		Map<String,String> playerAvaliMap = new HashMap<String,String>();
		playerAvaliMap.put("playerName", playerName);
		playerAvaliMap.put("tuesdayNets", tuesdayNets);
		playerAvaliMap.put("thursdayNets", thursdayNets);
		playerAvaliMap.put("saturdaymatch", saturdaymatch);
		playerAvaliMap.put("currentPlayer", currentPlayer);
		
		PlayerAvailibilityDAO pad = new PlayerAvailibilityDAO();
		
		if(pad.updatePlayerAvailibility(playerAvaliMap)){
			request.setAttribute("updated", "true");
		}
		
		return mapping.findForward("success");
	}
}
