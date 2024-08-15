package com.stajokulu.stajcell.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceDto {

    private BalanceType kind;

    private Double amount;
}
