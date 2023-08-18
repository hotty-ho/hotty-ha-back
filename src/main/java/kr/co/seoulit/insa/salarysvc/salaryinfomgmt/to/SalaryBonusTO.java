package kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to;

import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Dataset(name="salary_bonus")
@EqualsAndHashCode(callSuper=false)
public class SalaryBonusTO {
	
	
	private String empCode;
	private String empName;
	private String deptCode;
	private String position;
	private String baseSalary;
	private String awardsSalary;
	private String grade;
	
}
