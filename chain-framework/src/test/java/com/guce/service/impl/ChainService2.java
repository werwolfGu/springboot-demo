package com.guce.service.impl;

import com.guce.chain.IChainService;
import com.guce.chain.anno.ChainSerivce;
import com.guce.chain.model.ChainRequest;
import com.guce.chain.model.ChainResponse;
import org.springframework.stereotype.Service;

/**
 * @Author chengen.gu
 * @DATE 2020/2/13 3:02 下午
 */
@ChainSerivce(value = "service1",order = 100)
@Service
public class ChainService2 implements IChainService {
    @Override
    public void handle(ChainRequest request, ChainResponse response) {

        System.out.println(" test chainSerive2");
    }
}
