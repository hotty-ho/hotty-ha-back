package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service;

import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper.DailyEmpMgmtMapper;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DailyEmpMgmtServiceImpl implements DailyEmpMgmtService{

    @Autowired
    private DailyEmpMgmtMapper dailyEmpMgmtMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public ArrayList<DailyEmpTO> findDailyEmpList() {
        return dailyEmpMgmtMapper.selectDailyEmpList();
    }

    @Override
    public ArrayList<DailyEmpTO> findDailyEmpListWithConditions(Map<String, String> map) {
        return dailyEmpMgmtMapper.selectDailyEmpListWithConditions(map);
    }

    @Override
    public void registerDailyEmp(DailyEmpTO dailyEmpTO) {
        dailyEmpMgmtMapper.insertDailyEmp(dailyEmpTO);
    }

    @Override
    public void modifyDailyEmp(DailyEmpTO dailyEmpTO) {
        dailyEmpMgmtMapper.updateDailyEmp(dailyEmpTO);
    }

    @Override
    public void removeDailyEmp(DailyEmpTO dailyEmpTO) {
        dailyEmpMgmtMapper.deleteDailyEmp(dailyEmpTO);
    }

    @Override
    public void batchInsertDailyEmpListProcess(List<DailyEmpTO> list) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            for( DailyEmpTO to : list) {
                sqlSession.insert("kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper.DailyEmpMgmtMapper.insertDailyEmp",to);
            }
        }finally {
            sqlSession.flushStatements();
            sqlSession.clearCache();
            sqlSession.close();
        }
    }

    @Override
    public void batchUpdateDailyEmpListProcess(List<DailyEmpTO> list) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            for( DailyEmpTO to : list) {
                sqlSession.update("kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper.DailyEmpMgmtMapper.updateDailyEmp",to);
            }
        }finally {
            sqlSession.flushStatements();
            sqlSession.clearCache();
            sqlSession.close();
        }
    }

    @Override
    public void batchDeleteDailyEmpListProcess(List<DailyEmpTO> list) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            for( DailyEmpTO to : list) {
                sqlSession.delete("kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper.DailyEmpMgmtMapper.deleteDailyEmp",to);
            }
        }finally {
            sqlSession.flushStatements();
            sqlSession.clearCache();
            sqlSession.close();
        }
    }

    @Override
    public ArrayList<DailyEmpTO> findDailyEmpPayDateList(HashMap<String, String> map) {
        return dailyEmpMgmtMapper.selectDailyEmpPayList(map);
    }

    @Override
    public ArrayList<DailyEmpTO> findDailyEmpTargetDataList(HashMap<String, String> map) {
        return dailyEmpMgmtMapper.selectDailyEmpTargetDataList(map);
    }

    @Override
    public ArrayList<DailyEmpTO> findDailyEmpListExceptDate() {
        return dailyEmpMgmtMapper.selectDailyEmpExceptDateList();
    }

    @Override
    public ArrayList<DailyEmpTO> findDailyEmpTargetList() {
        return dailyEmpMgmtMapper.selectDailyEmpTargetList();
    }
}
