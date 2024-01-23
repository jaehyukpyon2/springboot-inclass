package com.practice.transaction.txManager;

import com.practice.transaction.Account;
import com.practice.transaction.TransactionMapper;
import com.practice.transaction.Transfer;
import com.practice.transaction.noTransaction.NoTransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionManagerServiceTest {

    private Long SENDER_ID = 1L;
    private Long RECEIVER_ID = 2L;
    private Long AMOUNT = 5_000L;

    @Autowired
    private TransactionManagerService service;

    @Autowired
    private TransactionMapper mapper;

    //@BeforeEach
    void before() {
        Account sender = service.getAccountById(SENDER_ID);
        Account receiver = service.getAccountById(RECEIVER_ID);
        sender.setBalance(10_000L);
        receiver.setBalance(0L);
        mapper.updateAccountBalance(sender);
        mapper.updateAccountBalance(receiver);
    }

    @DisplayName(value = "이체 테스트 001: 정상 이체")
    @Test
    void testTransfer_001() {
        Transfer transfer = service.transfer(SENDER_ID, RECEIVER_ID, AMOUNT);
        assertEquals(5_000L, transfer.getSender().getBalance());
        assertEquals(5_000L, transfer.getReceiver().getBalance());
    }

    @DisplayName(value = "이체 테스트 002: 잘못된 id로 이체")
    @Test
    void testTransfer_002() {
//        Exception e = assertThrows(Exception.class, () -> {
//            Transfer transfer = service.transfer(SENDER_ID, 901L, AMOUNT);
//        });
//        assertEquals(e.getClass().getSimpleName(), "BadSqlGrammarException");
        assertEquals(10_000L, service.getAccountById(SENDER_ID).getBalance());
        assertEquals(0L, service.getAccountById(RECEIVER_ID).getBalance());
    }

    @DisplayName(value = "mytest")
    @Test
    void test1() {
        service.makeException();
    }
}