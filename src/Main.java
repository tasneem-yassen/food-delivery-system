import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//create delivery system opject 
		DeliverySystem system = new DeliverySystem(0, 0, 0,0, 0);
		//load intial system data
		loadCustomers(system);
		loadRestaurants(system);
		loadRiders(system);
		loadRestAdmins(system);
		//assign restaurant admins to restaurants 
		system.assignRestAdminToRestaurant("ahmadAdmin", "2001");
		system.assignRestAdminToRestaurant("ahmadAdmin", "2002");
		system.assignRestAdminToRestaurant("noaAdmin", "2003");
		system.assignRestAdminToRestaurant("noaAdmin", "2004");
		system.assignRestAdminToRestaurant("davidAdmin", "2005");
		system.assignRestAdminToRestaurant("davidAdmin", "2006");
		//load intial orders 
		loadOrders(system);
		Scanner input = new Scanner(System.in);
		int choice = -1; // main menu choice variable
		while(choice !=0) {
			System.out.println("Welcome to Delivery System menu");
			System.out.println("Please choose:\n1: System admin\n"
					+ "2: RestaurantAdmin\n3: Rider\n4: Customer\n0: exit system");
			if(input.hasNextInt()) {
				choice = input.nextInt();
			}
			else {
			    System.out.println("Invalid input");
			    input.next();
			    continue;
			}
			switch(choice) {
		    case 1:
		        systemAdminMenu(input, system);
		        break;

		    case 2:
		        restaurantAdminMenu(input, system);
		        break;

		    case 3:
		        riderMenu(input, system);
		        break;

		    case 4:
		        customerMenu(input, system);
		        break;

		    case 0:
		        return;

		    default:
		        System.out.println("Invalid choice.");
			}
		}
	}
