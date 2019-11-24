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
 * @ClassName: DataSourceSqlServer
 * @Author: zhaobc
 * @Date: 2019/5/19 19:57
 * @Description: sqlServer多数据源配置
 **/
//@Configuration
//@MapperScan(basePackages = "com.yutu.mapper.sqlserver", sqlSessionTemplateRef  = "sqlServerSqlSessionTemplate")
public class DataSourceSqlServerConfig {

    @Value("${spring.datasource.sqlserver.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.sqlserver.url}")
    private String url;

    @Value("${spring.datasource.sqlserver.username}")
    private String username;

    @Value("${spring.datasource.sqlserver.password}")
    private String password;

    //其他配置
    @Value("${spring.datasource.sqlserver.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.sqlserver.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.sqlserver.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.sqlserver.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.sqlserver.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.sqlserver.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.sqlserver.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.sqlserver.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.sqlserver.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.sqlserver.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.sqlserver.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.sqlserver.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.sqlserver.filters}")
    private String filters;

    @Value("${spring.datasource.sqlserver.connectionProperties}")
    private String connectionProperties;


    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 16:32
     * @Description: 数据源配置加载配置文件
     **/
    @Bean(name = "sqlServerDataSource")
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
     * @Date: 2019/6/20 16:32
     * @Description: 创建该数据源的连接数据库工厂
     **/
    @Bean(name = "sqlServerSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("sqlServerDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/yutu/mapper/sqlserver/*.xml"));
        return bean.getObject();
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 16:32
     * @Description: 该数据源事务控制  用法 @Transactional(transactionManager="mySqlTransactionManager")
     **/
    @Bean(name = "sqlServerTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("sqlServerDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * @Author: zhaobc
     * @Date: 2019/6/20 16:33
     * @Description: MyBatis提供的持久层访问模板化的工具，线程安全，可通过构造参数或依赖注入SqlSessionFactory实例
     **/
    @Bean(name = "sqlServerSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlServerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
