package kr.co.seoulit.insa.attdsvc.attdappvl.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name="ds_dayAttenMng")
public class DayAttdMgtTO extends BaseTO{
	
	private String empCode, empName, applyDays ,dayAttdCode, workplaceCode
	,dayAttdName ,attendTime,HalfHolidayStatus
	,quitTime ,lateWhether ,leaveHour ,workHour,earlyLeaveHour
	,overWorkHour ,nightWorkHour ,finalizeStatus, privateleaveHour, publicleaveHour;
}