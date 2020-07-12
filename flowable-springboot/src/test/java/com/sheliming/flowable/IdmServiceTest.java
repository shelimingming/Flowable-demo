package com.sheliming.flowable;

import org.flowable.idm.api.IdmIdentityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class IdmServiceTest {
    @Autowired
    private IdmIdentityService idmIdentityService;
    @Test
    public void test() {

    }
}
