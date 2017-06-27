package com.ibm.jp.icw.dto;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BookDTOTest {

	@Test
	public void nameにsetした値がgetで取得できる() {
		String stringToSet = "English Name";
		BookDTO bookDTO = new BookDTO();
		bookDTO.setName(stringToSet);

		String expected = stringToSet;
		String actual = bookDTO.getName();

		assertThat(actual, is(expected));
	}

	@Test
	public void authorにsetした値がgetで取得できる() {
		String stringToSet = "English Name";
		BookDTO bookDTO = new BookDTO();
		bookDTO.setAuthor(stringToSet);

		String expected = stringToSet;
		String actual = bookDTO.getAuthor();

		assertThat(actual, is(expected));
	}

	@Test
	public void priceにsetした値がgetで取得できる() {
		int intToSet = 100;
		BookDTO bookDTO = new BookDTO();
		bookDTO.setPrice(intToSet);

		double expected = intToSet;
		double actual = bookDTO.getPrice();

		assertThat(actual, is(expected));
	}

}
