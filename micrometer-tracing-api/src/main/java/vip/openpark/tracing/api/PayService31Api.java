package vip.openpark.tracing.api;

import io.micrometer.observation.annotation.Observed;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author anthony
 * @version 2024/9/29
 * @since 2024/9/29 17:34
 */
@Observed
@FeignClient("quick-start-service-3-1")
public interface PayService31Api {

	/**
	 * 支付
	 *
	 * @param orderId 订单号
	 * @return 支付结果
	 */
	@GetMapping("pay")
	boolean pay(@RequestParam("orderId") String orderId);
}