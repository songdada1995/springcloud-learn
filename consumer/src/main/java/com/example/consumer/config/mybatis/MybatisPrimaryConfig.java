package com.example.consumer.config.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.consumer.core.Mapper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = MybatisPrimaryConfig.SCAN_PACKAGE, sqlSessionFactoryRef = "primarySqlSessionFactory")
public class MybatisPrimaryConfig {

    static final String SCAN_PACKAGE = "com.example.consumer.dao.primary";
    static final String MAPPER_LOCATION = "classpath*:mapper/primary/*.xml";
    static final String BEAN_NAME_PREFIX = "primary";
    static final String DATA_SOURCE_PROPERTIES_PREFIX = "spring.datasource.primary";

    static final String BEAN_SQL_SESSION_FACTORY_NAME = BEAN_NAME_PREFIX + "SqlSessionFactory";
    static final String BEAN_DATA_SOURCE_NAME = BEAN_NAME_PREFIX + "DataSource";
    static final String BEAN_TRANSACTION_MANAGER_NAME = BEAN_NAME_PREFIX + "TransactionManager";
    static final String BEAN_SQL_SESSION_TEMPLATE_NAME = BEAN_NAME_PREFIX + "SqlSessionTemplate";
    static final String BEAN_MAPPER_HELPER_NAME = BEAN_NAME_PREFIX + "MapperHelper";

    @Primary
    @Bean(name = BEAN_DATA_SOURCE_NAME)
    @ConfigurationProperties(prefix = DATA_SOURCE_PROPERTIES_PREFIX)
    public DruidDataSource transitDataSource() {
        return new DruidDataSource();
    }

    @Primary
    @Bean(name = BEAN_TRANSACTION_MANAGER_NAME)
    public DataSourceTransactionManager transactionManager(@Qualifier(value = BEAN_DATA_SOURCE_NAME) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = BEAN_SQL_SESSION_FACTORY_NAME)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(value = BEAN_DATA_SOURCE_NAME) DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        //????????????
        PageInterceptor pageInterceptor = new PageInterceptor();

        //?????????????????????: https://pagehelper.github.io/docs/howtouse/
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");           //??????
        properties.setProperty("rowBoundsWithCount", "true");       //?????? RowBounds ??????????????? count ??????
        properties.setProperty("reasonable", "true");               //pageNum<=0 ???????????????????????? pageNum>pages?????????????????????????????????????????????
        properties.setProperty("pageSizeZero", "true");             //?????? pageSize=0 ?????? RowBounds.limit = 0 ??????????????????????????????
        properties.setProperty("supportMethodsArguments", "true");  //???????????? Mapper ?????????????????????????????????
        properties.setProperty("offsetAsPageNum", "true");          //??? RowBounds ?????? offset ???????????? pageNum ??????

        pageInterceptor.setProperties(properties);

        //????????????
        sessionFactory.setPlugins(new Interceptor[]{pageInterceptor});

        //??????mapper location
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MybatisPrimaryConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Primary
    @Bean(name = BEAN_SQL_SESSION_TEMPLATE_NAME)
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier(value = BEAN_SQL_SESSION_FACTORY_NAME) SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = BEAN_MAPPER_HELPER_NAME)
    public MapperHelper mapperHelper(@Qualifier(value = BEAN_SQL_SESSION_FACTORY_NAME) SqlSessionFactory sqlSessionFactory) {
        MapperHelper mapperHelper = new MapperHelper();
        //????????????
        Config config = new Config();
        config.setNotEmpty(false);
        config.setIDENTITY("MYSQL");
        //??????????????????: http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3/2.Integration.md
        mapperHelper.setConfig(config);
        mapperHelper.registerMapper(Mapper.class);
        mapperHelper.processConfiguration(sqlSessionFactory.getConfiguration());

        return mapperHelper;
    }


}
