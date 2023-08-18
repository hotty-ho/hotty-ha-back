package kr.co.seoulit.insa.newempsvc.newempinfomgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name="ds_resume")
public class NewResumeTO extends BaseTO {
	private String workplace, p_code, p_name, p_gender, p_address, p_tel, p_dept, p_last_school, p_career, half, p_email;
	private int p_age, year;
}
