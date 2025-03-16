package org.hj.coremodule.repository;

import org.hj.coremodule.model.domain.Wallet;

public interface WalletRepository {
    Wallet save(Wallet wallet);
}
