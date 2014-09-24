package com.pkrm.cric.TestClasses;

import java.util.Calendar;
import java.util.Timer;

public class MainApplication {

	//public static void main(String[] args) {
	
	static{
		 
		System.out.println("Job Started...............");
		Timer timer = new Timer();
	    Calendar date = Calendar.getInstance();
	    date.set(
	      Calendar.DAY_OF_WEEK,
	      Calendar.MONDAY
	    );
	    date.set(Calendar.HOUR, 0);
	    date.set(Calendar.MINUTE, 0);
	    date.set(Calendar.SECOND, 0);
	    date.set(Calendar.MILLISECOND, 0);
	    
	    System.out.println("Start time==="+date.getTime());
	    // Schedule to run every Monday in midnight
	    timer.schedule(
	      new ReportGenerator(),
	      date.getTime(),
	      1000 * 60 * 60 * 24 * 7
	    );
	    System.out.println("Job Ends..................");
	  }
	
	
	
}
