package org.example.Library.mapper;

import org.example.Library.model.dto.Request.BorrowRRequestDto;
import org.example.Library.model.dto.Response.BorrowResponseDto;
import org.example.Library.model.entity.BorrowEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",builder = @Builder(disableBuilder = true))

public interface BorrowMapper extends BaseMapper<BorrowEntity, BorrowResponseDto, BorrowRRequestDto>{
}
