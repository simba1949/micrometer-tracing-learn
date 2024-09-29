package vip.openpark.tracing.api;

import io.micrometer.observation.annotation.Observed;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author anthony
 * @version 2024/9/29
 * @since 2024/9/29 17:29
 */
@Observed
@FeignClient("quick-start-service-2")
public interface OrderService2Api {

	/**
	 * 下订单
	 *
	 * @param productName 商品名称
	 * @return boolean
	 */
	@GetMapping("order")
	String order(@RequestParam("productName") String productName);
}