package com.example.demo2.domain.rsupd;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RsupdOperationRepo extends JpaRepository<RsupdOperation, Long> {
    List<RsupdOperationInfo> findTop10IdByProgressNullOrderByIdAsc();

}
