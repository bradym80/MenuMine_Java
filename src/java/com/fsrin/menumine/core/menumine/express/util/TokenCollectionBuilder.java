/*
 * Created on Jan 24, 2006
 *
 */
package com.fsrin.menumine.core.menumine.express.util;

import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.common.util.MenuMineUtil;

public class TokenCollectionBuilder {

    public Collection buildTokens(String expressQuery) {
        Collection tokens = new ArrayList();

        String[] tokensArray = expressQuery.split("[\\s]");
        for (int i = 0; i < tokensArray.length; i++) {
            String string = tokensArray[i];
            if (!MenuMineUtil.isEmpty(string)) {
                if (string.charAt(0) == '"') {
                    StringBuffer buffer = new StringBuffer();
                    buffer.append(string).append(" ");
                    i++;
                    for (; i < tokensArray.length; i++) {
                        string = tokensArray[i];
                        if (MenuMineUtil.isEmpty(string)) {
                            continue;
                        }
                        if (string.charAt(string.length() - 1) == '"') {
                            buffer.append(string).append(" ");
                            break;
                        } else {
                            buffer.append(string).append(" ");
                        }
                    }
                    String tok = buffer.toString().replace('"', ' ').trim();

                    tokens.add(tok);
                } else {
                    tokens.add(string);
                }
            }
        }

        return tokens;
    }
}
