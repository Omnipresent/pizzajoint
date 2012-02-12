package com.practice.pizzajoint.parameter;

import javax.ws.rs.WebApplicationException;

/**
 *
 * @author bhaarat
 */
public abstract class AbstractParameter <V>{
    private final V value;
    private final String originalParam;
    
    public AbstractParameter(String param) throws WebApplicationException{
        this.originalParam = param;
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
