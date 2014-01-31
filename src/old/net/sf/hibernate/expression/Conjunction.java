package net.sf.hibernate.expression;

/**
 * @author Gavin King
 */
public class Conjunction extends Junction {

    /**
     * @see net.sf.hibernate.expression.Junction#getOp()
     */
    String getOp() {
        return " and ";
    }

}