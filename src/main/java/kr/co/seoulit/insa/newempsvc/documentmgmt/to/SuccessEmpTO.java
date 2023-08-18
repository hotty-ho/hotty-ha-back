package kr.co.seoulit.insa.newempsvc.documentmgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Dataset(name="ds_newempSuccess")
@Data
@EqualsAndHashCode(callSuper=false)
public class SuccessEmpTO extends BaseTO {
    private double personality_avg, interview_avg;
    private String code, name;
    private int age;
    private String dept, gender, last_school, tel, address, career, email;
}
