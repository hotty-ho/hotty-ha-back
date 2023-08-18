package kr.co.seoulit.insa.attdsvc.attdmgmt.to;


import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Dataset(name="gds_emplist")
public class EmpListTO {

    private String empCode;
    private String empName;
}
