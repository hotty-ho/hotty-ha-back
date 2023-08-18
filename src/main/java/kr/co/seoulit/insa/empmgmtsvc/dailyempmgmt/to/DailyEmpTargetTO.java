package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Dataset(name="ds_dayPayTarget")
@Data
@EqualsAndHashCode(callSuper=false)
public class DailyEmpTargetTO extends BaseTO {
    private String
            workplaceCode,
            dempCode,
            dempName,
            joinDate,
            isForeign,
            juminNo,
            foreignNo,
            zipCode,
            addr,
            addrDetail,
            email,
            tel,
            phone,
            deptCode,
            pjtCode,
            posCode,
            empStatCode,
            jobCode,
            payStatCode,
            transAcCode,
            accountNo,
            depositor,
            salary,
            hourPrice,
            retireDate,
            isTaxfree,
            isEmpinsurance,
            isNationalannuity,
            isHealthinsurance,
            nationallityCode,
            stayStat,
            empinsuranceStatCode,
            chJobCode,
            memo,
            insImpose,
            insImposeReason,
            isStableFund,
            checked,
            payCode,
            payDate,
            payStartdate,
            payEnddate,
            payType,
            payDescription;
}
