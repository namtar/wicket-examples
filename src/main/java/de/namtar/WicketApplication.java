package de.namtar;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import de.namtar.page.MainPage;
import de.namtar.page.TableExamplePage;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start
 * class.
 * 
 * @see de.namtar.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return MainPage.class; // this could be a login page.
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		// add your configuration here

		// mount pages
		mountPage("main", MainPage.class);
		mountPage("table", TableExamplePage.class);
	}
}
