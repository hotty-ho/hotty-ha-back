package kr.co.seoulit.insa.attdsvc.attdmgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name="gds_dayAttd")
public class DayAttdTO extends BaseTO{
	
	private String empCode, empName, dayAttdCode, applyDay
	,attdTypeCode ,attdTypeName, time; 
}