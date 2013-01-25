package org.harry.datastruct;

import java.util.List;

/**
 * Defines type of Keys will be used for {@link MultiKeyTreeMapKey}
 * 
 * @author <a href="mailto:a395432@fmr.com">Harish Gavisiddaiah</a>
 * @since 2013
 * @param <K> type of keys used.
 */
public interface MultiKeyTreeMapKey<K> {
    
    /**
     * Implementation, should return list keys to be used to access map.
     * 
     * <p>Size and sequence of keys should always remain, if user wants to satisfy condition map.put(key, value) == map.get(key, value)</p>
     * 
     * <p>If some values don't have all keys defined, still key implementation should return list of keys with same size and sequence, except that 
     * it can have null values in list for key positions to which value not available<p>
     * 
     * @return list of all keys.
     */
    List<K> getkeys();
}
