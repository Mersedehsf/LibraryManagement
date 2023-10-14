package org.example.Library.mapper;

import org.example.Library.model.dto.BaseDto;
import org.example.Library.model.entity.BaseEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;



@MapperConfig(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG)
public interface BaseMapper<E extends BaseEntity, ResDto extends BaseDto, ReqDto extends BaseDto> {


    public E dtoToEntity(ReqDto dto);

    public ResDto entityToDto(E entity);

}

