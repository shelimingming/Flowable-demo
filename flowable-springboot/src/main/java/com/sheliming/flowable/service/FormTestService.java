package com.sheliming.flowable.service;

import org.flowable.engine.FormService;
import org.flowable.engine.TaskService;
import org.flowable.form.api.FormInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormTestService {
    @Autowired
    private FormService formService;

    @Autowired
    private TaskService taskService;

    public void test() {
        FormInfo taskFormModel = taskService.getTaskFormModel("sid-B72125FC-FFA1-4061-A8C9-586932C0D99D");
    }
}
