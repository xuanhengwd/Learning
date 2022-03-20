package com.example.test;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

public class TestCreate {

    /**
     * 使用activiti提供的默认方式来创建mysql的表
     */
    @Test
    public void testCreateDbTale(){
        //需要activiti提供的工具类
        //getDefaultProcessEngine 会默认从resource下读取名字为activiti.cfg.xml的文件
        //创建processEngine时会创建mysql表
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //自定义方式  配置文件可以自定义  bean也可以自定义
        ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml",
                        "processEngineConfiguration");
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();


        System.out.println(processEngine);
    }
}
