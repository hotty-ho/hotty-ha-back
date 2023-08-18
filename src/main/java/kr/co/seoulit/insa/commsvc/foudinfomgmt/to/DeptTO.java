package kr.co.seoulit.insa.commsvc.foudinfomgmt.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name="DEPT")
@Dataset(name="ds_deptList")
@EqualsAndHashCode(callSuper=false)
public class DeptTO extends BaseTO {

	@Id
	String deptCode;
	String deptName;
	String deptTel;

}
