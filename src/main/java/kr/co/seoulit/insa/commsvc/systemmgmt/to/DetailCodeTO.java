package kr.co.seoulit.insa.commsvc.systemmgmt.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity	
@Data
@Table(name = "DETAIL_CODE")
@Dataset(name="gds_detailcode")
@EqualsAndHashCode(callSuper=false)
@IdClass(value=DetailCodeTO.class)
public class DetailCodeTO implements Serializable{
	
	@Id
	private String detailCodeNumber;

	@Id
	private String codeNumber;
	
	@Id
	private String detailCodeName;

	@Id
	@Column(nullable=false)
	private String detailCodeNameusing;


}