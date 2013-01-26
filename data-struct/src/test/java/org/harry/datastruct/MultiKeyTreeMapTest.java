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
    
    private StrockRecord record1 = new StrockRecord( "NY", "MOTC", "CS", "US");
    private StrockRecord record2 = new StrockRecord(null, "MOTC", "CS", "US");
    private StrockRecord record3 = new StrockRecord(null, "MOTC", null, "US");    
    private StrockRecord record4 = new StrockRecord("NY", "MOTC", null, null);
    private StrockRecord record5 = new StrockRecord("NY", "GOLD", "CS", "US");
    private StrockRecord record6 = new StrockRecord(null, null, "CS", null);
    private StrockRecord record7 = new StrockRecord("NE", "GOLD", null, "US");
    private StrockRecord record8 = new StrockRecord("NE", null, "CS", "US");
    
    private MultiKeyTreeMap<String, StrockRecord, StrockRecord> map = null;    
    
   @Before
   public void setup() {
       map = new MultiKeyTreeMap<String, StrockRecord, StrockRecord>(4);       
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
       assertEquals(map.get(new StrockRecord( "NY", "MOTC", "CS", "US")), record1);
   }
   
   @Test
   public void testBestMatch() {       
       assertEquals(map.findBestMatch2(new StrockRecord("TK", "MOTC", "CS", "US")), record2);
       assertEquals(map.findBestMatch2(new StrockRecord("NY", "MOTC", "CC", "US")), record4);
       assertEquals(map.findBestMatch2(new StrockRecord("TK", "MOTC", "CC", "US")), record3);
       
       assertEquals(map.findBestMatch2(new StrockRecord("NY", "GOLD", "CS", "US")), record5);
       assertEquals(map.findBestMatch2(new StrockRecord("TEXAS", "FID", "CS", "US")), record6);
       assertEquals(map.findBestMatch2(new StrockRecord("NE", "GOLD", "CC", "US")), record7);
       
       assertEquals(map.findBestMatch2(new StrockRecord("NE", "GOLD", "CS", "UE")), record6);
   }
}
