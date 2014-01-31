/*
 * Created on Apr 11, 2005
 *
 * 
 */
package com.fsrin.menumine.core.menucam;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.common.Settings;
import com.fsrin.menumine.core.chainstat.ChainStat;

/**
 * @author Nick
 * 
 * This will take a Chain and find all of the fileNames of the associated
 * menucam images.
 *  
 */
public class MenuCamManager {

    public Collection getFiles(ChainStat chain) {
        Collection files = new ArrayList();
        String chainName = chain.getOperationName();
        chainName = chainName.toLowerCase().trim();

        chainName = chainName.replaceAll("\\W", "");

        File stream = new File(System.getProperty(Settings.CONTEXT_PATH)
                + "/menucam/" + chainName);

        File[] f = stream.listFiles();
        if (f != null) {
            for (int i = 0; i < f.length; i++) {
                File file = f[i];
                if (file.getName().indexOf(".jpg") > 0
                        || file.getName().indexOf(".gif") > 0) {
                    files.add("menucam/" + chainName + "/" + file.getName());
                }
            }
        }

        return files;
    }

}