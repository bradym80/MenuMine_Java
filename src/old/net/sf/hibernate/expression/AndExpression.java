//$Id: AndExpression.java,v 1.2 2005/04/03 06:29:03 nick Exp $
package net.sf.hibernate.expression;

/**
 * A logical "and"
 * 
 * @author Gavin King
 */
public class AndExpression extends LogicalExpression {

    String getOp() {
        return "and";
    }

    AndExpression(Criterion lhs, Criterion rhs) {
        super(lhs, rhs);
    }

}