package kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.seoulit.insa.commsvc.foudinfomgmt.to.PositionTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.entity.DetailCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.mapper.BaseExtSalMapper;
//import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.mapper.BaseSalaryMapper;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.mapper.SocialInsMapper;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.repository.BaseExtSalRepository;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.repository.BaseSalRepository;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to.BaseExtSalTO;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to.BaseSalaryTO;
import kr.co.seoulit.insa.salarysvc.salarystdinfomgmt.to.SocialInsTO;

@Service
@RequiredArgsConstructor
public class SalaryStdInfoMgmtServiceImpl implements SalaryStdInfoMgmtService{


	//✅생성자 주입 방식 변경 후_23.08.07.ha
	//@RequiredArgsConstructor 어노테이션 추가
	private final SocialInsMapper SocialInsureMapper;
	private final BaseExtSalRepository baseExtSalrepository;
	private final BaseSalRepository baseSalrepository;

	
	@Override
	public ArrayList<BaseSalaryTO> findBaseSalaryList() {

		ArrayList<BaseSalaryTO> baseSalaryList=null;
		baseSalaryList = (ArrayList<BaseSalaryTO>)baseSalrepository.findAll();
		//baseSalaryList = baseSalaryMapper.selectBaseSalaryList();
		return baseSalaryList;
		
	}
	
	@Override
	public void modifyBaseSalaryList(ArrayList<BaseSalaryTO> baseSalaryList) {


		if (baseSalaryList != null && baseSalaryList.size() > 0) { // 아무것도 없어거나 빈배열일경우를 대비

			for (BaseSalaryTO baseSalary : baseSalaryList) {
				switch (baseSalary.getStatus()) {

					case "update":
						baseSalrepository.save(baseSalary);
						break;

					case "insert":
						baseSalrepository.save(baseSalary);
						break;

					case "delete":
						baseSalrepository.deleteById(baseSalary.getPositionCode());
						break;
				}
			}
		}
		
	}
	
	@Override
	public ArrayList<BaseExtSalTO> findBaseExtSalList() {

		ArrayList<BaseExtSalTO> baseExtSalList=null;
		baseExtSalList = (ArrayList<BaseExtSalTO>)baseExtSalrepository.findAll();
		//baseExtSalList = baseExtSalMapper.selectBaseExtSalList();
		return baseExtSalList;
		
	}
	
	@Override
	public void modifyBaseExtSalList(ArrayList<BaseExtSalTO> baseExtSalList) {




		if (baseExtSalList != null && baseExtSalList.size() > 0) { // 아무것도 없어거나 빈배열일경우를 대비

			for (BaseExtSalTO baseExtSal : baseExtSalList) {
				DetailCode detailCode = new DetailCode();
				switch (baseExtSal.getStatus()) {

					case "update":
						baseExtSalrepository.save(baseExtSal);
						break;

					case "insert":
						baseExtSalrepository.save(baseExtSal);
						break;

					case "delete":
						baseExtSalrepository.deleteById(baseExtSal.getExtSalCode());
						break;
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<SocialInsTO> findBaseInsureList(String yearBox) {

		HashMap<String, Object> map = new HashMap<String, Object>();
	      map.put("yearBox", yearBox);
	      SocialInsureMapper.selectBaseInsureList(map);
	      ArrayList<SocialInsTO> BaseInsureList = (ArrayList<SocialInsTO>) map.get("result");
	      return BaseInsureList;
		
	}
	
	@Override
	public void updateInsureData(ArrayList<SocialInsTO> baseInsureList) {

		for (SocialInsTO baseInsure : baseInsureList) {
			SocialInsureMapper.updateInsureData(baseInsure);
		}
		
	}

	@Override
	public void deleteInsureData(String year) {
			SocialInsureMapper.deleteInsureData(year);
	
	}
	
}
