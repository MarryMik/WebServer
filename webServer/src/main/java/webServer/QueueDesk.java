package webServer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import dbconect.*;

public class QueueDesk {
	private List<Request> requests = new ArrayList<Request>();
	private List <Service> services = new ArrayList<Service>();
	private List<Operator> operators = new ArrayList<Operator>();
	private List<Client> clients = new ArrayList<Client>();
	private DatabaseHandler db = new DatabaseHandler();
	
	private static QueueDesk instance;

	private QueueDesk() {
		super();
	}

	public static QueueDesk getInstance() {
		if (instance == null) {
			instance = new QueueDesk();
		}
		return instance;
	}
	
	//***Client***
	
	public Client addClient(String name, String phone) {
		Client client = new Client(name,phone);
		clients.add(client);
		System.out.println("QueueDesk.addClient(), "+client);
		db.addClient(client);
		return client;
	}
	public void resetClients(){
		clients.clear();
		Client.zeroCounter();
	}
	public List<Client> clients(){
		return clients;
	}
	public Client checkClient(int id) {
		return clients.stream().filter(x -> x.getId() ==id).findAny().orElse(null);
	}
	
	public Client clientByPhone(String phone) {
		return clients.stream().filter(x->x.getPhone().equals(phone)).findAny().orElse(null);
	}
	
	//***Service***
	
	public Service addService(String serviceName) {
		Service service = new Service(serviceName);
		services.add(service);
		System.out.println("QueueDesk.addService(), "+ service);
		
		db.addServices(service);
		return service;
	} 
	
	
	public void addServiceList(String serviceName) {
		Service service = new Service(serviceName);
		services.add(service);
	}
	public void resetServices() {
		services.clear();
		Service.zeroCounter();
	}
	public List<Service> services(){
		services.clear();
		Service.zeroCounter();
		db.getServices();
		return services;
	}
	public Service findByName(String nameService) {
		Service searchService=null ;
		for(int i=0; i<services.size(); i++) {
			System.out.println(i+" "+ services.get(i).getName());
			if(services.get(i).getName().equals(nameService)) {
				searchService=services.get(i);
			}
		}
		return searchService;
	}
	public Service checkService(int id) {
		return services.stream().filter(x -> x.getId() == id).findAny().orElse(null);
	}
	
	//***Operator***
	
	public Operator addOperator(String phone, String password, String name, String acesscode) {
		Operator operator = new Operator(phone, password, name);
		operators.add(operator);
		System.out.println("QueueDesk.addOperator(), " + operator);
		db.addOperator(operator, "1");
		return operator;
	}
	
	public void addOperatorList(String phone, String password, String name) {
		Operator operator = new Operator(phone, password, name);
		operators.add(operator);
	}
	public void resetOperators() {
		operators.clear();
		Operator.zeroCounter();
	}
	public Operator checkOperator(int id) {
		return operators.stream().filter(x -> x.getId() == id).findAny().orElse(null);
	}

	public List<Operator> operators() {
		operators.clear();
		Operator.zeroCounter();
		db.getOperators();
		return operators;
	}

	public Operator operator(Operator operator) {
		Operator result = null;
		if (operator != null) {
			for (Request request : requests) {
				if (request.status() == Request.Status.NEW) {
					request.operator(operator);
					result = operator;
					db.assignRequest(operator);
					break;
				}
			}
		}

		System.out.println("QueueDesk.operator(), " + operator);
		return result;
	}
	public Operator operator(Operator operator, Request request) {
		Operator result = null;
		
		if (operator != null) {
					request.operator(operator);
					result = operator;					
		}

		System.out.println("QueueDesk.operator(operator, request), " + operator+ " "+ request);
		return result;
	}
	
	public Operator operatorByPhone(String phone) {
		return operators.stream().filter(x -> x.getPhone().equals(phone)).findAny().orElse(null);
	}
	//***Request***
	public Request addRequest(Client client, Service Service) {
		Request request = new Request(client,Service);
		requests.add(request);
		System.out.println("QueueDesk.addRequest(), " + request);
		db.addRequest(request);
		return request;
	}
	public Request addRequestList(Client client, Service service) {
		Request request = new Request(client, service);
		requests.add(request);
		return request;
	}
	public void close(Operator operator) {
		for (Request request : requests) {
			if (request.getOperator() == operator && request.status() == Request.Status.INPROGRESS) {
				request.close();
				break;
			}
		}
		System.out.println("QueueDesk.close(), " + operator);
	}
	
	public void closeInDB(Operator operator) {
			db.closeRequestbyOperator(operator);
			for (Request request : requests) {
				if (request.getOperator() == operator && request.status() == Request.Status.INPROGRESS) {
					request.close();
					break;
				}
			}
			System.out.println("QueueDesk.closeInDB(), " + operator);
		}
	
	public List<Request> allRequests(){
		requests.clear();
		Request.zeroCounter();
		db.getRequests();
		return requests;
	}

	public List<Request> requests(Request.Status status) {
		return requests.stream().filter(x -> x.status() == status).collect(Collectors.toList());
	}

	public List<Request> requests(Operator operator) {
		return requests.stream().filter(x -> x.getOperator() == operator && x.status() == Request.Status.INPROGRESS)
				.collect(Collectors.toList());
	}

	public Request checkTicket(int id) {
		return requests.stream().filter(x -> x.getId() == id).findAny().orElse(null);
	}

	public void print() {
		System.out.println("Requests:");
		if (requests == null || requests.size() == 0) {
			System.out.println("<EMPTY>");
		} else {
			for (Request request : requests) {
				System.out.println(request);
			}
		}
		System.out.println("---");
	}
}
