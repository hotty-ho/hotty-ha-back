package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Dataset(name="ds_familyInfo")
@EqualsAndHashCode(callSuper=false)
public class FamilyInfoTO extends BaseTO{
	
	private String empCode,familyCode,familyName,relation,birthdate,liveTogether;

}
