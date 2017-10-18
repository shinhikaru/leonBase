package com.rest;


import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.spi.container.ResourceFilter;
import com.sun.jersey.spi.container.ResourceFilterFactory;
import java.util.Collections;
import java.util.List;

/**
 *
 * クラスFWResourceFilterFactory
 */
public class FWResourceFilterFactory implements ResourceFilterFactory{

    @Override
    public List<ResourceFilter> create(AbstractMethod am) {
        if (am.isAnnotationPresent(FWRestSessionControl.class) || am.getResource().isAnnotationPresent(FWRestSessionControl.class)) {            
            System.out.println("######FWResourceFilterFactory#create FWRestSessionControl is FOUND!");
            return Collections.<ResourceFilter>singletonList(new FWRestFilter());
        } else {
            System.out.println("#####FWResourceFilterFactory#create getAnnotations=" + am.getAnnotations().toString());
        }
        return null;
    }
}
