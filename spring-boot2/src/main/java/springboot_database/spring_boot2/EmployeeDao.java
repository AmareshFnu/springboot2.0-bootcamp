package springboot_database.spring_boot2;

public class EmployeeDao {

	private String empName;
	private String empID;
	private String empSal;
	private final static String companyName = "ExilantTechnology";

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpSal() {
		return empSal;
	}

	public void setEmpSal(String empSal) {
		this.empSal = empSal;
	}

	public static String getCompanyname() {
		return companyName;
	}

}
