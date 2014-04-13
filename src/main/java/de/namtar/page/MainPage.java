package de.namtar.page;

import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.namtar.model.MenuLinkItem;

/**
 * The main page of the project.
 * 
 * @author Matthias Drummer
 */
public class MainPage extends AbstractNavigationPage {

	private static final long serialVersionUID = -6613861301330052839L;

	@Override
	protected List<MenuLinkItem> getLeftNavigation() {

		// TODO: only do selection here. Move the link creation to the basic page.
		List<MenuLinkItem> links = new LinkedList<MenuLinkItem>();

		MenuLinkItem mainPageLink = new MenuLinkItem(new AjaxFallbackLink<String>("navigationLink") {

			private static final long serialVersionUID = 6028735758572490456L;
			
			@Override
			public IModel<?> getBody() {
				return Model.of("Main");
			}

			@Override
			public void onClick(AjaxRequestTarget target) {

				setResponsePage(MainPage.class);
			}
		});

		// add other links
		MenuLinkItem tablePageLink = new MenuLinkItem(new AjaxFallbackLink<String>("navigationLink") {

			private static final long serialVersionUID = 3234332784346813111L;

			@Override
			public IModel<?> getBody() {
				return Model.of("Table");
			}
			
			@Override
			public void onClick(AjaxRequestTarget target) {

				setResponsePage(TableExamplePage.class);
			}
		});

		// set selection
		mainPageLink.setSelected(true);

		links.add(mainPageLink);
		links.add(tablePageLink);

		return links;
	}
}
