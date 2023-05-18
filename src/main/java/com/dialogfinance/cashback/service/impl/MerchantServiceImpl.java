package com.dialogfinance.cashback.service.impl;

import com.dialogfinance.cashback.entity.Customer;
import com.dialogfinance.cashback.entity.Merchant;
import com.dialogfinance.cashback.repository.MerchantRepository;
import com.dialogfinance.cashback.requests.CustomerRequest;
import com.dialogfinance.cashback.requests.MerchantRequest;
import com.dialogfinance.cashback.service.MerchantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MerchantService")
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public List<Merchant> findAllMerchant() {
        return merchantRepository.findAll();
    }

    @Override
    public Merchant findMerchantById(Long id) {
        Merchant merchantEntityss = merchantRepository.findById(id).get();
        return merchantEntityss;
    }

    @Override
    public Merchant saveMerchant(MerchantRequest merchantRequest) {
        Merchant merchant = new Merchant();
        merchant.setId(merchantRequest.getId());
        merchant.setMid(merchantRequest.getMid());
        merchant.setDelFlag(merchantRequest.getDelFlag());
        merchant.setStatus(merchantRequest.getStatus());
        merchant.setCashbackId(merchantRequest.getCashbackId());
        return merchantRepository.save(merchant);
    }


    @Override
    public Merchant updateMerchant(Merchant merchantEntity, Long id) {
        return null;
    }

    @Override
    public void deleteMerchant(Long id) {
        merchantRepository.deleteById(id);
    }
}
