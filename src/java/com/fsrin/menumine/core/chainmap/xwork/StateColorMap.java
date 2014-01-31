/*
 * Created on Aug 5, 2005
 *
 * 
 */
package com.fsrin.menumine.core.chainmap.xwork;

import java.awt.Color;
import java.util.HashMap;

/**
 * @author Nick
 * 
 *  
 */
public class StateColorMap {

    private static HashMap stateColorMap = new HashMap();

    //    static {
    //        stateColorMap.put(new Color(95, 207, 202), "MO");
    //
    //        stateColorMap.put(new Color(162, 219, 216), "IA");
    //
    //        stateColorMap.put(new Color(76, 198, 244), "IL");
    //
    //        stateColorMap.put(new Color(244, 153, 195), "IN");
    //
    //        stateColorMap.put(new Color(247, 184, 211), "MI");
    //
    //        stateColorMap.put(new Color(115, 203, 127), "MN");
    //
    //        stateColorMap.put(new Color(214, 233, 185), "ND");
    //
    //        stateColorMap.put(new Color(175, 215, 120), "NE");
    //
    //        stateColorMap.put(new Color(242, 76, 174), "OH");
    //
    //        stateColorMap.put(new Color(163, 214, 159), "OK");
    //
    //        stateColorMap.put(new Color(76, 210, 247), "WI");
    //
    //        stateColorMap.put(new Color(197, 224, 157), "SD");
    //
    //        stateColorMap.put(new Color(81, 76, 129), "NH");
    //
    //        stateColorMap.put(new Color(145, 77, 143), "ME");
    //
    //        stateColorMap.put(new Color(76, 140, 165), "RI");
    //
    //        stateColorMap.put(new Color(167, 162, 76), "DE");
    //
    //        stateColorMap.put(new Color(76, 159, 190), "MA");
    //
    //        
    //        
    //         stateColorMap.put(new Color(76, 158, 188), "MA");
    //       
    //        
    //        
    //        
    //        stateColorMap.put(new Color(120, 148, 92), "NJ");
    //
    //        stateColorMap.put(new Color(76, 138, 102), "CT");
    //
    //        stateColorMap.put(new Color(76, 156, 114), "NY");
    //
    //        stateColorMap.put(new Color(138, 169, 103), "PA");
    //
    //        stateColorMap.put(new Color(81, 104, 175), "DC");
    //
    //        stateColorMap.put(new Color(172, 195, 186), "AR");
    //
    //        stateColorMap.put(new Color(136, 157, 206), "GA");
    //
    //        stateColorMap.put(new Color(162, 108, 76), "WV");
    //
    //        stateColorMap.put(new Color(167, 179, 218), "AL");
    //
    //        stateColorMap.put(new Color(190, 224, 186), "KS");
    //
    //        stateColorMap.put(new Color(164, 193, 228), "KY");
    //
    //        stateColorMap.put(new Color(76, 155, 208), "MS");
    //
    //        stateColorMap.put(new Color(108, 110, 178), "FL");
    //
    //        stateColorMap.put(new Color(161, 76, 76), "NC");
    //
    //        stateColorMap.put(new Color(186, 82, 85), "SC");
    //
    //        stateColorMap.put(new Color(153, 221, 249), "LA");
    //
    //        stateColorMap.put(new Color(255, 246, 76), "TX");
    //
    //        stateColorMap.put(new Color(196, 188, 76), "MD");
    //
    //        stateColorMap.put(new Color(188, 122, 83), "VA");
    //
    //        stateColorMap.put(new Color(124, 174, 218), "TN");
    //
    //        stateColorMap.put(new Color(252, 191, 125), "WY");
    //
    //        stateColorMap.put(new Color(205, 189, 154), "ID");
    //
    //        stateColorMap.put(new Color(253, 209, 161), "MT");
    //
    //        stateColorMap.put(new Color(107, 109, 89), "HI");
    //
    //        stateColorMap.put(new Color(248, 171, 148), "WA");
    //
    //        stateColorMap.put(new Color(249, 169, 73), "UT");
    //
    //        stateColorMap.put(new Color(184, 187, 153), "AK");
    //
    //        stateColorMap.put(new Color(255, 246, 134), "NM");
    //
    //        stateColorMap.put(new Color(248, 165, 119), "NV");
    //
    //        stateColorMap.put(new Color(255, 249, 173), "CO");
    //
    //        stateColorMap.put(new Color(241, 73, 79), "CA");
    //
    //        stateColorMap.put(new Color(245, 138, 77), "AZ");
    //
    //        stateColorMap.put(new Color(245, 137, 113), "OR");
    //
    //        stateColorMap.put(new Color(94, 89, 146), "VT");
    //    }

