package au.com.pnspvtltd.mcd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("au.com.pnspvtltd.mcd")
public class MyCarDomainApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MyCarDomainApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyCarDomainApplication.class);
	}
}
