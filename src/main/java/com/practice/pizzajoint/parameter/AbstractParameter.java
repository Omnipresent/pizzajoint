package com.practice.pizzajoint.parameter;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response;
public abstract class AbstractParameter <V>{
    private final V value;
    public AbstractParameter(String param) throws WebApplicationException{
        try {
            this.value = parse(param);
        }
        catch (Throwable e) {
            throw new WebApplicationException(
              Response
                .status(Status.BAD_REQUEST)
                .entity(e.getMessage())
                .build()
            );
        }
    }

    public abstract V parse(String param) throws Throwable;
  
    public V getValue() {
        return this.value;
    }
}
