package com.example.demo.backup.pattern.template;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 总流程
 *
 * @author lijn
 * @version 1.0
 * @date 2019/8/29 10:23
 */
@RestController
public class Main extends BaseConfig<BaseService> {

    @Override
    protected Class<BaseService> getProcessorClass() {
        return BaseService.class;
    }

    @GetMapping("templatePattern")
    public void run() {
        System.out.println("进入了模板模式");
        processors.stream().forEach(service -> service.handle());
    }
}
