package com.example.demo2.service;

import com.example.demo2.domain.rsupd.RsupdOperation;
import com.example.demo2.domain.rsupd.RsupdUdl;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;

@Service
public class RsupdOperationFakerService {

    private final Faker faker;

    public RsupdOperationFakerService() {
        faker = new Faker(new Locale("en-GB"), new RandomService());
    }

    public RsupdOperation generateRsupdOperation() {
        RsupdOperation op = new RsupdOperation();

        op.setTipOp(faker.options().option("П010", "П025", "П031", "П032", "П040", "П061", "П062"));
        op.setFam(faker.name().lastName());
        op.setIm(faker.name().firstName());
        op.setOt(faker.name().lastName());
        op.setDr(faker.date().birthday().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
        op.setGender(faker.options().option(1, 2));
        op.setEnp(faker.number().digits(16));
        op.setCreatedAt(LocalDateTime.now());

        for (int i = 0; i < 2; i++) {
            RsupdUdl udl1 = new RsupdUdl();
            udl1.setType(faker.options().option(3, 9, 11, 14, 24));
            udl1.setDocSer(faker.number().digits(4));
            udl1.setDocNum(faker.number().digits(6));
            udl1.setDocDate(faker.date().past(365, TimeUnit.DAYS).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
            udl1.setRsupdOperation(op);
            op.getRsupdUdlSet().add(udl1);
        }

        return op;
    }
}
