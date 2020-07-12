package com.sheliming.flowable;

import org.flowable.engine.FormService;
import org.flowable.engine.TaskService;
import org.flowable.form.api.FormInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplication.class)
public class FormServiceTest {
    @Autowired
    private FormService formService;

    @Autowired
    private TaskService taskService;

    @Test
    public void test() {
        FormInfo taskFormModel = taskService.getTaskFormModel("sid-B72125FC-FFA1-4061-A8C9-586932C0D99D");
        System.out.println(taskFormModel);
    }
}
