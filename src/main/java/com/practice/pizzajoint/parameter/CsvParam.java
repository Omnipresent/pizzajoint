/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.pizzajoint.parameter;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

/**
 *
 * @author bhaarat
 */
public class CsvParam {
    
    private final Iterable<String> value;
    
    public CsvParam(String param) throws Throwable {
        value = parse(param);
    }
    
    public Iterable<String> parse(String param) throws Throwable {
        return Splitter.on(",").trimResults().omitEmptyStrings().split(param);
    }
    
    public Iterable<String> getValue() {
        return this.value;
    }
    
    
}
