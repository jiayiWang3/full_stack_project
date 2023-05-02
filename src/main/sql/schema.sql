CREATE DATABASE seckill;
use seckill;

CREATE TABLE seckill(
    `seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
    `name` varchar(120) NOT NULL  COMMENT ' 商品名称 ',
    `number` int NOT NULL  COMMENT ' 库存数量 ',
    `start_time` timestamp NOT NULL DEFAULT '2022-08-08 00:00:00' COMMENT ' 秒杀开启时间 ',
    `end_time` timestamp NOT NULL DEFAULT '2022-08-08 00:00:00' COMMENT ' 秒杀结束时间 ',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT ' 创建时间 ',
    PRIMARY KEY (seckill_id),
    key idx_start_time(start_time),
    key idx_end_time(end_time),
    key idx_cereate_time(create_time)
)ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';


insert into seckill(name,number,start_time,end_time)
values
    ('4000元秒杀iPhone11',100,'2022-06-01 00:00:00','2022-06-02 00:00:00'),
    ('4500元秒杀iPhone12',200,'2022-06-01 00:00:00','2022-06-02 00:00:00'),
    ('5000元秒杀iPhone13',300,'2022-06-01 00:00:00','2022-06-02 00:00:00'),
    ('6000元秒杀iPhone13pro',400,'2022-09-01 00:00:00','2022-09-30 00:00:00'),
    ('5000元秒杀HUAWEI',500,'2022-10-01 00:00:00','2022-10-02 00:00:00');


create table success_killed(
    `seckill_id` bigint NOT NULL  COMMENT '秒杀商品ID',
    `user_phone` bigint NOT NULL  COMMENT '用户手机号',
    `state` tinyint NOT NULL DEFAULT  -1 COMMENT '状态标志：-1：无效 0：成功 1：已付款',
    `create_time` timestamp NOT NULL DEFAULT  CURRENT_TIMESTAMP  COMMENT ' 创建时间 ',
    PRIMARY KEY(seckill_id,user_phone),/*联合主键*/
    KEY idx_create_time(create_time)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT='秒杀成功明细表';
















