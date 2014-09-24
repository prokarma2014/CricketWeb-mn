package com.pkrm.cric.TestClasses;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DisplayDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, ''yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/YYYY");
		Calendar curDate = Calendar.getInstance();
		curDate.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
	    System.out.println("Date = "+sdf.format(curDate.getTime()));
	    
	    curDate.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
	    System.out.println("Date = "+sdf.format(curDate.getTime()));
	    
	    curDate.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
	    System.out.println("Date = "+sdf.format(curDate.getTime()));
	    
	    System.out.println("Date = "+sdf2.format(curDate.getTime()));
		

	}

}
