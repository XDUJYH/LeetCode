package com.jyh.proxy.jdkproxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {

        //增强类对象
        IStudentService studentService = new StudentServiceImpl("qzb");

        //目标执行类
        DaoTransaction daoTransaction = new DaoTransaction();

        //方法拦截处理器
        TransactionHandler transactionHandler = new TransactionHandler(daoTransaction, studentService);

        /**
         *     public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h)
         */
        //获取代理实例对象
        IStudentService proxy = (IStudentService) Proxy.newProxyInstance(StudentServiceImpl.class.getClassLoader(),
                StudentServiceImpl.class.getInterfaces(),
                transactionHandler);
        System.out.println(proxy.sing("小星星"));
        System.out.println(proxy.dance());
    }
}
