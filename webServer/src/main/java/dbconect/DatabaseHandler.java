package dbconect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import webServer.*;

public class DatabaseHandler extends Config{
	Connection dbConnection;
	
	public Connection getDbConnection() 
			throws ClassNotFoundException, SQLException{
		String connectionString ="jdbc:mysql://"+dbHost + ":"
				+dbPort + "/" + dbName;
		Class.forName("com.mysql.jdbc.Driver");
		dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
		return dbConnection;
	}
	
	public void addOperator(Operator operator, String acesscode) {
		String insert="INSERT INTO "+Const.OPERATOR_TABLE 
				+ " (" + Const.OPERATOR_EMAIL+ "," 
				+ Const.OPERATOR_NAME +"," +Const.OPERATOR_ACESS +","
				+Const.OPERATOR_PASSW +") " +"VALUES (?,?,?,?)";	
		try {
			PreparedStatement prSt = getDbConnection().prepareStatement(insert);
			prSt.setString(1, operator.getPhone());
			prSt.setString(2, operator.getName());
			prSt.setString(3, acesscode);
			prSt.setString(4, operator.getPassword());
			prSt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void addServices(Service service) {
		String insert ="INSERT INTO "+Const.TICKET_TYPE_TABLE + " ("+Const.TICKET_TYPE_NAME
				+") VALUES (?)";
		
		try {
			PreparedStatement prSt = getDbConnection().prepareStatement(insert);
			prSt.setString(1, service.getName());
			prSt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void addRequest(Request request) {
		String insert ="INSERT INTO "+ Const.TICKETS_TABLE+" ("+Const.TICKETS_CL_ID
				+", "+Const.TICKETS_STATUS_ID+", "+Const.TICKETS_TYPE_ID+") VALUES(?,?,?)";		
		
		String status;
		if(request.status().equals(Request.Status.NEW)) {
			status="1";
		}else if (request.status().equals(Request.Status.INPROGRESS)) {
			status="2";
		}else {
			status="3";
		}
		try {
			PreparedStatement prSt = getDbConnection().prepareStatement(insert);
			prSt.setString(1, Integer.toString(request.getClient().getId()));
			prSt.setString(2, status);
			prSt.setString(3, Integer.toString(request.getService().getId()));
			prSt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addClient(Client client) {
		String insert = "INSERT INTO "+Const.CLIENT_TABLE
				+" ("+Const.CLIENT_NAME+", "+Const.CLIENT_PHONE+" ) VALUES (?,?)";
		try {
			PreparedStatement prSt = getDbConnection().prepareStatement(insert);
			prSt.setString(1, client.getName());
			prSt.setString(2, client.getPhone());
			prSt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
/*	public Operator getOperator(int id) {//	}
 *  public Client getClient(int id){}
 *  public Service getService(int id){}
 *  public Request getRequest(int id){}
 *  public Request updateRequest(Request request){}
 *  public void deleteOperator(Operator operator){}
 *  public void deleteClient(Client client){}
 *  public void deleteService(Service service){}
 *  public void deleteRequest(Request request){}
 *  public void deleteOperator(Operator operator){}
 */
}
