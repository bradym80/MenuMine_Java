/*
 * Created on May 13, 2005
 *
 * 
 */
package com.fsrin.menumine.core.flare;

import java.io.File;
import java.util.Date;
import java.util.Random;

import com.fsrin.menumine.common.Settings;

/**
 * @author Nick
 * 
 *  
 */
public class FlareImageService {

    private String[] files;

    private Random random;

    public FlareImageService() {
        super();

        random = new Random(new Date().getTime());
    }

    private void init() {
        /*
         * This has to be called after the context is init.
         */
        File stream = new File(System.getProperty(Settings.CONTEXT_PATH)
                + "/flare/");

        File[] f = stream.listFiles();
        this.files = new String[f.length];
        if (f != null) {
            for (int i = 0; i < f.length; i++) {
                File file = f[i];

                if (file.getName().indexOf(".jpg") > 0
                        || file.getName().indexOf(".gif") > 0) {
                    files[i] = "flare/" + file.getName();
                }
            }
        }

    }

    public String getRandomImagePath() {
        if (files == null) {
            this.init();
        }
        int index = Math.abs(random.nextInt() % files.length);
        String img = files[index];

        return img;
    }
}