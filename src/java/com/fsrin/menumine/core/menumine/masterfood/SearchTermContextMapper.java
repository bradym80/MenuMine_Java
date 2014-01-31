/*
 * Created on Aug 23, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menumine.masterfood;

import java.util.HashMap;

/**
 * @author Nick
 * 
 * This class allows us to add some context to a seach term.
 * 
 * For instance if we search Beef, we don't want to include beefsteak tomato. or
 * If we search BBQ or Barbecue we expect the same results.
 *  
 */
public class SearchTermContextMapper {

    public static SearchTermContextMapper singleton = new SearchTermContextMapper();

    private SearchTermContextMapper() {
        super();

        SearchTermContext context = new SearchTermContext("bbq");

        context.getOrTerms().add(context.getKeyTerm());
        context.getOrTerms().add("b-b-q");
        context.getOrTerms().add("b-b-que");
        context.getOrTerms().add("barbecue");
        context.getOrTerms().add("barbeque");
        searchTermContextMap.put(context.getKeyTerm(), context);

        context = new SearchTermContext("b-b-q");
        context.getOrTerms().add(context.getKeyTerm());
        context.getOrTerms().add("bbq");
        context.getOrTerms().add("b-b-que");
        context.getOrTerms().add("barbecue");
        context.getOrTerms().add("barbeque");
        searchTermContextMap.put(context.getKeyTerm(), context);

        context = new SearchTermContext("b-b-que");
        context.getOrTerms().add(context.getKeyTerm());
        context.getOrTerms().add("bbq");
        context.getOrTerms().add("b-b-q");
        context.getOrTerms().add("barbecue");
        context.getOrTerms().add("barbeque");
        searchTermContextMap.put(context.getKeyTerm(), context);

        context = new SearchTermContext("barbecue");
        context.getOrTerms().add(context.getKeyTerm());
        context.getOrTerms().add("bbq");
        context.getOrTerms().add("b-b-q");
        context.getOrTerms().add("b-b-que");
        context.getOrTerms().add("barbeque");
        searchTermContextMap.put(context.getKeyTerm(), context);

        context = new SearchTermContext("barbeque");
        context.getOrTerms().add(context.getKeyTerm());
        context.getOrTerms().add("bbq");
        context.getOrTerms().add("b-b-q");
        context.getOrTerms().add("b-b-que");
        context.getOrTerms().add("barbecue");
        searchTermContextMap.put(context.getKeyTerm(), context);

        context = new SearchTermContext("ham");
        context.getAndTerms().add(context.getKeyTerm());
        context.getNotTerms().add("burger");
        searchTermContextMap.put(context.getKeyTerm(), context);

        context = new SearchTermContext("poultry");
        context.getOrTerms().add(context.getKeyTerm());
        context.getOrTerms().add("chicken");
        context.getOrTerms().add("duck");
        context.getOrTerms().add("turkey");
        context.getOrTerms().add("goose");
        searchTermContextMap.put(context.getKeyTerm(), context);

        context = new SearchTermContext("beef");
        context.getAndTerms().add(context.getKeyTerm());
        context.getNotTerms().add("tomato");
        searchTermContextMap.put(context.getKeyTerm(), context);

    }

    public SearchTermContext find(String seachTerm) {

        return (SearchTermContext) searchTermContextMap.get(seachTerm);
    }

    private HashMap searchTermContextMap = new HashMap();

}