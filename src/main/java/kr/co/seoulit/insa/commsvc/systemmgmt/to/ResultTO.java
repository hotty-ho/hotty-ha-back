package kr.co.seoulit.insa.commsvc.systemmgmt.to;

import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;

@Dataset(name="out_error")
@Data
public class ResultTO {
	
	private String errorCode, errorMsg;

}
