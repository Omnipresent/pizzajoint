/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.pizzajoint.parameter;

import com.google.common.base.Splitter;

/**
 *
 * @author bhaarat
 */
public class CsvParam extends AbstractParameter<Iterable<String>> {
    
    
    public CsvParam(String param) {
        super(param);
    }

    @Override
    public Iterable<String> parse(String param) {
        return Splitter.on(",").trimResults().omitEmptyStrings().split(param);
    }
}
