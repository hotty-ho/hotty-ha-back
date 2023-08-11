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
@Table(name = "HOLIDAY")
@Dataset(name="ds_holiday")
@EqualsAndHashCode(callSuper=false)
public class HolidayTO extends BaseTO {
	
	@Id
	private String applyDay;
	private String holidayName;
	@Column(nullable=true)
	private String note;

}
