package kr.co.seoulit.insa.commsvc.systemmgmt.entity;

import kr.co.seoulit.insa.sys.annotation.Dataset;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;


@SuppressWarnings("serial")
@Dataset(name="gds_detailcode")
@Data
@Entity
@EqualsAndHashCode
public class DetailCode implements Serializable {

    @Id
    private String detailCodeNumber;


    private String codeNumber;


    private String detailCodeName;


    @Column(nullable=false)
    private String detailCodeNameusing;


}