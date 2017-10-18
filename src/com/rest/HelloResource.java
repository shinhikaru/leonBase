package com.rest.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.rest.FWRestSessionControl;

/**
 * リソース
 */
@Path("/hello")
public class HelloResource {
    // 呼び方
    // curl http://localhost:8080/leonBase/api/hello
    @GET

    @Produces(MediaType.TEXT_PLAIN)
    @RestSessionControl
    public String getHellowMsg() {
        return "HelloWold";
    }
}
