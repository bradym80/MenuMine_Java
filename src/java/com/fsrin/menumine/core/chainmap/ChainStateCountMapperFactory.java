/*
 * Created on Jul 19, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Nick
 */
public class ChainStateCountMapperFactory {

    private static Log log = LogFactory.getLog(ChainStateCountMapperFactory.class);
    
    public Collection getAll() {
        Collection ret = new ArrayList();

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                if (chainStateCount == null)
                    log.info("Chain state count is null");
                
                return chainStateCount.getMO();
            }

            public Object getStateKey() {

                return "MO";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getIA();
            }

            public Object getStateKey() {

                return "IA";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getIL();
            }

            public Object getStateKey() {

                return "IL";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getIN();
            }

            public Object getStateKey() {

                return "IN";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getMI();
            }

            public Object getStateKey() {

                return "MI";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getMN();
            }

            public Object getStateKey() {

                return "MN";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getND();
            }

            public Object getStateKey() {

                return "ND";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getNE();
            }

            public Object getStateKey() {

                return "NE";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getOH();
            }

            public Object getStateKey() {

                return "OH";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getOK();
            }

            public Object getStateKey() {

                return "OK";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getWI();
            }

            public Object getStateKey() {

                return "WI";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getSD();
            }

            public Object getStateKey() {

                return "SD";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.NORTH_EAST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getNH();
            }

            public Object getStateKey() {

                return "NH";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.NORTH_EAST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getME();
            }

            public Object getStateKey() {

                return "ME";
            }
        }

        );
        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.NORTH_EAST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getRI();
            }

            public Object getStateKey() {

                return "RI";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.NORTH_EAST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getDE();
            }

            public Object getStateKey() {

                return "DE";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.NORTH_EAST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getMA();
            }

            public Object getStateKey() {

                return "MA";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.NORTH_EAST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getNJ();
            }

            public Object getStateKey() {

                return "NJ";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.NORTH_EAST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getCT();
            }

            public Object getStateKey() {

                return "CT";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.NORTH_EAST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getNY();
            }

            public Object getStateKey() {

                return "NY";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.NORTH_EAST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getPA();
            }

            public Object getStateKey() {

                return "PA";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getDC();
            }

            public Object getStateKey() {

                return "DC";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getAR();
            }

            public Object getStateKey() {

                return "AR";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getGA();
            }

            public Object getStateKey() {

                return "GA";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getWV();
            }

            public Object getStateKey() {

                return "WV";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getAL();
            }

            public Object getStateKey() {

                return "AL";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.MIDWEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getKS();
            }

            public Object getStateKey() {

                return "KS";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getKY();
            }

            public Object getStateKey() {

                return "KY";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getMS();
            }

            public Object getStateKey() {

                return "MS";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getFL();
            }

            public Object getStateKey() {

                return "FL";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getNC();
            }

            public Object getStateKey() {

                return "NC";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getSC();
            }

            public Object getStateKey() {

                return "SC";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getLA();
            }

            public Object getStateKey() {

                return "LA";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getTX();
            }

            public Object getStateKey() {

                return "TX";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getMD();
            }

            public Object getStateKey() {

                return "MD";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getVA();
            }

            public Object getStateKey() {

                return "VA";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.SOUTH;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getTN();
            }

            public Object getStateKey() {

                return "TN";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getWY();
            }

            public Object getStateKey() {

                return "WY";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getID();
            }

            public Object getStateKey() {

                return "ID";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getMT();
            }

            public Object getStateKey() {

                return "MT";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getHI();
            }

            public Object getStateKey() {

                return "HI";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getWA();
            }

            public Object getStateKey() {

                return "WA";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getUT();
            }

            public Object getStateKey() {

                return "UT";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getAK();
            }

            public Object getStateKey() {

                return "AK";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getNM();
            }

            public Object getStateKey() {

                return "NM";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getNV();
            }

            public Object getStateKey() {

                return "NV";
            }
        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getCO();
            }

            public Object getStateKey() {

                return "CO";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getCA();
            }

            public Object getStateKey() {

                return "CA";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getAZ();
            }

            public Object getStateKey() {

                return "AZ";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.WEST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getOR();
            }

            public Object getStateKey() {

                return "OR";
            }

        }

        );

        ret.add(new ChainStateCountMapper() {
            public Object getKey() {
                return ChainStateCount.NORTH_EAST;
            }

            public Long getValue(ChainStateCount chainStateCount) {
                return chainStateCount.getVT();
            }

            public Object getStateKey() {

                return "VT";
            }
        }

        );

        return ret;
    }
}