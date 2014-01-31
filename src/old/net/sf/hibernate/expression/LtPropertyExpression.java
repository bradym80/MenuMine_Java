package net.sf.hibernate.expression;

/**
 * @author Gavin King
 */
public class LtPropertyExpression extends PropertyExpression {

    public LtPropertyExpression(String propertyName, String otherPropertyName) {
        super(propertyName, otherPropertyName);
    }

    String getOp() {
        return "<";
    }

}