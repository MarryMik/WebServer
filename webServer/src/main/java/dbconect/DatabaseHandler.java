package dbconect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
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
		System.out.println("connection  "+ connectionString);
		return dbConnection;
	}
	
	public void addOperator(Operator operator, String acesscode) {
		String insert="INSERT INTO "+Const.OPERATOR_TABLE 
				+ " (" + Const.OPERATOR_EMAIL+ "," 
				+ Const.OPERATOR_NAME +"," +Const.OPERATOR_ACESS +","
				+Const.OPERATOR_PASSW +", "+Const.OPERATOR_TYPE_ID+") " +"VALUES (?,?,?,?,?)";	
		try {
			PreparedStatement prSt = getDbConnection().prepareStatement(insert);
			prSt.setString(1, operator.getPhone());
			prSt.setString(2, operator.getName());
			prSt.setString(3, "1");
			prSt.setString(4, operator.getPassword());
			prSt.setString(5, "1");
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
			System.out.println(prSt);
			prSt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void addRequest(Request request) {
			
		//get request status
		String status;
		if(request.status().equals(Request.Status.CLOSED)) {
			status="3";
		}else if (request.status().equals(Request.Status.INPROGRESS)) {
			status="2";
		}else {
			status="1";
		}
		//get id service (ticket_type)
		Statement stmt;
		String idService=null;
		try {
			stmt = getDbConnection().createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT Ticket_Type_ID FROM your_contract.ticket_type WHERE Ticket_Type_Name='"+request.getService().getName()+"'");
			idService = rs1.getString("Ticket_Type_ID");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		//get id client
		Statement stmt1;
		String idClient=null;
		try {
			stmt1 = getDbConnection().createStatement();
			ResultSet rs2 = stmt1.executeQuery("SELECT Client_ID FROM your_contract.clients  WHERE PHONE_NUMBER='"+request.getClient().getPhone()+"'");
			idClient = rs2.getString("Client_ID");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		//add request
		String insert ="INSERT INTO "+ Const.TICKETS_TABLE+" ("+Const.TICKETS_CL_ID
				+", "+Const.TICKETS_STATUS_ID+", "+Const.TICKETS_TYPE_ID+") VALUES(?,?,?)";	
		try {
			PreparedStatement prSt = getDbConnection().prepareStatement(insert);
			prSt.setString(1, idClient);
			prSt.setString(2, status);
			prSt.setString(3, idService);
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
	
	public void getServices(){
		QueueDesk queueDesk = QueueDesk.getInstance();
		try {
			Statement stmt = getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ticket_type");
			while(rs.next()) {
				String name= rs.getString("Ticket_Type_Name");
				queueDesk.addServiceList(name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void getOperators() {
		QueueDesk queueDesk = QueueDesk.getInstance();
		
		Statement stmt;
		try {
			stmt = getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM operators;");
			while(rs.next()) {
				String name= rs.getString("Operator_Name");
				String password= rs.getString("Operator_passw");
				String phone= rs.getString("Operator_email");
				queueDesk.addOperatorList(phone, password, name);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getRequests() {
		QueueDesk queueDesk = QueueDesk.getInstance();
		Statement stmt;
		try {
			stmt = getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PHONE_NUMBER, Ticket_Type_Name, Ticket_Status_Name, Operator_email FROM requests ;");
			while(rs.next()) {
				String clientPhone= rs.getString("PHONE_NUMBER");
				String serviceName= rs.getString("Ticket_Type_Name");
				String status= rs.getString("Ticket_Status_Name");
				String operatorLogin= rs.getString("Operator_email");
				Client client = queueDesk.clientByPhone(clientPhone);
				Service service = queueDesk.findByName(serviceName);
				Request request = queueDesk.addRequestList(client, service);
				System.out.println(request);
				if(operatorLogin!=null ) {
					Operator operator = queueDesk.operatorByPhone(operatorLogin);
					   operator = queueDesk.operator(operator, request);
					   System.out.println(operator);
					   if(status.equals("CLOSED")) {
							queueDesk.close(operator);
						}
			       }
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
/*	
 *  public Request updateRequest(Request request){}
 *  public void deleteOperator(Operator operator){}
 *  public void deleteClient(Client client){}
 *  public void deleteService(Service service){}
 *  public void deleteRequest(Request request){}
 *  public void deleteOperator(Operator operator){}
 *  
 
 *  3. присвоїти запрос оператору
 *  4. закрити запрос, змінити статус
 *  
 *  
 */
}
