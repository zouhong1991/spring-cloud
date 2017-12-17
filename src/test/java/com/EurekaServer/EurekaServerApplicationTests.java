package com.EurekaServer;
import java.util.ArrayList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaServerApplicationTests {
    Logger log = LoggerFactory.getLogger(EurekaServerApplicationTests.class);  

	@Ignore
	@Test
	public void contextLoads() {
	}

//	@Ignore
	@Test  
    public void logMehodAndLine() throws InterruptedException{  
        StopWatch watch = new Slf4JStopWatch();  
        List<Long> times = new ArrayList<Long>();  
        int n = 10;  
        int size = 1000000;  
        Long totalTime = 0L;  
        for(int i = 0;i<n;i++){  
            watch.start();  
            for(int j = 0;j<size - 1;j++){  
                log.info("Example message");  
            }  
            watch.stop();  
            times.add(i, watch.getElapsedTime());  
            totalTime += watch.getElapsedTime();  
            Thread.sleep(500);  
        }  
        log.info("{}条耗时：{}ms",size,times.toString());  
        log.info("平均每{}条耗时：{}ms",size,totalTime/n);  
    }  
      
    /** 
     * 测试日志长度对时间的影响 
     */  
	@Ignore  
    @Test  
    public void logLength() throws InterruptedException{  
        StopWatch watch = new Slf4JStopWatch();  
        List<Long> times = new ArrayList<Long>();  
        int n = 50;  
        int size = 10000;  
        int length = 1000;  
        StringBuffer info = new StringBuffer();  
        log.info("开始。。。。");
        for(int i = 0;i < n; i++){  
            while(info.length()<(i+1)*length){  
                info.append("a");  
            }  
            String infoStr = info.toString();  
            watch.start();  
            for(int j = 0;j<size - 1;j++){  
                log.info(infoStr);  
            }  
            watch.stop();  
            times.add(i, watch.getElapsedTime());  
            Thread.sleep(500);  
        }  
        for(int i = 0;i < n; i++){  
            log.info("长度为{}时，{}条共耗时：{}ms",(i+1)*length,size,times.get(i));  
        }  
    }  
}
