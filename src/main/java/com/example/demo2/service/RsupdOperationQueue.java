package com.example.demo2.service;

import com.example.demo2.domain.rsupd.RsupdOperationInfo;
import com.example.demo2.domain.rsupd.RsupdOperationRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class RsupdOperationQueue {

    private final RsupdOperationRepo rsupdOperationRepo;

    @Scheduled(fixedRate = 1000 * 5)
    public void checkQueue() {
        List<RsupdOperationInfo> operations = rsupdOperationRepo.findTop10IdByProgressNullOrderByIdAsc();
        operations.forEach(operation -> {
            log.info(operation.getId());
        });
    }
}
