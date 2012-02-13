package com.practice.pizzajoint.parameter;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.WebApplicationException;
import java.text.ParseException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
public class SimpleDateParam extends AbstractParameter<Date>{
  private static final SimpleDateFormat simpleDate = new SimpleDateFormat("MM/dd/yyyy");
  public SimpleDateParam (String orderDate) {
    super(orderDate);
  }
  public Date parse(String orderDate) throws Throwable {
    return simpleDate.parse(orderDate);
  }
}
