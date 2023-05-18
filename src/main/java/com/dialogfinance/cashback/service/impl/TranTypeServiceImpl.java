package com.dialogfinance.cashback.service.impl;


import com.dialogfinance.cashback.entity.TranType;
import com.dialogfinance.cashback.repository.TranTypeRepository;
import com.dialogfinance.cashback.requests.TranTypeRequest;
import com.dialogfinance.cashback.service.TranTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranTypeServiceImpl implements TranTypeService {


    private final TranTypeRepository tranTypeRepository;

    public TranTypeServiceImpl(TranTypeRepository tranTypeRepository) {
        this.tranTypeRepository = tranTypeRepository;
    }

    @Override
    public List<TranType> findAllTranType() {
        return tranTypeRepository.findAll();
    }

    @Override
    public TranType findTranTypeById(Long id) {
        TranType tranTypeEntity = tranTypeRepository.findById(id).get();
        return tranTypeEntity;
    }

    @Override
    public TranType saveTranType(TranTypeRequest tranTypeRequest) {

        TranType tranType = new TranType();
        tranType.setId(tranTypeRequest.getId());
        tranType.setTranTypeId(tranTypeRequest.getTranTypeId());
        tranType.setTypeName(tranTypeRequest.getTypeName());
        return tranTypeRepository.save(tranType);
    }

    @Override
    public TranType updateTranType(TranType tranTypeEntity, Long id){

        return null;
    }

    @Override
    public void deleteTranType(Long id) {
        tranTypeRepository.deleteById(id);
    }
}



