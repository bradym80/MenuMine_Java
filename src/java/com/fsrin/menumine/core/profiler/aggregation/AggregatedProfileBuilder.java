/*
 * Created on Apr 20, 2006 by Reid
 */
package com.fsrin.menumine.core.profiler.aggregation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import ognl.Ognl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fsrin.menumine.common.FilterParameter;
import com.fsrin.menumine.common.dao.GenericDAOFactory;
import com.fsrin.menumine.common.dao.GenericResultCounter;
import com.fsrin.menumine.common.webwork.MMSorter;
import com.fsrin.menumine.core.menumine.FieldEnum;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParameters;
import com.fsrin.menumine.core.menumine.MasterFoodFilterParametersImpl;
import com.fsrin.menumine.core.menumine.express.util.SearchableTokenBuilder;
import com.fsrin.menumine.core.menumine.masterfood.hql.MasterFoodQueryBuilder;

public class AggregatedProfileBuilder {

    private Log log = LogFactory.getLog(AggregatedProfileBuilder.class);

    public Collection<Profile> buildApplications(
            ProfileFieldListProvider fieldListProvider, String searchString)
            throws Exception {

        Collection<AggregatedProfileFieldEnumImpl> temp = new ArrayList<AggregatedProfileFieldEnumImpl>();

        Collection<String> tokens = new SearchableTokenBuilder()
                .buildSearchableToken(searchString);

        if (tokens.size() == 0) {
            return new ArrayList<Profile>();
        }

        GenericResultCounter counter = new GenericResultCounter();

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        for (Iterator iter = fieldListProvider.getFields().iterator(); iter
                .hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();

            MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

            FilterParameter fp = (FilterParameter) Ognl.getValue(element
                    .getOgnlName(), p);

            fp.setSelect(true);
            fp.setAndValues(tokens);

            Integer[] counts = counter.getTwoCounts(builder
                    .getQueryForProfileApplicationsCount(p).toString());

            AggregatedProfileFieldEnumImpl profile = new AggregatedProfileFieldEnumImpl();

            profile.setFieldEnum(element);
            profile.setNumberOfApplications(counts[0].longValue());
            profile.setNumberOfOperationsUsing(counts[1].longValue());

            temp.add(profile);

        }

        long total = 0;
        for (Iterator<AggregatedProfileFieldEnumImpl> iter = temp.iterator(); iter
                .hasNext();) {
            AggregatedProfileFieldEnumImpl c = iter.next();
            total += c.getNumberOfApplications();
        }

        for (Iterator<AggregatedProfileFieldEnumImpl> iter = temp.iterator(); iter
                .hasNext();) {
            AggregatedProfileFieldEnumImpl c = iter.next();
            c.setTotalApplications(total);
        }

        Collection<Profile> ret = new TreeSet<Profile>(new TreeSet(
                new MMSorter().getDescending("numberOfApplications", "name")));

        ret.addAll(temp);

        return ret;

    }

    public Collection buildOperatorShare(
            ProfileFieldListProvider fieldListProvider, String searchString,
            String applicationFocus) throws Exception {

        Collection<AggregatedProfileNameableImpl> temp = new ArrayList<AggregatedProfileNameableImpl>();

        Collection<String> tokens = new SearchableTokenBuilder()
                .buildSearchableToken(searchString);

        if (tokens.size() == 0) {
            return new ArrayList<Profile>();
        }

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        MasterFoodFilterParameters p = this.buildParameters(fieldListProvider,
                tokens, applicationFocus);

        /*
         * disjunctive count query.
         */
        String hql = builder.getQueryForProfileOperatorShareCount(p).toString();

        log.info("query: " + hql);

        Collection raw = GenericDAOFactory.factory.buildData().find(hql);

        for (Iterator iter = raw.iterator(); iter.hasNext();) {
            Object[] element = (Object[]) iter.next();
            AggregatedProfileNameableImpl profile = new AggregatedProfileNameableImpl();
            profile.setName((String) element[1]);
            profile.setNumberOfApplications(((Integer) element[0]).longValue());

            temp.add(profile);
        }

        /*
         * sums it all up.
         */
        long total = 0;
        for (Iterator<AggregatedProfileNameableImpl> iter = temp.iterator(); iter
                .hasNext();) {
            AggregatedProfileNameableImpl c = iter.next();
            total += c.getNumberOfApplications();
        }

        for (Iterator<AggregatedProfileNameableImpl> iter = temp.iterator(); iter
                .hasNext();) {
            AggregatedProfileNameableImpl c = iter.next();
            c.setTotalApplications(total);
        }

        Collection<Profile> ret = new TreeSet<Profile>(new TreeSet(
                new MMSorter().getDescending("numberOfApplications", "name")));

        ret.addAll(temp);

        return ret;

    }

