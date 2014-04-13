package de.namtar.page;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import de.namtar.model.MenuLinkItem;
import de.namtar.panel.NavigationPanel;

/**
 * An abstract page that provides menu navigation.
 * 
 * @author Matthias Drummer
 */
public abstract class AbstractNavigationPage extends WebPage {

	private static final long serialVersionUID = 456244052382214162L;

	@Override
	protected void onInitialize() {
		super.onInitialize();

		addHtmlMetaTags();
		initElements();
	}

	private void addHtmlMetaTags() {
		// TODO: add tags if necessary
	}

	private void initElements() {
		// create navigation
		add(new Label("pageTitle", getPageTitle()));
		add(new NavigationPanel("leftnavigation", getLeftNavigation()));
	}

	private String getPageTitle() {
		return getString("pageTitle"); // each page that implements this has to add this property to its property file.
	}

	/**
	 * Returns the left navigation items. Each page is able to configure its navigation on its own.
	 * 
	 * @return a list of {@link MenuLinkItem}
	 */
	protected abstract List<MenuLinkItem> getLeftNavigation();
}
