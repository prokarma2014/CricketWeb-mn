package com.pkrm.cric.TestClasses;

import java.util.TimerTask;

import com.pkrm.cric.sendemail.SendFromPKMail;

public class ReportGenerator extends TimerTask {

  public void run() {
	  
	  SendFromPKMail sfpkm = new SendFromPKMail();
	  //sfpkm.sendEmailToAll();
	  sfpkm.sendEmaiFromPCCTAdmin();
  }

}
