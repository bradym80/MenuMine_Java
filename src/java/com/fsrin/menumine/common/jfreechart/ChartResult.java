/*
 * Created on Jan 20, 2005
 *
 * 
 */
package com.fsrin.menumine.common.jfreechart;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.Result;

/**
 * @author Nick
 * 
 *  
 */
public class ChartResult implements Result {

    private int width;

    private int height;

    public void execute(ActionInvocation invocation) throws Exception {
        JFreeChart chart = (JFreeChart) invocation.getStack()
                .findValue("chart");
        HttpServletResponse response = ServletActionContext.getResponse();
        OutputStream os = response.getOutputStream();

        ChartUtilities.writeChartAsPNG(os, chart, width, height);
        os.flush();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}