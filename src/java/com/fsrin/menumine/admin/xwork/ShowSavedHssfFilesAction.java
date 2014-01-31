/*
 * Created on Nov 3, 2006 by Reid
 */
package com.fsrin.menumine.admin.xwork;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menumine.util.ExcelSupport;
import com.fsrin.menumine.core.menumine.util.ExcelSupportFactory;

public class ShowSavedHssfFilesAction extends
        AbstractMenuMineSessionContextAwareAction {

    private Collection fileNames;
    
    private String delete;
    
    public String execute() throws Exception {
        
        ExcelSupport excelSupport = new ExcelSupportFactory().build();
        
        File dir = new File(excelSupport.getTempFilePath());
        
        File[] files = dir.listFiles();
        
        if (this.getDelete() != null) {
            for (int i = 0; i < files.length; i++) {
                files[i].delete();
            }
            dir = new File(excelSupport.getTempFilePath());
            
            files = dir.listFiles();
            
        }
        
        fileNames = new ArrayList();
        
        for (int i = 0; i < files.length; i++) {
            fileNames.add(files[i].getName());
        }
        
        
        return SUCCESS;
    }

    public Collection getFileNames() {
        return fileNames;
    }

    public void setFileNames(Collection fileNames) {
        this.fileNames = fileNames;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

}
