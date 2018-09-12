package org.csu.tshirt.persistence;

import org.csu.tshirt.domain.Account;

public interface AccountDAO {
    Account getAccountByUserid(String userId);
    Account getAccountByUseridAndPassword(String userId,String password);
    void insertAccount(Account account);
    void updateAccount(Account account);
}
