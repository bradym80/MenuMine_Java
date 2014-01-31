package com.fsrin.menumine.common.webwork;

import org.springframework.context.ApplicationContextAware;
import com.fsrin.menumine.context.webwork.AbstractMenuMineSessionContextAwareAction;
import com.fsrin.menumine.common.util.FileIOUtility;

public class DatabaseUpdateDate extends AbstractMenuMineSessionContextAwareAction {
	
	private String date;
	private String submit;
	
	public String execute() throws Exception {
		
		if(this.getDate() != null) {
			FileIOUtility.setDBUpdateDate(this.getDate());
		}
		return SUCCESS;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		if(this.date == null) {
			this.date = FileIOUtility.getDBUpdateDate();
		}
		return this.date;
	}
}
