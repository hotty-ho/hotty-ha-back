package kr.co.seoulit.insa.commsvc.foudinfomgmt.mapper;


import org.apache.ibatis.annotations.Mapper;
import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.PositionTO;

@Mapper
public interface PositionMapper {
//	public void updatePosition(PositionTO position);
//	public void insertPosition(PositionTO position);
//	public ArrayList<PositionTO> selectPositonList();
	public void deletePosition(PositionTO position);
}
