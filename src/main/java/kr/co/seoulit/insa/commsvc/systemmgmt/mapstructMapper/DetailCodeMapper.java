package kr.co.seoulit.insa.commsvc.systemmgmt.mapstructMapper;

import kr.co.seoulit.insa.commsvc.systemmgmt.dto.DetailCodeDTO;
import kr.co.seoulit.insa.commsvc.systemmgmt.entity.DetailCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DetailCodeMapper {
    DetailCodeMapper INSTANCE = Mappers.getMapper(DetailCodeMapper.class);

    // DetailCodeEntity -> DetailCodeDTO 매핑

    @Mapping(target = "detailCodeNumber", source = "detailCode.detailCodeNumber")
    @Mapping(target = "detailCodeName", source = "detailCode.detailCodeName")
    DetailCodeDTO entityToDetailCodeDTO(DetailCode detailCode);
}
