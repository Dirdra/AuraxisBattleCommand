package de.branius.dgc.model.ps2v2.ui.vaadin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.brainius.dgc.ps2.census.model.ps2v2.SingleCharacterByIdList;
import de.branius.dgc.api.ps2v2.exception.CensusException;
import de.branius.dgc.model.ps2v2.ui.vaadin.context.Factory;

@Theme("ABSTheme")
@Widgetset("org.vaadin.ui.ABSWidgetset")
public class CharacterUI extends UI implements Button.ClickListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LoggerFactory.getLogger(CharacterUI.class);
	
	private TextField tfCharacterName;
	private Button btSearchButton;
	private Label lbSearch;
	private Label lbCountResult;
	private Label lbCountResultResult;
	private Label lbCharID;
	private Label lbCharIDResult;

	@Override
	protected void init(VaadinRequest request) {
//		final CensusDataApi censusDataApi = Factory.getCensusDataApi();
		
		tfCharacterName = new TextField("Charname (firstLower)");
		btSearchButton = new Button("Search", this);
		lbCountResult = new Label("Count results");
		lbCountResultResult = new Label("Count results");
		lbCharID = new Label("CharID");
		lbCharIDResult =  new Label("");
		
		VerticalLayout content = new VerticalLayout();
		content.addComponent(tfCharacterName);
		content.addComponent(btSearchButton);
		content.addComponent(lbCountResult);
		content.addComponent(lbCountResultResult);
		content.addComponent(lbCharID);
		content.addComponent(lbCharIDResult);
		
		setContent(content );
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if (event.getSource() == btSearchButton) {
			Notification.show("start loading Data", Type.TRAY_NOTIFICATION);
			
			try {
				SingleCharacterByIdList response = Factory.getCensusDataApi().getData("single_character_by_id", SingleCharacterByIdList.class, "id="+tfCharacterName.getValue());
				lbCountResultResult.setValue(""+response.getCount());
				if (response.getSingleCharacterById().size() > 0) {
					lbCharIDResult.setValue(""+response.getSingleCharacterById().get(0).getCharacterId());
				}
				
				Notification.show("data loaded", Type.TRAY_NOTIFICATION);
			} catch (CensusException e) {
				LOG.error("error while retrieving data", e);
				Notification.show("Error while retrieving data", e.getMessage(), Type.ERROR_MESSAGE);
			}
		}
	}

}
