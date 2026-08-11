class ContactManager{
	static Contacts[] contactArray = new Contacts[0];
	static int id = 1;
	
	public static String generateId(int id){
		String generatedId = String.format("C%04d",id);
		return generatedId;
	}
		
	//check birthday
	public static boolean isValidBirthday(String dOb){
		LocalDate localdate = LocalDate.parse(dOb);
		int birthyear = localdate.getYear();
		int birthmonth = localdate.getMonthValue();
		int birthdate = localdate.getDayOfMonth();
			
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
			
			
		if(birthyear > 1926 && birthyear < currentYear && 12> birthmonth && birthmonth > 0 && birthdate >0 &&  birthdate <30){
			return true;
		}else{
			return false;
		}
	}
	
	//check salary
	public static boolean isValidsalary(double salary){
		if (salary > 0)
		{
			return true;
		}
			return false;
		}
			
	//check phone number
	public static boolean isValidPhonenumber(String number){
		if (number.startsWith("0") && number.length() == 10)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//extend array
	public static void extendArrays(String contactId, String name, String phoneNumber,String companyName,double salary,String dOb){
		Contacts[] tempContactArray = new Contacts[contactArray.length +1];
			for (int i = 0; i < contactArray.length; i++)
			{
				tempContactArray[i] = contactArray[i];
			}
				
				contactArray = tempContactArray;
				contactArray[contactArray.length -1] = new Contacts(contactId,name,phoneNumber,companyName,salary,dOb);
			}
			
			
	//CHECK PHONE NUMBER AND NAME 
	public static int searchNameorPhoneNo(String inputValue){
		for (int i = 0; i < contactArray.length; i++)
		{
			if (inputValue.equals(contactArray[i].getContactName()) || inputValue.equals(contactArray[i].getContactPhoneNumber()))
			{
				return i;
			}
			
		}
		return -1;
		
	}
	
	//UPDATE SALARY
	public static void updateSalary(int index){
		//Scanner input = new Scanner(System.in);
		/*System.out.println("Update Salary");
		System.out.println("===============");
		System.out.println();
		System.out.print("Input new salary - "); */
		int newSalary = input.nextInt();
		if (!isValidsalary(newSalary))
		{
			System.out.println("Salary should positive .. try again..");
		}
		contactArray[index].setSalaryAmount(newSalary);
		//System.out.println();
		//System.out.println("\t Contact has been update successfully... ");
		//System.out.println();
		//System.out.print("Do you want to update another Contact(Y/N): ");
		char yORn = input.next().charAt(0);
		if (yORn == 'Y' ||yORn == 'y' )
		{
			updateContacts();
		}if (yORn == 'N' ||yORn == 'n')
		{
			main(null);
		}
	}
	//UPDATE COMPANY NAME 
	public static void updateCompanyName(int index){
		//Scanner input = new Scanner(System.in);
		/*System.out.println("Update Company Name ");
		System.out.println("===============");
		System.out.println();
		System.out.print("Input new name - ");*/
		String newCompanyName = input.next();
		contactArray[index].setCompanyName(newCompanyName);
		//System.out.println();
		//System.out.println("\t Contact has been update successfully... ");
		//System.out.println();
		//System.out.print("Do you want to update another Contact(Y/N): ");
		char yORn = input.next().charAt(0);
			if (yORn == 'Y' ||yORn == 'y' )
			{
				updateContacts();
			}if (yORn == 'N' ||yORn == 'n')
			{
				main(null);
			}
	}
	//UPDATE PHONE NUMBER
	public static void updatephoneNo(int index){
		//Scanner input = new Scanner(System.in);
		/*System.out.println("Update Phone Number");
		System.out.println("===============");
		System.out.println();*/
		L5:while (true)
		{
			//System.out.print("Input new new phone number - ");
			String newPhoneNo = input.next();
			if (!isValidPhonenumber(newPhoneNo))
			{
				//System.out.println("Invalid phone number.. try again..");
				continue L5;
			}else
			{
				contactArray[index].setContactPhoneNumber(newPhoneNo);
				System.out.println();
				//System.out.println("\t Contact has been update successfully... ");
				//System.out.println();
				//System.out.print("Do you want to update another Contact(Y/N): ");
				char yORn = input.next().charAt(0);
				if (yORn == 'Y' ||yORn == 'y' )
				{
					updateContacts();
				}if (yORn == 'N' ||yORn == 'n')
				{
					main(null);
				}
			}
		}
	}
	//UPDATE NAME
	public static void updateName(int index){
		//Scanner input = new Scanner(System.in);
		/*System.out.println("Update Name");
		System.out.println("===============");
		System.out.println();
		System.out.print("Input new name - ");*/
		String newName = input.next();
		contactArray[index].setContactName(newName);
		//System.out.println();
		//System.out.println("\t Contact has been update successfully... ");
		//System.out.println();
		//System.out.print("Do you want to update another Contact(Y/N): ");
		char yORn = input.next().charAt(0);
			if (yORn == 'Y' ||yORn == 'y' )
			{
				updateContacts();
			}if (yORn == 'N' ||yORn == 'n')
			{
				main(null);
			}
	}
	
	//REDUCE ARRAY
	public static void reduceArrays(int index){
		Contacts[] temporaryArray = new Contacts[contactArray.length -1];
		for (int i = index; i < contactArray.length-1; i++)
		{
			contactArray[i] = contactArray[i+1];
		}
		
		contactArray = temporaryArray;
		
	}
	
	//SORT BY NAME
	public static void sortingByName(){
	//Scanner input=new Scanner(System.in);
		
		for(int j=contactArray.length-1 ;j > 0;j--){
			for (int i = 0; i < j; i++){
				if(contactArray[i].getContactName().charAt(0) > contactArray[(i+1)].getContactName().charAt(0)){
					Contacts temp = contactArray[i];
					contactArray[i] = contactArray[i+1];
					contactArray[i+1] = temp;	
				}
			}
		}
	}
	//SORT BY SALARY
	public static void sortingBySalary(){
		//Scanner input = new Scanner(System.in);
		for (int j = contactArray.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (contactArray[i].getSalaryAmount() < contactArray[i + 1].getSalaryAmount()) {
					Contacts temp = contactArray[i];
					contactArray[i] = contactArray[i + 1];
					contactArray[i + 1] = temp;
				}
			}
		}
	}
	//SORT BY BIRTHDAY
	public static void sortingByBirthday(){
		for (int j = contactArray.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (contactArray[i].getDoB().compareTo(contactArray[i + 1].getDoB()) > 0) {
					Contacts temp = contactArray[i];
					contactArray[i] = contactArray[i + 1];
					contactArray[i + 1] = temp;
				}
			}
		}
	}
	
	
}
