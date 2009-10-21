package com.googlecode.projeto1.client.panels.modality;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.MouseListenerAdapter;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.projeto1.client.PanelSwitcher;
import com.googlecode.projeto1.client.panels.Util;
import com.googlecode.projeto1.client.panels.demands.DemandSellerPanel;
import com.googlecode.projeto1.client.panels.help.Help;
import com.googlecode.projeto1.client.panels.query.QueryPanel;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.FitLayout;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 *
 * @author Alcione Pinheiro
 * @author Diego Rodrigues
 * @author João Felipe
 * @version LARbc 1.0
 */
public class ModalityPanel extends Panel {
	
	private AbsolutePanel rootPanel;
	private Image comprarButton;
	private Image selectedComprarButton;
	private boolean isSelectedComprarButton;
	private Image venderButton;
	private Image selectedVenderButton;
	private boolean isSelectedVenderButton;
	private boolean isAdministrarVenderButton;
	private boolean isSelectedAjudaButton;
	private Panel buttonsComprarPanel;
	private Panel buttonsPanel;
	private Panel buttonsAjudaPanel;
	private Image managerButtonImage;
	private Image selectedManagerButtonImage;
	private Image ajudaButtonImage;
	private Image selectedAjudaButtonImage;
	private LoginWindow loginWindow;
	private Panel wrapperPanel;

	public ModalityPanel() {
		super();
		rootPanel = new AbsolutePanel();
		{
			Image image = new Image("images/larbc.png");
			rootPanel.add(image, 35, 25);
			image.setPixelSize(280, 100);
		}
		buttonsPanel = new Panel();		
		buttonsComprarPanel = new Panel();
		buttonsAjudaPanel = new Panel();
		buttonsAjudaPanel.setLayout(new ColumnLayout());
		wrapperPanel = new Panel();
		wrapperPanel.setLayout(new ColumnLayout());
		this.isSelectedVenderButton = false;
		this.isSelectedComprarButton = false;
		this.isSelectedAjudaButton = false;
		Image image = Util.createImage(Util.QUESTION);
		image.setPixelSize(280, 70);
		createVenderButton();
		createComprarButton();
		rootPanel.add(image, 300, 250);
		rootPanel.add(buttonsComprarPanel, 215, 357);
		rootPanel.add(buttonsPanel, 490, 360);
		
		this.add(rootPanel);
		this.setLayout(new FitLayout());
		this.setFrame(true);
		this.loginWindow = new LoginWindow();

		
		createManagerButton();
		createSelectedManagerButton();
		createAjudaButton();
		createSelectedAjudaButton();

		wrapperPanel = new Panel();
		Panel rightPanel = new Panel();
		rightPanel.add(managerButtonImage);
		wrapperPanel.add(managerButtonImage);
		buttonsAjudaPanel.add(ajudaButtonImage);
		rootPanel.add(buttonsAjudaPanel, 887, 39);
		rootPanel.add(wrapperPanel, 950, 40);
		this.loginWindow = new LoginWindow();

	}
	
	//BOTAO COMPRAR
	private void createComprarButton() {
		comprarButton = Util.createImage(Util.COMPRAR_BUTTON_IMAGE);
		comprarButton.setPixelSize(175, 43);
		comprarButton.addMouseListener(new MouseListenerAdapter(){

			public void onMouseEnter(Widget arg0) {
				isSelectedComprarButton = true;
				rebuildComprarPanel();
				
			}
		});
		selectedComprarButton = Util.createImage(Util.SELECTED_COMPRAR_BUTTON_IMAGE);
		selectedComprarButton.setPixelSize(175, 43);
		selectedComprarButton.addMouseListener(new MouseListenerAdapter(){			

			public void onMouseLeave(Widget arg0) {
				isSelectedComprarButton = false;
				rebuildComprarPanel();				
			}			
			
		});
		selectedComprarButton.addClickListener(new ClickListener(){

			public void onClick(Widget arg0) {
				PanelSwitcher.switchPanel(new QueryPanel());				
			}
			
		});
		
		buildButtonsComprarPanel();
		
	}
	
	private void buildButtonsComprarPanel() {
		buttonsComprarPanel.removeAll();
		if(!isSelectedComprarButton){
			buttonsComprarPanel.add(comprarButton);
		}else{
			buttonsComprarPanel.add(selectedComprarButton);
		}
		buttonsComprarPanel.doLayout();		
	}

