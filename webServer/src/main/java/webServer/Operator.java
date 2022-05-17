package webServer;

import java.util.Objects;

public class Operator {
	private static int counter;
	private int id;
	private String phone;
	private String password;
	private String name;
	

	public Operator(String Phone, String Password, String Name) {
		id = ++counter;
		phone=Phone;
		password=Password;
		setName(Name);
	}
	
	

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Operator #" + id +" "+name+" "+phone+" "+password;
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
		Operator other = (Operator) obj;
		return id == other.id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
}
