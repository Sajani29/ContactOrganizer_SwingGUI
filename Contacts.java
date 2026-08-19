class Contacts{
	private String contactId;
	private String name;
	private String phoneNumber;
	private String companyName;
	private Double salary;
	private String dOb;
	
	Contacts(){}
	
	
	Contacts(String contactId,String name,String phoneNumber,String companyName,double salary,String dOb){
		setContactId(contactId);
		setContactName(name);
		setContactPhoneNumber(phoneNumber);
		setCompanyName(companyName);
		setSalaryAmount(salary);
		setDOb(dOb);
	}
	public void setContactId(String contactId){
		this.contactId = contactId;
	}
	public  void setContactName(String name){
		this.name = name;
	}
	public  void setContactPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	public  void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	public  void setSalaryAmount(double salary){
		this.salary = salary;
	}
	public  void setDOb(String dOb){
		this.dOb = dOb;
	}
	public  String getContactId(){
		return contactId;
	}
	public  String getContactName(){
		return name;
	}
	public String getContactPhoneNumber(){
		return phoneNumber;
	}
	public String getCompanyName(){
		return companyName;
	}
	public  double getSalaryAmount(){
		return salary;
	}
	public String getDoB(){
		return dOb;
	}	
}
