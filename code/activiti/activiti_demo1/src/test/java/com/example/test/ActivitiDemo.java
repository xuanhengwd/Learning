package com.example.test;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

public class ActivitiDemo {

    /**
     * 测试流程部署
     *
     * ACT_RE_DEPLOYMENT  流程部署表  每部署一次都会增加一条记录
     * ACT_RE_PROCDEF 流程定义表
     * ACT_GE_BYTEARRAY 流程资源表
     */

    @Test
    public void testDeployment(){
        //1、创建ProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2、获取RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3、使用service流程的部署，定义一个流程的名字 把bpmn和png部署到数据库
        Deployment deploy = repositoryService.createDeployment()
                .name("出差申请流程")
                .addClasspathResource("bpmn/evention.bpmn")
                .addClasspathResource("bpmn/evention.png")
                .deploy();

        System.out.println("流程部署id"+deploy.getId());
        System.out.println("流程部署名字"+deploy.getName());

    }


    /**
     * 启动流程实例
     * ACT_HI_ACTINST 流程实例执行历史
     * ACT_RU_IDENTITYLINK 流程参与者的历史信息
     * ACT_HI_PROCINST 流程实例的历史信息
     * ACT_HI_TASKINST 任务的历史信息
     * ACT_RU_EXECUTION 流程的执行信息
     * ACT_HI_IDENTITYLINK 流程参与者信息
     * ACT_RU_TASK 任务信息
     */
    @Test
    public void testStartProcess(){
        //1、获取ProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2、获取RunTimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3、根据流程定义的id启动流程
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("myEvention");
        //4、输出内容
        System.out.println("流程定义id："+instance.getProcessDefinitionId());
        System.out.println("流程实例id："+instance.getId());
        System.out.println("当前活动的id："+instance.getActivityId());

    }

    /**
     * 查询个人待执行的任务
     */
    @Test
    public void testFindPersonTastList(){
        //1、获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2、获取taskService
        TaskService taskService = processEngine.getTaskService();
        //3、根据流程key和任务负责人查询任务
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("myEvention")//流程key
                .taskAssignee("zhangsan")//要查询的负责人
                .list();
        //4、输出
        for (Task task : list) {
            System.out.println("流程实例id："+task.getProcessDefinitionId());
            System.out.println("任务id："+task.getId());
            System.out.println("任务负责人："+task.getAssignee());
            System.out.println("任务名称："+task.getName());
        }
    }
    

}
