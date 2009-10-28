package com.googlecode.projeto1.client.panels.maps;


import com.google.gwt.maps.client.event.MapClickHandler;
import com.google.gwt.maps.client.event.PolylineMouseOutHandler;
import com.google.gwt.maps.client.event.PolylineMouseOverHandler;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Polyline;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;

/**
 * @author Alcione Pinheiro
 * @author Diego Rodrigues
 * @author João Felipe
 * @version LARbc 1.0
 */
public class POILineMap extends MappingWindow{
	
	private Polyline line;
	private boolean mouseOverLine;
	
	public POILineMap(){
		super();
		mouseOverLine = false;
		this.line = null;
		this.setTitle("Pontos de Interesse");		
		this.addButton(getSaveButton());
		this.addMapEvent();
	}	

	private PolylineMouseOverHandler getPolylineMouseOverHandler() {
		return new PolylineMouseOverHandler(){

			public void onMouseOver(PolylineMouseOverEvent event) {
				mouseOverLine = true;
				
			}
			
		};
	}
	
	private PolylineMouseOutHandler getPolylineMouseOutHandler() {
		return new PolylineMouseOutHandler(){

			public void onMouseOut(PolylineMouseOutEvent event) {
				mouseOverLine = false;				
			}
			
		};
	}	

	private void addMapEvent() {
		myMap.addMapClickHandler(new MapClickHandler() {
			public void onClick(final MapClickEvent clickEvent) {
				if(line == null){
					LatLng[] array = new LatLng[1];
					array[0] = clickEvent.getLatLng();
					line = new Polyline(array);
					line.addPolylineMouseOverHandler(getPolylineMouseOverHandler());
					line.addPolylineMouseOutHandler(getPolylineMouseOutHandler());
					myMap.addOverlay(line);
					line.setEditingEnabled(true);
				}
				if(!mouseOverLine){
					line.insertVertex(line.getVertexCount(), clickEvent.getLatLng());					
				}
			}			
			
		});
	}	

	private Button getSaveButton() {
		Button okButton = new Button("Salvar");
		okButton.addListener(new ButtonListenerAdapter(){
			public void onClick(Button button, EventObject e) {
				myMap.clearOverlays();
				hide();
			}

		});
		return okButton;
	}		
	

}