//$Id: OrExpression.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.expression;

/**
 * A logical "or"
 * 
 * @author Gavin King
 */
public class OrExpression extends LogicalExpression {

    String getOp() {
        return "or";
    }

    OrExpression(Criterion lhs, Criterion rhs) {
        super(lhs, rhs);
    }

}