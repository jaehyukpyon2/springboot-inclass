package com.practice.transaction.txAnnotation;

import com.practice.transaction.Account;
import com.practice.transaction.TransactionMapper;
import com.practice.transaction.Transfer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionAnnotationService {

    @Autowired
    private final TransactionMapper txMapper;

    public Account getAccountById(long accountId) {
        return txMapper.getAccountById(accountId);
    }

    @Transactional(rollbackFor = Exception.class)
    public Transfer transfer(long senderId, Long receiverId, long amount) throws ClassNotFoundException {
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

    private Account receive(Long receiverId, Long amount) throws ClassNotFoundException {
        if (900L == receiverId) {
            throw new NullPointerException();
        }

        if (901L == receiverId) {
            throw new ClassNotFoundException();
        }

        Account receiver = txMapper.getAccountById(receiverId);
        receiver.setBalance(receiver.getBalance() + amount);

        txMapper.updateAccountBalance(receiver);
        return receiver;
    }
}
