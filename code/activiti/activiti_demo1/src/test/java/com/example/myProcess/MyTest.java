package com.example.myProcess;

import com.example.demo.pojo.Evention;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {



    /**
     * 删除流程部署信息
     *
     * 当前流程如果没有完成，想要删除 需要特殊方式
     * 原理：级联删除
     */
    @Test
    public void deleteDeployMent(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //通过部署id删除流程部署信息
        String deploymentId="52501";
        String[] ids = {
                "67501","70001",
                "70002","72501",
                "75001","77501",
                "82501"
        };
        for (String id : ids) {
            repositoryService.deleteDeployment(id,true);
        }
        //repositoryService.deleteDeployment(deploymentId);
        //repositoryService.deleteDeployment(deploymentId,true);

    }


    //部署
    @Test
    public void testDeployment() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //部署
        Deployment deploy = repositoryService.createDeployment()
                .name("采购执行申请")
                .addClasspathResource("bpmn/prcocess1.bpmn")
                .deploy();

        //输出部署信息
        System.out.println("流程部署id：" + deploy.getId());
        System.out.println("流程部署名字：" + deploy.getName());
        System.out.println("流程定义key"+deploy.getKey());
    }


    @Test
    public void testStartProcess(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String key="Myprocess";
        //流程变量map
        Map<String,Object> variables = new HashMap<>();
        //设置任务负责人
        variables.put("id1","1");
        variables.put("id2","2");
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(key, "1",variables);

        System.out.println("流程定义id："+instance.getProcessDefinitionId());
        System.out.println("流程实例id："+instance.getId());
        System.out.println("当前活动的id："+instance.getActivityId());

    }


    /**
     * 完成任务
     */
    @Test
    public void completTask(){

        String processInstanceId="85001";
        String key="Myprocess";
        String assingee="1";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
//        Task task = taskService.createTaskQuery()
//                .processDefinitionKey(key)
//                .taskAssignee(assingee)
//                .singleResult();
        Task task = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .taskAssignee(assingee)
                .singleResult();

        Map<String,Object> map = new HashMap<>();
        map.put("result",0);
        if (task!=null){
            System.out.println(task);
            taskService.complete(task.getId(),map);
        }

    }


    @Test
    public void queryTask(){

        String processInstanceId="95001";
        String key="Myprocess";
        String assingee="1";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
//        Task task = taskService.createTaskQuery()
//                .processDefinitionKey(key)
//                .taskAssignee(assingee)
//                .singleResult();
        List<Task> tasks = taskService.createTaskQuery()
                .taskAssignee(assingee).list();
        System.out.println(tasks);


    }


    /**
     * 查看历史信息
     */
    @Test
    public void findHistoryInfo(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        HistoryService historyService = processEngine.getHistoryService();

        //获取actinst表的查询对象
        HistoricActivityInstanceQuery instanceQuery = historyService.createHistoricActivityInstanceQuery();
        //查询actinst表  条件：根据InstanceId 查询
        instanceQuery.processInstanceId("55001");
        //根据DefinitionId
        //instanceQuery.processDefinitionId("myEvention:1:7504");
        //增加排序
        instanceQuery.orderByHistoricActivityInstanceStartTime().asc();
        List<HistoricActivityInstance> activityInstanceList = instanceQuery.list();

        for (HistoricActivityInstance instance : activityInstanceList) {
            System.out.println(instance.getActivityId());
            System.out.println(instance.getActivityName());
            System.out.println(instance.getProcessInstanceId());
            System.out.println("----------------------");
        }

    }
}
