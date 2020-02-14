package com.guce.chain.model;

import com.guce.chain.IChainService;
import com.guce.chain.anno.ChainService;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author chengen.gu
 * @DATE 2020/2/14 1:49 下午
 */
public class ChainExecServiceWrapper {

    /**
     * 执行service
     */
    @Getter
    @Setter
    private IChainService chainService;
    /**
     * 执行chainResourceName
     */
    @Getter
    private String chainResourceName ;

    /**
     * 执行顺序
     */
    @Getter
    private int order;

    /**
     * 是否异步
     */
    @Getter
    private boolean isAsync;

    /**
     * 异步超时时间
     */
    @Getter
    private long asyncTimeout;


    public ChainExecServiceWrapper annoParamWrapper(ChainService anno){
        this.chainResourceName = anno.value();
        this.order = anno.order();
        this.isAsync = anno.isAsync();
        this.asyncTimeout = anno.asyncTimeout();
        return this;
    }

    @Override
    public String  toString(){

        return "{chainSerivce:" + chainService
                + ",chainResourceName:" + chainResourceName
                + ",order:" + order
                + ", isAsync:" + isAsync
                + ", asyncTimeout:" + asyncTimeout + "}";
    }
}