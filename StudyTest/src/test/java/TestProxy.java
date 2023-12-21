import com.jyh.proxy.cglibproxy.CglibInterceptor;
import com.jyh.proxy.jdkproxy.DaoTransaction;
import com.jyh.proxy.jdkproxy.IStudentService;
import com.jyh.proxy.jdkproxy.StudentServiceImpl;
import com.jyh.proxy.jdkproxy.TransactionHandler;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class TestProxy {


    @Test
    public void testJdkProxy(){
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



    @Test
    public void testCglibProxy(){
        //得到方法拦截器
        IStudentService studentService = new StudentServiceImpl("qzb");
        CglibInterceptor interceptor = new CglibInterceptor(new DaoTransaction(), studentService);
        //使用CGLIB框架生成目标类的子类（代理类）实现增强
        Enhancer enhancer = new Enhancer();
        //设置父类字节码
        enhancer.setSuperclass(StudentServiceImpl.class);
        //设置拦截处理
        enhancer.setCallback(interceptor);
        IStudentService service = (IStudentService) enhancer.create();
        System.out.println(service.sing("小星星"));
        System.out.println(service.dance());
    }
}
