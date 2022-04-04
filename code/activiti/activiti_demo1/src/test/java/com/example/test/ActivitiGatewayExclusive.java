package com.example.test;

import com.example.demo.pojo.Evention;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ActivitiGatewayExclusive {
    /**
     * 流程部署
     */
    @Test
    public void testDeployment(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //部署
        Deployment deploy = repositoryService.createDeployment()
                .name("出差申请流程-排他网关")
                .addClasspathResource("bpmn/evention-exclusive.bpmn")
                //.addClasspathResource(".png")
                .deploy();

        //输出部署信息
        System.out.println("流程部署id："+deploy.getId());
        System.out.println("流程部署名字："+deploy.getName());
    }

    @Test
    public void testStartProcess(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String key="exclusive";
        //设置流程变量
        Evention evention = new Evention();
        //设置出差日期
        evention.setNum(2d);

        //流程变量map
        Map<String,Object> map = new HashMap<>();
        map.put("evention",evention);

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, map);

        System.out.println("流程实例名称："+processInstance.getName());
        System.out.println("流程实例id"+processInstance.getProcessInstanceId());


    }

    /**
     * 完成任务
     */
    @Test
    public void completTask(){

        String key="exclusive";
        //String assingee="李四";
        String assingee="李财务";
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
