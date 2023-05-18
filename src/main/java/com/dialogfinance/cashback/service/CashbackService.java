package com.dialogfinance.cashback.service;

import com.dialogfinance.cashback.entity.Cashback;
import com.dialogfinance.cashback.requests.CashbackRequest;

import java.util.List;

public interface CashbackService {

    List<Cashback> findAllCashback();

    Cashback findCashbackById(Long id);

    Cashback saveCashback(CashbackRequest cashbackRequest);

    Cashback updateCashback(Cashback cashbackEntity, Long id);

    void deleteCashback(Long id);


}
