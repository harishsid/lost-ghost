/* 
 * Copyright (c) 2013 FMR Corp.
 * All Rights Reserved.
 *
 * Fidelity Confidential Information.
 * Created on Jan 25, 2013
 */
package org.harry.datastruct;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test..
 *
 * @author <a href="mailto:a395432@fmr.com">a395432</a>
 * @since  
 */
public class MultiKeyTreeMapTest {
    
    private CFTRecord record1 = new CFTRecord( "NY", "MOTC", "CS", "US");
    private CFTRecord record2 = new CFTRecord(null, "MOTC", "CS", "US");
    private CFTRecord record3 = new CFTRecord(null, "MOTC", null, "US");    
    private CFTRecord record4 = new CFTRecord("NY", "MOTC", null, null);
    private CFTRecord record5 = new CFTRecord("NY", "GOLD", "CS", "US");
    private CFTRecord record6 = new CFTRecord(null, null, "CS", null);
    private CFTRecord record7 = new CFTRecord("NE", "GOLD", null, "US");
    private CFTRecord record8 = new CFTRecord("NE", null, "CS", "US");
    
    private MultiKeyTreeMap<String, CFTRecord, CFTRecord> map = null;    
    
   @Before
   public void setup() {
       map = new MultiKeyTreeMap<String, CFTRecord, CFTRecord>(4);       
       map.put(record1, record1);
       map.put(record2, record2);
       map.put(record3, record3);
       map.put(record4, record4);
       map.put(record5, record5);
       map.put(record6, record6);
       map.put(record7, record7);
       map.put(record8, record8);
       
   }
   
   @Test
   public void testfullMatch() {
       assertEquals(map.get(new CFTRecord( "NY", "MOTC", "CS", "US")), record1);
   }
   
   @Test
   public void testBestMatch() {       
       assertEquals(map.findBestMatch2(new CFTRecord("TK", "MOTC", "CS", "US")), record2);
       assertEquals(map.findBestMatch2(new CFTRecord("NY", "MOTC", "CC", "US")), record4);
       assertEquals(map.findBestMatch2(new CFTRecord("TK", "MOTC", "CC", "US")), record3);
       
       assertEquals(map.findBestMatch2(new CFTRecord("NY", "GOLD", "CS", "US")), record5);
       assertEquals(map.findBestMatch2(new CFTRecord("TEXAS", "FID", "CS", "US")), record6);
       assertEquals(map.findBestMatch2(new CFTRecord("NE", "GOLD", "CC", "US")), record7);
       
       assertEquals(map.findBestMatch2(new CFTRecord("NE", "GOLD", "CS", "UE")), record6);
   }
}
