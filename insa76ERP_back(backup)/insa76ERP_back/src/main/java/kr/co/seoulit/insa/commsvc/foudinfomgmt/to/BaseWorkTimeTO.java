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
@Table(name = "BASE_WORK_TIME")
@Dataset(name="ds_baseWorkTime")
@EqualsAndHashCode(callSuper=false)
public class BaseWorkTimeTO extends BaseTO {
	
	  @Id
	  @Column(nullable=false)
	  String applyYear;
	  String attendTime;
	  String quitTime;
	  String lunchStartTime;
	  String lunchEndTime;
	  String dinnerStartTime;
	  String dinnerEndTime;
	  String overEndTime;
	  String nightEndTime;
	

}