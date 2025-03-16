
package org.hj.appmodule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.hj.appmodule", "org.hj.coremodule", "org.hj.inframodule"})
public class AppModuleApplication {

		public static void main(String[] args) {
			SpringApplication.run(AppModuleApplication.class, args);
		}
}