/////////////loading starting values/////////////////////////////////////////
	public static boolean loadCustomers(DeliverySystem system) {
		//load intial cutomers into system 
		boolean success = true;
	    success = system.addCustomer(new Customer("1001", "Ahmad", "Ali",
	            new Address("10 Herzl", "Haifa", "12345"),
	            "0521234567", "ahmad@gmail.com", 100)) && success;
	    success = system.addCustomer(new Customer("1002", "Noa", "Cohen",
	            new Address("20 Hanamal", "Haifa", "23456"),
	            "0531234567", "noa@gmail.com", 250)) && success;
	    success = system.addCustomer(new Customer("1003", "David", "Levi",
	            new Address("30 Allenby", "Tel Aviv", "34567"),
	            "0541234567", "david@gmail.com", 0)) && success;
	    success = system.addCustomer(new Customer("1004", "Sara", "Mansour",
	            new Address("40 Hagalil", "Nazareth", "45678"),
	            "0551234567", "sara@gmail.com", 55)) && success;
	    success = system.addCustomer(new Customer("1005", "Lina", "Haddad",
	            new Address("50 Carmel", "Haifa", "56789"),
	            "0561234567", "lina@gmail.com", 70)) && success;
	    success = system.addCustomer(new Customer("1006", "Omar", "Nassar",
	            new Address("60 Begin", "Jerusalem", "67890"),
	            "0571234567", "omar@gmail.com", 900)) && success;
	    success = system.addCustomer(new Customer("1007", "Maya", "Bar",
	            new Address("70 Yaffo", "Acre", "78901"),
	            "0581234567", "maya@gmail.com", 60)) && success;
	    success = system.addCustomer(new Customer("1008", "Rami", "Saleh",
	            new Address("80 Shalom", "Haifa", "89012"),
	            "0591234567", "rami@gmail.com", 33)) && success;
	    success = system.addCustomer(new Customer("1009", "Dana", "Mor",
	            new Address("90 Nof", "Tiberias", "90123"),
	            "0501234567", "dana@gmail.com", 300)) && success;
	    success = system.addCustomer(new Customer("1010", "Yara", "Khalil",
	            new Address("100 Hadar", "Haifa", "11223"),
	            "0527654321", "yara@gmail.com", 770)) && success;
	    return success;
	}
	public static boolean loadRestaurants(DeliverySystem system) {
		//load intial restaurants into system
		boolean success = true; 
		// Regular restaurants
	    success = system.addRestaurant(new Restaurant("2001","Burger House",
	            "Fast Food",4.5,true,15)) && success;
	    success = system.addRestaurant(new Restaurant("2002","Pizza Corner",
	            "Italian",4.1,true,10)) && success;
	    success = system.addRestaurant(new Restaurant("2003","Green Bowl",
	            "Healthy",4.3,true,12)) && success;
	    success = system.addRestaurant(new Restaurant("2004","Mama Pasta",
	            "Italian",4.0,false,14)) && success;
	    success = system.addRestaurant(new Restaurant("2005","Falafel King",
	            "Middle Eastern",4.6,true,8)) && success;
	    success = system.addRestaurant(new Restaurant("2006","Wok Time",
	            "Chinese",4.2,true,11)) && success;
	    success = system.addRestaurant(new Restaurant("2007","Taco Place",
	            "Mexican",4.4,true,13)) && success;
	    success = system.addRestaurant(new Restaurant("2008","Sea Food Bay",
	            "Seafood",4.7,true,20)) && success;
	    success = system.addRestaurant(new Restaurant("2009","Village Kitchen",
	            "Homemade",4.1,true,9)) && success;
	    success = system.addRestaurant(new Restaurant("2010","Coffee Spot",
	            "Cafe",4.0,true,7)) && success;
	    // Fast food restaurants
	    success = system.addRestaurant(new FastFoodRestaurant("2011","Quick Bite",
	            "Fast Food",4.2,true,12,20,8)) && success;
	    success = system.addRestaurant(new FastFoodRestaurant("2012","Speedy Sushi",
	            "Japanese",4.4,true,18,15,6)) && success;
	    success = system.addRestaurant(new FastFoodRestaurant("2013","Rapid Pizza",
	            "Italian",4.1,true,10,12,5)) && success;
	    success = system.addRestaurant(new FastFoodRestaurant("2014","Burger Express",
	            "Fast Food",4.5,true,14,10,4)) && success;
	    success = system.addRestaurant(new FastFoodRestaurant("2015","Hot Dog Hub",
	            "American",4.0,true,9,8,3)) && success;
	    success = system.addRestaurant(new FastFoodRestaurant("2016","Chicken Rush",
	            "Fast Food",4.3,true,13,14,5)) && success;
	    success = system.addRestaurant(new FastFoodRestaurant("2017","Wrap & Go",
	            "Street Food",4.1,true,11,9,4)) && success;
	    success = system.addRestaurant(new FastFoodRestaurant("2018","Snack Attack",
	            "Snacks",3.9,true,7,6,2)) && success;
	    success = system.addRestaurant(new FastFoodRestaurant("2019","Fast Noodles",
	            "Asian",4.2,true,10,11,4)) && success;
	    success = system.addRestaurant(new FastFoodRestaurant("2020","Toast Point",
	            "Cafe",4.0,true,8,7,3)) && success;
	    // Premium restaurants
	    success = system.addRestaurant(new PremiumRestaurant("2021","Royal Steak",
	            "Steakhouse",4.9,true,25,100,10)) && success;
	    success = system.addRestaurant(new PremiumRestaurant("2022","Luxury Grill",
	            "Grill",5.0,true,30,150,12)) && success;
	    success = system.addRestaurant(new PremiumRestaurant("2023","Golden Fish",
	            "Seafood",4.8,true,28,120,11)) && success;
	    success = system.addRestaurant(new PremiumRestaurant("2024","Elite Sushi",
	            "Japanese",4.9,true,26,130,10)) && success;
	    success = system.addRestaurant(new PremiumRestaurant("2025","Diamond Pasta",
	            "Italian",4.7,true,24,110,9)) && success;
	    success = system.addRestaurant(new PremiumRestaurant("2026","Sky Lounge",
	            "Fusion",4.8,true,35,200,15)) && success;
	    success = system.addRestaurant(new PremiumRestaurant("2027","Chef Palace",
	            "French",4.9,true,32,180,14)) && success;
	    success = system.addRestaurant(new PremiumRestaurant("2028","Prestige Dining",
	            "International",4.6,true,27,140,10)) && success;
	    success = system.addRestaurant(new PremiumRestaurant("2029","Prime Taste",
	            "Steakhouse",4.7,true,29,160,13)) && success;
	    success = system.addRestaurant(new PremiumRestaurant("2030","Ocean Pearl",
	            "Seafood",4.8,true,31,170,12)) && success;
	    return success;
	}
	public static boolean loadRiders(DeliverySystem system) {
		//load intial riders into system
		boolean success = true;
		success = system.addRider(new Rider("123456789","Ahmad","Ali",
				"0521234567","car",true,new Order[20],0)) && success;
		success = system.addRider(new Rider("987654321","Noa","Cohen",
				"0532345678","bike",true,new Order[20],0)) && success;
		success = system.addRider(new Rider("456789123","David","Levi",
				"0543456789","motorBike",true,new Order[20],0)) && success;
		success = system.addRider(new Rider("741852963","Lina","Haddad",
				"0554567890","car",false,new Order[20],0)) && success;
		success = system.addRider(new Rider("159357486","Omar","Nassar",
				"0565678901","bike",true,new Order[20],0)) && success;

		return success;
	}
	public static boolean loadRestAdmins(DeliverySystem system) {
		//load intial restaurant admins into system
		boolean success = true;
		success = system.addRestAdmin(new RestAdmin("Ahmad Ali",
				"ahmadAdmin","1234",new Restaurant[10],0)) && success;
		success = system.addRestAdmin(new RestAdmin("Noa Cohen",
				"noaAdmin","5678",new Restaurant[10],0)) && success;
		success = system.addRestAdmin(new RestAdmin("David Levi",
				"davidAdmin","9999",new Restaurant[10],0)) && success;

		return success;
	}
	public static boolean loadOrders(DeliverySystem system) {
		//load intial orders into system
		boolean success = true;
		success = system.addOrder(new Order("3001","1001",system.findRestaurantByCode("2001"),
				"2001","000",new MyDate(10,5,2026),new MyDate(0,0,0),
				85,"sent")) && success;
		success = system.assignRiderToOrder("123456789", "3001") && success ;
		success = system.addOrder(new Order("3002","1002",system.findRestaurantByCode("2003"),
				"2003","000",new MyDate(11,5,2026),new MyDate(12,5,2026),
				140,"delivered")) && success;
		success = system.addOrder(new Order("3003","1003",system.findRestaurantByCode("2005"),
				"2005","000",new MyDate(12,5,2026),new MyDate(0,0,0),
				60,"sent")) && success;
		success = system.addOrder(new Order("3004","1004",system.findRestaurantByCode("2002"),
				"2002","000",new MyDate(13,5,2026),new MyDate(0,0,0),
				95,"on the way")) && success;
		success = system.addOrder(new Order("3005","1005",system.findRestaurantByCode("2006"),
				"2006","000",new MyDate(13,5,2026),new MyDate(13,5,2026),
				220,"delivered")) && success;
		success = system.assignRiderToOrder("159357486", "3005") && success;
		return success;
	}
