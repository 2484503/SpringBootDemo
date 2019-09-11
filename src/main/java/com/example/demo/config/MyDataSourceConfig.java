package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据库配置
 *
 * @author lijn
 * @version 1.0
 * @date 2019/8/9 09:39
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.mapper",sqlSessionFactoryRef = "myDataSourceSqlSessionFactory")
public class MyDataSourceConfig {

    @Bean("myDataSourceSqlSessionFactory")
    public SqlSessionFactory myDataSourceSqlSessionFactory(
            @Qualifier("druid") DataSource dataSource
    ) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "myDataSourceTransactionManager")//配置事务
    public DataSourceTransactionManager testTransactionManager(@Qualifier("druid") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "myDataSourceSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("myDataSourceSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