    public StateColorMap() {
        super();

    }

    public static String getState(Color srcColor) {
        stateColorMap.put(new Color(95, 207, 202), "MO");

        stateColorMap.put(new Color(162, 219, 216), "IA");

        stateColorMap.put(new Color(76, 198, 244), "IL");

        stateColorMap.put(new Color(244, 153, 195), "IN");

        stateColorMap.put(new Color(247, 184, 211), "MI");

        stateColorMap.put(new Color(115, 203, 127), "MN");

        stateColorMap.put(new Color(214, 233, 185), "ND");

        stateColorMap.put(new Color(175, 215, 120), "NE");

        stateColorMap.put(new Color(242, 76, 174), "OH");

        stateColorMap.put(new Color(163, 214, 159), "OK");

        stateColorMap.put(new Color(76, 210, 247), "WI");

        stateColorMap.put(new Color(197, 224, 157), "SD");

        stateColorMap.put(new Color(81, 76, 129), "NH");

        stateColorMap.put(new Color(145, 77, 143), "ME");

        stateColorMap.put(new Color(76, 140, 165), "RI");

        stateColorMap.put(new Color(167, 162, 76), "DE");

        stateColorMap.put(new Color(76, 159, 190), "MA");
        //  stateColorMap.put(new Color(76, 157, 188), "MA");
        // stateColorMap.put(new Color(76, 158, 188), "MA");

        stateColorMap.put(new Color(120, 148, 92), "NJ");

        // stateColorMap.put(new Color(76, 138, 103), "CT");

        stateColorMap.put(new Color(76, 138, 102), "CT");
        //   stateColorMap.put(new Color(78, 130, 86), "CT");

        stateColorMap.put(new Color(76, 156, 114), "NY");

        stateColorMap.put(new Color(138, 169, 103), "PA");

        stateColorMap.put(new Color(81, 104, 175), "DC");

        stateColorMap.put(new Color(76, 195, 186), "AR");

        stateColorMap.put(new Color(136, 157, 206), "GA");

        stateColorMap.put(new Color(162, 108, 76), "WV");

        stateColorMap.put(new Color(168, 179, 218), "AL");

        stateColorMap.put(new Color(190, 224, 186), "KS");

        stateColorMap.put(new Color(164, 193, 228), "KY");

        stateColorMap.put(new Color(76, 155, 208), "MS");

        stateColorMap.put(new Color(108, 110, 178), "FL");

        stateColorMap.put(new Color(161, 76, 76), "NC");

        stateColorMap.put(new Color(186, 82, 85), "SC");

        stateColorMap.put(new Color(153, 221, 249), "LA");

        stateColorMap.put(new Color(255, 246, 76), "TX");

        stateColorMap.put(new Color(196, 188, 76), "MD");

        stateColorMap.put(new Color(188, 122, 83), "VA");

        stateColorMap.put(new Color(124, 174, 218), "TN");

        stateColorMap.put(new Color(252, 191, 125), "WY");

        stateColorMap.put(new Color(250, 189, 154), "ID");

        stateColorMap.put(new Color(253, 209, 161), "MT");

        stateColorMap.put(new Color(107, 109, 89), "HI");

        stateColorMap.put(new Color(248, 171, 148), "WA");

        stateColorMap.put(new Color(249, 169, 73), "UT");

        stateColorMap.put(new Color(184, 187, 153), "AK");

        stateColorMap.put(new Color(255, 246, 134), "NM");

        stateColorMap.put(new Color(248, 165, 119), "NV");

        stateColorMap.put(new Color(255, 249, 173), "CO");

        stateColorMap.put(new Color(241, 73, 79), "CA");

        stateColorMap.put(new Color(245, 132, 77), "AZ");

        stateColorMap.put(new Color(245, 137, 113), "OR");

        stateColorMap.put(new Color(94, 89, 146), "VT");

        /*
         * Nope
         */
        // stateColorMap.put(new Color(19, 60, 27), "VT");
        if (new Color(255, 255, 255).getRGB() == srcColor.getRGB()) {
            return null;
        }

        if (stateColorMap.containsKey(srcColor)) {
            return (String) stateColorMap.get(srcColor);
        } else {
            //   System.out.println(srcColor.getRed()+":"+srcColor.getGreen()+":"+srcColor.getBlue());

            return null;
        }
    }

}