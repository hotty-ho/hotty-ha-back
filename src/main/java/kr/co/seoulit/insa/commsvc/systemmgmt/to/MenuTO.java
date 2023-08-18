package kr.co.seoulit.insa.commsvc.systemmgmt.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MenuTO {

  private String menu_name, super_menu_code, menu_code, depth, is_collapse, menu_url, navbar_name;

}
