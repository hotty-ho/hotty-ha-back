package kr.co.seoulit.insa.commsvc.foudinfomgmt.mapper;


import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.HolidayTO;

@Mapper
public interface HolidayMapper {
	
	String selectWeekDayCount(HashMap<String, Object> map);
//	public ArrayList<HolidayTO> selectHolidayList();
//	public void updateCodeList(HolidayTO holyday);
//	public void insertCodeList(HolidayTO holyday);
	public void deleteCodeList(HolidayTO holyday);
}
