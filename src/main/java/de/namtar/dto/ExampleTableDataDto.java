package de.namtar.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * A simple dto for example table data.
 * 
 * @author Matthias Drummer
 */
public class ExampleTableDataDto implements Serializable {

	private static final long serialVersionUID = -4041381512265384023L;

	private String value1;
	private int value2;
	private Set<String> multipleValues;

	public ExampleTableDataDto() {
	}

	public ExampleTableDataDto(String value1, int value2, Set<String> multipleValues) {
		super();
		this.value1 = value1;
		this.value2 = value2;
		this.multipleValues = multipleValues;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public Set<String> getMultipleValues() {
		return multipleValues;
	}

	public void setMultipleValues(Set<String> multipleValues) {
		this.multipleValues = multipleValues;
	}

}
