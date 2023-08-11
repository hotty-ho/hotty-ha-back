package kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Dataset(name="gds_socialIns")
@EqualsAndHashCode(callSuper=false)
public class SocialInsTO extends BaseTO{
	
	private String
	attributionYear,
	healthinsureRates,
	longtermcareRates,
	nationpenisionRates,
	teachpenisionRates,
	empinsureRates,
	wrkinsureRates,
	jobstabilRates,
	vocacompetencyRates,
	industinsureRates,
	industinsurecharRates;

}