package com.practice.pizzajoint.parameter;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author bhaarat
 */
public class DateParam extends AbstractParameter<Date> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
    public DateParam (String date) throws WebApplicationException {
        super (date);
    }
    
    @Override
    public Date parse(String param) throws Throwable{
        return dateFormat.parse(param);
    }
    
}
