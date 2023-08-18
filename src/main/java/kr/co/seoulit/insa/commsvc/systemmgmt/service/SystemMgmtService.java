package kr.co.seoulit.insa.commsvc.systemmgmt.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.seoulit.insa.commsvc.systemmgmt.dto.DetailCodeDTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.entity.DetailCode;
import kr.co.seoulit.insa.commsvc.systemmgmt.exception.IdNotFoundException;
import kr.co.seoulit.insa.commsvc.systemmgmt.exception.PwMissMatchException;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.AdminCodeTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.BoardTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.CodeTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.DetailCodeTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.MenuTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.ReportSalaryTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.ReportTO;
import kr.co.seoulit.insa.empmgmtsvc.empinfomgmt.to.EmpTO;

public interface SystemMgmtService {
	//Login Part
	public EmpTO findEmp(String name, String empCode) throws IdNotFoundException, PwMissMatchException;
	
	//Code Part 
//	public ArrayList<DetailCodeTO> findDetailCodeList(String codetype);

	public ArrayList<DetailCodeDTO> findDetailCodeList(String code);
	public ArrayList<DetailCodeTO> findDetailCodeListRest(String code1,String code2,String code3);
	public ArrayList<CodeTO> findCodeList();

	//IO part
	public void registEmpImg(String empCode, String imgExtend);
	


	// Ireport Part 
	public ReportTO viewReport(String empCode);
	public ReportSalaryTO viewSalaryReport(String empCode, String applyMonth);
	
	//Board Part
	public ArrayList<BoardTO> getBoardList();
	public void addBoard(BoardTO board);
	public BoardTO getBoard(int board_seq);
	public BoardTO getBoard(String sessionId,int board_seq);
	public void changeHit(int board_seq);
	public int getRowCount();
	public ArrayList<BoardTO> getBoardList(int sr, int er);
	public void removeBoard(int board_seq);
	// Menu Part 
	public ArrayList<MenuTO> findMenuList();

	//Authority Part
	public ArrayList<AdminCodeTO> adminCodeList(); 
	public void modifyAuthority(String empCode, String adminCode);

	public ArrayList<AdminCodeTO> authadminCodeList(String empno);
}
