package TSR_Travels.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Adminstrator {
	static Scanner sc = new Scanner(System.in);
	private static List<Bus> busList = new ArrayList<>();
	
	private Adminstrator() {
		
	}
	static Adminstrator busAdminObj = new Adminstrator();
	
	public static Adminstrator getAdminObj() {
		return busAdminObj;
	}
	

	public void addBus() {
		
		
		// AC Sleeper Buses
		busList.add(new Bus("1", "Bangalore", "Mysore", "Sleeper", "AC", 20,
		        Map.of("Bangalore", 0, "Ramanagara", 40, "Maddur", 80, "Mysore", 150)));
		busList.add(new Bus("2", "Hyderabad", "Chennai", "Sleeper", "AC", 25,
		        Map.of("Hyderabad", 0, "Kurnool", 150, "Nellore", 250, "Chennai", 400)));
		busList.add(new Bus("3", "Coimbatore", "Ooty", "Sleeper", "AC", 15,
		        Map.of("Coimbatore", 0, "Metupalayam", 50, "Coonoor", 80, "Ooty", 120)));

		// Non-AC Sleeper Buses
		busList.add(new Bus("4", "Bangalore", "Mysore", "Sleeper", "NonAC", 25,
		        Map.of("Bangalore", 0, "Ramanagara", 40, "Maddur", 80, "Mysore", 150)));
		busList.add(new Bus("5", "Hyderabad", "Chennai", "Sleeper", "NonAC", 22,
		        Map.of("Hyderabad", 0, "Kurnool", 150, "Nellore", 250, "Chennai", 400)));
		busList.add(new Bus("6", "Coimbatore", "Ooty", "Sleeper", "NonAC", 18,
		        Map.of("Coimbatore", 0, "Metupalayam", 50, "Coonoor", 80, "Ooty", 120)));

		// AC Seater Buses
		busList.add(new Bus("7", "Bangalore", "Chennai", "Seater", "AC", 30,
		        Map.of("Bangalore", 0, "Hosur", 60, "Vellore", 120, "Chennai", 180)));
		busList.add(new Bus("8", "Hyderabad", "Bangalore", "Seater", "AC", 35,
		        Map.of("Hyderabad", 0, "Mahbubnagar", 60, "Anantapur", 120, "Bangalore", 250)));
		busList.add(new Bus("9", "Coimbatore", "Erode", "Seater", "AC", 28,
		        Map.of("Coimbatore", 0, "Tiruppur", 40, "Perundurai", 80, "Erode", 120)));



	}
	
	public List<Bus> getBusList(){
		return busList;
	}
	
	public void setBusList(List<Bus> busList) {
		this.busList = busList;
	}

	
	public void unLockAccount() {
		System.out.println("Enter your e-mail ID : ");
		String email = sc.nextLine();
		while(UserLogin.validateEmail(email)) {
			System.out.println("No user exists with entered e-main ID\n");
			System.out.println("Re-enter your E-mail ID : ");
			email = sc.nextLine();
		}
		
		System.out.println("Enter your password : ");
		String password = sc.nextLine();
		while(!UserLogin.validatePassword(email,password)) {
			System.out.println("nvalid Password\n");
			System.out.println("Re-enter your password : ");
			password = sc.nextLine();
		}
		
		if(UserSignUp.getSignUpObject().getUserMap().get(email).getAccountStatus().equals("Locked")) {
			
			UserSignUp.getSignUpObject().getUserMap().get(email).setFailedCount(0);
			UserSignUp.getSignUpObject().getUserMap().get(email).setAccountStatus("Active");
			System.out.println("\nAccount Un-Locked");
		}else {
			System.out.println("Your Account is Already Active !!");
		}
	}
}















