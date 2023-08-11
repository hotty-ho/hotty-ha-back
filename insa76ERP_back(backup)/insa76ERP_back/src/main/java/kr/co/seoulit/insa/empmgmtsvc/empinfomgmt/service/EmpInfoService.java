package kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.DeptTO;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpAppointmentInfoTO;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpAppointmentTO;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpAppointmentTypeTO;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpEvalTO;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpTO;

public interface EmpInfoService {
	public EmpTO getEmp(String name); //selectEmp
	public String findLastEmpCode();
	public EmpTO findAllEmpInfo(String empCode);
	public ArrayList<EmpTO> findEmpList(String dept); //findEmployeeListByDept
	public void registEmployee(EmpTO empto);
	public void modifyEmployee(EmpTO emp);
	public void deleteEmpList(ArrayList<EmpTO> empList);
	public ArrayList<DeptTO> findDeptList();

	public void registEmpEval(EmpEvalTO empevalto,String workInfo);
	public ArrayList<EmpEvalTO> findEmpEval();
	public ArrayList<EmpEvalTO> findEmpEval(String dept, String year);
	public void removeEmpEvalList(String emp_code , String apply_day);

	public void modifyEmpEvalList(ArrayList<EmpEvalTO> empevalList);


	public void registAppoint(HashMap<String, Object> map,EmpAppointmentTO emp);
	public void updateAppoint(ArrayList<EmpAppointmentTypeTO> type);
	public EmpAppointmentInfoTO generateHosu();
	public void registAppointmentinfo(EmpAppointmentInfoTO empAppointmentInfoTO);
	public ArrayList<EmpAppointmentInfoTO> findAppointmentinfo(String searchType);
	public ArrayList<EmpAppointmentTypeTO> findAppointmentinfoEmp(String hosu, String type);
	public ArrayList<EmpAppointmentTypeTO> findAppointmentEmp(String empCode);
	public EmpAppointmentTO countAppointmentEmp(String hosu);
	public ArrayList<EmpAppointmentTypeTO> findAllAppointEmp(String hosu);
}
