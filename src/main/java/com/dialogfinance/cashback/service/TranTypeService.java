package com.dialogfinance.cashback.service;

import com.dialogfinance.cashback.entity.Merchant;
import com.dialogfinance.cashback.entity.TranType;
import com.dialogfinance.cashback.requests.MerchantRequest;
import com.dialogfinance.cashback.requests.TranTypeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TranTypeService {

    List<TranType> findAllTranType();

    TranType findTranTypeById(Long id);

    TranType saveTranType(TranTypeRequest tranTypeRequest);

    TranType updateTranType(TranType tranTypeEntity, Long id);

    void deleteTranType(Long id);
}
