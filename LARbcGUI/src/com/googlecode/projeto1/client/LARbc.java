package com.googlecode.projeto1.client;

import com.google.gwt.core.client.EntryPoint;
import com.googlecode.projeto1.client.panels.results.ResultsPanel;

public class LARbc implements EntryPoint {
	
	

	public void onModuleLoad() {		
//		PanelSwitcher.switchPanel(new WelcomePanel());
//		PanelSwitcher.switchPanel(new ModalityPanel());
//		PanelSwitcher.switchPanel(new NorthModalityPanel());
//		PanelSwitcher.switchPanel(new QueryPanel());
		PanelSwitcher.switchPanel(new ResultsPanel());
//		PanelSwitcher.switchPanel(new CasePanel());
	
	}
}
