/*
 * Created on Aug 14, 2006 by Reid
 */
package com.fsrin.menumine.core.flavortrak.xwork;

import java.util.Collection;

import com.fsrin.menumine.core.menumine.masterfood.DistinctQueryBuilder;
import com.fsrin.menumine.core.menumine.masterfood.DistinctQueryBuilderBroker;
import com.opensymphony.xwork.Action;

public class FlavorTrakAction extends AbstractFlavorTrakContextAwareAction {

    private Collection cuisineFamily;
    
    private Collection genMenuPart;
    
    private Collection genCookingMethod;
    
    public String execute() throws Exception {
        
        initializeCollections();
        
        this.getFlavorTrakContext().setCuisineFamily(null);
        
        this.getFlavorTrakContext().setGenCookingMethod(null);
        
        this.getFlavorTrakContext().setGenMenuPart(null);
        
        return Action.SUCCESS;
    }
    
    protected void initializeCollections() {
        
        //
        DistinctQueryBuilder builder = DistinctQueryBuilderBroker.getInstance();
        
        this.setCuisineFamily(builder.getCuisineFamily());
        
        this.setGenCookingMethod(builder.getGenCookingMethod());
        
        this.setGenMenuPart(builder.getMenuPart());
        
    }

    public Collection getCuisineFamily() {
        return cuisineFamily;
    }

    public void setCuisineFamily(Collection cuisineFamily) {
        this.cuisineFamily = cuisineFamily;
    }

    public Collection getGenCookingMethod() {
        return genCookingMethod;
    }

    public void setGenCookingMethod(Collection genCookingMethod) {
        this.genCookingMethod = genCookingMethod;
    }

    public Collection getGenMenuPart() {
        return genMenuPart;
    }

    public void setGenMenuPart(Collection genMenuPart) {
        this.genMenuPart = genMenuPart;
    }
    
}