///////////////// menu helper methods ///////////////////////////////////////////
	public static void systemAdminMenu(Scanner input, DeliverySystem system) {
		//handles system admin menu
		String userName, password;
		boolean exitFlag = false;
		int adminChoice = -1;
		System.out.println("Please enter your userName:");
		userName = input.next();
		System.out.println("Please enter your password:");
		password = input.next();
		while(!system.systemAdminLogin(userName, password)) {
			System.out.println("Login info is wrong please try again : ");
			System.out.println("Please enter your userName or 0 to go back:");
			userName = input.next();
			if(userName.equals("0")) {
				exitFlag = true;
				break; 
			}
			System.out.println("Please enter your password:");
			password = input.next();
		}
		// if user asked to go back 
		if(exitFlag) {
			return; 
		}
		while(adminChoice != 0) {
			System.out.println("Welcome admin\nPlease choose action:\n"
					+ "1: Add customer\n2: Add restaurant admin\n3: Assign admin to restaurant\n4: Add restaurant\n"
					+ "5: Add rider\n6: Assign rider to order\n0: go back");
			if(input.hasNextInt()) {
				adminChoice = input.nextInt();
			}
			else {
			    System.out.println("Invalid input");
			    input.next();
			    continue;
			}
			switch(adminChoice) {
            case 1:
                addCustomerFromInput(input, system);
                break;

            case 2:
                addRestaurantAdminFromInput(input, system);
                break;

            case 3:
                assignadminToRestaurantFromInput(input, system);
                break;

            case 4:
                addRestaurantFromInput(input, system);
                break;

            case 5:
                addRiderFromInput(input, system);
                break;

            case 6:
                assignRiderToOrderFromInput(input, system);
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid choice.");
			}
		}
		
	}	
	public static void restaurantAdminMenu(Scanner input, DeliverySystem system) {
		//handles restaurant admin menu
		String userName, password;
		boolean exitFlag = false;
		int adminChoice = -1;
		System.out.println("Please enter your userName:");
		userName = input.next();
		System.out.println("Please enter your password:");
		password = input.next();
		RestAdmin loggedAdmin = system.restAdminLogin(userName, password);
		while(loggedAdmin == null) {
			System.out.println("Login info is wrong please try again : ");
			System.out.println("Please enter your userName or 0 to go back:");
			userName = input.next();
			if(userName.equals("0")) {
				exitFlag = true;
				break; 
			}
			System.out.println("Please enter your password:");
			password = input.next();
			loggedAdmin = system.restAdminLogin(userName, password);
		}
		// if user asked to go back 
		if(exitFlag) {
			return; 
		}
		while(adminChoice != 0) {
			System.out.println("Welcome restaurant admin\nPlease choose action:\n"
					+ "1: Add customer\n2: Add order\n3: Add rider\n"
					+ "4: Assign rider to order\n0: go back");
			if(input.hasNextInt()) {
				adminChoice = input.nextInt();
			}
			else {
			    System.out.println("Invalid input");
			    input.next();
			    continue;
			}
			switch(adminChoice) {
            case 1:
                addCustomerFromInput(input, system);
                break;

            case 2:
            	addOrderFromInput(input, system, loggedAdmin);
                break;

            case 3:
            	addRiderFromInput(input, system);
                break;

            case 4:
            	assignRiderToOrderFromInput(input, system);
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid choice.");
			}
		}
	}
	public static void riderMenu(Scanner input, DeliverySystem system) {
		//handles rider menu
		String id;
		boolean exitFlag = false; 
		int riderChoice = -1;
		System.out.println("Please enter your id: ");
		id = input.next();
		Rider loggedRider = system.riderLogin(id);
		while(loggedRider == null) {
			System.out.println("Login info is wrong please try again : ");
			System.out.println("Please enter your id or 0 to go back:");
			id = input.next();
			if(id.equals("0")) {
				exitFlag = true;
				break; 
			}
			loggedRider = system.riderLogin(id);
		}
		// if user asked to go back 
		if(exitFlag) {
			return; 
		}
		while(riderChoice != 0) {
			System.out.println("Welcome rider\nPlease choose action: ");
			System.out.println("1: update order status to on the way"
					+ "\n2: update order status to delivered\n3: show all orders\n0: go back");
			if(input.hasNextInt()) {
				riderChoice = input.nextInt();
			}
			else {
			    System.out.println("Invalid input");
			    input.next();
			    continue;
			}
			switch(riderChoice) {
			case 1:
				updateOrderStatusToOnTheWay(input,system,loggedRider);
				break;
			case 2:
				updateOrderStatusToDelivered(input,system,loggedRider);
				break;
			case 3:
				printOrdersByRider(loggedRider);
				break;
			case 0:
                break;

            default:
                System.out.println("Invalid choice."); 
			}
		}
	}
	public static void customerMenu(Scanner input, DeliverySystem system) {
		//handles customer menu
		String customerCode;
		boolean exitFlag = false;
		int customerChoice = -1;
		System.out.println("Please enter your code: ");
		customerCode = input.next();
		Customer loggedCustomer = system.customerLogin(customerCode);
		while(loggedCustomer == null) {
			System.out.println("Login info is wrong please try again : ");
			System.out.println("Please enter your code or 0 to go back:");
			customerCode = input.next();
			if(customerCode.equals("0")) {
				exitFlag = true;
				break; 
			}
			loggedCustomer = system.customerLogin(customerCode);
		}
		// if user asked to go back 
		if(exitFlag) {
			return; 
		}
		while(customerChoice != 0) {
			System.out.println("Welcome customer\nPlease choose action: ");
			System.out.println("1: add new order\n2: show all orders\n3: show restaurant info by code"
					+ "\n4: update personal info\n0: go back");
			if(input.hasNextInt()) {
				customerChoice = input.nextInt();
			}
			else {
			    System.out.println("Invalid input");
			    input.next();
			    continue;
			}
			switch(customerChoice) {
			case 1:
				addOrderFromInputCustomer(input,system,loggedCustomer);
				break;
			case 2:
				printAllOrdersForCustomer(system,loggedCustomer);
				break;
			case 3:
				printRestaurantInfo(input,system);
				break;
			case 4:
			    updateCustomerInfoFromInput(input, system, loggedCustomer);
			    break;
			case 0:
                break;

            default:
                System.out.println("Invalid choice."); 
			}
		}
	}
