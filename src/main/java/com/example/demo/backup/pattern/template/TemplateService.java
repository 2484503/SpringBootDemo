package com.example.demo.backup.pattern.template;

import org.springframework.stereotype.Service;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/8/29 10:21
 */
@Service
@HandlerConfig(isValid = false)
public class TemplateService extends BaseService {
    @Override
    protected void startService() {
        System.out.println("开始了test方法");
    }
}
