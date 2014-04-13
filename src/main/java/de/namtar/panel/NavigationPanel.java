package de.namtar.panel;

import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

import de.namtar.model.MenuLinkItem;

/**
 * A panel that displays navigation items.
 * 
 * @author Matthias Drummer
 */
public class NavigationPanel extends Panel {

	private static final long serialVersionUID = 7637788926188435707L;

	private List<MenuLinkItem> menuLinkItems;

	/**
	 * Constructor.
	 * 
	 * @param htmlId the html markup id
	 * @param menuLinkItems a list of {@link MenuLinkItem}
	 */
	public NavigationPanel(String htmlId, List<MenuLinkItem> menuLinkItems) {
		super(htmlId);
		this.menuLinkItems = menuLinkItems;
		this.setOutputMarkupId(true);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new ListView<MenuLinkItem>("navigationItem", menuLinkItems) {

			private static final long serialVersionUID = 2112863690408276301L;

			@Override
			protected void populateItem(ListItem<MenuLinkItem> item) {

				MenuLinkItem menuItem = item.getModelObject();
				// do css foo here to highlight a selected item.
				// AttributeAppender etc...

				item.add(menuItem.getLink());
			}

		});
	}
}
