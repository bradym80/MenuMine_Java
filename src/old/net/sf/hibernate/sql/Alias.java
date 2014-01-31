//$Id: Alias.java,v 1.2 2005/04/03 06:29:05 nick Exp $
package net.sf.hibernate.sql;

import net.sf.hibernate.dialect.Dialect;

/**
 * An alias generator for SQL identifiers
 * 
 * @author Gavin King
 */
public final class Alias {

    private final int length;

    private final String suffix;

    /**
     * Constructor for Alias.
     */
    public Alias(int length, String suffix) {
        super();
        this.length = (suffix == null) ? length : length - suffix.length();
        this.suffix = suffix;
    }

    /**
     * Constructor for Alias.
     */
    public Alias(String suffix) {
        super();
        this.length = Integer.MAX_VALUE;
        this.suffix = suffix;
    }

    public String toAliasString(String sqlIdentifier) {
        char begin = sqlIdentifier.charAt(0);
        int quoteType = Dialect.QUOTE.indexOf(begin);
        String unquoted = getUnquotedAliasString(sqlIdentifier, quoteType);
        if (quoteType >= 0) {
            char endQuote = Dialect.CLOSED_QUOTE.charAt(quoteType);
            return begin + unquoted + endQuote;
        } else {
            return unquoted;
        }
    }

    public String toUnquotedAliasString(String sqlIdentifier) {
        return getUnquotedAliasString(sqlIdentifier);
    }

    private String getUnquotedAliasString(String sqlIdentifier) {
        char begin = sqlIdentifier.charAt(0);
        int quoteType = Dialect.QUOTE.indexOf(begin);
        return getUnquotedAliasString(sqlIdentifier, quoteType);
    }

    private String getUnquotedAliasString(String sqlIdentifier, int quoteType) {
        String unquoted = sqlIdentifier;
        if (quoteType >= 0) {
            unquoted = unquoted.substring(1, unquoted.length() - 1);
        }
        if (unquoted.length() > length) {
            unquoted = unquoted.substring(0, length);
        }
        if (suffix == null) {
            return unquoted;
        } else {
            return unquoted + suffix;
        }
    }

    public String[] toUnquotedAliasStrings(String[] sqlIdentifiers) {
        String[] aliases = new String[sqlIdentifiers.length];
        for (int i = 0; i < sqlIdentifiers.length; i++) {
            aliases[i] = toUnquotedAliasString(sqlIdentifiers[i]);
        }
        return aliases;
    }

    public String[] toAliasStrings(String[] sqlIdentifiers) {
        String[] aliases = new String[sqlIdentifiers.length];
        for (int i = 0; i < sqlIdentifiers.length; i++) {
            aliases[i] = toAliasString(sqlIdentifiers[i]);
        }
        return aliases;
    }

}