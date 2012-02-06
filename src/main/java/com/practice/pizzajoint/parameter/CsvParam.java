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
