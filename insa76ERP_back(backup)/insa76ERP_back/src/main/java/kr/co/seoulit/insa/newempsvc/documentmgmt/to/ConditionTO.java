package kr.co.seoulit.insa.newempsvc.documentmgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name="gds_condition")
public class ConditionTO extends BaseTO {
	private int min_age;
	private int max_age;
	private String dept;
	private String last_school;
	private String half;
	private int year;
	private String hwp_file;
	private String career;
	private String workplaceCode;
}