//////////// helper methods//////////////////////////
	public static void addCustomerFromInput(Scanner input, DeliverySystem system) {
		// this method adds customer after validating users input 
		System.out.println("Please enter the customers info:");
		String code, firstName, familyName, city, street, zip;
		String phoneNum , mail;
		double refund;
		while(true) { //check code 
			System.out.println("Code: "); 
			code = input.next();
			if(!InputValidation.isNotEmpty(code)) {
				System.out.println("Invalid code, try again: ");
			}else if(system.findCustomerByCode(code) != null) {
				System.out.println("Code already exists.");
			}else {
				break;
			}
		}
		while(true) {//check first name
			System.out.println("First name: ");
			firstName = input.next();
			if(!InputValidation.isNotEmpty(firstName) || !InputValidation.isOnlyLetters(firstName)) {
				System.out.println("Invalid name, try again: ");
			}else {
				break;
			}
		}
		input.nextLine(); // clear leftover newline
		while(true) { //check family name
			System.out.println("Family name: ");
			familyName = input.nextLine();
			if(!InputValidation.isNotEmpty(familyName) || !InputValidation.isOnlyLettersAndSpaces(familyName)) {
				System.out.println("Invalid family name, try again: ");
			}else {
				break;
			}
		}
		while(true) {//check city
			System.out.println("City: ");
			city = input.nextLine();
			if(!InputValidation.isNotEmpty(city) || !InputValidation.isOnlyLettersAndSpaces(city)) {
				System.out.println("Invalid city, try again: ");
			}else {
				break;
			}
		}
		while(true) {//check street
			System.out.println("street:  ");
			street = input.nextLine();
			if(!InputValidation.isNotEmpty(street)) {
				System.out.println("Invalid street, try again: ");
			}else {
				break;
			}
		}
		while(true) { // check zip code 
			System.out.println("zip code:  ");
			zip = input.next();
			if(!InputValidation.isValidZipCode(zip)) {
				System.out.println("Invalid zip code, try again: ");
			}else {
				break;
			}
		}
		Address address = new Address(street,city,zip);
		
		while(true) { //check phone number 
			System.out.println("Phone number:  ");
			phoneNum = input.next();
			if(!InputValidation.isNotEmpty(phoneNum) || !InputValidation.isOnlyDigits(phoneNum) ||
				       phoneNum.length() != 10 || !phoneNum.startsWith("05")) {
				        System.out.println("Invalid phone number, try again.");
				    } else {
				        break;
				    }
		}
		while(true) { //check mail 
			System.out.println("Mail: ");
			mail = input.next();
			if(!InputValidation.isValidEmail(mail)) {
				System.out.println("Invalid mail, try again: ");
			}else {
				break; 
			}
		}
		while(true) {
			System.out.println("refund balance: ");

		    if(input.hasNextDouble()) {
		        refund = input.nextDouble();

		        if(refund >= 0) {
		            break;
		        } else {
		            System.out.println("Refund cannot be negative.");
		        }
		    } else {
		        System.out.println("Invalid refund balance.");
		        input.next();
		    }
		}
		
		Customer customer = new Customer(code, firstName, familyName,
					address,phoneNum,mail, refund); 
		if(system.addCustomer(customer)) {
			System.out.println("Customer added successfully\nCode: "+code);
			
		}else {
			System.out.println("Could not add customer");
		}
	}
	public static void addRestaurantAdminFromInput(Scanner input, DeliverySystem system) {
		// this method adds restaurant admin after validating users input
		System.out.println("Please enter the restaurant admin info:");
		String name, userName, password; 
		input.nextLine();
		while(true) { //check name 
			System.out.println("Name: "); 
			name = input.nextLine();
			if(!InputValidation.isNotEmpty(name) || !InputValidation.isOnlyLettersAndSpaces(name)) {
				System.out.println("Invalid name, try again: ");
			}else {
				break; 
			}
		}
		while(true) { //check userName 
			System.out.println("userName: "); 
			userName = input.next();
			if(!InputValidation.isNotEmpty(userName)) {
				System.out.println("Invalid userName, try again: ");
			}else if(system.findRestAdminByUserName(userName) != null) {
				System.out.println("userName already exists.");
			}else {
				break;
			}
		}
		while(true) { //check password
			System.out.println("password: "); 
			password = input.next();
			if(!InputValidation.isNotEmpty(password)) {
				System.out.println("Invalid password, try again: ");
			}else {
				break;
			}
		}
		RestAdmin restAdmin = new RestAdmin(name, userName, password, new Restaurant[10], 0);
		if(system.addRestAdmin(restAdmin)) {
		    System.out.println("Restaurant admin added successfully.");
		} else {
		    System.out.println("Could not add restaurant admin.");
		}
	}

	public static void addRestaurantFromInput(Scanner input, DeliverySystem system) {
		// this method adds restaurant after validating users input
		System.out.println("Please choose what kind of restaurant you would like to add:\n1: Regular restaurant\n2: Fast food restaurant\n3: Premium restaurant");
		int choice = -1; 
		String code, name, cuisine;
		double rating, baseDeliveryFee;
		boolean isOpen;
		while(choice != 1 && choice != 2 && choice != 3) {
			if(input.hasNextInt()) {
				choice = input.nextInt();
			} else {
				System.out.println("Invalid input");
				input.next();
			}
			if(choice != 1 && choice != 2 && choice != 3) {
				System.out.println("Please enter 1, 2, or 3.");
			}
		}
		System.out.println("Enter restaurant info:");
		while(true) { //check code 
			System.out.println("Code: ");
			code = input.next();
			if(!InputValidation.isNotEmpty(code)) {
				System.out.println("Invalid code, try again: ");
			}else if(system.findRestaurantByCode(code) != null) {
				System.out.println("Code already exists.");
			}else {
				break;
			}
		}
		input.nextLine();
		while(true) { //check mame
			System.out.println("Name: ");
			name = input.nextLine();
			if(!InputValidation.isNotEmpty(name) || !InputValidation.isOnlyLettersAndSpaces(name)) {
				System.out.println("Invalid name, try again: ");
			}else {
				break;
			}
		}
		while(true) { //check cuisine
			System.out.println("Cuisine: ");
			cuisine = input.nextLine();
			if(!InputValidation.isNotEmpty(cuisine) || !InputValidation.isOnlyLettersAndSpaces(cuisine)) {
				System.out.println("Invalid cuisine, try again: ");
			}else {
				break; 
			}
		}
		while(true) {//rating 
			System.out.println("Rating: ");
		    if(input.hasNextDouble()) {
		        rating = input.nextDouble();

		        if(rating >= 0) {
		            break;
		        } else {
		            System.out.println("Rating cannot be negative.");
		        }
		    } else {
		        System.out.println("Invalid rating.");
		        input.next();
		    }
		}
		while(true) {//check is it open 
			System.out.println("Is it open? Enter true or false: ");
			if(input.hasNextBoolean()) {
				isOpen = input.nextBoolean();
				break;
			}else {
				System.out.println("Invalid input.");
				input.next();
			}
		}
		while(true) {
			System.out.println("Base delivery fee: ");
			if(input.hasNextDouble()) {
				baseDeliveryFee = input.nextDouble();
				if(baseDeliveryFee >= 0) {
					break;
				}else {
					System.out.println("Delivery fee cannot be negative.");
				}
			}else {
				System.out.println("Invalid delivery fee.");
				input.next();
			}
		}
		Restaurant restaurant = null;
		if(choice == 1) {
			restaurant = new Restaurant(code, name, cuisine, rating, isOpen, baseDeliveryFee);
		}else if(choice == 2){
			int averagePrepTime;
			double fastDeliveryFee;
			while(true) {
				System.out.println("Average preparation time: ");
				if(input.hasNextInt()) {
					averagePrepTime = input.nextInt();
					if(averagePrepTime > 0) {
						break;
					}else {
						System.out.println("Preparation time must be positive.");
					}
				}else {
					System.out.println("Invalid preparation time.");
					input.next();
				}
			}

			while(true) {
				System.out.println("Fast delivery fee: ");
				if(input.hasNextDouble()) {
					fastDeliveryFee = input.nextDouble();
					if(fastDeliveryFee >= 0) {
						break;
					}else {
						System.out.println("Fast delivery fee cannot be negative.");
					}
				}else {
					System.out.println("Invalid fast delivery fee.");
					input.next();
				}
			}
			restaurant = new FastFoodRestaurant(code, name, cuisine, rating, isOpen,
					baseDeliveryFee, averagePrepTime, fastDeliveryFee);
		}
		else if(choice == 3) {
			double minOrderAmount, extraCommissionPercent;
			while(true) {
				System.out.println("Minimum order amount: ");
				if(input.hasNextDouble()) {
					minOrderAmount = input.nextDouble();
					if(minOrderAmount > 0) {
						break;
					}else {
						System.out.println("Minimum order must be positive.");
					}
				}else {
					System.out.println("Invalid minimum order amount.");
					input.next();
				}
			}

			while(true) {
				System.out.println("Extra commission percent: ");
				if(input.hasNextDouble()) {
					extraCommissionPercent = input.nextDouble();
					if(extraCommissionPercent > 0) {
						break;
					}else {
						System.out.println("Commission percent must be positive.");
					}
				}else {
					System.out.println("Invalid commission percent.");
					input.next();
				}
			}
			restaurant = new PremiumRestaurant(code, name, cuisine, rating, isOpen,
					baseDeliveryFee, minOrderAmount, extraCommissionPercent);
		}
		if(system.addRestaurant(restaurant)) {
			System.out.println("Restaurant added successfully. Code: " + code);
		}else {
			System.out.println("Could not add restaurant.");
		}
	}
	public static void addRiderFromInput(Scanner input, DeliverySystem system) {
		// this method adds rider after validating users input
		System.out.println("Please enter your driver info: ");
		String id, firstName, familyName, phoneNum, vehicle;
		while(true) {
			System.out.println("Id: ");
			id = input.next();

			if(!InputValidation.isValidId(id)) {
				System.out.println("Invalid id, try again.");
			}else if(system.findRiderById(id) != null) {
				System.out.println("Id already exists.");
			}else {
				break;
			}
		}
		while(true) {
			System.out.println("First name: ");
			firstName = input.next();

			if(!InputValidation.isNotEmpty(firstName) ||
					!InputValidation.isOnlyLetters(firstName)) {
				System.out.println("Invalid first name.");
			}else {
				break;
			}
		}

		input.nextLine();

		while(true) {
			System.out.println("Family name: ");
			familyName = input.nextLine();

			if(!InputValidation.isNotEmpty(familyName) ||
					!InputValidation.isOnlyLettersAndSpaces(familyName)) {
				System.out.println("Invalid family name.");
			}else {
				break;
			}
		}

		while(true) {
			System.out.println("Phone number: ");
			phoneNum = input.next();

			if(!InputValidation.isOnlyDigits(phoneNum) ||
					phoneNum.length() != 10 ||
					!phoneNum.startsWith("05")) {
				System.out.println("Invalid phone number.");
			}else {
				break;
			}
		}

		while(true) {
			System.out.println("Vehicle (car / bike / motorBike): ");
			vehicle = input.next();

			if(vehicle.equalsIgnoreCase("car") ||
					vehicle.equalsIgnoreCase("bike") ||
					vehicle.equalsIgnoreCase("motorBike")) {
				break;
			}else {
				System.out.println("Invalid vehicle type.");
			}
		}

		Rider rider = new Rider(id, firstName, familyName,
				phoneNum, vehicle, true, new Order[20], 0);

		if(system.addRider(rider)) {
			System.out.println("Rider added successfully.");
		}else {
			System.out.println("Could not add rider.");
		}
	}
	public static void addOrderFromInput(Scanner input, DeliverySystem system, RestAdmin loggedAdmin) {
		// this method adds order after validating users input
		System.out.println("Please enter order info: ");
		String orderCode, customerCode, restaurantCode ;
		int day, month, year; 
		double baseAmount; 
		while(true) {
			System.out.println("order code: ");
			orderCode = input.next();
			if(!InputValidation.isNotEmpty(orderCode) || !InputValidation.isOnlyDigits(orderCode)) {
				System.out.println("Invalid order code, try again: ");
			}else if(system.findOrderByCode(orderCode) != null) {
				System.out.println("order code already exists.");
			}
			else {
				break; 
			}
		}
		while(true) {
			System.out.println("customer code: ");
			customerCode = input.next();
			if(!InputValidation.isNotEmpty(customerCode) || !InputValidation.isOnlyDigits(customerCode)) {
				System.out.println("Invalid customer code, try again: ");
			}else if(system.findCustomerByCode(customerCode) == null) {
				System.out.println("customer doesnt exists.");
			}
			else {
				break; 
			}
		}
		while(true) {
			System.out.println("restaurant code: ");
			restaurantCode = input.next();
			if(!InputValidation.isNotEmpty(restaurantCode) || !InputValidation.isOnlyDigits(restaurantCode)) {
				System.out.println("Invalid restaurant code, try again: ");
			}else if(system.findRestaurantByCode(restaurantCode) == null) {
				System.out.println("restaurant doesnt exists.");
			}else if(!loggedAdmin.isResponsibleFor(restaurantCode)) {
				System.out.println("You are not responsible for this restaurant");
			}
			else {
				break; 
			}
		}
		System.out.println("Please enter the date of you order: ");
		MyDate orderDate;
		while(true) {
			System.out.println("day: ");
			if(!input.hasNextInt()) {
				System.out.println("Invalid day");
				input.next();
				continue;
			}
			day = input.nextInt();
			System.out.println("month: ");
			if(!input.hasNextInt()) {
				System.out.println("Invalid month");
				input.next();
				continue;
			}
			month = input.nextInt();
			System.out.println("year: ");
			if(!input.hasNextInt()) {
				System.out.println("Invalid year");
				input.next();
				continue;
			}
			year = input.nextInt();
			orderDate = new MyDate(day,month,year);
			if(orderDate.getDay() == day && orderDate.getMonth() == month 
					&& orderDate.getYear() == year) {
				break;
			}
			System.out.println("Invalid date, try again");	
		}
		while(true) {
			System.out.println("Base amount: ");
			if(input.hasNextDouble()) {
				baseAmount = input.nextDouble();
				if(baseAmount > 0) {
					break;
				}else {
					System.out.println("Base amount must be positive");
				}
			}else {
				System.out.println("Invalid base amount");
				input.next();
			}
		}
		Restaurant restaurant = system.findRestaurantByCode(restaurantCode);
		Order order = new Order(orderCode, customerCode, restaurant, restaurantCode,
				"000", orderDate, new MyDate(0,0,0), baseAmount, "sent");
		Customer customer = system.findCustomerByCode(customerCode);
		double finalPrice = order.getFinalPrice();
		if(customer.getRefundBalance() < finalPrice) {
			System.out.println("Not enough refund balance");
			return;
		}
		customer.setRefundBalance(customer.getRefundBalance() - finalPrice);
		if(system.addOrder(order)) {
			System.out.println("Order added successfully. Code: " + orderCode);
		}else {
			System.out.println("Could not add order");
		}
	}
	public static void addOrderFromInputCustomer(Scanner input,DeliverySystem system,Customer loggedCustomer) {
		// this method allows the customer to add a new order after validating input 
		System.out.println("Please enter order info: ");
		String orderCode, restaurantCode ;
		int day, month, year; 
		double baseAmount; 
		while(true) {
			System.out.println("order code: ");
			orderCode = input.next();
			if(!InputValidation.isNotEmpty(orderCode) || !InputValidation.isOnlyDigits(orderCode)) {
				System.out.println("Invalid order code, try again: ");
			}else if(system.findOrderByCode(orderCode) != null) {
				System.out.println("order code already exists.");
			}
			else {
				break; 
			}
		}
		while(true) {
			System.out.println("restaurant code: ");
			restaurantCode = input.next();
			if(!InputValidation.isNotEmpty(restaurantCode) || !InputValidation.isOnlyDigits(restaurantCode)) {
				System.out.println("Invalid restaurant code, try again: ");
			}else if(system.findRestaurantByCode(restaurantCode) == null) {
				System.out.println("restaurant doesnt exists.");
			}
			else {
				break; 
			}
		}
		System.out.println("Please enter the date of your order: ");
		MyDate orderDate;
		while(true) {
			System.out.println("day: ");
			if(!input.hasNextInt()) {
				System.out.println("Invalid day");
				input.next();
				continue;
			}
			day = input.nextInt();
			System.out.println("month: ");
			if(!input.hasNextInt()) {
				System.out.println("Invalid month");
				input.next();
				continue;
			}
			month = input.nextInt();
			System.out.println("year: ");
			if(!input.hasNextInt()) {
				System.out.println("Invalid year");
				input.next();
				continue;
			}
			year = input.nextInt();
			orderDate = new MyDate(day,month,year);
			if(orderDate.getDay() == day && orderDate.getMonth() == month 
					&& orderDate.getYear() == year) {
				break;
			}
			System.out.println("Invalid date, try again");	
		}
		while(true) {
			System.out.println("Base amount: ");
			if(input.hasNextDouble()) {
				baseAmount = input.nextDouble();
				if(baseAmount > 0) {
					break;
				}else {
					System.out.println("Base amount must be positive");
				}
			}else {
				System.out.println("Invalid base amount");
				input.next();
			}
		}
		Restaurant restaurant = system.findRestaurantByCode(restaurantCode);
		Order order = new Order(orderCode, loggedCustomer.getCustomerCode(), restaurant, restaurantCode,
				"000", orderDate, new MyDate(0,0,0), baseAmount, "sent");
		double finalPrice = order.getFinalPrice();
		if(loggedCustomer.getRefundBalance() < finalPrice) {
			System.out.println("Not enough refund balance");
			return; 
		}
		loggedCustomer.setRefundBalance(loggedCustomer.getRefundBalance() - finalPrice);
		if(system.addOrder(order)) {
			System.out.println("Order added successfully. Code: " + orderCode);
		}else {
			System.out.println("Could not add order.");
		}
		
	}
	public static void assignadminToRestaurantFromInput(Scanner input, DeliverySystem system) {
		//this method assigns an admin to an existing restaurant 
		System.out.println("Please enter restaurant admin userName: ");
		String userName;
		userName = input.next();
		while(system.findRestAdminByUserName(userName) == null ) {
			System.out.println("No restaurant admin with the userName you entered exists");
			System.out.println("Please enter restaurant admin userName: ");
			userName = input.next();
		}
		System.out.println("Please enter restaurant code: ");
		String restaurantCode; 
		restaurantCode = input.next();
		while(system.findRestaurantByCode(restaurantCode) == null ) {
			System.out.println("No restaurant with code you entered exists");
			System.out.println("Please enter restaurant Code: ");
			restaurantCode = input.next();
		}
		system.assignRestAdminToRestaurant(userName, restaurantCode);
		System.out.println("Restaurant assigned successfully.");
	}
	public static void assignRiderToOrderFromInput(Scanner input, DeliverySystem system) {
		//this method assigns a rider to an existing order
		System.out.println("Please enter rider id:");
		String riderId = input.next();
		while(system.findRiderById(riderId) == null ||
				!system.findRiderById(riderId).isAvailable()) {
			System.out.println("Rider does not exist or is not available.");
			System.out.println("Please enter rider id:");
			riderId = input.next();
		}

		System.out.println("Please enter order code:");
		String orderCode = input.next();

		while(system.findOrderByCode(orderCode) == null) {
			System.out.println("Order does not exist.");
			System.out.println("Please enter order code:");
			orderCode = input.next();
		}

		if(system.assignRiderToOrder(riderId, orderCode)) {
			System.out.println("Rider assigned successfully.");
		}else {
			System.out.println("Could not assign rider to order.");
		}
	}
	public static void updateOrderStatusToOnTheWay(Scanner input,DeliverySystem system,Rider loggedRider) {
		//this method updates order status to "on the way"
		String orderCode ;
		Order order;
		while(true) {
			System.out.println("Order code: ");
			orderCode = input.next();
			order = system.findOrderByCode(orderCode);
			if(!InputValidation.isNotEmpty(orderCode) || !InputValidation.isOnlyDigits(orderCode)) {
				System.out.println("Invalid order code, try again: ");
			}else if(order == null) {
				System.out.println("order doesnt exists.");
			}else if(!order.getRiderCode().equals(loggedRider.getRiderId())) {
				System.out.println("This order is not assigned to you.");
			}
			else {
				break; 
			}
		}
		if(system.markOrderOnTheWay(orderCode)) {
			System.out.println("Order status changed successfully. Order code: " + orderCode);
		}else {
			System.out.println("Could not update order status.");
		}
	}
	public static void printOrdersByRider(Rider loggedRider) {
		//this method prints all the orders that belong to the rider
		Order[] orders = loggedRider.getOrders();
		for (int i = 0; i < orders.length; i++) {
			if(orders[i] != null) {
				System.out.println("order: "+orders[i]);
			}
		}
	}
	public static void printAllOrdersForCustomer(DeliverySystem system,Customer loggedCustomer) {
		//this method print all the orders that the customer have
		String code = loggedCustomer.getCustomerCode();
		Order[] orders = system.getOrders();
		for (int i = 0; i < orders.length; i++) {
			if(orders[i] != null && orders[i].getCustomerCode().equals(code)) {
				System.out.println("order: "+orders[i]);
			}
		}
	}
	public static void printRestaurantInfo(Scanner input,DeliverySystem system) {
		//this method prints the restaurant info
		String restaurantCode;
		Restaurant restaurant = null;
		while(true) {
			System.out.println("enter restaurant code: ");
			restaurantCode = input.next();
			restaurant = system.findRestaurantByCode(restaurantCode);
			if(!InputValidation.isNotEmpty(restaurantCode) || !InputValidation.isOnlyDigits(restaurantCode)) {
				System.out.println("Invalid restaurant code, try again: ");
			}else if(restaurant == null) {
				System.out.println("restaurant doesnt exists.");
			}
			else {
				break; 
			}	
		}
		System.out.println("restuarant info: "+ restaurant);
	}
	public static void updateOrderStatusToDelivered(Scanner input,DeliverySystem system,Rider loggedRider) {
		//this method updates order status to "delivered" and validates the delivery date
		String orderCode;
		Order order;
		int day,month,year; 
		while(true) {
			System.out.println("Order code: ");
			orderCode = input.next();
			order = system.findOrderByCode(orderCode);
			if(!InputValidation.isNotEmpty(orderCode) || !InputValidation.isOnlyDigits(orderCode)) {
				System.out.println("Invalid order code, try again: ");
			}else if(order == null) {
				System.out.println("order doesnt exists.");
			}else if(!order.getRiderCode().equals(loggedRider.getRiderId())) {
				System.out.println("This order is not assigned to you.");
			}
			else {
				break; 
			}
		}
		System.out.println("Please enter the date of your order: ");
		MyDate deliveryDate;
		while(true) {
			System.out.println("day: ");
			if(!input.hasNextInt()) {
				System.out.println("Invalid day");
				input.next();
				continue;
			}
			day = input.nextInt();
			System.out.println("month: ");
			if(!input.hasNextInt()) {
				System.out.println("Invalid month");
				input.next();
				continue;
			}
			month = input.nextInt();
			System.out.println("year: ");
			if(!input.hasNextInt()) {
				System.out.println("Invalid year");
				input.next();
				continue;
			}
			year = input.nextInt();
			deliveryDate = new MyDate(day,month,year);
			if(deliveryDate.getDay() == day && deliveryDate.getMonth() == month 
					&& deliveryDate.getYear() == year) {
				break;
			}
			System.out.println("Invalid date, try again");	
		}
		if(system.markOrderDelivered(orderCode,deliveryDate)) {
			System.out.println("Order status changed successfully. Order code: " + orderCode);
		}else {
			System.out.println("Could not update order status.");
		}
	}
	public static void updateCustomerInfoFromInput(Scanner input, DeliverySystem system, Customer loggedCustomer) {
		//this method allowes the customer to update its own address and phone number 
		int customerChoice = -1;
		while(customerChoice != 0) {
			System.out.println("Please choose what you would like to update:"
					+ "\n1: Adress\n2: Phone number\n0: go back");
			if(input.hasNextInt()) {
				customerChoice = input.nextInt();
			}
			else {
			    System.out.println("Invalid input");
			    input.next();
			    continue;
			}
			switch(customerChoice) {
			case 1:
				updateCustomerAddress(input,system,loggedCustomer);
				break;
			case 2:
				updateCustomerPhone(input,system,loggedCustomer);
				break;
			case 0:
				break;
			default:
	            System.out.println("Invalid choice."); 
	        }
		}
	}
	public static void updateCustomerAddress(Scanner input,DeliverySystem system,Customer loggedCustomer) {
		//this method is a helper for "updateCustomerInfoFromInput" to update the address
		String city, street,zip; 
		System.out.println("Please enter the new address: ");
		input.nextLine();
		while(true) {//check city
			System.out.println("City: ");
			city = input.nextLine();
			if(!InputValidation.isNotEmpty(city) || !InputValidation.isOnlyLettersAndSpaces(city)) {
				System.out.println("Invalid city, try again: ");
			}else {
				break;
			}
		}
		while(true) {//check street
			System.out.println("street:  ");
			street = input.nextLine();
			if(!InputValidation.isNotEmpty(street)) {
				System.out.println("Invalid street, try again: ");
			}else {
				break;
			}
		}
		while(true) { // check zip code 
			System.out.println("zip code:  ");
			zip = input.next();
			if(!InputValidation.isValidZipCode(zip)) {
				System.out.println("Invalid zip code, try again: ");
			}else {
				break;
			}
		}
		Address address = new Address(street,city,zip);
		loggedCustomer.setAddress(address);
		System.out.println("Address updated successfully: ");
	}
	public static void updateCustomerPhone(Scanner input,DeliverySystem system,Customer loggedCustomer) {
		//this method is a helper for "updateCustomerInfoFromInput" to update the phone number
		String phoneNumber;
		while(true) {
			System.out.println("Enter phone number:");
			phoneNumber = input.next();
			if(!InputValidation.isNotEmpty(phoneNumber) || !InputValidation.isOnlyDigits(phoneNumber)) {
				System.out.println("Invalid phone number, try again: ");
				}else {
					if(loggedCustomer.setCustomerPhone(phoneNumber)) {
						System.out.println("Phone number updated successfully");
						break;
				}else {
					System.out.println("Invalid phone number, try again: ");
				}
			}
		}
	}
	
}
