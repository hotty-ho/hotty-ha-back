package kr.co.seoulit.insa.testdaylabr;

import kr.co.seoulit.insa.commsvc.systemmgmt.to.BaseTO;
import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "DAY_LABOR")
@Dataset(name = "gds_daylabor")
public class DayLaborTO extends BaseTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,b1,b2,b3,b4;

}
