package net.sf.hibernate.expression;

/**
 * @author Gavin King
 */
public class EqPropertyExpression extends PropertyExpression {

    public EqPropertyExpression(String propertyName, String otherPropertyName) {
        super(propertyName, otherPropertyName);
    }

    String getOp() {
        return "=";
    }

}