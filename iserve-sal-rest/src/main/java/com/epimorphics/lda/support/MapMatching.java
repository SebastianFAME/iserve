/*
    See lda-top/LICENCE (or http://elda.googlecode.com/hg/LICENCE)
    for the licence for this software.
    
    (c) Copyright 2011 Epimorphics Limited
    $Id$
*/
package com.epimorphics.lda.support;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Fetch values from a Properties. There may be multiple matching keys.
 * Map values represent sets of strings by being cut with commas.
 *
 * @author chris
 */
public class MapMatching {

    public static Set<String> allValuesWithMatchingKey(String key, Properties p) {
        Set<String> result = new HashSet<String>();
        for (Object ko : p.keySet()) {
            String k = ko.toString();
            if (accepts(key, k))
                result.addAll(Arrays.asList(p.get(k).toString().split(",")));
        }
        return result;
    }


    public static boolean accepts(String pattern, String key) {
        return
                pattern.equals(key)
                        || (pattern.endsWith(".*") && key.startsWith(pattern.substring(0, pattern.length() - 1)))
                ;
    }
}
