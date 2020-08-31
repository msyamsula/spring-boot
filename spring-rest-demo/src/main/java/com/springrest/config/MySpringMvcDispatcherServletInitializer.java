// abstract initializer, this is a boiler plate

package com.springrest.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {RestConfig.class}; // specify the rest config java file
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"}; // specify root for our app
	}

}
