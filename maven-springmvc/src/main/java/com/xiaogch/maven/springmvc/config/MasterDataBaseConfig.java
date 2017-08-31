package com.xiaogch.maven.springmvc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@Configuration
@MapperScan(basePackages = "com.xiaogch.maven.springmvc.dao" , sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataBaseConfig {

    @Value("${master.db.url}")
    private String url;
    @Value("${master.db.username}")
    private String username;
    @Value("${master.db.password}")
    private String password;

    @Value("${master.db.maxActive:100}")
    private int maxActive;

    @Value("${master.db.initialSize:10}")
    private int initialSize;

    @Value("${master.db.maxWait:6000}")
    private int maxWait;

    @Value("${master.db.minIdle:10}")
    private int minIdle;

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
        return sqlSessionFactoryBean.getObject();
    }
}
