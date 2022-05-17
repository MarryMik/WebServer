package dbconect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
			//System.out.println(prSt);
			prSt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void addRequest(Request request) {
			
		String status="1";
		//get id service (ticket_type)
		String idService=getIdServicebyName(request.getService().getName());
		//get id client
		String idClient= this.getIdClientbyPhone(request.getClient().getPhone());
		
		//add request
		String insert ="INSERT INTO "+ Const.TICKETS_TABLE+" ("+Const.TICKETS_CL_ID
				+", "+Const.TICKETS_STATUS_ID+", "+Const.TICKETS_TYPE_ID+") VALUES(?,?,?)";	
		if(idClient !=null|| idService !=null) {
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
		}else {
			System.out.println("error");
		}
	}
	public String getIdServicebyName(String name) {
		Statement stmt;
		String idService=null;
		try {
			stmt = getDbConnection().createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT Ticket_Type_ID FROM ticket_type WHERE Ticket_Type_Name='"+name+"'");
			if(rs1.next()) {
			idService = rs1.getString("Ticket_Type_ID");
			//System.out.println("the id of service: "+idService);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return idService;
	}
	
	public String getIdClientbyPhone(String phone) {
		Statement stmt1;
		String clientId=null;
		try {
			stmt1 = getDbConnection().createStatement();
			ResultSet rs2 = stmt1.executeQuery("SELECT Client_ID FROM clients  WHERE PHONE_NUMBER='"+phone+"'");
			if(rs2.next()) {
			 clientId = rs2.getString("Client_ID");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return clientId;
	}
	public Client getClientbyPhone(String phone) {
		Statement stmt1;
		QueueDesk queueDesk = QueueDesk.getInstance();
		String clientName=null;
		try {
			stmt1 = getDbConnection().createStatement();
			ResultSet rs2 = stmt1.executeQuery("SELECT * FROM clients  WHERE PHONE_NUMBER='"+phone+"'");
			if(rs2.next()) {
			 clientName = rs2.getString("Client_Name");
			 
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return queueDesk.addClient(clientName, phone);
	}
	
	public String getIdOperatorbyPhone(String phone) {
		Statement stmt1;
		String operatorId=null;
		try {
			stmt1 = getDbConnection().createStatement();
			ResultSet rs2 = stmt1.executeQuery("SELECT Operator_ID FROM operators WHERE Operator_email='"+phone+"'");
			if(rs2.next()) {
				operatorId = rs2.getString("Operator_ID");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return operatorId;
	}
	
	public Operator getOperatorByphone(String login) {
		Statement stmt1;
		String operatorName=null;
		String operatorPassword=null;
		String operatorLogin=null;
		try {
			stmt1 = getDbConnection().createStatement();
			ResultSet rs2 = stmt1.executeQuery("SELECT * FROM operators WHERE Operator_email='"+login+"'");
			if(rs2.next()) {
				operatorName = rs2.getString("Operator_ID");
				operatorPassword= rs2.getString("Operator_passw");
				operatorLogin = rs2.getString("Operator_email");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
			return new Operator(operatorLogin, operatorPassword,operatorName );
		
		
	}
	
	public Operator getOperatorByLogin(String login, String password) {
		Statement stmt1;
		String operatorName=null;
		String operatorPassword=null;
		String operatorLogin=null;
		try {
			stmt1 = getDbConnection().createStatement();
			ResultSet rs2 = stmt1.executeQuery("SELECT * FROM operators WHERE Operator_email='"+login+"' and Operator_passw='"+password+"'");
			if(rs2.next()) {
				operatorName = rs2.getString("Operator_Name");
				operatorPassword= rs2.getString("Operator_passw");
				operatorLogin = rs2.getString("Operator_email");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		if(operatorLogin!=null && operatorPassword!=null && operatorLogin!=null) {
			return new Operator(operatorLogin, operatorPassword,operatorName );
		}else {
			return null;
		}
		
	}
	
	public String getIdRequestbyStatus(String status) {
		Statement stmt1;
		String requestId=null;
		try {
			stmt1 = getDbConnection().createStatement();
			ResultSet rs2 = stmt1.executeQuery("SELECT Ticket_ID FROM your_contract.tickets WHERE Ticket_Status_ID='"+status+"'");
			if(rs2.next()) {
				requestId = rs2.getString("Ticket_ID");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return requestId;
	}
	
	public String getIdRequestForClosing(String clientPhone, String status, String operatorLogin) {
		Statement stmt;
		String requestId=null;
		try {
			stmt = getDbConnection().createStatement();
			ResultSet rs2 = stmt.executeQuery("SELECT Ticket_ID FROM your_contract.requests "
			+"WHERE PHONE_NUMBER='"+clientPhone+"' AND Operator_email='"+operatorLogin+"' AND Ticket_Status_Name='"+status+"';");
			if(rs2.next()) {
				requestId = rs2.getString("Ticket_ID");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return requestId;
	}
	
	
	public void getRequestsbyOperator(Operator operator) {
		QueueDesk queueDesk = QueueDesk.getInstance();
		Statement stmt;
		try {
			stmt = getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PHONE_NUMBER, Ticket_Type_Name, Ticket_Status_Name, Operator_email"
			+" FROM requests WHERE Operator_email='"+operator.getPhone()+"';");
			while(rs.next()) {
				String clientPhone= rs.getString("PHONE_NUMBER");
				String serviceName= rs.getString("Ticket_Type_Name");
				String status= rs.getString("Ticket_Status_Name");
				String operatorLogin= rs.getString("Operator_email");
				Client client = this.getClientbyPhone(clientPhone);
				Service service = queueDesk.findByName(serviceName);
				Request request = queueDesk.addRequestList(client, service);
				System.out.println(request);
				if(operatorLogin!=null ) {
					Operator operator1 = queueDesk.operatorByPhone(operatorLogin);
					   operator1 = queueDesk.operator(operator1, request);
					   System.out.println(operator1);
					   if(status.equals("CLOSED")) {
							queueDesk.close(operator1);
						}
			       }
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public void getListOfRequestsbyOperatorPhone(String phone) {
		QueueDesk queueDesk = QueueDesk.getInstance();
		Statement stmt;
		try {
			stmt = getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *"
			+" FROM requests WHERE Operator_email='"+phone+"' and Ticket_Status_Name='INPROGRESS';");
			while(rs.next()) {
				String clientPhone= rs.getString("PHONE_NUMBER");
				String serviceName= rs.getString("Ticket_Type_Name");
				Client client = this.getClientbyPhone(clientPhone);
				Service service = queueDesk.findByName(serviceName);
				String status= rs.getString("Ticket_Status_Name");
				String operatorLogin= rs.getString("Operator_email");
				Request request = queueDesk.addRequestListOperator(client, service);
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
	public List<String> getListOfRequestsbyOperator(Operator operator) {
		Statement stmt;
		List <String> requestsByOperator = new ArrayList<String>();
		try {
			stmt = getDbConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Ticket_ID"
			+" FROM requests WHERE Operator_email='"+operator.getPhone()+"' and Ticket_Status_Name='INPROGRESS';");
			while(rs.next()) {
				String requestId=rs.getString("Ticket_ID");
				requestsByOperator.add(requestId);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return requestsByOperator;
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
			ResultSet rs = stmt.executeQuery("SELECT PHONE_NUMBER, Ticket_Type_Name, Ticket_Status_Name, Operator_email FROM requests order by Ticket_Status_Name;");
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
					   //System.out.println(operator);
					   if(status.equals("CLOSED")) {
							queueDesk.close(operator);
						}
			       }
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getActivityOperatorbyPhone(String phone) {
		Statement stmt1;
		String operatorId=null;
		try {
			stmt1 = getDbConnection().createStatement();
			ResultSet rs2 = stmt1.executeQuery("SELECT Is_Available FROM operators WHERE Operator_email='"+phone+"'");
			if(rs2.next()) {
				operatorId = rs2.getString("Is_Available");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		return operatorId;
	}
	
	public void assignRequest (Operator operator) {
		
		//id request by status 'NEW'
		String idRequest= this.getIdRequestbyStatus("1");
		//id operator by phone
		String idOperator= this.getIdOperatorbyPhone(operator.getPhone());
		String Activity=this.getActivityOperatorbyPhone(operator.getPhone());
		if(Activity.equals("1")) {
		String isActive="0";
		
		String insert = "INSERT INTO "+Const.TICKETS_ASSIGNMENTS_TABLE
				+" ("+Const.TICKETS_ASSIGNMENTS_ID+", "+Const.TICKETS_ASSIGNMENTS_OPERATOR_ID
				+", "+Const.TICKETS_ASSIGNMENTS_IS_ACTIVE+" ) VALUES (?,?,?)";
		try {
			PreparedStatement prSt = getDbConnection().prepareStatement(insert);
			prSt.setString(1, idRequest);
			prSt.setString(2, idOperator);
			prSt.setString(3, isActive);
			prSt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		String update2 ="UPDATE `your_contract`.`tickets` SET `Ticket_Status_ID` = '2' WHERE (`Ticket_ID` = '"+idRequest+"');";
		try {
			PreparedStatement prSt1 = getDbConnection().prepareStatement(update2);
			prSt1.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		
		
	}
	

	
	public void closeRequestbyOperator(Operator operator) {
		List <String> requestsByOperator = new ArrayList<String>();
		requestsByOperator =this.getListOfRequestsbyOperator(operator);
		String idRequest = requestsByOperator.get(0);
		String idOperator=this.getIdOperatorbyPhone(operator.getPhone());
		System.out.println("idRequest="+idRequest+" idOperator="+idOperator);
					try {
						PreparedStatement prSt = getDbConnection().prepareStatement("UPDATE `your_contract`.`tickets_assignments` "
								+"SET `Is_Active` = '0' WHERE (`Ticket_ID` = '"+idRequest+"') and (`OPERATOR_ID` = '"+idOperator+"');");
						prSt.executeUpdate();
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
					String update2 ="UPDATE `your_contract`.`tickets` SET `Ticket_Status_ID` = '3' WHERE (`Ticket_ID` = '"+idRequest+"');";
					try {
						PreparedStatement prSt1 = getDbConnection().prepareStatement(update2);
						prSt1.executeUpdate();
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
	}

}
