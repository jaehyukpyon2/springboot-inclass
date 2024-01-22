package com.practice.transaction;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {
    private long id;
    private String name;
    private long balance;

    @Builder
    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
    }
}
