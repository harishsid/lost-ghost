package org.harry.datastruct;

import java.util.List;

/**
 * Define APIs to be implemented by M
 * 
 * @author harry
 *
 * @param <K> type of key
 */
public interface MultiKeyTreeMapKey<K extends Comparable<K>> {
	
  public List<K> getkeys();
}
