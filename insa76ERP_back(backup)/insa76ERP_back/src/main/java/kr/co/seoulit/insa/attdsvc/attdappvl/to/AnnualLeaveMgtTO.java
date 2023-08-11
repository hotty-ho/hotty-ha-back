package kr.co.seoulit.insa.attdsvc.attdappvl.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "ANNUAL_VACATION_MANAGE")
@Dataset(name="ds_vacation")
@IdClass(value=AnnualLeaveMgtTO.class)
public class AnnualLeaveMgtTO extends BaseTO implements Serializable{
	
	@Id
	@Column(nullable=false)
	private String empCode;
	@Id
	@Column(nullable=false)
	private String applyYearMonth;
	private String empName;
	private String afternoonOff;
	private String monthlyLeave;
	private String remainingHoliday;
	private String finalizeStatus;
	
}