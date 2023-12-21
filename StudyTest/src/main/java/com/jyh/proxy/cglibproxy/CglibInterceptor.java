package com.jyh.proxy.cglibproxy;

import com.jyh.proxy.jdkproxy.DaoTransaction;
import com.jyh.proxy.jdkproxy.IStudentService;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class CglibInterceptor implements MethodInterceptor {

    DaoTransaction transaction;

    private Object obj;

    public CglibInterceptor(DaoTransaction transaction, Object obj) {
        this.transaction = transaction;
        this.obj = obj;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object ret = null;
        //事务增强
        if(method.getName().equals("sing")){
            transaction.before();
            ret = method.invoke(obj, objects);
            transaction.after();
        }else {
            ret = method.invoke(obj, objects);
        }

        return ret;
    }
}
