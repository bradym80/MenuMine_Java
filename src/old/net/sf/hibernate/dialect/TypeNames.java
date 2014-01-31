//$Id: TypeNames.java,v 1.4 2005/08/24 04:33:26 nick Exp $
package net.sf.hibernate.dialect;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import net.sf.hibernate.MappingException;
import net.sf.hibernate.util.StringHelper;

/**
 * This class maps a type to names. Associations may be marked with a capacity.
 * Calling the get() method with a type and actual size n will return the
 * associated name with smallest capacity >= n, if available and an unmarked
 * default type otherwise. Eg, setting
 * 
 * <pre>
 * names.put(type, &quot;TEXT&quot;);
 * names.put(type, 255, &quot;VARCHAR($l)&quot;);
 * names.put(type, 65534, &quot;LONGVARCHAR($l)&quot;);
 * </pre>
 * 
 * will give you back the following:
 * 
 * <pre>
 * 
 *  
 *    names.get(type)         // --&gt; &quot;TEXT&quot; (default)
 *    names.get(type,    100) // --&gt; &quot;VARCHAR(100)&quot; (100 is in [0:255])
 *    names.get(type,   1000) // --&gt; &quot;LONGVARCHAR(1000)&quot; (1000 is in [256:65534])
 *    names.get(type, 100000) // --&gt; &quot;TEXT&quot; (default)
 *   
 *  
 * </pre>
 * 
 * On the other hand, simply putting
 * 
 * <pre>
 * names.put(type, &quot;VARCHAR($l)&quot;);
 * </pre>
 * 
 * would result in
 * 
 * <pre>
 * 
 *  
 *    names.get(type)        // --&gt; &quot;VARCHAR($l)&quot; (will cause trouble)
 *    names.get(type, 100)   // --&gt; &quot;VARCHAR(100)&quot;
 *    names.get(type, 10000) // --&gt; &quot;VARCHAR(10000)&quot;
 *   
 *  
 * </pre>
 * 
 * @author Christoph Beck
 */
public class TypeNames {
    private String placeholder;

    private HashMap weighted = new HashMap();

    private HashMap defaults = new HashMap();

    /**
     * Constructor.
     * 
     * @param placeholder
     *            string to be replaced by actual size/length in type names
     */
    public TypeNames(String placeholder) {
        super();

        this.placeholder = placeholder;
    }

    /**
     * get default type name for specified type
     * 
     * @param typecode
     *            the type key
     * @return the default type name associated with specified key
     */
    public String get(int typecode) throws MappingException {
        String result = (String) defaults.get(new Integer(typecode));
        if (result == null)
            throw new MappingException("No Dialect mapping for JDBC type: "
                    + typecode);
        return result;
    }

    /**
     * get type name for specified type and size
     * 
     * @param typecode
     *            the type key
     * @param size
     *            the (maximum) type size/length
     * @return the associated name with smallest capacity >= size, if available
     *         and the default type name otherwise
     */
    public String get(int typecode, int size) throws MappingException {
        Map map = (Map) weighted.get(new Integer(typecode));
        if (map != null && map.size() > 0) {
            // iterate entries ordered by capacity to find first fit
            Iterator entries = map.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                if (size <= ((Integer) entry.getKey()).intValue()) {
                    return StringHelper.replaceOnce((String) entry.getValue(),
                            placeholder, Integer.toString(size));
                }
            }
        }
        return StringHelper.replaceOnce(get(typecode), placeholder, Integer
                .toString(size));
    }

    /**
     * set a type name for specified type key and capacity
     * 
     * @param typecode
     *            the type key
     */
    public void put(int typecode, int capacity, String value) {
        TreeMap map = (TreeMap) weighted.get(new Integer(typecode));
        if (map == null) {// add new ordered map
            map = new TreeMap();
            weighted.put(new Integer(typecode), map);
        }
        map.put(new Integer(capacity), value);
    }

    /**
     * set a default type name for specified type key
     * 
     * @param typecode
     *            the type key
     */
    public void put(int typecode, String value) {
        defaults.put(new Integer(typecode), value);
    }
}

