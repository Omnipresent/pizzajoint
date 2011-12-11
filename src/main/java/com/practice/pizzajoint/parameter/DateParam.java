/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.pizzajoint.parameter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bhaarat
 */
public class DateParam extends AbstractParameter<Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
    public DateParam (String date) {
        super (date);
    }
    
    @Override
    public Date parse(String param) throws Throwable{
        return dateFormat.parse(param);
    }
    
}
