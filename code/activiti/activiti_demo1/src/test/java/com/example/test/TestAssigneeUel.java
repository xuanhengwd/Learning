package com.example.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestAssigneeUel {

    /**
     * 部署流程
     */
    @Test
    public void testDeployment(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //部署
        Deployment deploy = repositoryService.createDeployment()
                .name("出差申请流程-uel")
                .addClasspathResource("bpmn/evention-uel.bpmn")
                .deploy();

        //输出部署信息
        System.out.println("流程部署id："+deploy.getId());
        System.out.println("流程部署名字："+deploy.getName());
    }

    /**
     * 启动
     */
    @Test
    public void startAssigneeUel(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();


        //设定负责人的值，用来替换uel表达式
        Map<String,Object> assigneeMap = new HashMap<>();
        assigneeMap.put("assignee0","张三");
        assigneeMap.put("assignee1","李经理");
        assigneeMap.put("assignee2","王总");
        assigneeMap.put("assignee3","赵财务");
        //启动流程实例
        runtimeService.startProcessInstanceByKey("myEvention1",assigneeMap);


    }
}
