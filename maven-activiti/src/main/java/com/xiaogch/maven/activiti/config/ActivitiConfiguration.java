package com.xiaogch.maven.activiti.config;


import org.activiti.engine.*;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ActivitiConfiguration {

    @Autowired
    @Qualifier("masterDataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("masterTransactionManager")
    private DataSourceTransactionManager transactionManager;

    @Bean(name="processEngine")
    public ProcessEngine getProcessEngine() throws Exception {
        SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        configuration.setTransactionManager(transactionManager);
        configuration.setDatabaseSchemaUpdate("true");
        ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
        factoryBean.setProcessEngineConfiguration(configuration);
        return factoryBean.getObject();
    }

    @Autowired
    @Qualifier("processEngine")
    @Bean(name="taskService")
    public TaskService getTaskService(ProcessEngine processEngine) {
        return processEngine.getTaskService();
    }

    @Autowired
    @Qualifier("processEngine")
    @Bean(name="historyService")
    public HistoryService getHistoryService(ProcessEngine processEngine) {
        return processEngine.getHistoryService();
    }

    @Autowired
    @Qualifier("processEngine")
    @Bean(name="repositoryService")
    public RepositoryService getRepositoryService(ProcessEngine processEngine) {
        return processEngine.getRepositoryService();
    }

    @Autowired
    @Qualifier("processEngine")
    @Bean(name="runtimeService")
    public RuntimeService getRuntimeService(ProcessEngine processEngine) {
        return processEngine.getRuntimeService();
    }

    @Autowired
    @Qualifier("processEngine")
    @Bean(name="dynamicBpmnService")
    public DynamicBpmnService getDynamicBpmnService(ProcessEngine processEngine) {
        return processEngine.getDynamicBpmnService();
    }

    @Autowired
    @Qualifier("processEngine")
    @Bean(name="identityService")
    public IdentityService getIdentityService(ProcessEngine processEngine) {
        return processEngine.getIdentityService();
    }
}
