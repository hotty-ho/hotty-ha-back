package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@Table(name = "EMP_EVAL")
@Dataset(name="LICENSEINFO")
@EqualsAndHashCode(callSuper=false)
public class LicenseInfoTO extends BaseTO {
	

	private String empCode;
	private String licenseCode;
	private String licenseName;
	private String getDate;
	private String expireDate;
	private String licenseLevel;
	private String licenseCenter;
	private String issueNumber;

}