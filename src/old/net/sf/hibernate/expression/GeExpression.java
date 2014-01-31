//$Id: GeExpression.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.expression;

/**
 * @author Gavin King
 */
public class GeExpression extends SimpleExpression {

    GeExpression(String propertyName, Object value) {
        super(propertyName, value);
    }

    /**
     * @see net.sf.hibernate.expression.SimpleExpression#getOp()
     */
    String getOp() {
        return ">=";
    }

}