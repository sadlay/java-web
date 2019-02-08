package com.lay.smartframework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Description: 切面代理
 * @Author: lay
 * @Date: Created in 16:01 2019/2/8
 * @Modified By:IntelliJ IDEA
 */
public  class AspectProxy implements Proxy {
    private static final Logger LOGGER= LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result=null;
        Class<?> cls=proxyChain.getTargetClass();
        Method method=proxyChain.getTargetMethod();
        Object[] params=proxyChain.getMethodParams();

        begin();
        try {
            if(intercept(cls,method,params)){
                before(cls,method,params);
                result=proxyChain.doProxyChain();
                after(cls,method,params,result);
            }else{
                result=proxyChain.doProxyChain();
            }
        }catch (Exception e){
            LOGGER.error("proxy failure",e);
            error(cls,method,params,e);
            throw e;
        }finally {
            end();
        }
        return result;
    }

    public void end(){

    }

    public void error(Class<?> cls, Method method, Object[] params, Exception e) {
    }

    public void after(Class<?> cls, Method method, Object[] params, Object result) {
    }

    public void before(Class<?> cls, Method method, Object[] params) {
    }

    public boolean intercept(Class<?> cls, Method method, Object[] params) {
        LOGGER.info("begin intercept");
        return true;
    }

    public void begin() {
    }
}
