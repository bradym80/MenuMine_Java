/*
 * Copyright 2003 Jayson Falkner (jayson@jspinsider.com)
 * This code is from "Servlets and JavaServer pages; the J2EE Web Tier",
 * http://www.jspbook.com. You may freely use the code both commercially
 * and non-commercially. If you like the code, please pick up a copy of
 * the book and help support the authors, development of more free code,
 * and the JSP/Servlet/J2EE community.
 */
package com.fsrin.utils.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author Reid
 *
 */
public class GZIPFilter implements Filter {

    private Log log = LogFactory.getLog(GZIPFilter.class);
    
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        if (req instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
                
            if (this.isCompressable(request)) {
                log.debug("GZIP supported, compressing.");
                GZIPResponseWrapper wrappedResponse = new GZIPResponseWrapper(
                        response);
                chain.doFilter(req, wrappedResponse);
                wrappedResponse.finishResponse();
                return;
            
            }
            chain.doFilter(req, res);
        }
    }

    public void init(FilterConfig filterConfig) {
        // noop
    }

    public void destroy() {
        // noop
    }
    
    private boolean isCompressable(HttpServletRequest request) {
        

        String ae = request.getHeader("accept-encoding");
        log.debug("accept encoding is " + ae);
        
        if (ae != null && ae.indexOf("gzip") != -1) {
            log.debug("accept encoding indicates compressable.");
            return true;
        }
        
        String ua = request.getHeader("user-agent");
        log.debug("user agent is " + ua);
        
        if (ua != null && (ua.indexOf("Firefox") != -1 || ua.indexOf("MSIE") != -1)) {
            log.debug("user agent indicates compressable");
            return true;
        }
        
        log.info("doesn't appear compressable ");
        return false;

        
        
    }
}
