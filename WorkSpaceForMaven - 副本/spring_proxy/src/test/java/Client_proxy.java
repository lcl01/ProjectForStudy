import com.itheima.proxy.Producer;
import com.itheima.proxy.impl.ProducerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client_proxy {
    public static void main(String[] args) {
        final Producer producer=new ProducerImpl();
        Producer proxyProducer=(Producer) Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue=null;
                //1.获取方法执行的参数
                Float money = (Float)args[0];
                if ("saleProduct".equals(method.getName())) {
                    returnValue=method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
        proxyProducer.saleProduct(1000);
    }
}
