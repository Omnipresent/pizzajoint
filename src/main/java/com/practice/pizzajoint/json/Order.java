/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.pizzajoint.json;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author bhaarat
 */
public class Order {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);
    
    private final int id;
    private final String orderName;
    private final boolean isReady;
    private final Date dateOfOrder;
    private final List<Topping> toppings;

    public static AtomicInteger getID_COUNTER() {
        return ID_COUNTER;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public int getId() {
        return id;
    }

    public boolean isIsReady() {
        return isReady;
    }

    public String getOrderName() {
        return orderName;
    }

    public List<Topping> getToppings() {
        return toppings;
    }
    
    public Order (String name, boolean ready, Date orderDate, Iterable<Topping> toppings) {
        this(ID_COUNTER.incrementAndGet(), name, ready, orderDate, toppings);
    }
    
    @JsonCreator
    public Order (@JsonProperty("uid") int id, 
                  @JsonProperty("name") String name,
                  @JsonProperty("ready") boolean ready,
                  @JsonProperty("orderdate") Date orderDate,
                  @JsonProperty("toppings") Iterable<Topping> toppings) {
        this.id = id;
        this.orderName = name;
        this.isReady = ready;
        this.dateOfOrder = orderDate;
        this.toppings = Collections.unmodifiableList(Lists.newArrayList(toppings));
    }
    
}
