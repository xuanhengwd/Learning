package com.example.test;

import com.example.demo.pojo.Evention;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试任务完成时 添加流程变量
 */
public class TestVariables2Complete {

    @Test
    public void testDeployment(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //部署
        Deployment deploy = repositoryService.createDeployment()
                .name("出差申请流程-variables2-complete")
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
//        Evention evention = new Evention();
//        //设置出差日期
//        evention.setNum(3d);
//
//        //流程变量map
        Map<String,Object> variables = new HashMap<>();
//        variables.put("evention",evention);

        //设置任务负责人
        variables.put("assignee0","李四3");
        variables.put("assignee1","王经理3");
        variables.put("assignee2","杨总3");
        variables.put("assignee3","张财务3");


        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, variables);
        System.out.println(processInstance.getId());


    }

    /**
     * 完成任务
     */
    @Test
    public void completTask(){

        String key="myProcess_1";
        //String assingee="李四3";
        String assingee="王经理3";
        //String assingee="杨总1";
        Evention evention = new Evention();
        evention.setNum(2d);
        Map<String,Object> map = new HashMap<>();
        map.put("evention",evention);

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .processDefinitionKey(key)
                .taskAssignee(assingee)
                .singleResult();

        if (task!=null){
            //根据id完成任务 并完成流程变量
            taskService.complete(task.getId(),map);
            System.out.println(task.getId()+"任务已经完成");
        }
    }

}
