package com.terminator;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/")
public class GreetingResource {

    @ConfigProperty(name = "application.message")
    String message;

    @ConfigProperty(name = "quarkus.application.name")
    String appName;

    @ConfigProperty(name = "callable.url")
    String callableURL;

    @ConfigProperty(name = "testing.myname")
    String myName;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return String.format("Message: %s", message);
    }

    @GET
    @Path("/name")
    public String getAppName(){
        return appName;
    }

    @GET
    @Path("/provider")
    public String getFromConfigProvider(){
        Config config = ConfigProvider.getConfig();
        String message = String.format("message: %s", config.getValue("application.message", String.class));
        return message;
    }

    @GET
    @Path("/optional-provider")
    public String getFromOptionalConfigProvider(){
        Config config = ConfigProvider.getConfig();
        String value = config.getOptionalValue("application.message", String.class)
                .orElse("Optional message");
        String message = String.format("message: %s", value);
        return message;
    }

    @GET
    @Path("/callable")
    public String getCallableURL(){
        return callableURL;
    }

    @GET
    @Path("/my-name")
    public String getMyName(){
        return myName;
    }
}
