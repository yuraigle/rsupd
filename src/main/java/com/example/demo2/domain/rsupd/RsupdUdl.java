package com.example.demo2.domain.rsupd;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(schema = "rsupd", name = "udl")
@NoArgsConstructor
public class RsupdUdl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer type;

    @Column(name = "docser")
    private String docSer;

    @Column(name = "docnum")
    private String docNum;

    private LocalDate docDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_id")
    private RsupdOperation rsupdOperation;
}
