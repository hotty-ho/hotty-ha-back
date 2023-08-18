package kr.co.seoulit.insa.newempsvc.documentmgmt.to;


import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Dataset(name="ds_newempRecruit")
@Data
@EqualsAndHashCode(callSuper=false)
public class RecruitmentTO extends BaseTO //신규사원등록
{
	private String pcode, pname, gender, tel, address, email, lastschool, dept, approvalStatus, chk;
	private int age;
	private double p_avg, i_avg;
}
