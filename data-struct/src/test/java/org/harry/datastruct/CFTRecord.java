/* 
 * Copyright (c) 2013 FMR Corp.
 * All Rights Reserved.
 *
 * Fidelity Confidential Information.
 * Created on Jan 25, 2013
 */
package org.harry.datastruct;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * TODO Add class description.
 *
 * @author <a href="mailto:a395432@fmr.com">a395432</a>
 * @since  
 */
public class CFTRecord implements MultiKeyTreeMapKey<String> {
    
    private String firm;
    private String iv_type;
    private String country;
    private String exchange;
  

    /**
     * constructor.
     * @param firm .
     * @param iv_type .
     * @param country .
     * @param exchange .
     */
    public CFTRecord(String exchange, String firm, String iv_type, String country) {
        super();
        this.firm = firm;
        this.iv_type = iv_type;
        this.country = country;
        this.exchange = exchange;
    }



  
    public List<String> getkeys() {
        return Lists.newArrayList(exchange, firm, iv_type, country);
    }
    
    

}
