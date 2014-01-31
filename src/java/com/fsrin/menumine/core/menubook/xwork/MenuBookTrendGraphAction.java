/*
 * Created on 2005-3-18
 *
 */
package com.fsrin.menumine.core.menubook.xwork;

import java.util.Collection;

import org.jfree.chart.JFreeChart;

import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.core.menubook.MenuBook;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.util.OgnlValueStack;

/**
 * @author Nick
 * @version 1
 */

public class MenuBookTrendGraphAction extends AbstractMenuMineSessionContextAwareAction{

    private JFreeChart chart;



    public String execute() throws Exception {
        Collection col = null; //= this.getStatisticalTableResults().getRows();
        OgnlValueStack stack = ActionContext.getContext().getActionInvocation()
                .getStack();

        MenuBook menuBook = (MenuBook) stack.findValue("menuBook");

        String titleString = "MenuBook Trends";

        int maxLines = 15;

        chart = MenuBookChartBuilder.singleton.buildTrendChart(menuBook,
                titleString, maxLines);

        return SUCCESS;
    }



    public JFreeChart getChart() {
        return chart;
    }



}