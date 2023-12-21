package com.jyh.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler {
    //增强类对象
    private DaoTransaction daoTransaction;
    //需要代理的对象
    private Object obj;

    public TransactionHandler(DaoTransaction daoTransaction, Object obj) {
        this.daoTransaction = daoTransaction;
        this.obj = obj;
    }

    @Override
    /**
     * proxy 代理实例，可以通过newProxyInstance创建代理实例
     * Method 执行模板方法的，invoke调用方法执行
     * args 参数数组
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        if(method.getName().equals("sing")){
            daoTransaction.before();
            ret = method.invoke(obj,args);
            daoTransaction.after();
        }else {
            ret = method.invoke(obj,args);
        }
        return ret;

    }
}