    public Collection buildSegmentShare(
            ProfileFieldListProvider fieldListProvider, String searchString,
            String applicationFocus) throws Exception {

        Collection<AggregatedProfileNameableImpl> temp = new ArrayList<AggregatedProfileNameableImpl>();

        Collection<String> tokens = new SearchableTokenBuilder()
                .buildSearchableToken(searchString);

        if (tokens.size() == 0) {
            return new ArrayList<Profile>();
        }

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        MasterFoodFilterParameters p = this.buildParameters(fieldListProvider,
                tokens, applicationFocus);

        /*
         * disjunctive count query.
         */
        String hql = builder.getQueryForProfileSegmentShareCount(p).toString();

        log.info("query: " + hql);

        this.populateTempCollectionWithData(temp, hql);

        Collection<Profile> ret = new TreeSet<Profile>(new TreeSet(
                new MMSorter().getDescending("numberOfApplications", "name")));

        ret.addAll(temp);

        return ret;

    }

    public Collection buildSectorShare(
            ProfileFieldListProvider fieldListProvider, String searchString,
            String applicationFocus) throws Exception {

        Collection<AggregatedProfileNameableImpl> temp = new ArrayList<AggregatedProfileNameableImpl>();

        Collection<String> tokens = new SearchableTokenBuilder()
                .buildSearchableToken(searchString);

        if (tokens.size() == 0) {
            return new ArrayList<Profile>();
        }

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        MasterFoodFilterParameters p = this.buildParameters(fieldListProvider,
                tokens, applicationFocus);

        /*
         * disjunctive count query.
         */
        String hql = builder.getQueryForProfileSectorShareCount(p).toString();

        log.info("query: " + hql);

        this.populateTempCollectionWithData(temp, hql);

        Collection<Profile> ret = new TreeSet<Profile>(new TreeSet(
                new MMSorter().getDescending("numberOfApplications", "name")));

        ret.addAll(temp);

        return ret;

    }

    public void populateTempCollectionWithData(Collection temp, String hql) {

        Collection raw = GenericDAOFactory.factory.buildData().find(hql);

        for (Iterator iter = raw.iterator(); iter.hasNext();) {
            Object[] element = (Object[]) iter.next();
            AggregatedProfileNameableImpl profile = new AggregatedProfileNameableImpl();
            profile.setName((String) element[2]);
            profile.setNumberOfApplications(((Integer) element[0]).longValue());
            profile.setNumberOfOperationsUsing(((Integer) element[1])
                    .longValue());

            temp.add(profile);
        }

        /*
         * sums it all up.
         */
        long total = 0;
        for (Iterator<AggregatedProfileNameableImpl> iter = temp.iterator(); iter
                .hasNext();) {
            AggregatedProfileNameableImpl c = iter.next();
            total += c.getNumberOfApplications();
        }

        for (Iterator<AggregatedProfileNameableImpl> iter = temp.iterator(); iter
                .hasNext();) {
            AggregatedProfileNameableImpl c = iter.next();
            c.setTotalApplications(total);
        }

    }

    public MasterFoodFilterParameters buildParameters(
            ProfileFieldListProvider fieldListProvider, Collection tokens,
            String applicationFocus) throws Exception {

        MasterFoodFilterParameters p = null;

        if (applicationFocus == null || applicationFocus.trim().length() == 0) {
            p = buildAllParameters(fieldListProvider, tokens);
        } else {
            p = buildSingleParameters(tokens, applicationFocus);
        }

        return p;
    }

    public MasterFoodFilterParameters buildAllParameters(
            ProfileFieldListProvider fieldListProvider, Collection tokens)
            throws Exception {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        for (Iterator iter = fieldListProvider.getFields().iterator(); iter
                .hasNext();) {
            FieldEnum element = (FieldEnum) iter.next();

            FilterParameter fp = (FilterParameter) Ognl.getValue(element
                    .getOgnlName(), p);

            fp.setAndValues(tokens);

        }

        return p;
    }

    public MasterFoodFilterParameters buildSingleParameters(Collection tokens,
            String applicationFocus) throws Exception {

        MasterFoodFilterParameters p = new MasterFoodFilterParametersImpl();

        FilterParameter fp = (FilterParameter) Ognl.getValue(applicationFocus,
                p);

        fp.setAndValues(tokens);

        return p;
    }

    public Profile buildBigPicture(ProfileFieldListProvider fieldListProvider,
            String searchString) throws Exception {

        Collection<String> tokens = new SearchableTokenBuilder()
                .buildSearchableToken(searchString);

        if (tokens.size() == 0) {
            return new AggregatedProfileNameableImpl();
        }

        MasterFoodQueryBuilder builder = new MasterFoodQueryBuilder();

        MasterFoodFilterParameters p = this.buildParameters(fieldListProvider,
                tokens, null);

        /*
         * disjunctive count query.
         */
        String hql = builder.getQueryForProfileApplicationsCount(p).toString();

        log.info("query: " + hql);

        Integer[] counts = new GenericResultCounter().getTwoCounts(hql);

        AggregatedProfileNameableImpl ret = new AggregatedProfileNameableImpl();
        ret.setName("Big Picture");
        ret.setNumberOfApplications(counts[0].longValue());
        ret.setNumberOfOperationsUsing(counts[1].longValue());
        ret.setTotalApplications(counts[0].longValue());

        return ret;
    }
}
