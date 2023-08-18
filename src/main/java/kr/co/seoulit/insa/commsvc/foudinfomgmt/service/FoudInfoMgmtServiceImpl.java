package kr.co.seoulit.insa.commsvc.foudinfomgmt.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.insa.commsvc.systemmgmt.entity.DetailCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.insa.commsvc.foudinfomgmt.mapper.BaseWorkTimeMapper;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.mapper.DeptMapper;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.mapper.HolidayMapper;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.mapper.PositionMapper;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.repository.BaseWorkTimeRepository;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.repository.DeptRepository;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.repository.HolidayRepository;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.repository.PositionRepository;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.BaseWorkTimeTO;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.DeptTO;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.HolidayTO;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.PositionTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.mapper.DetailCodeMapper;
import kr.co.seoulit.insa.commsvc.systemmgmt.repository.DetailCodeRepository;


@Service
public class FoudInfoMgmtServiceImpl implements FoudInfoMgmtService {
	
	@Autowired
	private HolidayMapper holidayMapper;
	@Autowired
	private BaseWorkTimeMapper baseWorkTimeMapper;
	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private DetailCodeMapper detailCodeMapper;
	@Autowired
	private PositionMapper positionMapper;
	
	@Autowired
	private DeptRepository deptrepository;
	@Autowired
	private BaseWorkTimeRepository baseworktimerepository;
	@Autowired
	private HolidayRepository holidayRepository;
	@Autowired
	private PositionRepository positionrepository;
	@Autowired
	private DetailCodeRepository detailcoderepository;
	


	@Override
	public ArrayList<DeptTO> findDeptList() {

		ArrayList<DeptTO> deptList = null;
		deptList = (ArrayList<DeptTO>)deptrepository.findAll();
//		deptList = deptMapper.selectDeptList();
		return deptList;

	}

	@Override
	public void batchDeptProcess(ArrayList<DeptTO> deptto) {

		DetailCode detailCode = new DetailCode();

		for (DeptTO deptBean : deptto) {

			switch (deptBean.getStatus()) {

			case "update":
				deptrepository.save(deptBean);
				//deptMapper.updateDept(deptBean);
				detailCode.setDetailCodeNumber(deptBean.getDeptCode());
				detailCode.setDetailCodeName(deptBean.getDeptName());
				detailCode.setCodeNumber("CO-07"); // co-07이 부서관련 코드
				detailCode.setDetailCodeNameusing("Y"); // 새로 만들어져서 이렇게하다 .
				detailcoderepository.save(detailCode);
				//detailCodeMapper.updateDetailCode(detailCode);
				break;

			case "insert":
				deptrepository.save(deptBean);
				//deptMapper.registDept(deptBean);
				detailCode.setDetailCodeNumber(deptBean.getDeptCode()); // 디테일코드에는 모든 코드들이 있기때문에 입력해준다.
				detailCode.setDetailCodeName(deptBean.getDeptName());
				detailCode.setCodeNumber("CO-07");
				detailCode.setDetailCodeNameusing("Y");
				detailcoderepository.save(detailCode);
				//detailCodeMapper.registDetailCode(detailCode);
				break;

			case "delete":
				deptMapper.deleteDept(deptBean);
				detailCode.setDetailCodeNumber(deptBean.getDeptCode());
				detailCode.setDetailCodeName(deptBean.getDeptName());
				detailcoderepository.deleteById(detailCode.getDetailCodeNumber());
				break;

			case "normal":
				break;
			}
		}
	}

	
	@Override
	public ArrayList<PositionTO> findPositionList() {

		ArrayList<PositionTO> positionList = null;
		positionList = (ArrayList<PositionTO>)positionrepository.findAll();
		//positionList = positionMapper.selectPositonList();
		return positionList;

	}

	@Override
	public void modifyPosition(ArrayList<PositionTO> positionList) {

		if (positionList != null && positionList.size() > 0) { // 아무것도 없어거나 빈배열일경우를 대비

			for (PositionTO positionTO : positionList) {
				DetailCode detailCode = new DetailCode();
				switch (positionTO.getStatus()) {

				case "update":
					positionrepository.save(positionTO);
					//positionMapper.updatePosition(positionTO);
					detailCode.setDetailCodeNumber(positionTO.getPositionCode());
					detailCode.setDetailCodeName(positionTO.getPosition());
					detailCode.setCodeNumber("CO-04"); // 직급과련 코드.
					detailCode.setDetailCodeNameusing("Y");
					detailcoderepository.save(detailCode);
					//detailCodeMapper.updateDetailCode(detailCode);
					break;

				case "insert":
					positionrepository.save(positionTO);
					//positionMapper.insertPosition(positionTO);
					detailCode.setDetailCodeNumber(positionTO.getPositionCode());
					detailCode.setDetailCodeName(positionTO.getPosition());
					detailCode.setCodeNumber("CO-04");
					detailCode.setDetailCodeNameusing("Y");
					detailcoderepository.save(detailCode);
					//detailCodeMapper.registDetailCode(detailCode);
					break;

				case "delete":
					positionMapper.deletePosition(positionTO);
					detailCode.setDetailCodeNumber(positionTO.getPositionCode());
					detailCode.setDetailCodeName(positionTO.getPosition());
					detailcoderepository.deleteById(detailCode.getDetailCodeNumber());
					break;
				}
			}
		}

	}

	@Override
	public ArrayList<HolidayTO> findHolidayList() {

		ArrayList<HolidayTO> holidayList = null;
		holidayList = (ArrayList<HolidayTO>)holidayRepository.findAll();
		//holidayList = holidayMapper.selectHolidayList();
		return holidayList;

	}

	@Override
	public String findWeekDayCount(String startDate, String endDate) {
		HashMap<String , Object> map = new HashMap<>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		
		String weekdayCount = null;
		weekdayCount = holidayMapper.selectWeekDayCount(map);
		return weekdayCount;

	}

	@Override
	public void batchHolidayProcess(ArrayList<HolidayTO> holiday) {

		for (HolidayTO holidayTO : holiday) {
			switch (holidayTO.getStatus()) {

			case "update":
				holidayRepository.save(holidayTO);
				//holidayMapper.updateCodeList(holidayTO);
				break;

			case "insert":
				holidayRepository.save(holidayTO);
				//holidayMapper.insertCodeList(holidayTO);
				break;

			case "delete":
				holidayMapper.deleteCodeList(holidayTO);
				break;

			}
		}

	}

	@Override
	public ArrayList<BaseWorkTimeTO> findTimeList() {

		ArrayList<BaseWorkTimeTO> timeList = null;
		timeList = (ArrayList<BaseWorkTimeTO>)baseworktimerepository.findAll();
		//timeList = baseWorkTimeMapper.selectTimeList();
		return timeList;

	}

	@Override
	public void batchTimeProcess(ArrayList<BaseWorkTimeTO> timeList) {

		for (BaseWorkTimeTO baseWorkTimeTO : timeList) {
			if(baseWorkTimeTO.getStatus()!=null) { 
				switch (baseWorkTimeTO.getStatus()) {
	
				case "update":
					baseworktimerepository.save(baseWorkTimeTO);
					//baseWorkTimeMapper.updateTime(baseWorkTimeTO);
					break;
	
				case "insert":
					baseworktimerepository.save(baseWorkTimeTO);
					//baseWorkTimeMapper.insertTime(baseWorkTimeTO);
					break;
	
				case "delete":
					baseWorkTimeMapper.deleteTime(baseWorkTimeTO);
					break;
				}
			}
		}
	}

}
