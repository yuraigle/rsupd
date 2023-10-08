package com.example.demo2.controller;

import com.example.demo2.domain.rsupd.RsupdOperation;
import com.example.demo2.domain.rsupd.RsupdOperationRepo;
import com.example.demo2.service.RsupdOperationFakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RsupdOperationController {

    private final RsupdOperationFakerService opFakerService;
    private final RsupdOperationRepo rsupdOperationRepo;

    @PostMapping("/op/fill100")
    public String fill100() {
        List<RsupdOperation> ops = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            RsupdOperation op = opFakerService.generateRsupdOperation();
            ops.add(op);
        }

        rsupdOperationRepo.saveAll(ops);

        return "100";
    }
}
