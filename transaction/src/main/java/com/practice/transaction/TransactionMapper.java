package com.practice.transaction;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionMapper {
    Account getAccountById(long accountId);

    Account getAccountByIdWrongSql(long accountId);

    void updateAccountBalance(Account account);

    int insertAccount(Account user);
}
