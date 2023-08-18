package kr.co.seoulit.insa.attdsvc.attdmgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Dataset(name="gds_restAttd")
@EqualsAndHashCode(callSuper=false)
public class RestAttdTO extends BaseTO{
	
	private String empCode, empName, restAttdCode, restTypeCode
	,restTypeName, requestDate, startDate
	,endDate, numberOfDays, cost, cause
	,applovalStatus, rejectCause, startTime, endTime;
}
