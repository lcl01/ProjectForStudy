import com.itheima.product.Product;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client_extents {
    public static void main(String[] args) {
        final Product product=new Product();
        Product cglibProduct=(Product) Enhancer.create(product.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Float money = (Float)objects[0];
                if("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(product, money*0.8f);
                }
                return returnValue;
            }
        });
        cglibProduct.saleProduct(2000f);
    }
}
