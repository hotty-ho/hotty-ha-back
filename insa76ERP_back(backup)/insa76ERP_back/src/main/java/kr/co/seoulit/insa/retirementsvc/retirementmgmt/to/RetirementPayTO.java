package kr.co.seoulit.insa.retirementsvc.retirementmgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Dataset(name="out_retirementpay")
@Data
@EqualsAndHashCode(callSuper=false)
public class RetirementPayTO extends BaseTO {
    private String empName, retirementPay,retirementRange, hiredate, retiredate, retirementBonus, retirementAwards;
}