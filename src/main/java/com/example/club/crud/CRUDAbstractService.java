package com.example.club.crud;

import com.example.club.common.Api;
import com.example.club.common.Pagination;
import com.example.club.user.db.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CRUDAbstractService<DTO, ENTITY> implements CRUDInterface<DTO> {
    @Autowired(required = false)
    private JpaRepository<ENTITY, Long> jpaRepository;

    @Autowired(required = false)
    private Converter<DTO, ENTITY> converter;

    @Override
    public DTO create(DTO dto) {

        var entity = converter.toEntity(dto);
        jpaRepository.save(entity);
        var returnDTO = converter.toDto(entity);

        return returnDTO;
    }

    @Override
    public Optional<DTO> read(Long id) {
        var entity = jpaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("해당 유저가 없습니다. : " + id));

        var dto = converter.toDto(entity);

        return Optional.ofNullable(dto);
    }

    @Override
    public DTO update(DTO dto) {
        var id = converter.getId(dto);

        var existEntity = jpaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("해당 유저가 없습니다. : " + id));


        var newEntity = converter.updateEntity(existEntity, dto);
        jpaRepository.save(newEntity);

        var returnDTO = converter.toDto(newEntity);
        return returnDTO;
    }

    @Override
    public String delete(Long id) {
        jpaRepository.deleteById(id);
        return "Deleted Success";
    }

    @Override
    public Api<List<DTO>> list(Pageable pageable) {
        var list = jpaRepository.findAll(pageable);

        var pagination = Pagination.builder()
            .page(list.getNumber())
            .size(list.getSize())
            .currentElements(list.getNumberOfElements())
            .totalElements(list.getTotalElements())
            .totalPage(list.getTotalPages())
            .build()
            ;

        var dtoList = list.stream()
            .map(it -> converter.toDto(it))
            .toList();

        var response = Api.<List<DTO>>builder()
            .body(dtoList)
            .pagination(pagination)
            .build();

        return response;
    }
}
