package com.example.demo.pattern.template;

import org.springframework.stereotype.Service;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/8/29 10:22
 */
@Service
@HandlerConfig(isValid = true)
public class TemplateOneService extends BaseService {
    @Override
    protected void startService() {
        System.out.println("start test function");
    }
}
