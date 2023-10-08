package com.example.demo2.domain.rsupd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "operation", schema = "rsupd")
@NoArgsConstructor
public class RsupdOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tip_op")
    private String tipOp;

    private String enp;
    private String fam;
    private String im;
    private String ot;
    private LocalDate dr;
    private Integer gender;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private LocalDateTime progress;

    @Column(name = "processed_at")
    private LocalDateTime processedAt;

    private String result;

    @OneToMany(mappedBy = "rsupdOperation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<RsupdUdl> rsupdUdlSet = new HashSet<>();

}
