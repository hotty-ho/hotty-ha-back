package kr.co.seoulit.insa.attdsvc.attdappvl.service;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.seoulit.insa.attdsvc.attdappvl.to.DayAttdMgtTO;
import kr.co.seoulit.insa.attdsvc.attdappvl.to.MonthAttdMgtTO;
import kr.co.seoulit.insa.attdsvc.attdappvl.mapper.AnnualVacationMgtMapper;
import kr.co.seoulit.insa.attdsvc.attdappvl.mapper.DailyAttndMgtMapper;
import kr.co.seoulit.insa.attdsvc.attdappvl.mapper.MonthlyAttndMgtMapper;
import kr.co.seoulit.insa.attdsvc.attdappvl.to.AnnualLeaveMgtTO;
import kr.co.seoulit.insa.attdsvc.attdmgmt.mapper.ExcusedAttndMapper;
import kr.co.seoulit.insa.attdsvc.attdmgmt.to.RestAttdTO;



@Service
public class AttdAppvlServiceImpl implements AttdAppvlService {
	
	@Autowired
	private DailyAttndMgtMapper dayAttdMgtMapper;
	@Autowired
	private ExcusedAttndMapper excusedAttndMapper;
	@Autowired
	private MonthlyAttndMgtMapper monthAttdMgtMapper;
	@Autowired
	private AnnualVacationMgtMapper annualVacationMgtMapper;
	


	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<DayAttdMgtTO> findDayAttdMgtList(String applyDay, String workplaceCode) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("applyDay",applyDay);
		map.put("workplaceCode",workplaceCode);
		dayAttdMgtMapper.batchDayAttdMgtProcess(map);
		
		return (ArrayList<DayAttdMgtTO>) map.get("result");
	}


	//attndPut
	@Override
	public void modifyDayAttdMgtList(ArrayList<DayAttdMgtTO> dayAttdMgtList) {

		for (DayAttdMgtTO dayAttdMgt : dayAttdMgtList) {
				dayAttdMgtMapper.updateDayAttdMgtList(dayAttdMgt);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<MonthAttdMgtTO> findMonthAttdMgtList(String applyYearMonth, String workplaceCode) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("applyYearMonth", applyYearMonth);
		map.put("workplaceCode", workplaceCode);

		monthAttdMgtMapper.batchMonthAttdMgtProcess(map);

		return (ArrayList<MonthAttdMgtTO>) map.get("result");
	}

	@Override
	public void modifyMonthAttdMgtList(ArrayList<MonthAttdMgtTO> monthAttdMgtList) {

		for (MonthAttdMgtTO monthAttdMgt : monthAttdMgtList) {
				monthAttdMgtMapper.updateMonthAttdMgtList(monthAttdMgt);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<AnnualLeaveMgtTO> findAnnualVacationMgtList(String applyYearMonth, String workplaceCode) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("applyYearMonth", applyYearMonth);
		map.put("workplaceCode", workplaceCode);

		annualVacationMgtMapper.batchAnnualVacationMgtProcess(map);

		System.out.println("map ============= " + map);

		return (ArrayList<AnnualLeaveMgtTO>) map.get("result");
	}

	@Override
	public void modifyAnnualVacationMgtList(ArrayList<AnnualLeaveMgtTO> annualVacationMgtList) {

		for (AnnualLeaveMgtTO annualVacationMgt : annualVacationMgtList) {
			annualVacationMgtMapper.updateAnnualVacationMgtList(annualVacationMgt);
				annualVacationMgtMapper.updateAnnualVacationList(annualVacationMgt);
		}
	}

	@Override
	public void cancelAnnualVacationMgtList(ArrayList<AnnualLeaveMgtTO> annualVacationMgtList) {

		for (AnnualLeaveMgtTO annualVacationMgt : annualVacationMgtList) {
			if (annualVacationMgt.getStatus().equals("update")) {
				annualVacationMgtMapper.cancelAnnualVacationMgtList(annualVacationMgt);
				annualVacationMgtMapper.cancelAnnualVacationList(annualVacationMgt);
			}
		}

	}

	@Override
	public ArrayList<RestAttdTO> findRestAttdListByDept(String empName, String startDate, String endDate) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<RestAttdTO> restAttdList = null;
		map.put("empName", empName);
		map.put("startDate", startDate);
		map.put("endDate", endDate);

		System.out.println("empName =============== " + empName);
		System.out.println("startDate =============== " + startDate);
		System.out.println("endDate =============== " + endDate);

		if (empName.equals("undefined")) {
			restAttdList = excusedAttndMapper.selectRestAttdListByAllDept(map);
		} else {

			restAttdList = excusedAttndMapper.selectRestAttdListByDept(map);
		}

		return restAttdList;
	}


	//attnd-approval2
	@Override
	public void modifyRestAttdList(ArrayList<RestAttdTO> restAttdList) {

		for (RestAttdTO restAttd : restAttdList) {
			System.out.println("===================="+restAttd.getStatus());
			if (restAttd.getStatus().equals("update")) {
				excusedAttndMapper.updateRestAttd(restAttd);
			}
		}
	}

	@Override
	public ArrayList<DayAttdMgtTO> findAttdList(String applyDay) {

		ArrayList<DayAttdMgtTO> attdList = dayAttdMgtMapper.findAttdList(applyDay);

		return attdList;
	}

	@Override
	public void saveAttd(ArrayList<DayAttdMgtTO> dayAttdList) {

		for (DayAttdMgtTO restAttd : dayAttdList) {
			System.out.println(restAttd.getStatus());
			if (restAttd.getStatus().equals("update")) {
				dayAttdMgtMapper.updateDayAttd(restAttd);
			}
		}

	}

	@Override
	public ArrayList<RestAttdTO> overtimeFindList(String requestDate, String restTypeCode) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ArrayList<RestAttdTO> restAttdList = null;
		map.put("requestDate", requestDate);
		map.put("restTypeCode", restTypeCode);

		System.out.println("empName =============== " + requestDate);
		System.out.println("startDate =============== " + restTypeCode);

		restAttdList = excusedAttndMapper.overtimeFindList(map);


		return restAttdList;
	}

	@Override
	public void overtimeApplovalSave(ArrayList<RestAttdTO> restAttdList) {

		for (RestAttdTO restAttd : restAttdList) {
			System.out.println("===================="+restAttd.getStatus());
			if (restAttd.getStatus().equals("update")) {
				excusedAttndMapper.updateOvertime(restAttd);
			}
		}
	}

}
