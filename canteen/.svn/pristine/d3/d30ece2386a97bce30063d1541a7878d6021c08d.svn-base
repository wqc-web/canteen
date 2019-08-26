package com.zhongzhou.log.annotation;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.zhongzhou.entity.canteen.User;
import com.zhongzhou.log.LogObjectHolder;
import com.zhongzhou.utils.DateUtil;
import com.zhongzhou.utils.HttpKit;


@Aspect
@Component
public class LogAop {

    //为LogInfer添加切面
    @Pointcut("@annotation(com.zhongzhou.log.annotation.LogInfer)")
    public void aspectjMethod() {
    };



    /*@Around("aspectjMethod()")
    public void afterExec(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        try {
            //记录日志
            insertlog(method);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    @Around("aspectjMethod()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {

        //先执行业务
        Object result = point.proceed();
        System.out.println("log切面");
        try {
            insertlog(point);
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return result;
    }

    private void insertlog(ProceedingJoinPoint point) throws Exception {

        //获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();

        String remake = currentMethod.getAnnotation(LogInfer.class).remake();
        String objectKey = currentMethod.getAnnotation(LogInfer.class).objectKey();
        String ID = currentMethod.getAnnotation(LogInfer.class).ID();
        Map<String, String> obj2 = HttpKit.getRequestParameters();
        String keyString = "主键:"+ID+"="+obj2.get(ID)+";;;";
        remake = keyString+remake;
        if (currentMethod.getAnnotation(LogInfer.class).logType().indexOf("修改") != -1 || currentMethod.getAnnotation(LogInfer.class).logType().indexOf("编辑") != -1) {
            Object obj1 = LogObjectHolder.me().get(objectKey);
            if(obj1!=null){
                //判断主键是否相同

                remake = keyString+contrastObj(obj1, obj2);
            }
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        User user = (User)request.getSession().getAttribute("user");
    }

    /**获取ip地址
     * @return
     */
    private String getIpAddr() {
        String ipAddress = null;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();

            // 这里主要是获取本机的ip,可有可无
            if (ipAddress.equals("127.0.0.1") || ipAddress.endsWith("0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }

        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
            // = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        // 或者这样也行,对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        // return
        // ipAddress!=null&&!"".equals(ipAddress)?ipAddress.split(",")[0]:null;
        return ipAddress;
    }



    /**
     * 比较两个对象,并返回不一致的信息
     *
     * @author stylefeng
     * @Date 2017/5/9 19:34
     */
    public static String contrastObj(Object pojo1, Map<String, String> pojo2) {
        String str = "";
        try {
            //Class clazz = pojo1.getClass();
            Field[] fields = pojo1.getClass().getDeclaredFields();
            int i = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                if ("serialVersionUID".equals(field.getName())) {
                    continue;
                }
                Object o1 = field.get(pojo1);
                Object o2 = pojo2.get(field.getName());
                if (o1 == null || o2 == null) {
                    continue;
                }
                if (o1 instanceof Date) {
                    o1 = DateUtil.getTime((Date) o1);
                }
                if (!o1.toString().equals(o2.toString())) {
                    if (i != 1) {
                        str += ";;;";
                    }
                    str += "字段名称" + field.getName() + ",旧值:" + o1 + ",新值:" + o2;
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

}
