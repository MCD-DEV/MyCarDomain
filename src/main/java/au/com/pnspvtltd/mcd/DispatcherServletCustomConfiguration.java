package au.com.pnspvtltd.mcd;

import javax.servlet.Filter;

import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class DispatcherServletCustomConfiguration {

	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}

	@Bean
	public ServletRegistrationBean dispatcherServletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(),
				new String[] { "/api/*", "/" });
		registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
		return registration;
	}

	@Bean
	public Filter filterToSupportPUTOperations() {
		return new HiddenHttpMethodFilter();
	}

	@Bean
	public FilterRegistrationBean registerFilterToSupportPUTOperations() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(filterToSupportPUTOperations());
		registration.addUrlPatterns(new String[] { "/api/*" });
		registration.setName("FilterToSupportPUTOperations");
		// registration.setOrder(1);
		return registration;
	}

}
