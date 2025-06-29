package com.example.club.crud;
import com.example.club.common.Api;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
public interface CRUDInterface<DTO> {
    DTO create(DTO dto);

    Optional<DTO> read(Long id);

    DTO update(DTO dto);

    String delete(Long id);

    Api<List<DTO>> list(Pageable pageable);
}
