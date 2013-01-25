/**
 * 
 */
package org.harry.datastruct;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author harry
 *
 */
public class MultiKeyTreeMap<K extends Comparable<K>, M extends MultiKeyTreeMapKey<K>, V> {

	public static final String NILL = "*NILL";
	
	 /**
     * The number of key-value mappings contained in this map.
     */
    transient int size;
    
    
    private static final class TreeNode<K, V> {
    	private V value;
    	private Map<K, TreeNode<K, V>> childrens = new HashMap<K, MultiKeyTreeMap.TreeNode<K,V>>();
    	
    	public V findBestMatch(Iterator<K> keys) {
    		if (keys.hasNext()) {
    			
    		}
    		return value;
    	}
    	
    }
    
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	public V get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public V put(M key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	public V remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public void putAll(Map<? extends M, ? extends V> m) {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
