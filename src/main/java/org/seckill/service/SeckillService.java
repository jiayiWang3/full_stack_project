package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

public interface SeckillService {

    /**
     * get all seckill records
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * get one seckill record
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * when seckill start show url addresses,
     * if not start, show system time and seckill time
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * execute seckill operation
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException, RepeatKillException, SeckillCloseException;


}
