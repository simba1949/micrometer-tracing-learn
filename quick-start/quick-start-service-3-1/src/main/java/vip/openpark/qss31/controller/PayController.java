package vip.openpark.qss31.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import vip.openpark.tracing.api.PayService31Api;

import java.util.concurrent.TimeUnit;

/**
 * @author anthony
 * @version 2024/9/29
 * @since 2024/9/29 17:47
 */
@Slf4j
@RestController
public class PayController implements PayService31Api {
	@Override
	public boolean pay(String orderId) {
		log.info("pay orderId:{}", orderId);
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			log.error("订单请求创建，请求入参：{}，出参：{}", orderId, e.getMessage());
		}
		return true;
	}
}