package com.googlecode.projeto1.client.panels.modality;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.RowLayoutData;

public class ModalityPanel extends Panel {
	
	private NorthModalityPanel northPanel;
	private CenterModalityPanel centerPanel;
	
	public ModalityPanel(){
		super(); 
		this.setFrame(true);
		this.northPanel = new NorthModalityPanel();
		this.centerPanel = new CenterModalityPanel();
		this.add(northPanel, new RowLayoutData("20%"));
		this.setAutoScroll(true);
		this.add(centerPanel, new RowLayoutData(300));		
	}

}
