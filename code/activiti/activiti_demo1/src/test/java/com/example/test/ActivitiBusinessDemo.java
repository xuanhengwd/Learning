package com.example.test;

import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class ActivitiBusinessDemo {


    /**
     * 添加业务key  到Aciviti表
     */
    @Test
    public void addBusinessKey(){
        //1、获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2、获取RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3、启动流程的过程中，添加businesskey
        //第一个参数 流程定义的ley    第二个参数 businessKey 出差申请单的id  1001
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("myEvention", "1001");

        System.out.println(instance.getBusinessKey());
    }

    /**
     * 全部流程实例的 挂起 和 激活
     */
    @Test
    public void suspendAllProcessInstance(){
        //1、获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2、获取RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3、查询流程定义 获取流程定义查询的对象
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("myEvention")
                .singleResult();
        //4、获取当前流程定义的实例 是否都是挂起的状态

        boolean suspended = processDefinition.isSuspended();
        //5、获取流程定义的id
        String id = processDefinition.getId();
        //6、如果挂起状态，改为激活
        if(suspended){
            //参数1：流程定义id  参数2：是否激活   参数3：激活时间
            repositoryService.activateProcessDefinitionById(id,true,null);
            System.out.println("流程定义id："+id+",已激活");
        }
        //7、如果激活 改为挂起
        else{
            repositoryService.suspendProcessDefinitionById(id,true,null );
            System.out.println("流程定义id："+id+",已挂起");
        }
    }

    /**
     * 挂起或激活单个流程实例
     */
    @Test
    public void suspendSingleProcessInstance(){
        //1、获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2、获取RuntimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3、获取流程实例对象
        ProcessInstance instance = runtimeService.createProcessInstanceQuery()
                .processInstanceId("12501")
                .singleResult();
        //4、得到当前流程实例的暂停状态
        boolean suspended = instance.isSuspended();
        //5、获取流程实例id
        String id = instance.getId();
        //6、判断是否暂停 暂停-》激活
        if (suspended){
            runtimeService.activateProcessInstanceById(id);
            System.out.println("流程实例id："+id+",已激活");
        }
        //7、激活-》暂停
        else {
            runtimeService.suspendProcessInstanceById(id);
            System.out.println("流程实例id："+id+",以挂起");
        }
    }

    /**
     * 完成个人任务
     */
    @Test
    public void completTask(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();

        Task task = taskService.createTaskQuery()
                .processInstanceId("12501")
                .taskAssignee("zhangsan")
                .singleResult();

        System.out.println("流程实例id："+task.getProcessInstanceId());
        System.out.println("任务id："+task.getId());
        System.out.println("任务负责人："+task.getAssignee());
        System.out.println("任务名称："+task.getName());

        String id = task.getId();

        taskService.complete(id);


    }
}
