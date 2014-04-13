package de.namtar.page;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import de.namtar.component.ShortenLabelTextComponent;
import de.namtar.dto.ExampleTableDataDto;
import de.namtar.model.MenuLinkItem;

/**
 * Page for several table examples.
 * 
 * @author Matthias Drummer
 */
public class TableExamplePage extends AbstractNavigationPage {

	private static final long serialVersionUID = 6986901159344837857L;

	@Override
	protected List<MenuLinkItem> getLeftNavigation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		// if data objects are nested one can get access to nested properties via dot separation. e.g valueObject.value1
		List<IColumn<ExampleTableDataDto, String>> columns = new ArrayList<IColumn<ExampleTableDataDto, String>>();
		columns.add(new PropertyColumn<ExampleTableDataDto, String>(Model.of(getString("col_value1")), "value1"));
		columns.add(new PropertyColumn<ExampleTableDataDto, String>(Model.of(getString("col_value2")), "value2"));
		columns.add(new PropertyColumn<ExampleTableDataDto, String>(Model.of(getString("col_multipleValues")), "multipleValues") {

			private static final long serialVersionUID = 650695923521448852L;

			@Override
			public void populateItem(Item<ICellPopulator<ExampleTableDataDto>> item, String componentId, IModel<ExampleTableDataDto> rowModel) {
//				super.populateItem(item, componentId, rowModel);

				// @See item.add(what to display);
				item.add(new ShortenLabelTextComponent(componentId, rowModel.getObject().getMultipleValues(), 50));
			}
		});

		DefaultDataTable<ExampleTableDataDto, String> dataTable = new DefaultDataTable<ExampleTableDataDto, String>("table", columns,
				new ExampleDataProvider(), 9000);
		add(dataTable);
	}

	/**
	 * Quick implementation of an example data provider.
	 * 
	 * @author Matthias Drummer
	 */
	private static class ExampleDataProvider extends SortableDataProvider<ExampleTableDataDto, String> {

		private static final long serialVersionUID = -588393400258102369L;

		private Set<ExampleTableDataDto> data = new LinkedHashSet<ExampleTableDataDto>();

		public ExampleDataProvider() {
			// generate some random data;

			for (int i = 0; i < 20; i++) {
				Set<String> stringSet = new HashSet<String>();
				for (int j = 0; j < 20; j++) {
					stringSet.add("String" + j);
				}

				ExampleTableDataDto dto = new ExampleTableDataDto("Value" + i, i, stringSet);

				data.add(dto);
			}
		}

		@Override
		public Iterator<? extends ExampleTableDataDto> iterator(long first, long count) {
			return data.iterator();
		}

		@Override
		public long size() {
			return data.size();
		}

		@Override
		public IModel<ExampleTableDataDto> model(ExampleTableDataDto object) {
			return Model.of(object);
		}

	}

}
