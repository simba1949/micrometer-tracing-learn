package vip.openpark.qss2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.openpark.tracing.api.OrderService2Api;
import vip.openpark.tracing.api.PayService31Api;
import vip.openpark.tracing.api.DeliveryService32Api;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author anthony
 * @version 2024/9/29
 * @since 2024/9/29 17:41
 */
@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OrderController implements OrderService2Api {
	private final PayService31Api payService31Api;
	private final DeliveryService32Api deliveryService32Api;

	@Override
	public String order(@RequestParam("productName") String productName) {
		log.info("订单请求创建，请求入参：{}", productName);
		String orderId = UUID.randomUUID().toString();

		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			log.error("订单请求创建，请求入参：{}，出参：{}", productName, e.getMessage());
		}

		log.info("订单请求支付，请求入参：{}", orderId);
		boolean payResult = payService31Api.pay(orderId);
		log.info("订单请求支付，请求入参：{}，出参：{}", orderId, payResult);
		if (!payResult) {
			return "支付失败";
		}

		log.info("订单请求发货，请求入参：{}", orderId);
		boolean deliveryResult = deliveryService32Api.delivery(orderId);
		log.info("订单请求发货，请求入参：{}，出参：{}", orderId, deliveryResult);
		if (!deliveryResult) {
			return "支付成功，发货失败";
		}

		return "支付成功，发货成功";
	}
}