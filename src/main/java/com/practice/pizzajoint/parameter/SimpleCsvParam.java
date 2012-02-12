package com.practice.pizzajoint.parameter;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.WebApplicationException;
import java.text.ParseException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
public class SimpleCsvParam {
  private static final SimpleCsvParam dateFormat = new SimpleDateFormat("MM/dd/yyyy");
  private String originalParameter = "";
  private Date date = new Date();
  
public SimpleDateParam (String orderDate) throws WebApplicationException {
    try {
      this.originalParameter = orderDate;
      this.date = dateFormat.parse(orderDate);
    }
    catch (ParseException e) {
      throw new WebApplicationException(
        Response
          .status(Status.BAD_REQUEST)
          .entity(e.getMessage())
          .build()
      );
    }
  }
  public Date getValue() {
    return this.date;
  }
}
