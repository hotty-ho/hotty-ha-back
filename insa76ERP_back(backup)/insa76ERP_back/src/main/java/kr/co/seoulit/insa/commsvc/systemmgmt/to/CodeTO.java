package kr.co.seoulit.insa.commsvc.systemmgmt.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "DIVISION_CODE")
@Dataset(name="gds_codeList")
public class CodeTO extends BaseTO{
	
	@Id
	@Column(nullable=false)
	private String codeNumber;
	private String codeName;
	private String modifiable;
	private String status;

}
