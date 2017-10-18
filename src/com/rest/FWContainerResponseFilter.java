package com.rest;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import jp.co.infomart.imf.annotation.FWInjectable;
import jp.co.infomart.imf.http.FWSession;
import jp.co.infomart.imf.log.FWLoggerFactory;
import org.slf4j.Logger;

/**
 * RESTfulService(JAX-RS)の利用後のレスポンス返却前に介入する。
 */

@Provider
public class FWContainerResponseFilter implements  ContainerResponseFilter {
    
    @Context
    private HttpServletRequest httpServletRequest;
    
    private final Logger logger = FWLoggerFactory.getLogger(FWContainerResponseFilter.class);
       
    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        
        // 個別処理
        
        return response;
    }
}
