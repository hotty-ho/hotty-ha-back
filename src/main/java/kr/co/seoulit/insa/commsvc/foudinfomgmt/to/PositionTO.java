package kr.co.seoulit.insa.commsvc.foudinfomgmt.to;

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
@Table(name = "POSITION")
@Dataset(name="ds_positionList")
@EqualsAndHashCode(callSuper=false)
public class PositionTO extends BaseTO {
	
	@Id
	@Column(nullable=false)
	private String positionCode;
	private String position;
	private String baseSalary;
	private String hobongRatio;
	private String allowance;
}
