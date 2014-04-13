package de.namtar.component;

import java.util.Set;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 * A component that reduces the displayed length of a label by a given value and displays the whole text when an on
 * mouse over event occurs.
 * 
 * @author Matthias Drummer
 */
public class ShortenLabelTextComponent extends Panel {

	private static final long serialVersionUID = 3570013487847932739L;

	private Set<String> stringsToDisplay;
	private int numberOfCharactersToDisplay;
	private String shortenSuffix = "...+";

	private Label suffixLabel;

	/**
	 * Constructor.
	 * 
	 * @param htmlId the id of the html component
	 * @param stringsToDisplay a set of Strings that shall be displayed
	 * @param numberOfCharactersToDisplay the number of characters which will be displayed until the string is
	 *            shortened.
	 */
	public ShortenLabelTextComponent(String htmlId, Set<String> stringsToDisplay, int numberOfCharactersToDisplay) {
		super(htmlId);

		if (numberOfCharactersToDisplay < 1) {
			throw new IllegalArgumentException("The size of the characters to be displayed may not less than 1.");
		}

		this.stringsToDisplay = stringsToDisplay;
		this.numberOfCharactersToDisplay = numberOfCharactersToDisplay;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		suffixLabel = new Label("labelSuffix");

		StringBuilder sb = new StringBuilder();
		boolean firstOne = true;
		for (String string : stringsToDisplay) {
			if ((sb.length() + string.length()) > numberOfCharactersToDisplay) {

				suffixLabel.setDefaultModel(Model.of(shortenSuffix));
				break;
			}
			if (!firstOne) {
				sb.append(", ");
			} else {
				firstOne = false;
			}

			sb.append(string);
		}

		add(new Label("label", sb.toString()));
		add(suffixLabel);
		add(createFullTextLabel());
	}

	private Label createFullTextLabel() {

		final Label lbl = new Label("fullTextLabel", stringsToDisplay.toString());
		lbl.setOutputMarkupId(true);

		suffixLabel.add(new AjaxEventBehavior("onmouseover") {

			private static final long serialVersionUID = -2039858486671702519L;

			@Override
			protected void onEvent(AjaxRequestTarget target) {

				lbl.add(AttributeAppender.remove("style"));
				lbl.add(new AttributeAppender("style", "visibility: visible; position: fixed; width: 100px;"));

				target.add(lbl);
			}
		});

		suffixLabel.add(new AjaxEventBehavior("onmouseout") {

			private static final long serialVersionUID = -2039858486671702519L;

			@Override
			protected void onEvent(AjaxRequestTarget target) {

				lbl.add(AttributeAppender.remove("style"));
				lbl.add(new AttributeAppender("style", "visibility: hidden; position: fixed; width: 100px;"));

				target.add(lbl);
			}
		});

		return lbl;
	}

	public void setShortenSuffix(String shortenSuffix) {
		this.shortenSuffix = shortenSuffix;
	}

	public String getShortenSuffix() {
		return shortenSuffix;
	}
}
