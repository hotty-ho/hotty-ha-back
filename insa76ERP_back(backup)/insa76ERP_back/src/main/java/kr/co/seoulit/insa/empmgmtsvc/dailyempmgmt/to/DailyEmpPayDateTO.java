package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to;


import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Dataset(name="ds_dailyEmpPayDate")
@Data
@EqualsAndHashCode(callSuper=false)
public class DailyEmpPayDateTO extends BaseTO {

    private String
            payCode,
            payDate,
            payStartdate,
            payEnddate,
            payType,
            payDescription;

}
