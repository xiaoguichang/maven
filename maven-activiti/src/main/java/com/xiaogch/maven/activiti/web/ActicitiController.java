package com.xiaogch.maven.activiti.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaogch.maven.activiti.web.request.ActivitiPublishRequest;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class ActicitiController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RepositoryService repositoryService;

    private static final String RESULT_CODE = "result_code";
    private static final int RESULT_CODE_SUCCESS = 0;
    private static final int RESULT_CODE_FAILURE = -1;
    private static final String RESULT_MSG = "result_msg";

    @RequestMapping("deploy.do")
    public String deploy(HttpServletRequest httpRequest , HttpServletResponse httpResponse ,
                          @Valid ActivitiPublishRequest activitiPublishRequest , Errors error) {
        logger.info("deploy proccess , {}" , activitiPublishRequest);
        JSONObject responseJson = new JSONObject();
        if (error.hasErrors())  {
            responseJson.put(RESULT_CODE , RESULT_CODE_FAILURE);
            responseJson.put(RESULT_MSG , error.getAllErrors().get(0).getDefaultMessage());
        } else {
            try {
                repositoryService.createDeployment()
                        .addClasspathResource(activitiPublishRequest.getProccessPath())
                        .deploy();
                logger.info("deploy proccess {} success , the number proccess in system is {}" ,
                        activitiPublishRequest.getProccessPath() , repositoryService.createProcessDefinitionQuery().count());
                responseJson.put(RESULT_CODE , RESULT_CODE_SUCCESS);
                responseJson.put(RESULT_MSG , "deploy activiti proccess success");
            } catch (Exception e) {
                logger.error("deploy activiti proccess exception " , e);
                responseJson.put(RESULT_CODE , RESULT_CODE_FAILURE);
                responseJson.put(RESULT_MSG , "deploy activiti proccess failure");
            }
        }
        return responseJson.toJSONString();
    }
}
