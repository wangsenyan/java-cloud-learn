package com.wsy.cloud.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 懒加载
 * 底层通过8719端口同步数据
 * 流控规则:
 *   - 默认错误 DefaultController
 *   - 预热: 阈值/coldFactor(默认值为3) 经过多少时长才能达到这个阈值
 *     - WarmUpController
 *     - 从阈值/3 ~ 阈值 需要多少时间预热
 *   - 排队等待
 * 熔断降级
 *  - sentinel熔断降级会在调用链路中的某个资源出现不稳定状态时(例如调用超时或异常比例升高),
 *    对这个资源的调用进行限制,让请求快速失败,避免影响到其他资源而导致级联错误
 *  - 当资源降级后,在接下来的降级时间窗口内,对该资源的调用都自动熔断(默认抛出DegradeException)
 *  - 没有半开状态
 *  - RT 平均响应时间,秒
 *    - 窗口期过后关闭断路器
 *    - 超出阈值且在时间窗口内通过的请求>=5,两个条件同时满足后触发降级
 *    - RT 最大4900(更大的要通过-Dcsp.sentinel.statistic.max.rt=xxxx才能生效)
 *  - 异常比例,秒
 *    - QPS>=5 且异常比例(秒级统计)超过阈值时,触发降级;时间窗口期结束后,关闭降级
 *  - 异常数
 * 热点key限流 BlockException 只对违背配置的项进行防备
 *    - @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
 *    - 参数例外项
 * 系统规则
 *   - load
 *   - rt
 *   - 线程数
 *   - 入口qps
 *   - cpu使用率
 *   SphU 定义资源
 *   Tracer 定义统计
 *   ContextUtil 定义上下文
 *异常:
 *  fallback 服务降级,只负责业务异常
 *  blockHandler 只负责sentinel控制台配置
 *     都配置,优先blockHandler
 *  exceptionToIgnore = {Myclass.class} 忽略参数
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class} )
public class AlibabaSentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelApplication.class,args);
    }
}
