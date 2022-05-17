package webServer;

public class Service {
	private static int counter;
	private int id;
	private String name;
	
	public Service(String Name){
		name=Name;
		id=++Service.counter;
	}
	public String getName() {
//		System.out.println("finded name:"+name+":");
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public static void zeroCounter() {
		counter=0;
	}
	
 @Override
 public String toString() {
	 return "Service #"+id+" "+ name;
 }
	
}
