package com.guce;

import com.guce.chain.IChainService;
import com.guce.chain.executor.ChainExecutor;
import com.guce.spring.SpringContextBean;
import com.guce.spring.bootstrap.SpringbootStartup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author chengen.gu
 * @DATE 2020/2/13 2:56 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringbootStartup.class})// 指定启动类
public class SpringBootstrapTest {

    @Autowired
    private ChainExecutor chainExecutor ;

    @Test
    public void test(){
        String[] name = SpringContextBean.getBeanNamesForType(IChainService.class);
        System.out.println(name);

        chainExecutor.execute("service1",null,null);

    }
}
