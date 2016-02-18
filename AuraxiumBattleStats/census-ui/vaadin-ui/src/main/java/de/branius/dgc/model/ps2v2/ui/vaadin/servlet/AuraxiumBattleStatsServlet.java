package de.branius.dgc.model.ps2v2.ui.vaadin.servlet;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import de.branius.dgc.model.ps2v2.ui.vaadin.AuraxiumBattleStats;
import de.branius.dgc.model.ps2v2.ui.vaadin.CharacterUI;

@WebServlet(urlPatterns = "/*", name = "AuraxiumBattleStatsServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = CharacterUI.class, productionMode = false)
public class AuraxiumBattleStatsServlet extends VaadinServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}