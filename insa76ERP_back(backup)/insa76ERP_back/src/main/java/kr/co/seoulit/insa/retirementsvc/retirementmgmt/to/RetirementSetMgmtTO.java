package kr.co.seoulit.insa.retirementsvc.retirementmgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Dataset(name="gds_retirementSetMgmt")
@Data
@EqualsAndHashCode(callSuper = false)
public class RetirementSetMgmtTO extends BaseTO {
    private String moelCheck, moelCheckCode, retirementRange, retirementRangeCode, monthOrDay, monthOrDayCode, retiredayCheck, retiredayCheckCode;
}