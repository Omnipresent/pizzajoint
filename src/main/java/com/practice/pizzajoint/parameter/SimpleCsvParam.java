package com.practice.pizzajoint.parameter;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.WebApplicationException;
import java.lang.IllegalArgumentException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.google.common.base.Splitter;
public class SimpleCsvParam extends AbstractParameter<Iterable<String>> {
  public SimpleCsvParam (String toppings) {
    super (toppings);
  }
  public Iterable<String> parse(String csvToppings) throws Throwable{
    return Splitter.on(",").trimResults().omitEmptyStrings().split(csvToppings);
  }
}
