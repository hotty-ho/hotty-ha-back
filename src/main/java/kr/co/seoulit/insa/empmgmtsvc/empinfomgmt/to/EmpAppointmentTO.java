package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to;

import java.util.ArrayList;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Dataset(name="gds_appointment")
@EqualsAndHashCode(callSuper=false)
public class EmpAppointmentTO extends BaseTO {
	
	private String empCode,hosu,deptChangeStatus,positionChangeStatus,hobongChangeStatus,
	retirementStatus,dispatchStatus,leaveStatus,requestDate,approvalStatus;
}
