package com.example.demo.utils;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/10/10 15:31
 */
public class AnnoParse {

    /**
     * 解析传入的key值
     *
     * @param field
     * @param method
     * @param args
     * @return
     */
    public static final String parseKey(String field, Method method, Object[] args) {
        if (!StringUtils.hasLength(field))
            return null;

        LocalVariableTableParameterNameDiscoverer nd = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = nd.getParameterNames(method);
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        for (int i = 0; i < parameterNames.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }

        return parser.parseExpression(field).getValue(context, String.class);
    }
}
