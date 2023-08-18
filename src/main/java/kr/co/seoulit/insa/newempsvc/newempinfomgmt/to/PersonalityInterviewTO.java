package kr.co.seoulit.insa.newempsvc.newempinfomgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Dataset(name="out_personalityInterview")
@Data
@EqualsAndHashCode(callSuper=false)
public class PersonalityInterviewTO extends BaseTO
{
	private String p_code, p_name;
	private int p_age, p_challenge, p_creativity, p_passion, p_cooperation, p_globalmind,
				i_attitude, i_scrupulosity, i_reliability, i_creativity, i_positiveness;
}
