
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class credit_card {
	
	//CC: abreviation for credit card
	
	public int CC_number;
	public String CC_brandName;
	public String CC_userName;
	public String CC_userLastName;
	public LocalDate CC_expirationDate;
	public int CC_amount;
	public float CC_ServiceFee ;
	
	LocalDate thisDate = LocalDate.now();
	int yearNow =thisDate.getYear();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/YY");
	
	public credit_card() {}; //default constructor
	
	public credit_card(
			int CC_number,
			String CC_userName, 
			String CC_userLastName, 
			String CC_brandName,
			LocalDate CC_expirationDate, 
			int CC_amount,
			float CC_ServiceFee ) 
	{
		this.CC_number = CC_number;
		this.CC_userName = CC_userName;
		this.CC_userLastName = CC_userLastName;
		this.CC_brandName = CC_brandName;
		this.CC_expirationDate = CC_expirationDate;
		this.CC_amount = CC_amount;
		this.CC_ServiceFee  = CC_ServiceFee ;
	}
	
	public void ShowInfo() {
		String Expired = " ";
		if(CC_expirationDate.getYear() < yearNow ) {Expired = "EXPIRED";}
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~");
		if(CC_number != 0) {
		System.out.println("Credit Card :" + CC_brandName + " " + CC_number);
		}
		else {System.out.println("INVALID CREDIT CARD");}
		System.out.println("Owner: " + CC_userName + " " + CC_userLastName);
		System.out.println("Service Fee: " + Math.round(CC_ServiceFee*100)/100.0 + "%");
	    System.out.println("Experation Date: " + dtf.format(CC_expirationDate) + " "+ Expired );
	    System.out.println("Amount Entered: "+ CC_amount);
	    System.out.println("~~~~~~~~~~~~~~~~~~");
	}
	
	public void Introduction() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Welcome to the Bank of SEV");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}

	