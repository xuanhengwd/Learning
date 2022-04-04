package com.example.test;

import com.example.demo.pojo.Evention;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestVariables {

    @Test
    public void testDeployment(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //部署
        Deployment deploy = repositoryService.createDeployment()
                .name("出差申请流程-variables")
                .addClasspathResource("bpmn/evention-global.bpmn")
                .deploy();

        //输出部署信息
        System.out.println("流程部署id："+deploy.getId());
        System.out.println("流程部署名字："+deploy.getName());
    }

    @Test
    public void testStartProcess(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String key="myProcess_1";
        //设置流程变量
        Evention evention = new Evention();
        //设置出差日期
        evention.setNum(2d);

        //流程变量map
        Map<String,Object> variables = new HashMap<>();
        variables.put("evention",evention);

        //设置任务负责人
        variables.put("assignee0","李四");
        variables.put("assignee1","王经理");
        variables.put("assignee2","杨总");
        variables.put("assignee3","张财务");


        runtimeService.startProcessInstanceByKey(key,variables);


    }

    /**
     * 完成任务
     */
    @Test
    public void completTask(){

        String key="myProcess_1";
//        String assingee="李四";
        String assingee="王经理";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(key)
                .taskAssignee(assingee)
                .singleResult();

        if (task!=null){
            taskService.complete(task.getId());
        }
    }

}
