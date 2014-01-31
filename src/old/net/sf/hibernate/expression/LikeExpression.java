//$Id: LikeExpression.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.expression;

/**
 *  
 */
public class LikeExpression extends SimpleExpression {

    public LikeExpression(String propertyName, Object value, boolean ignoreCase) {
        super(propertyName, value, ignoreCase);
    }

    LikeExpression(String propertyName, Object value) {
        super(propertyName, value);
    }

    LikeExpression(String propertyName, String value, MatchMode matchMode) {
        this(propertyName, matchMode.toMatchString(value));
    }

    /**
     * @see net.sf.hibernate.expression.SimpleExpression#getOp()
     */
    String getOp() {
        return " like ";
    }

}