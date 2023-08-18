package kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "BASE_EXT_SAL")
@Dataset(name="ds_baseExtSal")
@EqualsAndHashCode(callSuper=false)
public class BaseExtSalTO  extends BaseTO{
	
	@Id
	@Column(nullable=false)
	private String extSalCode;
	private String extSalName;
	private String ratio;

}
