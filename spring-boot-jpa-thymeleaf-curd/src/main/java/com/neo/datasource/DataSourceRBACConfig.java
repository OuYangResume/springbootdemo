package com.neo.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author :Administrator
 * @Date:Created by 11:00 on 2018/6/11.
 * @Description: 添加rbac的数据源
 */
@Configuration
@MapperScan(basePackages = "com.neo.mapper.rbac",sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class DataSourceRBACConfig {
    /**
     *@Description:根据配置文件生成对应的数据源
     */
    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")

    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }
    /**
     *@Description:通过工厂把数据源注入
     */
    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //指定dao对应的xml的路径，这样可以动态加载，解耦和
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/rbac/*.xml"));
        return bean.getObject();
    }
//    /**
//     *@Description:给指定数据源加载上事物
//     */
//    @Bean(name = "test2TransactionManager")
//
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
    /**
     *@Description:把工厂放入template模板中
     */
    @Bean(name = "test2SqlSessionTemplate")

    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
