package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Dataset(name="gds_appointmenttype")
@EqualsAndHashCode(callSuper=false)
public class EmpAppointmentTypeTO extends BaseTO {
	
	private String empCode,hosu,lastDept,nextDept,appointmentDate,dispatchDate,dispatchReturnDate,dispatchPosition,lastWorkplace,lastRegion,
					lastHobong,nextHobong,promotionDate,lastPosition,nextPosition,retirementDate,leaveDate,reinstatementDate,leaveType,empName;

}
