package com.practice.transaction.noTransaction;

import com.practice.transaction.Account;
import com.practice.transaction.TransactionMapper;
import com.practice.transaction.Transfer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoTransactionService {

    @Autowired
    private final TransactionMapper txMapper;

    public Account getAccountById(long accountId) {
        return txMapper.getAccountById(accountId);
    }

    public Transfer transfer(long senderId, Long receiverId, long amount) {
        Transfer transfer = new Transfer().builder()
                .sender(send(senderId, amount))
                .receiver(receive(receiverId, amount))
                .build();

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
}
