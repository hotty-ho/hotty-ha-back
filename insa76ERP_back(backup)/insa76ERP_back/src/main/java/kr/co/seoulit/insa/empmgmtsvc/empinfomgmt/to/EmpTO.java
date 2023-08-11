package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to;


import java.util.ArrayList;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Dataset(name="gds_emp")
@Data
@EqualsAndHashCode(callSuper=false)
public class EmpTO extends BaseTO{

   private String workplaceCode, empCode, empName, birthdate, gender, mobileNumber, address, detailAddress, postNumber, email,
           lastSchool, imgExtend, positionCode, deptCode, hobong, occupation, employment, authority, hiredate,
           deptName, position;

   int achievement,ability, attitude;
   ArrayList<FamilyInfoTO> familyInfoList;
   ArrayList<LicenseInfoTO> licenseInfoList;
   ArrayList<WorkInfoTO> workInfo;

   public String getImgExtend() {
      return "jpg";
   }

}
