package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Dataset(name="gds_appointmentinfo")
@EqualsAndHashCode(callSuper=false)
public class EmpAppointmentInfoTO extends BaseTO {
	
	private String hosu,appointmentDate,appointmentDetail,appointmentCount,title,appointmentType,approvalStatus;

}
