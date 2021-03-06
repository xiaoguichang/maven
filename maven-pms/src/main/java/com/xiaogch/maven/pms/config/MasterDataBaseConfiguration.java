package com.xiaogch.maven.pms.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@Configuration
@MapperScan(basePackages = "com.xiaogch.maven.*.dao.scan" , sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataBaseConfiguration {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${db.master.url}")
    private String url;
    @Value("${db.master.username}")
    private String username;
    @Value("${db.master.password}")
    private String password;

    @Value("${db.master.maxActive:100}")
    private int maxActive;

    @Value("${db.master.initialSize:10}")
    private int initialSize;

    @Value("${db.master.maxWait:6000}")
    private int maxWait;

    @Value("${db.master.minIdle:10}")
    private int minIdle;

    @Value("${mybatis.mapper.loactions}")
    private String mapperLoactions;


    @Bean(name = "masterDataSource")
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        return druidDataSource;
    }

    @Autowired
    @Qualifier("masterDataSource")
    @Bean(name = "masterTransactionManager")
    public DataSourceTransactionManager getTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Autowired
    @Qualifier("masterDataSource")
    @Bean(name="masterSqlSessionFactory")
    public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources(mapperLoactions);
        if (logger.isDebugEnabled()) {
            logger.debug("resources size is {}" , resources == null ? "0" : resources.length);
            if (resources != null) {
                for (Resource resource : resources) {
                    if (logger.isDebugEnabled()) {
                        logger.debug("resource info is {}" , resource.getURL());
                    }
                }
            }
        }
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean.getObject();
    }

    @Autowired
    @Qualifier("masterSqlSessionFactory")
    @Bean(name="sqlSessionTemplate")
    public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
