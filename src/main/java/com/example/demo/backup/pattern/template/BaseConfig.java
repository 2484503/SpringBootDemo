package com.example.demo.backup.pattern.template;

import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

/**
 * 注册服务配置
 *
 * @author lijn
 * @version 1.0
 * @date 2019/8/29 10:06
 */
public abstract class BaseConfig<T> implements ApplicationContextAware {

    protected List<T> processors = Lists.newArrayList();

    @Getter(AccessLevel.PROTECTED)
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        applicationContext.getBeansOfType(getProcessorClass()).values().forEach(this::register);
    }

    /**
     * 获取流程基类
     */
    protected abstract Class<T> getProcessorClass();

    /**
     * 注册流程
     */
    protected boolean register(T processor) {
        processors.add(processor);
        return true;
    }
}
