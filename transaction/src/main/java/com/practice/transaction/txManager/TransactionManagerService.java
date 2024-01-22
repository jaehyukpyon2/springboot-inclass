package com.practice.transaction.txManager;

import com.practice.transaction.Account;
import com.practice.transaction.TransactionMapper;
import com.practice.transaction.Transfer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionManagerService {

    @Autowired
    private final TransactionMapper txMapper;

    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    private TransactionDefinition txDefinition;

    public Account getAccountById(long accountId) {
        return txMapper.getAccountById(accountId);
    }

    public Transfer transfer(long senderId, Long receiverId, long amount) {
        TransactionStatus status = txManager.getTransaction(txDefinition);

        Transfer transfer = null;

        try {
            transfer = new Transfer().builder()
                    .sender(send(senderId, amount))
                    .receiver(receive(receiverId, amount))
                    .build();
            txManager.commit(status);
        } catch (Exception e) {
            log.error("Transaction Error", e);
            txManager.rollback(status);
        }
        return transfer;
    }

    private Account send(Long senderId, Long amount) {
        Account sender = txMapper.getAccountById(senderId);
        sender.setBalance(sender.getBalance() - amount);

        txMapper.updateAccountBalance(sender);

        return sender;
    }

    private Account receive(Long receiverId, Long amount) {

        if (901L == receiverId) {
            Account receiver = txMapper.getAccountByIdWrongSql(receiverId);
        }
        Account receiver = txMapper.getAccountById(receiverId);
        receiver.setBalance(receiver.getBalance() + amount);

        txMapper.updateAccountBalance(receiver);
        return receiver;
    }

    public void makeException() {
        TransactionStatus status = txManager.getTransaction(txDefinition);
        try {
            txMapper.insertNewAcc();
            //throwException_1();
            throwException_2();
            //txManager.commit(status);
        } catch (Exception e) {
            log.error("error!!", e);
            //txManager.rollback(status);
        }
        txManager.commit(status);
    }

    public void throwException_1() {
        throw new RuntimeException();
    }

    public void throwException_2() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }
}
