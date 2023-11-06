package com.example.subsub.MapStruct;

import com.example.subsub.domain.Subject;
import com.example.subsub.dto.SubjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
   SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

   @Mapping(source = "userId.userId", target = "userId")
   SubjectDTO toDto(Subject entity);

   @Mapping(source = "userId", target = "userId.userId")
   Subject toEntity(SubjectDTO dto);

}
