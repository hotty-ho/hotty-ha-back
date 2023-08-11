package kr.co.seoulit.insa.newempsvc.documentmgmt.to;


import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Dataset(name="back_eduPlan")
@EqualsAndHashCode(callSuper=false)
public class EduPlanTO extends BaseTO {
    private String EDU_DATE;
    private String EDU_NAME;
    private String EDU_CONTENT;
    private String EDU_HOST;
    private String EDU_PLACE;
}
