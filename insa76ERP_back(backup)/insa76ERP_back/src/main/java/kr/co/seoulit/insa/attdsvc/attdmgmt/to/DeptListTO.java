package kr.co.seoulit.insa.attdsvc.attdmgmt.to;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "DEPT")
@EqualsAndHashCode(callSuper=false)
@Dataset(name="gds_deptlist")
public class DeptListTO extends BaseTO{

    @Id
    private String deptCode;

    private String deptName;

    private String deptTel;
}