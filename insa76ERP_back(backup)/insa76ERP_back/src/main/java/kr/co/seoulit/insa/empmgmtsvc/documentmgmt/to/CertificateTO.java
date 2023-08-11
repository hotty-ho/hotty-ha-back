package kr.co.seoulit.insa.empmgmtsvc.documentmgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name="ds_CertificateBean")
public class CertificateTO extends BaseTO {

	private String empCode, empName, deptName, requestDate, useDate, usageCode,
	usageName, etc, approvalStatus, rejectCause, status;
}
