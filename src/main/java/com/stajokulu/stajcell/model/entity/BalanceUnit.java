package com.stajokulu.stajcell.model.entity;

import com.stajokulu.stajcell.model.BalanceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BalanceUnit {
    @Id
    @GeneratedValue
    private Long id;

    private BalanceType kind;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "number")
    private MobileLine mobileLine;
}
