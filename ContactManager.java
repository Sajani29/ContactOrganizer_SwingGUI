import java.time.*;
import java.time.format.DateTimeParseException;
class ContactManager{
	static Contacts[] contactArray = new Contacts[0];
	static int id = 1;
	
	ContactManager(){}
		
		 public static String generateId(int id){
			String generatedId = String.format("C%04d",id);
			return generatedId;
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
	
		//Addcontact
		public static void addContact(String name,String phoneNo,String ComName,double salary,String dOb){
			extendArrays(generateId(id),name,phoneNo,ComName,salary,dOb);
			id++;
			
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
	
	//check salary
	public static boolean isValidsalary(double salary){
		if (salary > 0)
		{
			return true;
		}
			return false;
	}
	
	//check birthday
	public static boolean isValidBirthday(String dOb) {
    try {
        LocalDate localdate = LocalDate.parse(dOb);

        LocalDate currentDate = LocalDate.now();

        if (localdate.getYear() > 1926 &&
            !localdate.isAfter(currentDate)) {

            return true;

        } else {
            return false;
        }

    } catch (DateTimeParseException e) {
        return false;
    }
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
	
	// REDUCE ARRAY
		public static void reduceArrays(int index) {

			if (contactArray.length == 0) {
				return;
			}

			Contacts[] temporaryArray = new Contacts[contactArray.length - 1];

			for (int i = 0, j = 0; i < contactArray.length; i++) {

				if (i == index) {
					continue;
				}

				temporaryArray[j] = contactArray[i];
				j++;
			}

			contactArray = temporaryArray;
		}
			
}	

	
	/*
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
		*/
		
		
	
	

