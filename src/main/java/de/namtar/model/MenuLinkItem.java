package de.namtar.model;

import java.io.Serializable;

import org.apache.wicket.markup.html.link.AbstractLink;

/**
 * A Menu link item.
 * 
 * @author Matthias Drummer
 */
public class MenuLinkItem implements Serializable {

	private static final long serialVersionUID = -816304422693705588L;

	private boolean selected;
	private AbstractLink link;

	/**
	 * Constructor.
	 * 
	 * @param link a wicket link item
	 */
	public MenuLinkItem(AbstractLink link) {
		// this abstract link must be created with the htmlId navigationLink to be used whithin the navigation panel.
		this.link = link;
	}

	public AbstractLink getLink() {
		return link;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
