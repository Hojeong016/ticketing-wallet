package org.hj.coremodule.repository;

import org.hj.coremodule.model.domain.Wallet;

public interface WalletRepository {
    Wallet findById(Long id);
    Wallet save(Wallet wallet);
}
