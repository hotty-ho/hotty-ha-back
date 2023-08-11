package kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "FULLTIME_EMPLOYEE_SALARY")
@Dataset(name="fulltime_employee_salary")
@EqualsAndHashCode(callSuper=false)
public class FullTimeSalTO extends BaseTO {
	
	@Id
	private String empCode;
	private String applyYearMonth;
	private String basicSalary;
	private String positionSalary;
	private String familySalary;
	private String foodSalary;
	private String overWorkSalary;
	private String nationalPension;
	private String healthInsurance;
	private String longTermInsurance;
	private String employmentInsurance;
	private String religionDonation;
	private String incomeTax;
	private String residentTax;
	private String finalizeStatus;
	private String basicSalBefore;
	
}
	