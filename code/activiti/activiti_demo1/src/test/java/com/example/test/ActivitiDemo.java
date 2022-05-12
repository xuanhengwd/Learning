package com.example.test;

import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.zip.ZipInputStream;

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
        //3、根据流程实例的id启动流程
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

    /**
     * 完成个人任务
     */
    @Test
    public void completTask(){
        //1、获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2、获取service
        TaskService taskService = processEngine.getTaskService();
        //3、根据任务id完成任务 完成张三的任务
//        taskService.complete("5005");

        //获取jerry -MyEvention 对应的任务
/*        Task task = taskService.createTaskQuery()
                .processDefinitionKey("myEvention")
                .taskAssignee("jerry")
                .singleResult();*/
        //完成jack对应任务
/*        Task task = taskService.createTaskQuery()
                .processDefinitionKey("myEvention")
                .taskAssignee("jack")
                .singleResult();*/
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("myEvention")
                .taskAssignee("rose")
                .singleResult();

        System.out.println("流程实例id："+task.getProcessDefinitionId());
        System.out.println("任务id："+task.getId());
        System.out.println("任务负责人："+task.getAssignee());
        System.out.println("任务名称："+task.getName());
        //获取id
        String id = task.getId();
        //完成jerry任务  -》  jack  ->  rose
        taskService.complete(id);


    }

    /**
     * 使用zip包进行批量的部署
     */
    @Test
    public void deployProcessByZip(){

        //获取流程引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //获取RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //读取资源包文件 构建inputStream
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("bpmn/evention.zip");

        //用inputStream构造ZipInputStream
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        //使用压缩包的流进流程的部署
        Deployment deploy = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .deploy();

        System.out.println("流程部署id："+deploy.getId());
        System.out.println("流程部署名称："+deploy.getName());
    }


    /**
     * 查询流程定义
     */
    @Test
    public void queryProcessDefinition(){
        //获取引擎
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //获取 RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //获取ProcessDifinitionQuery对象
        ProcessDefinitionQuery definitionQuery = repositoryService.createProcessDefinitionQuery();
        //查询当前所有的流程定义,返回流程定义信息的集合
        List<ProcessDefinition> definitionList = definitionQuery.processDefinitionKey("myEvention")//流程定义的key
                .orderByProcessDefinitionVersion()//根据version排序
                .desc()//倒序
                .list();
        //输出
        for (ProcessDefinition processDefinition : definitionList) {
            System.out.println("流程定义id:"+processDefinition.getId());
            System.out.println("流程定义名称:"+processDefinition.getName());
            System.out.println("流程定义的Key:"+processDefinition.getKey());
            System.out.println("流程定义版本:"+processDefinition.getVersion());
            System.out.println("流程部署id:"+processDefinition.getDeploymentId());
        }
    }


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
        //repositoryService.deleteDeployment(deploymentId);
        repositoryService.deleteDeployment(deploymentId,true);

    }

    /**
     * 下载资源文件
     * 方案一：使用Activiti提供的api，来下载资源文件
     * 方案二：自己写代码从数据库中下载文件 使用jdbc对blob  clob 读取出来  保存到文件目录
     * 解决io操作
     * 使用方案一  RepositoryService
     */
    @Test
    public void getDeployment() throws IOException {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //获取查询对象   createProcessDefinitionQuery 查询流程定义信息
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey("myEvention").singleResult();
        //获取部署id
        String deploymentId = processDefinition.getDeploymentId();
        //获取png
        String pngName = processDefinition.getDiagramResourceName();//获取png图片的目录和名字
        InputStream pngInput = repositoryService.getResourceAsStream(deploymentId, pngName);
        //bpmn
        String bpmnName = processDefinition.getResourceName();
        InputStream bpmnInput = repositoryService.getResourceAsStream(deploymentId, bpmnName);

        //构造outputStream
        File pngFile = new File("D:\\ing\\java\\code\\bpmn\\example\\env1.png");
        File bpmnFile = new File("D:\\ing\\java\\code\\bpmn\\example\\env1.bpmn");

        FileOutputStream pngOutputS = new FileOutputStream(pngFile);
        FileOutputStream bpmnOutputS = new FileOutputStream(bpmnFile);

        //输入流，输出流转换
        IOUtils.copy(pngInput,pngOutputS);
        IOUtils.copy(bpmnInput,bpmnOutputS);

        //关闭流
        bpmnOutputS.close();
        pngOutputS.close();
        pngInput.close();
        bpmnInput.close();
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
        //instanceQuery.processInstanceId("10001");
        //根据DefinitionId
        instanceQuery.processDefinitionId("myEvention:1:7504");
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
