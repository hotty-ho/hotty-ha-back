package kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to;


import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Dataset(name="retirement_salary")
@EqualsAndHashCode(callSuper=false)
public class RetirementSalaryTO extends BaseTO {
	
	private String position; 
	private String empName;
	private String empCode; 
	private String hiredate; 
	private String calculateDate; 
	private String workingDate;
	private String retirementSalary;

}
