package kr.co.seoulit.insa.commsvc.systemmgmt.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ReportSalaryTO {
	
	private String empName, position, deptName, hiredate, applyYearMonth, totalExtSal,
				   totalDeduction, totalPayment, realSalary, salary, cost, healthIns,
				   goyongIns, janggiIns, gukmin;
}
