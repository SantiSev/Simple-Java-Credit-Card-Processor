

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;


public class main {

	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/YY");
		DateTimeFormatter YY = DateTimeFormatter.ofPattern("YY");

		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		Scanner scan4 = new Scanner(System.in);
		Scanner scan5 = new Scanner(System.in);
		boolean loopBool = true;
		int selection = 0;
		LocalDate thisDate = LocalDate.now();
		String yearNow =YY.format(thisDate);
		float yearNowFloat = Float.parseFloat(yearNow);
		float monthNow = thisDate.getMonthValue();
		float dayNow = thisDate.getDayOfMonth();
		
		List<String> CreditCardBrands = new ArrayList<String>();
		CreditCardBrands.add("VISA");
		CreditCardBrands.add("NARA");
		CreditCardBrands.add("AMEX");
		int listIdentity;
		
		int CC_number = 0;
		String CC_brandName;
		String CC_userName;
		String CC_userLastName;
		int CC_Year = 0;
		int CC_Month = 0;
		int CC_Amount = 0;
		float CC_ServiceFee = 0;
		
		while(true) {
		credit_card CC = new credit_card();
		CC.Introduction();
		
		    System.out.println("Enter Your Name Please:");
		    CC_userName = scan.next();
		    System.out.println("Enter Your Last Name Please:");
		    CC_userLastName = scan.next();
		    
		    loopBool = true;
		    while(loopBool)
		    {
		    System.out.println("Please select a Credit Card Provider: ");
		    for (int i = 1; i <= CreditCardBrands.size(); i++) {
		    	
		    	System.out.println("["+i+"] --> " + CreditCardBrands.get(i-1));  
			}
		   
		    try {
		    	selection = scan5.nextInt();
			} catch (Exception e) {
				System.out.println("you entered a character that does not belong");
				System.out.println("We will now set as default your selection to VISA");
				selection = 1;
			}
		    	if (selection > 0 && selection <= CreditCardBrands.size()) {
			    loopBool = false;
			}
		    	else {
		    	System.out.println("Please Enter a value seen on the list!");
		    		loopBool = true;
		    	}
		    }
		    
	    	CC_brandName =CreditCardBrands.get(selection - 1);
	    	listIdentity = selection;
	    	System.out.println("Credit Card: " + CC_brandName);
	    	    	
	    	System.out.println("Enter Your Credit Card Number:");
	    	try {
	    		CC_number = scan1.nextInt();
			} catch (Exception e) {
				System.out.println("The value you entered is imposible to be a credit card number");
				CC_number = 0;
			}
	    	
	    	
	    	
	    	System.out.println("Enter your Experation Date:");
	    	loopBool = true;
	    	while(loopBool) {
	    		System.out.println("Month (MM):");
	    		try {
	    			CC_Month = scan2.nextInt();
				} catch (Exception e) {
					System.out.println("You entered an invalid format");
					System.out.println("now defaulting to the present month");
					CC_Month = thisDate.getMonthValue();
				}
	        	
	    		if (CC_Month < 0 || CC_Month > 12 ) {
					System.out.println("The Month you entered does not exist");
					System.out.println("Please enter a valid month");
				}
	    		else {loopBool = false;}
	    	}
	    	
	    	
	    	loopBool = true;
	    	while(loopBool) {
	    		System.out.println("Year (YYYY):");
	    		try {
	    			CC_Year = scan3.nextInt();
				} catch (Exception e) {
					System.out.println("You entered an invalid format");
					System.out.println("now defaulting to the present year");
					CC_Year = thisDate.getYear();
				}
	    		if (CC_Year < 0) {
					System.out.println("The Year you entered does not exist");
					System.out.println();
				}
	    		else {loopBool = false;}
	    		}
	    	
	    	LocalDate CC_expirationDate = LocalDate.of(CC_Year, CC_Month, 1);
	    	System.out.println("Experation Date: " + dtf.format(CC_expirationDate) );
	    	
	    	
	    	loopBool = true;
	    	while(loopBool) {
	    	System.out.println("Enter the amount of Funds (PESOS Arg) you wish to add to your account");
	    	try {
	    		CC_Amount = scan4.nextInt();
			} catch (Exception e) {
				System.out.println("You entered an invalid format");
				System.out.println("now defaulting to $1000");
				CC_Amount = 1000;
			}
	    
	    	if (CC_Amount < 1000) {System.out.println("please enter an amout that is more than $1000");}
	    	else { loopBool = false;}
	    	}
	    	System.out.println("Amount entered: " + CC_Amount);
			
	    	System.out.println("Since your card belongs to: " + CreditCardBrands.get(listIdentity - 1));
	    	
	    	switch (listIdentity) {
	    	case 1:
	    		CC_ServiceFee  = yearNowFloat / monthNow;
	    		break;
	    	case 2:
	    		CC_ServiceFee  = (float) (dayNow * 0.5);
	    		break;
	    	case 3:
	    		CC_ServiceFee  = (float) (monthNow * 0.1) ;
	    		break;
	    	}
	    	
	    	if(CC_ServiceFee  >= 5) {CC_ServiceFee  = 5; }
	    	else if (CC_ServiceFee <= 0.3) {CC_ServiceFee  = (float) 0.3;}
	    	
	    	System.out.println("your service fee rate is: " + Math.round(CC_ServiceFee*100)/100.0 + "%");
	    	
	    	credit_card New_CC = new credit_card(
	    			CC_number,
	    			CC_userName, 
	    			CC_userLastName, 
	    			CC_brandName,
	    			CC_expirationDate, 
	    			CC_Amount,
	    			CC_ServiceFee 
	    			);
	    	
	    	New_CC.ShowInfo();
	    	
	}
	}
}
	