	private void rebuildComprarPanel() {
		buildButtonsComprarPanel();		
	}
	
	
	//BOTAO VENDER
	private void buildButtonsPanel() {
		buttonsPanel.removeAll();
		if(!isSelectedVenderButton){
			buttonsPanel.add(venderButton);
		}else{
			buttonsPanel.add(selectedVenderButton);
		}
		buttonsPanel.doLayout();		
	}

	private void rebuildPanel() {
		buildButtonsPanel();		
	}
	
	private void createVenderButton() {
		venderButton = Util.createImage(Util.VENDER_BUTTON_IMAGE);
		venderButton.setPixelSize(160, 40);
		venderButton.addMouseListener(new MouseListenerAdapter(){

			public void onMouseEnter(Widget arg0) {
				isSelectedVenderButton = true;
				rebuildPanel();
				
			}
			
		});
		selectedVenderButton = Util.createImage(Util.SELECTED_VENDER_BUTTON_IMAGE);
		selectedVenderButton.setPixelSize(160, 40);
		selectedVenderButton.addMouseListener(new MouseListenerAdapter(){			

			public void onMouseLeave(Widget arg0) {
				isSelectedVenderButton = false;
				rebuildPanel();				
			}			
			
		});
		
		selectedVenderButton.addClickListener(new ClickListener(){

			public void onClick(Widget arg0) {
				PanelSwitcher.switchPanel(new DemandSellerPanel());				
			}
			
		});
		
		buildButtonsPanel();
	}
	
	private void rebuildNorthPanel(Image buttonImage){
		wrapperPanel.removeAll();
		if(!isAdministrarVenderButton){
			Panel rightPanel = new Panel();
			rightPanel.add(buttonImage);
			wrapperPanel.add(rightPanel);
		}else{
			Panel rightPanel = new Panel();
			rightPanel.add(buttonImage);
			wrapperPanel.add(rightPanel);
		}
		wrapperPanel.doLayout();	
	}

	//BOTAO ADMINISTRAR
	private void createSelectedManagerButton() {
		selectedManagerButtonImage = Util.createImage(Util.SELECTED_ADMINISTRAR_BUTTON_IMAGE);
		selectedManagerButtonImage.setPixelSize(60, 10);
		selectedManagerButtonImage.addMouseListener(new MouseListenerAdapter(){

			public void onMouseLeave(Widget arg0) {
				rebuildNorthPanel(managerButtonImage);
				
			}			
			
		});
		
		selectedManagerButtonImage.addClickListener(new ClickListener(){

			public void onClick(Widget arg0) {
				loginWindow.show(selectedManagerButtonImage.getElement());
				
			}
			
		});		
		
	}

	private void createManagerButton() {
		managerButtonImage = Util.createImage(Util.ADMINISTRAR_BUTTON_IMAGE);
		managerButtonImage.setPixelSize(60, 10);
		managerButtonImage.addMouseListener(new MouseListenerAdapter(){
			
			public void onMouseEnter(Widget arg0) {
				rebuildNorthPanel(selectedManagerButtonImage);
			}
		});
	}
	
	//BOTAO AJUDA
	private void createSelectedAjudaButton() {
		selectedAjudaButtonImage = Util.createImage(Util.AJUDA_SELECTED_BUTTON_IMAGE);
		selectedAjudaButtonImage.setPixelSize(33, 13);
		selectedAjudaButtonImage.addMouseListener(new MouseListenerAdapter(){

			public void onMouseLeave(Widget arg0) {
				rebuildAjudaPanel(ajudaButtonImage);
				
			}			
			
		});
		
		selectedAjudaButtonImage.addClickListener(new ClickListener(){

			public void onClick(Widget arg0) {
				PanelSwitcher.switchPanel(new Help());				
			}
			
		});		
		
	}

	private void createAjudaButton() {
		ajudaButtonImage = Util.createImage(Util.AJUDA_BUTTON_IMAGE);
		ajudaButtonImage.setPixelSize(33, 13);
		ajudaButtonImage.addMouseListener(new MouseListenerAdapter(){
			
			public void onMouseEnter(Widget arg0) {
				rebuildAjudaPanel(selectedAjudaButtonImage);
			}
		});
	}
	
	private void rebuildAjudaPanel(Image buttonImage){
		buttonsAjudaPanel.removeAll();
		if(!isSelectedAjudaButton){
			buttonsAjudaPanel.add(buttonImage);
		}else{
			buttonsAjudaPanel.add(buttonImage);
		}
		buttonsAjudaPanel.doLayout();	
	}
}

