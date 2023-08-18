package kr.co.seoulit.insa.salarysvc.salaryinfomgmt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.mapper.FullTimeSalaryMapper;
import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.mapper.RetirementSalMapper;
import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.mapper.SalaryBonusMapper;
import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to.FullTimeSalTO;
import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to.PayDayTO;
import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to.RetirementSalaryTO;
import kr.co.seoulit.insa.salarysvc.salaryinfomgmt.to.SalaryBonusTO;

//스프링 컴포넌트이며 기능적으로는
//비즈니스 로직을 수행하는 서비스 레이어임을 알려주는 어노테이션
@Service
@RequiredArgsConstructor
public class SalaryInfoMgmtServiceImpl implements SalaryInfoMgmtService {

/*  ✅생성자 주입 방식 변경 전_23.08.07.ha
    스프링에서는 서비스 객체를 관리하고
    필요한 곳에서 주입하여 사용하기 위해
    @Autowired 어노테이션을 사용한다.

    @Autowired
    private FullTimeSalaryMapper fullTimeSalaryMapper;
    @Autowired
    private RetirementSalMapper retirementSalMapper;
    @Autowired
    private SalaryBonusMapper salaryBonusMapper;
*/
    //✅생성자 주입 방식 변경 후_23.08.07.ha
    //@RequiredArgsConstructor 어노테이션 추가
    private final FullTimeSalaryMapper fullTimeSalaryMapper;
    private final RetirementSalMapper retirementSalMapper;
    private final SalaryBonusMapper salaryBonusMapper;


    //📌급여조회
    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<FullTimeSalTO> findselectSalary(String applyYearMonth, String empCode) {
        // ✅이유1: 여러 데이터를 담기 위해서
        // HashMap의 자료형이 Object인 이유는 목록을 반환해야하지만
        // java에서 메소드는 하나의 객체만 반환할 수 있으므로 여러 데이터를 담기 위해서

        // ✅이유2: 편의성과 확장성
        // HashMap은 키-값 쌍으로 데이터를 저장할 수 있으므로,
        // 결과를 여러 개의 키에 대응하는 값으로 매핑하여 반환할 수 있어서

        // ✅이유3: 유연성
        // 타입에 대한 제한이 없어서
        HashMap<String, Object> map = new HashMap<>();
        map.put("applyYearMonth", applyYearMonth);
        map.put("empCode", empCode);
        //map 객체를 매개변수로 받아서 월급여 정보를 데이터베이스에서 조회하고, 그 결과를 map 객체에 저장
        fullTimeSalaryMapper.selectFullTimeSalary(map);
        //map 객체에서 "result"라는 키로 저장된 값을 가져와 fullTimeSalaryList 변수에 저장
        ArrayList<FullTimeSalTO> fullTimeSalaryList = (ArrayList<FullTimeSalTO>) map.get("result");
        return fullTimeSalaryList;

    }


    @Override
    public ArrayList<FullTimeSalTO> findAllMoney(String applyYearMonth) {

        ArrayList<FullTimeSalTO> findAllMoneyList = null;
        findAllMoneyList = fullTimeSalaryMapper.findAllMoney(applyYearMonth);
        return findAllMoneyList;

    }

    /*
    일전에 코드 줄 수 를 줄이기 위한 변경 내용
    🧑‍💻논의점
    조회 결과가 null인 경우 빈 List를 반환하면 되지만 코드를 아래와 같이 줄일 경우
    null인 경우를 처리하기 위한 추가적인 로직이 필요, 이로 인해 코드의 안정성이 떨어질 수 있다.

    변경 전의 코드처럼 변수를 사용하여 조회 결과를 받아오는 것이 안전하며,
    코드의 가독성과 유지보수에도 도움이 될 수 있다.

    @Override
	public ArrayList<FullTimeSalTO> findAllMoney(String applyYearMonth) {

		return fullTimeSalaryMapper.findAllMoney(applyYearMonth);

	}
    */


    @Override
    public ArrayList<PayDayTO> findPayDayList() {

        ArrayList<PayDayTO> PayDayList = null;
        PayDayList = fullTimeSalaryMapper.selectPayDayList();
        return PayDayList;

    }

    @Override
    public void modifyFullTimeSalary(List<FullTimeSalTO> fullTimeSalary) {

        for (FullTimeSalTO fullTimeSalTO : fullTimeSalary) {
            fullTimeSalaryMapper.updateFullTimeSalary(fullTimeSalTO);
        }

    }

    @Override
    public ArrayList<RetirementSalaryTO> findretirementSalaryList(String empCode) {
        ArrayList<RetirementSalaryTO> retirementSalaryList = retirementSalMapper.selectretirementSalaryList(empCode);
        return retirementSalaryList;

    }

    @Override
    public ArrayList<SalaryBonusTO> findBonusSalary(String empCode) {

        ArrayList<SalaryBonusTO> SalaryBonusList = null;
        SalaryBonusList = salaryBonusMapper.selectBonusSalary(empCode);
        return SalaryBonusList;

    }

}
