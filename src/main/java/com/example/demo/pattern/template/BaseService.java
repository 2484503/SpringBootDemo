package com.example.demo.pattern.template;

import org.springframework.core.annotation.AnnotationUtils;

/**
 * 基础服务
 *
 * @author lijn
 * @version 1.0
 * @date 2019/8/29 10:14
 */
public abstract class BaseService {

    private boolean isValid;

    protected BaseService() {
        HandlerConfig config = AnnotationUtils.findAnnotation(getClass(), HandlerConfig.class);
        if (config == null)
            throw new RuntimeException("服务未配置@HandlerConfig注解，" + getClass().getSimpleName());

        initialize(config);
    }

    /**
     * 获取配置
     */
    private void initialize(HandlerConfig config) {
        this.isValid = config.isValid();
    }

    protected abstract void startService();

    public void handle() {
        if (accept())
            return;
        startService();
    }

    protected boolean accept() {
        return isValid;
    }
}
