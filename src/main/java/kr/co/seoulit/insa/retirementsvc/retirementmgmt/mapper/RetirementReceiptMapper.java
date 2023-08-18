package kr.co.seoulit.insa.retirementsvc.retirementmgmt.mapper;

import kr.co.seoulit.insa.retirementsvc.retirementmgmt.to.RetirementPersonTO;
import kr.co.seoulit.insa.retirementsvc.retirementmgmt.to.RetirementReceiptTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface RetirementReceiptMapper {
    public RetirementReceiptTO selectReport(
            @Param("empCode") String empCode, @Param("retirementRange") String retirementRange,
            @Param("hireDate") String hireDate, @Param("retireDate") String retireDate,
            @Param("retirementPay") String retirementPay);

    public ArrayList<RetirementPersonTO> selectRetirementList(
            @Param("empCode") String empCode, @Param("startDate") String startDate, @Param("endDate") String endDate);

    public void updateRetirementApply(HashMap<String, String> map);

    public void insertRetirementReceipt(HashMap<String, String> map);
}