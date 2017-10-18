package com.rest.jaxrs;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


/**
 *
 */

@ApplicationPath("api")
public class RestApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(PetSalesOfficeListResource.class);
		return s;
	}
}
