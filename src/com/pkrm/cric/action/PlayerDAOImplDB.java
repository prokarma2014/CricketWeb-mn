package com.pkrm.cric.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.mysql.jdbc.Blob;
import com.pkrm.cric.model.TeamRegistration;

public class PlayerDAOImplDB implements PlayerDAO {


	public List<String> getPlayerDetailsByName(String player_Name)
			throws MyDAOException {
		Connection con = null;
		try {
			con = MyConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			// PreparedStatement
			// ps=con.prepareStatement("select * from players where names like 'm%'");
			// ps.setString(2, player_Name);
			// ResultSet rS =
			// stmt.executeQuery("select * from players where names like 'm%'");

			ResultSet rS = stmt.executeQuery("select * from players where EMPLOYEE_NAME like '"+ player_Name + "%'");
			// ResultSet rs=ps.executeQuery();
			List<String> list = new ArrayList<String>();
			while (rS.next()) {
				//PlayerDetails details = new PlayerDetails();
				// details.playerName=rs.getString(2);
				list.add(rS.getString(2));

			}
			con.close();
		//	System.out.println("Players list :" + list);
			return list;

		}

		catch (SQLException e) {
			System.out.println("Error:\n\t" + e.getMessage());
			throw new MyDAOException("Exception while getting data fromm DB");
		}
	}
	public boolean insertTeamDetails(TeamRegistration teamRegistration)
			throws MyDAOException {
		 InputStream inputStream = null;
		FormFile file =teamRegistration.getTeamLogo();
		int filesize=file.getFileSize();
		//String fname= file.getFileName();
		try {
			 inputStream= file.getInputStream();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = null;
		try
		{
			con = MyConnectionFactory.getConnection();
			String inserQuery="insert into team(team_id,team_name,TEAM_CAPT,TEAM_VICE_CAPT,TEAM_CAPT_ID,TEAM_VICE_CAPT_ID,PLAYER_ID,teamlogo) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(inserQuery);
			ps.setString(2,teamRegistration.getTeamName());
			ps.setInt(1, teamRegistration.getTeamID());
			ps.setString(3,teamRegistration.getCaptainName());
			ps.setString(4,teamRegistration.getViceCaptainName());
			ps.setInt(5, teamRegistration.getCaptainID());
			ps.setInt(6, teamRegistration.getViceCaptainID());
			ps.setString(7,teamRegistration.getSelectPlayers());
//			ps.setNull(8,Types.BLOB);
			ps.setBinaryStream(8, inputStream, filesize);
//			ps.setString(9,teamRegistration.getSelectedPlayers());
			ps.executeUpdate();

			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			//System.out.println("**Exception**"+e.getMessage());
		}
		// TODO Auto-generated method stub
		return false;
	}

	public Blob getImage(Integer teamId){
		 Connection con;
		try {
			  con = MyConnectionFactory.getConnection();
			 String getimage="select teamlogo from team where team_id=? ";
			 PreparedStatement ps = con.prepareStatement(getimage);
			 ps.setInt(1,teamId );
			ResultSet resultSet= ps.executeQuery();
			if(resultSet.next()){
			return	(Blob) resultSet.getBlob(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
}
