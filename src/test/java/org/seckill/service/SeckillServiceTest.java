package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() {
        long id = 1000L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void testSeckillLogic() {
        long id =1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if(exposer.isExposed()){
            logger.info("exposer={}", exposer);
            long phone = 18917767734L;
            String md5 = exposer.getMd5();
            try{
                SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
                logger.info("execution={}", execution);
            }catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            }
        }else{
            logger.warn("exposer={}", exposer);
        }
    }
}
//    @Test
//    public void exportSeckillUrl() {
//        long id=1005;
//        Exposer exposer = seckillService.exportSeckillUrl(id);
//        logger.info("exposer={}", exposer);
//    }
//
//    @Test
//    public void executeSeckill() {
//        long id=1005;
//        long phone = 18917767734L;
//        String md5 = "cbb629bd9307f4c55812a9b8b82b1774";
//        try{
//            SeckillExecution execution = seckillService.executeSeckill(id, phone, md5);
//            logger.info("execution={}", execution);
//        }catch (SeckillCloseException e) {
//            logger.error(e.getMessage());
//        } catch (RepeatKillException e) {
//            logger.error(e.getMessage());
//        }
//    }
//}
