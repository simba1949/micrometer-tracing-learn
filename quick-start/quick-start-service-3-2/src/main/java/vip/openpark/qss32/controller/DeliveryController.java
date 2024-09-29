package vip.openpark.qss32.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import vip.openpark.tracing.api.DeliveryService32Api;

import java.util.concurrent.TimeUnit;

/**
 * @author anthony
 * @version 2024/9/29
 * @since 2024/9/29 17:50
 */
@Slf4j
@RestController
public class DeliveryController implements DeliveryService32Api {
	@Override
	public boolean delivery(String orderId) {
		log.info("订单请求发货, orderId={}", orderId);
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			log.error("订单请求发货，请求入参：{}，出参：{}", orderId, e.getMessage());
		}
		return true;
	}
}