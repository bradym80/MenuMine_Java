package net.sf.hibernate.expression;

/**
 * @author Gavin King
 */
public class Disjunction extends Junction {

    /**
     * @see net.sf.hibernate.expression.Junction#getOp()
     */
    String getOp() {
        return " or ";
    }

}