/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.pizzajoint.json;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 *
 * @author bhaarat
 */
@JsonSerialize(using = Topping.ToppingSerializer.class)
@JsonDeserialize(using = Topping.ToppingDeserializer.class)
public class Topping {
    
    private final String toppingName;
    
    public Topping (String toppingName) {
        this.toppingName = toppingName;
    }
    
    public String getToppingName() {
        return this.toppingName;
    }
    
    @Override
    public String toString() {
        return "Topping Name:  = " + this.toppingName;
    }
    
    public static class ToppingSerializer extends JsonSerializer<Topping> {

        @Override
        public void serialize(Topping t, JsonGenerator jg, SerializerProvider sp) throws IOException  {
            jg.writeString(t.getToppingName());
        }
        
    }
    
    public static class ToppingDeserializer extends JsonDeserializer<Topping> {

        @Override
        public Topping deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
            String toppingName = jp.getText();
            return new Topping(toppingName);
        }
        
    }
    
}
