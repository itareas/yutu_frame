package com.yutu.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName: DataSourceOracle
 * @Author: zhaobc
 * @Date: 2019/5/19 19:58
 * @Description: Oracle多数据源配置
 **/
//@Configuration
//@MapperScan(basePackages = "com.yutu.mapper.oracle", sqlSessionTemplateRef  = "oracleSqlSessionTemplate")
public class DataSourceOracleConfig {

    @Value("${spring.datasource.oracle.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.oracle.url}")
    private String url;

    @Value("${spring.datasource.oracle.username}")
    private String username;

    @Value("${spring.datasource.oracle.password}")
    private String password;

    //其他配置
    @Value("${spring.datasource.oracle.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.oracle.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.oracle.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.oracle.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.oracle.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.oracle.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.oracle.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.oracle.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.oracle.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.oracle.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.oracle.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.oracle.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.oracle.filters}")
    private String filters;

    @Value("${spring.datasource.oracle.connectionProperties}")
    private String connectionProperties;


    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 16:30
     * @Description: 数据源配置加载配置文件
     **/
    @Bean(name = "oracleDataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        //其他配置
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);

        return dataSource;
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 16:31
     * @Description: 创建该数据源的连接数据库工厂
     **/
    @Bean(name = "oracleSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("oracleDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/yutu/mapper/oracle/*.xml"));
        return bean.getObject();
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 16:31
     * @Description: 该数据源事务控制  用法 @Transactional(transactionManager="mySqlTransactionManager")
     **/
    @Bean(name = "oracleTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("oracleDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 16:31
     * @Description: MyBatis提供的持久层访问模板化的工具，线程安全，可通过构造参数或依赖注入SqlSessionFactory实例
     **/
    @Bean(name = "oracleSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("oracleSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
