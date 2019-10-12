package com.example.demo.constants;

import com.example.demo.utils.AnnoParse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/10/10 15:33
 */
@Aspect
@Component
public class CacheAnnoAspect {

    @SuppressWarnings("rawtypes")
    @Around("@annotation(ca)")
    public Object cache(ProceedingJoinPoint pjp, CacheAnno ca) throws Throwable {

        // 获取参数的类型
        Class[] argTypes = ((MethodSignature) pjp.getSignature()).getParameterTypes();

        Method method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), argTypes);

        CacheAnno cacheAnno = method.getAnnotation(CacheAnno.class);

        String keyValue = AnnoParse.parseKey(cacheAnno.key(), method, pjp.getArgs());

        // Class modelType = method.getAnnotation(CacheAnno.class).annotationType();

        // String keyName = modelType.getName();

        Object obj = RedisCache.get(keyValue);
        if (obj != null) {
            System.out.println("从缓存中获取数据");
            return obj;
        }

        obj = pjp.proceed();

        if (obj != null) {
            RedisCache.set(keyValue, obj);
        }

        System.out.println("从数据库中获取数据");
        return obj;
    }

}
