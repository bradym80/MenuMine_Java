/*
 * Created on Apr 12, 2006 by Reid
 */
package com.fsrin.menumine.users;

public class UserPreference {

    private Long id;
    
    private String username;
    
    private String key;
    
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
