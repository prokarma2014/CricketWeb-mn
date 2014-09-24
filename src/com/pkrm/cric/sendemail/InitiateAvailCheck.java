package com.pkrm.cric.sendemail;

import java.util.TimerTask;

import com.pkrm.cric.sendemail.SendFromPKMail;

public class InitiateAvailCheck extends TimerTask {

  public void run() {
	  
	  SendFromPKMail sfpkm = new SendFromPKMail();
	  sfpkm.sendEmailToAll();
  }

}
