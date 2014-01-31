/*
 * Created on Jan 16, 2006
 *
 */
package com.fsrin.menumine.testutil;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.io.Resource;

public class MockApplicationContext implements ApplicationContext {

    public ApplicationContext getParent() {
        
        return null;
    }

    public String getDisplayName() {
        
        return null;
    }

    public long getStartupDate() {
        
        return 0;
    }

    public void publishEvent(ApplicationEvent arg0) {
    }

    public boolean containsBeanDefinition(String arg0) {
        
        return false;
    }

    public int getBeanDefinitionCount() {
        
        return 0;
    }

    public String[] getBeanDefinitionNames() {
        
        return null;
    }

    public String[] getBeanDefinitionNames(Class arg0) {
        
        return null;
    }

    public String[] getBeanNamesForType(Class arg0) {
        
        return null;
    }

    public String[] getBeanNamesForType(Class arg0, boolean arg1, boolean arg2) {
        
        return null;
    }

    public Map getBeansOfType(Class arg0) throws BeansException {
        
        return null;
    }

    public Map getBeansOfType(Class arg0, boolean arg1, boolean arg2) throws BeansException {
        
        return null;
    }

    public Object getBean(String arg0) throws BeansException {
        
        return null;
    }

    public Object getBean(String arg0, Class arg1) throws BeansException {
        
        return null;
    }

    public boolean containsBean(String arg0) {
        
        return false;
    }

    public boolean isSingleton(String arg0) throws NoSuchBeanDefinitionException {
        
        return false;
    }

    public Class getType(String arg0) throws NoSuchBeanDefinitionException {
        
        return null;
    }

    public String[] getAliases(String arg0) throws NoSuchBeanDefinitionException {
        
        return null;
    }

    public BeanFactory getParentBeanFactory() {
        
        return null;
    }

    public String getMessage(String arg0, Object[] arg1, String arg2, Locale arg3) {
        
        return null;
    }

    public String getMessage(String arg0, Object[] arg1, Locale arg2) throws NoSuchMessageException {
        
        return null;
    }

    public String getMessage(MessageSourceResolvable arg0, Locale arg1) throws NoSuchMessageException {
        
        return null;
    }

    public Resource[] getResources(String arg0) throws IOException {
        
        return null;
    }

    public Resource getResource(String arg0) {
        
        return null;
    }




}
