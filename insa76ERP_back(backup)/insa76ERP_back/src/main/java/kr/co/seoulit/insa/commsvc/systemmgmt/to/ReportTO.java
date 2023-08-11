package kr.co.seoulit.insa.commsvc.systemmgmt.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ReportTO {
	
   private String empName, hiredate, occupation, employmentType, position,
   				  address, detailAddress, deptName;

}