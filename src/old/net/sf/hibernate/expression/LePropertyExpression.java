package net.sf.hibernate.expression;

/**
 * @author Gavin King
 */
public class LePropertyExpression extends PropertyExpression {

    public LePropertyExpression(String propertyName, String otherPropertyName) {
        super(propertyName, otherPropertyName);
    }

    String getOp() {
        return "<=";
    }

}