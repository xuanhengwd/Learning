package com.example.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestListener {
    @Test
    public void testDeployment(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //部署
        Deployment deploy = repositoryService.createDeployment()
                .name("测试监听器")
                .addClasspathResource("bpmn/demo-listen.bpmn")
                .deploy();

        //输出部署信息
        System.out.println("流程部署id："+deploy.getId());
        System.out.println("流程部署名字："+deploy.getName());
    }

    @Test
    public void startAssigneeUel(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //启动流程实例
        runtimeService.startProcessInstanceByKey("testListener");


    }

}
