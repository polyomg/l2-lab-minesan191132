package org.example.service;

import org.example.model.Account;

public interface AccountService {
    Account findById(String username);
}
