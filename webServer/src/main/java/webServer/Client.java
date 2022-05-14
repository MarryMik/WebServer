package webServer;
import java.util.Objects;

public class Client {
	private static int counter;
	private int id;
	private String name;
	private String phone;
	
	
	public Client(String Name, String Phone) {
		id =++counter;
		name=Name;
		phone=Phone;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Client #" + id+ " "+name+" "+phone;
	}
	
	public static void zeroCounter() {
		counter=0;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return id == other.id;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
