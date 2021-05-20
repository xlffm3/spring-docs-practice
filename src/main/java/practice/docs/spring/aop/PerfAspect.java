package practice.docs.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerfAspect {

    @Around("bean(simpleEventService)")
    public Object logPeer(ProceedingJoinPoint pip) throws Throwable {
        long begin = System.currentTimeMillis();
        System.out.println();
        Object retval = pip.proceed(); //실제 원하는 Target Method의 작업 수행
        System.out.println(System.currentTimeMillis() - begin);
        return retval;
    }

    @Before("bean(SimpleEventService)")
    public void hello() {
        System.out.println("hello");
    }
}
