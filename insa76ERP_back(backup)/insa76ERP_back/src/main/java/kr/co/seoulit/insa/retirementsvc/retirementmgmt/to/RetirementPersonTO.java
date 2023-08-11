package kr.co.seoulit.insa.retirementsvc.retirementmgmt.to;


import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Dataset(name="out_retPerson")
@Data
@EqualsAndHashCode(callSuper=false)
public class RetirementPersonTO {
    private String  empCode, empName, deptName, retirementDate, workplaceName;
}
