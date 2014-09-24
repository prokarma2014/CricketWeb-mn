package com.pkrm.cric.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.pkrm.cric.dao.CommonDaoIMpl;

public class CricWebAppUtil extends CommonDaoIMpl {

	public static String getCurDay() {

		String dayOfWeek = null;
		Calendar initiateDate = Calendar.getInstance();

		if (initiateDate.get(Calendar.DAY_OF_WEEK) == 1) {
			dayOfWeek = "SUNDAY";
		} else if (initiateDate.get(Calendar.DAY_OF_WEEK) == 2) {
			dayOfWeek = "MONDAY";
		} else if (initiateDate.get(Calendar.DAY_OF_WEEK) == 3) {
			dayOfWeek = "TUESDAY";
		} else if (initiateDate.get(Calendar.DAY_OF_WEEK) == 4) {
			dayOfWeek = "WEDNESDAY";
		} else if (initiateDate.get(Calendar.DAY_OF_WEEK) == 5) {
			dayOfWeek = "THURSDAY";
		} else if (initiateDate.get(Calendar.DAY_OF_WEEK) == 6) {
			dayOfWeek = "FRIDAY";
		} else if (initiateDate.get(Calendar.DAY_OF_WEEK) == 7) {
			dayOfWeek = "SATURDAY";
		}
		return dayOfWeek;
	}

	public ResultSet getPlayersAvailibility(String aPlayerName) {
		
		String result = "";
		ResultSet rs = null;

		try {

			String queryString = null;
			PreparedStatement statement = null;
			String UpString = null;
			int i = 1;
			if (aPlayerName != null && aPlayerName.length() > 0) {
				
				queryString = "select *, (case when week(p.UPDATEDDATE)>= week(now())  " +
						"then 0 else 1 end) 'IsWeeklyUpdated' from playeravailibility p where p.PLAYER_NAME = ?";
				statement = getConnection().prepareStatement(queryString);
				statement.setString(1, aPlayerName);
			} else {
				queryString = "select *, (case when week(p.UPDATEDDATE)>= week(now())  " +
						"then 0 else 1 end) 'IsWeeklyUpdated' from playeravailibility p";
				statement = getConnection().prepareStatement(queryString);
			}

			result = "PLAYER NAME\t   TUESDAY NETS\t THURSDAY NETS\tSATURDAY MATCH\t\tISWEEKLYUPDATED\n\n";
			rs = statement.executeQuery();
			
			
			
//			while (rs.next()) {
//
//				if (rs.getDate("UPDATEDDATE") != null) {
//					if(rs.getString("IsWeeklyUpdated").equals("0")){
//						UpString = "Updated";
//					}else{
//						UpString = "Not Updated";
//					}					
//				}else{
//					UpString = "Not Updated Yet";
//				}
//
//				 if(i==14){
//					 result = result + i++ +"."+rs.getString("PLAYER_NAME")+"\t"+rs.getString("TUESDAYNETS")+"\t\t"
//							 +rs.getString("THURSDAYNETS")+"\t\t"+rs.getString("SATURDAYMATCH")+"\t\t"+UpString+"\n";
//				 }else{
//					 result = result + i++ +"."+rs.getString("PLAYER_NAME")+"\t\t"+rs.getString("TUESDAYNETS")+"\t\t"
//							 +rs.getString("THURSDAYNETS")+"\t\t"+rs.getString("SATURDAYMATCH")+"\t\t"+UpString+"\n";
//				 }
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return result;
		return rs;

	}

	public static void main(String[] args) {
		// getCurDay();
		CricWebAppUtil cu = new CricWebAppUtil();
		cu.getPlayersAvailibility(null);

	}

}
