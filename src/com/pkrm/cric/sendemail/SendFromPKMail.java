package com.pkrm.cric.sendemail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.pkrm.cric.appconstants.ApplicationConstants;
import com.pkrm.cric.util.CricWebAppUtil;

public class SendFromPKMail {

	final String username = "smaddula@prokarma.com";
	final String password = "Ganesh1301";
	CricWebAppUtil CricUtil = new CricWebAppUtil();

	public void sendEmailToAll() {

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			if (CricWebAppUtil.getCurDay().equals("MONDAY")) {

				ArrayList<String> playerlist = ApplicationConstants.PlayersEmailList;

				for (int i = 0; i < playerlist.size(); i++) {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("smaddula@prokarma.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(playerlist.get(i)));
					message.setSubject("PCCT: Team availibility for this week");

					message.setText("Click below link to update your availibility"
							+ "\n\n http://10.5.50.198:9090/CricWebApp/displayAvalPage.do"
							+ "\n\n Please do not reply to this mail, this was automatically "
							+ "triggered by the automatic system.\n\n"
							+ "\n\nThanks\nPCCT Admin");

					Transport.send(message);
					System.out.println("Send to:" + playerlist.get(i));

				}
			}

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public void sendEmaiFromPCCTAdmin() {

		System.out.println("Sending mail");

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		String conStyle = "<style> table,th,td{border:2px solid green;"
				+ "border-collapse:collapse;padding:9px;}</style>";

		String conPreText = "<p>Hi,</p><h4>Plese find the player's avialibility for Saturday match</h4><br>";

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("smaddula@prokarma.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("smaddula@prokarma.com"));
			message.setSubject("PCCT: Team availibility for this week");

			String strConst = "<table><tr><th>PLAYER NAME</th><th>TUESDAY NETS</th>"
					+ "<th>THURSDAY NETS</th><th>SATURDAY MATCH</th><th>ISWEEKLYUPDATED</th>"
					+ "</tr>";
			ResultSet rs = CricUtil.getPlayersAvailibility(null);
			String upString = null;
			String tabContent = "";
			while (rs.next()) {

				if (rs.getDate("UPDATEDDATE") != null) {
					if (rs.getString("IsWeeklyUpdated").equals("0")) {
						upString = "Updated";
					} else {
						upString = "Not Updated";
					}
				} else {
					upString = "Not Updated Yet";
				}
				tabContent = tabContent
						+ "<tr><td>"
						+ rs.getString("PLAYER_NAME")
						+ "</td><td>"
						+ ((rs.getString("TUESDAYNETS") == null || rs
								.getString("TUESDAYNETS").equals("null")) ? "--"
								: rs.getString("TUESDAYNETS"))
						+ "</td><td>"
						+ ((rs.getString("THURSDAYNETS") == null || rs
								.getString("THURSDAYNETS").equals("null")) ? "--"
								: rs.getString("THURSDAYNETS"))
						+ "</td><td>"
						+ ((rs.getString("SATURDAYMATCH") == null || rs
								.getString("SATURDAYMATCH").equals("null")) ? "--"
								: rs.getString("SATURDAYMATCH")) + "</td><td>"
						+ upString + "</td></tr>";
			}
			message.setContent(conPreText + conStyle + strConst + tabContent
					+ "</table>" + "<br><br><br><p>Thanks<br>PCCT Admin</p>",
					"text/html");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getReportForTuesDayNets() {

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			if (CricWebAppUtil.getCurDay().equals("MONDAY")) {

				ArrayList<String> playerlist = ApplicationConstants.PlayersEmailList;

				for (int i = 0; i < playerlist.size(); i++) {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("smaddula@prokarma.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(playerlist.get(i)));
					message.setSubject("PCCT: Team availibility for this week");

					message.setText("Click below link to update your availibility"
							+ "\n\n http://10.5.50.198:9090/CricWebApp/displayAvalPage.do"
							+ "\n\n Please do not reply to this mail, this was automatically "
							+ "triggered by the automatic system.\n\n"
							+ "\n\nThanks\nPCCT Admin");

					Transport.send(message);
					System.out.println("Send to:" + playerlist.get(i));

				}

			}

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public void getReportForThursDayNets() {

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			if (CricWebAppUtil.getCurDay().equals("WEDNESDAY")) {

				ArrayList<String> playerlist = ApplicationConstants.PlayersEmailList;

				for (int i = 0; i < playerlist.size(); i++) {

					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("smaddula@prokarma.com"));
					message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(playerlist.get(i)));
					message.setSubject("PCCT: Team availibility for this week");

					message.setText("Click below link to update your availibility"
							+ "\n\n http://10.5.50.198:9090/CricWebApp/displayAvalPage.do"
							+ "\n\n Please do not reply to this mail, this was automatically "
							+ "triggered by the automatic system.\n\n"
							+ "\n\nThanks\nPCCT Admin");

					Transport.send(message);
					System.out.println("Send to:" + playerlist.get(i));

				}
			}

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	public void getReportForSaturdayMatch() {

		System.out.println("Sending mail");

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		if (CricWebAppUtil.getCurDay().equals("FRIDAY")) {

			String conStyle = "<style> table,th,td{border:2px solid green;"
					+ "border-collapse:collapse;padding:9px;}</style>";

			String conPreText = "<p>Hi,</p><h4>Plese find the player's avialibility for Saturday match</h4><br>";

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("smaddula@prokarma.com"));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse("mjagan@prokarma.com"));
				message.setSubject("PCCT: Team availibility Report for this week");

				String strConst = "<table><tr><th>PLAYER NAME</th><th>TUESDAY NETS</th>"
						+ "<th>THURSDAY NETS</th><th>SATURDAY MATCH</th><th>ISWEEKLYUPDATED</th>"
						+ "</tr>";
				ResultSet rs = CricUtil.getPlayersAvailibility(null);
				String upString = null;
				String tabContent = "";
				while (rs.next()) {

					if (rs.getDate("UPDATEDDATE") != null) {
						if (rs.getString("IsWeeklyUpdated").equals("0")) {
							upString = "Updated";
						} else {
							upString = "Not Updated";
						}
					} else {
						upString = "Not Updated Yet";
					}
					tabContent = tabContent
							+ "<tr><td>"
							+ rs.getString("PLAYER_NAME")
							+ "</td><td>"
							+ ((rs.getString("TUESDAYNETS") == null || rs
									.getString("TUESDAYNETS").equals("null")) ? "--"
									: rs.getString("TUESDAYNETS"))
							+ "</td><td>"
							+ ((rs.getString("THURSDAYNETS") == null || rs
									.getString("THURSDAYNETS").equals("null")) ? "--"
									: rs.getString("THURSDAYNETS"))
							+ "</td><td>"
							+ ((rs.getString("SATURDAYMATCH") == null || rs
									.getString("SATURDAYMATCH").equals("null")) ? "--"
									: rs.getString("SATURDAYMATCH"))
							+ "</td><td>" + upString + "</td></tr>";
				}
				message.setContent(conPreText + conStyle + strConst
						+ tabContent + "</table>"
						+ "<br><br><br><p>Thanks<br>PCCT Admin</p>",
						"text/html");

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public void sendReportToAll(){


		System.out.println("Sending mail");

		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.office365.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		String conStyle = "<style> table,th,td{border:2px solid green;"
				+ "border-collapse:collapse;padding:9px;}</style>";

		String conPreText = "<p>Hi,</p><h4>Plese find the player's avialibility for Saturday match</h4><br>";

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("smaddula@prokarma.com"));
			message.setSubject("PCCT: Team availibility for this week");

			String strConst = "<table><tr><th>PLAYER NAME</th><th>TUESDAY NETS</th>"
					+ "<th>THURSDAY NETS</th><th>SATURDAY MATCH</th><th>ISWEEKLYUPDATED</th>"
					+ "</tr>";
			ResultSet rs = CricUtil.getPlayersAvailibility(null);
			String upString = null;
			String tabContent = "";
			while (rs.next()) {

				if (rs.getDate("UPDATEDDATE") != null) {
					if (rs.getString("IsWeeklyUpdated").equals("0")) {
						upString = "Updated";
					} else {
						upString = "Not Updated";
					}
				} else {
					upString = "Not Updated Yet";
				}
				tabContent = tabContent
						+ "<tr><td>"
						+ rs.getString("PLAYER_NAME")
						+ "</td><td>"
						+ ((rs.getString("TUESDAYNETS") == null || rs
								.getString("TUESDAYNETS").equals("null")) ? "--"
								: rs.getString("TUESDAYNETS"))
						+ "</td><td>"
						+ ((rs.getString("THURSDAYNETS") == null || rs
								.getString("THURSDAYNETS").equals("null")) ? "--"
								: rs.getString("THURSDAYNETS"))
						+ "</td><td>"
						+ ((rs.getString("SATURDAYMATCH") == null || rs
								.getString("SATURDAYMATCH").equals("null")) ? "--"
								: rs.getString("SATURDAYMATCH")) + "</td><td>"
						+ upString + "</td></tr>";
			}
			message.setContent(conPreText + conStyle + strConst + tabContent
					+ "</table>" + "<br><br><br><p>Thanks<br>PCCT Admin</p>",
					"text/html");
			
			ArrayList<String> playerlist = ApplicationConstants.PlayersEmailList;

			for (int i = 0; i < playerlist.size(); i++) {
				
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(playerlist.get(i)));
				Transport.send(message);
				System.out.println("Send to "+playerlist.get(i));
				
			}		

			

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	public static void main(String[] args) {

		SendFromPKMail sfpkmail = new SendFromPKMail();
//		sfpkmail.sendEmaiFromPCCTAdmin();
		// sfpkmail.sendEmailToAll();
		// sfpkmail.getReportForSaturdayMatch();
		sfpkmail.sendReportToAll();

	}

}
