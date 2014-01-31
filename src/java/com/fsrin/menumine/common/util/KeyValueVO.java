/*
 * Created on Sep 6, 2006 by Reid
 */
package com.fsrin.menumine.common.util;

public class KeyValueVO {

    private Long key;
    
    private String value;
    
    public KeyValueVO(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
