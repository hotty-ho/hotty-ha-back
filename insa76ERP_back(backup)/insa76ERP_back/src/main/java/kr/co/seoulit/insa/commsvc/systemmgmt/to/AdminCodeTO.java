package kr.co.seoulit.insa.commsvc.systemmgmt.to;

import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Dataset(name="ds_admin")
@EqualsAndHashCode(callSuper=false)
public class AdminCodeTO extends BaseTO{
	
	String admin_code , admin_authority, authority;

}
