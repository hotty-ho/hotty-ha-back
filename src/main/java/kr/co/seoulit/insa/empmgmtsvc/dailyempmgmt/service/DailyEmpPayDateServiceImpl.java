package kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.service;

import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper.DailyEmpPayDateMapper;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpPayDateTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpPayTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTO;
import kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.to.DailyEmpTargetTO;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DailyEmpPayDateServiceImpl implements DailyEmpPayDateService{

    @Autowired
    private DailyEmpPayDateMapper dailyEmpPayDateMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public void insertDailyEmpPayDate(List<DailyEmpPayDateTO> list) {
        dailyEmpPayDateMapper.insertDailyEmpPayDate(list);
    }

    @Override
    public void deleteDailyEmpPayDate() {
        dailyEmpPayDateMapper.deleteDailyEmpPayDate();
    }

    @Override
    public ArrayList<DailyEmpPayDateTO> findDailyPayList() {
        return dailyEmpPayDateMapper.selectDailyPayDateList();
    }

//    @Override
//    public void registerDailyPayDate(DailyEmpPayDateTO dailyEmpPayDateTO) {
//        dailyEmpPayDateMapper.insertDailyPayDate();
//    }
//
//    @Override
//    public void modifyDailyPayDate(DailyEmpPayDateTO dailyEmpPayDateTO) {
//
//    }
//
//    @Override
//    public void removeDailyPayDate(DailyEmpPayDateTO dailyEmpPayDateTO) {
//
//    }

    @Override
    public void batchInsertDailyPayDateListProcess(ArrayList<DailyEmpPayDateTO> list) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            for( DailyEmpPayDateTO to : list) {
                sqlSession.insert("kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper.DailyEmpPayDateMapper.insertDailyPayDate",to);
            }
        }finally {
            sqlSession.flushStatements();
            sqlSession.clearCache();
            sqlSession.close();
        }
    }

    @Override
    public void batchUpdateDailyPayDateListProcess(ArrayList<DailyEmpPayDateTO> list) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            for( DailyEmpPayDateTO to : list) {
                sqlSession.update("kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper.DailyEmpPayDateMapper.updateDailyPayDate",to);
            }
        }finally {
            sqlSession.flushStatements();
            sqlSession.clearCache();
            sqlSession.close();
        }
    }

    @Override
    public void batchDeleteDailyPayDateListProcess(ArrayList<DailyEmpPayDateTO> list) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            for( DailyEmpPayDateTO to : list) {
                sqlSession.delete("kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper.DailyEmpPayDateMapper.deleteDailyPayDate",to);
            }
        }finally {
            sqlSession.flushStatements();
            sqlSession.clearCache();
            sqlSession.close();
        }
    }

    @Override
    public void updateDailyPayDate(List<DailyEmpTO> list) {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            for (DailyEmpTO to : list) {
                sqlSession.update("kr.co.seoulit.insa.empmgmtsvc.dailyempmgmt.mapper.DailyEmpPayDateMapper.updateDailyPayDateTarget", to);
            }
        } finally {
            sqlSession.flushStatements();
            sqlSession.clearCache();
            sqlSession.close();
        };
    }

}
