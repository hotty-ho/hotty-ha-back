package kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PayDayTO {
	
	private String
	ord,
	payment_date,
	smltn_issue,
	salary_type,
	remarks;

}
