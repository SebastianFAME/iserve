/*
    See lda-top/LICENCE (or http://elda.googlecode.com/hg/LICENCE)
    for the licence for this software.
    
    (c) Copyright 2011 Epimorphics Limited
    $Id$
*/
package com.epimorphics.lda.core;

import com.epimorphics.lda.support.PrefixLogger;

import java.util.ArrayList;

@SuppressWarnings("serial")
class ChainTrees extends ArrayList<ChainTree> {

    public void renderTriples(StringBuilder sb, PrefixLogger pl) {
        for (ChainTree c : this) c.renderTriples(sb, pl);
    }

    public String renderWhere(StringBuilder sb, PrefixLogger pl, String u) {
        for (ChainTree c : this) {
            sb.append(u);
            c.renderWhere(sb, pl);
            u = "UNION ";
        }
        return u;
    }
}