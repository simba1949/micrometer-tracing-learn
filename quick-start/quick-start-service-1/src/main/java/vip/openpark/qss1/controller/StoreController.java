package vip.openpark.qss1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.openpark.tracing.api.OrderService2Api;

/**
 * @author anthony
 * @version 2024/9/29
 * @since 2024/9/29 17:51
 */
@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class StoreController {
	private final OrderService2Api orderService2Api;

	@GetMapping(value = "storeOrder")
	public String storeOrder(@RequestParam("productName") String productName) {
		log.info("用户请求商家进行下单，商品名称：{}", productName);
		return orderService2Api.order(productName);
	}
}