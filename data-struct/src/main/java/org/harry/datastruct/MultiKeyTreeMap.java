package org.harry.datastruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * B-tree concept based Java implementation, provide basic Map functionality with support for multiple keys. Provide
 * ability to structure large set of data stored in Tree structure and ability to search for both for exact match and
 * best match.
 * 
 * <p>
 * Implementation has Tree node with multiple child node and default child node. Child nodes are stored in map with
 * their key or if key is null default child node is used.
 * 
 * </p>
 * 
 * <p>
 * Map is initialized with threshold, which defines the depth of Tree. Once threshold is defined, keys
 * {@link MultiKeyTreeMapKey} used for {@link #get(MultiKeyTreeMapKey)}, {@link #put(MultiKeyTreeMapKey, Object)},
 * {@link #findBestMatch(MultiKeyTreeMapKey)} operations should return {@link MultiKeyTreeMapKey#getkeys()} list with
 * size == threshold, else {@link IllegalArgumentException} exception will be thrown.
 * </p>
 * 
 * <p>
 * Each Tree node represent condition path in tree, based on its level it will be either default node path for its
 * parent node or path to one of key's value used by its parent node.
 * </p>
 * 
 * <p>
 * Tree start with {@link #entryNode} which is the root node of the tree and values are always stored in last node in
 * tree hierarchy. Node position is governed by conditions passed in Key and depth of tree ({@link #threshold}
 * 
 * Map put {@link #put(MultiKeyTreeMapKey, V)} operation is condition based sequential node insertion. Keys list is
 * iterated in sequence and Node insertion starts with root node, for each key if key is null, default node is inserted
 * else we lookup we look up child map with key if child node not found it insert a child node with key. Insertion is
 * then delegated to either default node or child node. This operation is continued recursively till all keys are
 * iterated and value is stored in last node.
 * 
 * </p>
 * 
 * <p>
 * Map get operation {@link #get(MultiKeyTreeMapKey)} operation is condition based sequential node navigation. Keys list
 * is iterated in sequence and Node navigation starts with root node. Navigation logic for using each key it fetch child
 * node, if key is null it navigates to default child node.
 * 
 * Navigation ends if there is there is no child node, else logic is recursed till all keys are iterated and value from
 * last node is returned.
 * <p>
 * 
 * <p>
 * Best match {@link #findBestMatch(MultiKeyTreeMapKey)} operation work exactly {@link #get(MultiKeyTreeMapKey)}
 * operation except that it navigate to default child node both when key is null or if we don't find child node using
 * key.
 * 
 * This feather allows us structure data with multiple conditions and allows us search best possible match using one
 * key.
 * 
 * </p>
 * 
 * @author <a href="mailto:harishsid@gmail.com">Harish Gavisiddaiah</a>
 * @since 2013
 * @param <K> type of keys used.
 * @param <M> implementation of {@link MultiKeyTreeMapKey} which represent group of keys.
 * @param <V> type of value stored in nodes.
 * 
 */
public class MultiKeyTreeMap<K, M extends MultiKeyTreeMapKey<K>, V> {

    public static final String NILL = "*NILL";

    /**
     * The number of key-value mappings contained in this map.
     */
    private long size;

    /** threshold defines the depth of Tree. */
    private int threshold;

    /** Root Node. */
    private TreeNode<K, V> entryNode = new TreeNode<K, V>();

    /**
     * Default constructor.
     * 
     * @param threshold define the depth of the queue which is equal number of keys/conditions used to get/put
     *            operation.
     */
    public MultiKeyTreeMap(int threshold) {
        this.threshold = threshold;
    }

    /**
     * Navigate tree nodes till all keys in {@link MultiKeyTreeMapKey} are matched and return value.
     * 
     * @param key Multi key.
     * @return value if found.
     */
    public V get(M key) {
        validateKeys(key);
        // Clone the list to make sure list is not modified while iterating.
        Iterator<K> keys = new ArrayList<K>(key.getkeys()).iterator();
        return entryNode.get(keys);
    }

    /**
     * Navigate tree nodes to match or best match all keys in {@link MultiKeyTreeMapKey} and return matched value.
     * 
     * @param key Multi key.
     * @return value if found.
     */
    public V findBestMatch(M key) {
        validateKeys(key);
        // Clone the list to make sure list is not modified while iterating.
        Iterator<K> keys = new ArrayList<K>(key.getkeys()).iterator();
        return entryNode.findBestMatch(keys);
    }

    /**
     * Navigate tree nodes to match or best match all keys in {@link MultiKeyTreeMapKey} and return matched value.
     * 
     * @param key Multi key.
     * @return value if found.
     */
    public V findBestMatch2(M key) {
        validateKeys(key);        
        return entryNode.findBestMatch2(key.getkeys());
    }

    /**
     * Store the value in Tree node which match all keys in {@link MultiKeyTreeMapKey}. Nodes inserted if they don't
     * exist for given condition.
     * 
     * @param key Mult Key.
     * @param value if found.
     */
    public void put(M key, V value) {
        validateKeys(key);
        // Clone the list to make sure list is not modified while iterating.
        Iterator<K> keys = new ArrayList<K>(key.getkeys()).iterator();
        entryNode.put(keys, value);
        size++;
    }

    /**
     * Reset the tree.
     */
    public void clear() {
        // Reset Entry node
        entryNode = new TreeNode<K, V>();
        size = 0;
    }

    /**
     * Returns the number of values stored in Tree Map.
     * 
     * Note: This is not number of nodes present in the tree.
     * 
     * @return number of values.
     */
    public long size() {
        return size;
    }

    /**
     * 
     * @param key keys to validate.
     * @return Iterator of keys.
     */
    private void validateKeys(M key) {
        if (key == null || key.getkeys() == null) {
            throw new NullPointerException();
        }
        if (threshold != key.getkeys().size()) {
            throw new IllegalArgumentException("Invalid Key specified, number conditions/key exceed queue depth "
                + threshold);
        }
    }

    /**
     * Tree Node representation with support for multiple nodes with condition and default node.
     */
    private static final class TreeNode<K, V> {
        private V value;
        private Map<Object, TreeNode<K, V>> childNodes = new HashMap<Object, TreeNode<K, V>>();
        private TreeNode<K, V> defaultChildNode;

        private V findBestMatch(Iterator<K> keys) {
            if (keys.hasNext()) {
                Object key = keys.next();
                TreeNode<K, V> childNode = defaultChildNode;
                if (key != null) {
                    TreeNode<K, V> match = childNodes.get(key);
                    if (match != null) { // If no found naviagate under Nill condition.
                        childNode = match;
                    }
                }
                if (childNode == null) {
                    return null;
                }
                return childNode.findBestMatch(keys);
            } else { // End of tree node.
                return value;
            }
        }

        private V findBestMatch2(List<K> keys) {
            if (!keys.isEmpty()) {
                List<K> searchKeys = new ArrayList<K>(keys);
                Object key = searchKeys.remove(0);
                if (key != null) {
                    TreeNode<K, V> child = childNodes.get(key);
                    if (child != null) { // If no found naviagate under Nill condition.
                        V match = child.findBestMatch2(searchKeys);
                        if (match != null) {
                            return match;
                        }
                    }
                }
                if (defaultChildNode != null) {
                    return defaultChildNode.findBestMatch2(searchKeys);
                }
                return null;
            } else { // End of tree node.
                return value;
            }
        }

        private V get(Iterator<K> keys) {
            if (keys.hasNext()) {
                Object key = keys.next();
                TreeNode<K, V> childNode = defaultChildNode;
                if (key != null) { // Always override the default Node if Key is not null for exact match.
                    childNode = childNodes.get(key);
                }
                if (childNode == null) {
                    return null;
                }
                return childNode.get(keys);
            } else {
                return value;
            }
        }

        private void put(Iterator<K> keys, V value) {
            if (keys.hasNext()) {
                Object key = keys.next();
                if (key != null) {
                    TreeNode<K, V> childNode = childNodes.get(key);
                    if (childNode == null) { // Create node if don't exist
                        childNode = new TreeNode<K, V>();
                    }
                    childNodes.put(key, childNode); // Register node with parent.
                    childNode.put(keys, value);// Recurs till end of Tree.
                } else { // Null key user defaul Node
                    if (defaultChildNode == null) {
                        defaultChildNode = new TreeNode<K, V>();
                    }
                    defaultChildNode.put(keys, value);
                }

            } else { // End of Tree
                this.value = value;
            }
        }

    }
}
