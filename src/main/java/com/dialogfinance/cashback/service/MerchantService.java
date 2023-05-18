package com.dialogfinance.cashback.service;


import com.dialogfinance.cashback.entity.Merchant;
import com.dialogfinance.cashback.requests.MerchantRequest;

import java.util.List;

public interface MerchantService {

    List<Merchant> findAllMerchant();
    Merchant findMerchantById(Long id);
    Merchant saveMerchant(MerchantRequest merchantRequest);
    Merchant updateMerchant(Merchant merchantEntity, Long id);
    void deleteMerchant(Long id);
}
