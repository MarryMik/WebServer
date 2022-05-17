package webServer;


public class Request {
	public enum Status {
		NEW, INPROGRESS, CLOSED
	}

	private static int counter;
	private int id;
	private Client client;
	private Service service;
	private Operator operator;
	private Status status = Status.NEW;

	public Request(Client cl, Service Service) {
		id = ++Request.counter;
		service=Service;
		client=cl;
	}

	public int getId() {
		return id;
	}

	public Operator getOperator() {
		return operator;
	}

	public Status status() {
		return status;
	}
	
	public Request updadeStatus(Request req, Status s) {
		return req;
	}

	@Override
	public String toString() {
		return "Request #" + id + " " + status + " " + operator + " " +client + " "+service;
	}

	public void operator(Operator newOperator) {
		operator = newOperator;
		status = Status.INPROGRESS;
	}

	public void close() {
		status = Status.CLOSED;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client cl) {
		this.client=cl;
	}
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	public static void zeroCounter() {
		counter=0;
	}

}
