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
@EqualsAndHashCode(callSuper=false)
@Table(name = "POSITION")
@Dataset(name="gds_basesalary")
public class BaseSalaryTO extends BaseTO {
	
	@Id
	@Column(nullable=false)
	private String positionCode; 
	private String position;
	private String baseSalary; 
	private String hobongRatio;
	
}
