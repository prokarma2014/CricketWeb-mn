package com.pkrm.cric.listners;

import java.util.Calendar;
import java.util.Timer;

import com.pkrm.cric.sendemail.GetReportForSaturdayMatch;
import com.pkrm.cric.sendemail.GetReportForThursDayNets;
import com.pkrm.cric.sendemail.GetReportForTuesDayNets;
import com.pkrm.cric.sendemail.InitiateAvailCheck;

public class StartTimerTasks {
	
	
	static{
		 
		System.out.println("Job Started...............");
		Timer timer = new Timer();
	    Calendar initiateDate = Calendar.getInstance();
	    initiateDate.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
	    initiateDate.set(Calendar.HOUR, 0);
	    initiateDate.set(Calendar.MINUTE, 0);
	    initiateDate.set(Calendar.SECOND, 0);
	    initiateDate.set(Calendar.MILLISECOND, 0);	    
	    System.out.println("Start time==="+initiateDate.getTime());
	    // Schedule to run every Monday in midnight
	    timer.schedule(
	      new InitiateAvailCheck(),
	      initiateDate.getTime(),
	      1000 * 60 * 60 * 24 * 7
	    );
	    
	    /*
	    Calendar tuesDayNetsDate = Calendar.getInstance();
	    tuesDayNetsDate.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
	    tuesDayNetsDate.set(Calendar.HOUR, 6);
	    tuesDayNetsDate.set(Calendar.MINUTE, 0);
	    tuesDayNetsDate.set(Calendar.SECOND, 0);
	    tuesDayNetsDate.set(Calendar.MILLISECOND, 0);
	    timer.schedule(
	  	      new GetReportForTuesDayNets(),
	  	      tuesDayNetsDate.getTime(),
	  	      1000 * 60 * 60 * 24 * 7
	  	    );
	    
	    
	    Calendar thursDayNetsDate = Calendar.getInstance();
	    thursDayNetsDate.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
	    thursDayNetsDate.set(Calendar.HOUR, 6);
	    thursDayNetsDate.set(Calendar.MINUTE, 0);
	    thursDayNetsDate.set(Calendar.SECOND, 0);
	    thursDayNetsDate.set(Calendar.MILLISECOND, 0);
	    timer.schedule(
		  	      new GetReportForThursDayNets(),
		  	      thursDayNetsDate.getTime(),
		  	      1000 * 60 * 60 * 24 * 7
		  	    );
	    
	    
	    Calendar fridayMatchDate = Calendar.getInstance();
	    fridayMatchDate.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
	    fridayMatchDate.set(Calendar.HOUR, 4);
	    fridayMatchDate.set(Calendar.MINUTE, 0);
	    fridayMatchDate.set(Calendar.SECOND, 0);
	    fridayMatchDate.set(Calendar.MILLISECOND, 0);
	    timer.schedule(
		  	      new GetReportForSaturdayMatch(),
		  	      fridayMatchDate.getTime(),
		  	      1000 * 60 * 60 * 24 * 7
		  	    );
	    
	    */
	    System.out.println("Job Ends..................");
	  }
	
	
	
	
	

}
