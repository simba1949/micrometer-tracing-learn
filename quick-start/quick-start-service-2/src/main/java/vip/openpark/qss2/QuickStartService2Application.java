package vip.openpark.qss2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author anthony
 * @version 2024/9/29
 * @since 2024/9/29 17:31
 */
@EnableFeignClients(basePackages = "vip.openpark.tracing.api")
@SpringBootApplication
public class QuickStartService2Application {
	public static void main(String[] args) {
		SpringApplication.run(QuickStartService2Application.class, args);
	}
}