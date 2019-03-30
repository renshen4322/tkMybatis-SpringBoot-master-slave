package cn.mmooo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    private DataSource defaultTargetDataSource;
    private Map<String, DataSource> targetDataSources;

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<String, DataSource> targetDataSources) {
        this.defaultTargetDataSource = defaultTargetDataSource;
        this.targetDataSources = targetDataSources;
    }


    /**
     * 超过两个读库要实现一个负载均衡算法
     * @return
     */

    @Override
    protected Object determineCurrentLookupKey() {
        // 使用 DynamicDataSourceHolder 保证线程安全
        String dataSource = DynamicDataSourceHolder.get();
        log.info("当前数据库: {}", dataSource);
        return dataSource;
    }

    @Override
    public void afterPropertiesSet() {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(new HashMap<>(targetDataSources));
        super.afterPropertiesSet();
    }

}