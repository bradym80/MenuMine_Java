/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express.util;

import java.util.Collection;

import junit.framework.TestCase;

public class TokenCollectionBuilderTest extends TestCase {

    public void testBasic() throws Exception {
        
        Collection tokens = new TokenCollectionBuilder().buildTokens("chicken");
        
        assertTrue(tokens.size() == 1);
        
    }
    
    public void testLongerString() throws Exception {
        
        String query = "chicken feta wonderbread";
        
        Collection tokens = new TokenCollectionBuilder().buildTokens(query);
        
        assertTrue(tokens.size() == 3);
        
    }
    
    public void testQuotedString() throws Exception {
        String query = "\"one and two\"";

        Collection tokens = new TokenCollectionBuilder().buildTokens(query);
        
        assertTrue(tokens.size() == 1);
        
    }
    
    public void testMultipleQuotedStrings() throws Exception {
        String query = "\"one and two\" \"three and four\"";

        Collection tokens = new TokenCollectionBuilder().buildTokens(query);
        
        assertTrue(tokens.size() == 2);
        
    }
    
    public void testQuotedStringAndPlainData() throws Exception {
        String query = "\"one and two\" three four five";

        Collection tokens = new TokenCollectionBuilder().buildTokens(query);
        
        assertTrue(tokens.size() == 4);
        
    }
}
