package kr.co.seoulit.insa.attdsvc.attdmgmt.entity;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.to.DetailCodeTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "REST_ATTD")
@EqualsAndHashCode(callSuper=false)
@Dataset(name="gds_restAttd")
@SequenceGenerator(
        name="REST_ATTD_SEQ_GEN", //시퀀스 제너레이터 이름
        sequenceName="REST_ATTD_CODE_SEQ", //시퀀스 이름
        initialValue=1, //시작값
        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
)
@IdClass(value= RestAttd.class)
public class RestAttd implements Serializable {

    @Id
    @Column(nullable=false)
    private String empCode;

    @Id
    @Column(nullable=false)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "REST_ATTD_SEQ_GEN"
    )
    private String restAttdCode;

    private String restTypeCode;

    private String restTypeName;

    private String requestDate;

    private String startDate;

    private String endDate;

    private String cause;

    private String applovalStatus;

    private String rejectCause;

    private String cost;

    private String startTime;

    private String endTime;

    private String numberOfDays;
}
