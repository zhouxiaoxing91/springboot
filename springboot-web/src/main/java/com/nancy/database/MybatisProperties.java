package com.nancy.database;

/**
 * All rights Reserved, Designed By guangfeng.zhou
 *
 * @version V1.0
 * @Project: springboot
 * @Package: com.nancy.database
 * @Description: (用一句话描述该文件做什么)
 * @author: guangfeng.zhou
 * @date: 2017/7/28 16:31
 */

import org.apache.ibatis.session.ExecutorType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

/**
 * Configuration properties for Mybatis.
 *
 * @author Eddú Meléndez
 */
@ConfigurationProperties(prefix = MybatisProperties.MYBATIS_PREFIX)
public class MybatisProperties {

    public static final String MYBATIS_PREFIX = "mybatis";

    /**
     * Config file path.
     */
    private String config;

    /**
     * Location of mybatis mapper.base.mapper files.
     */
    private Resource[] mapperLocations;

    /**
     * Package to scan domain objects.
     */
    private String typeAliasesPackage;

    /**
     * Package to scan handlers.
     */
    private String typeHandlersPackage;

    /**
     * Check the config file exists.
     */
    private boolean checkConfigLocation = false;

    /**
     * Execution mode.
     */
    private ExecutorType executorType = ExecutorType.SIMPLE;

    public String getConfig() {
        return this.config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Resource[] getMapperLocations() {
        return this.mapperLocations;
    }

    public void setMapperLocations(Resource[] mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getTypeHandlersPackage() {
        return this.typeHandlersPackage;
    }

    public void setTypeHandlersPackage(String typeHandlersPackage) {
        this.typeHandlersPackage = typeHandlersPackage;
    }

    public String getTypeAliasesPackage() {
        return this.typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

    public boolean isCheckConfigLocation() {
        return this.checkConfigLocation;
    }

    public void setCheckConfigLocation(boolean checkConfigLocation) {
        this.checkConfigLocation = checkConfigLocation;
    }

    public ExecutorType getExecutorType() {
        return this.executorType;
    }

    public void setExecutorType(ExecutorType executorType) {
        this.executorType = executorType;
    }
}

