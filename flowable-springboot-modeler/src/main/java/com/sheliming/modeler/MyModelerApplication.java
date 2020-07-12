package com.sheliming.modeler;

import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.ui.modeler.properties.FlowableModelerAppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"com.sheliming.modeler", "org.flowable.ui.modeler", "org.flowable.ui.common"})
@EnableConfigurationProperties(FlowableModelerAppProperties.class)
public class MyModelerApplication {
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    public static void main(String[] args) {
        SpringApplication.run(MyModelerApplication.class, args);
    }

    @Bean
    public void test() {
        System.out.println("______test______");
        System.out.println(repositoryService);

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("test");
        System.out.println(processInstance.getId());
        List<Task> taskList = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();

        taskService.claim(taskList.get(0).getId(), "admin");

        List<Task> taskList2 = taskService.createTaskQuery().taskAssignee("admin").list();

        taskService.complete(taskList.get(0).getId());

        List<Task> taskList3 = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();

        taskService.complete(taskList3.get(0).getId());


        List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstance.getId()).list();

        //List<Task> taskList = taskService.createTaskQuery().taskUnassigned().list();
        System.out.println(taskList);
    }

}