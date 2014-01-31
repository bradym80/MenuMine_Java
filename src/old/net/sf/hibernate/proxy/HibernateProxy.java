// $Id: HibernateProxy.java,v 1.2 2005/04/03 06:29:04 nick Exp $
package net.sf.hibernate.proxy;

import java.io.Serializable;

public interface HibernateProxy extends Serializable {
    public Object writeReplace();
}

