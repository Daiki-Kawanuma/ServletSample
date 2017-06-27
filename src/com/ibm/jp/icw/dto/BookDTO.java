package com.ibm.jp.icw.dto;

/**
 * 本のDTOです。
 */
public class BookDTO {
	private String name;
	private String author;
	private int price;

	/**
	 * nameのゲッター
	 * @return nameを返す。セットされていない場合はブランク。
	 */
	public String getName() {
		System.out.println("情報：BookDTO#getName：" + name);
		return name;
	}
	/**
	 * nameのセッター
	 * @param name - 本の名前
	 */
	public void setName(String name) {
		System.out.println("情報：BookDTO#setName：" + name);
		this.name = name;
	}

	/**
	 * authorのゲッター
	 * @return authorを返す。セットされていない場合はブランク。
	 */
	public String getAuthor() {
		System.out.println("情報：BookDTO#getAuthor：" + author);
		return author;
	}
	/**
	 * authorのセッター
	 * @param author - 本の著者
	 */
	public void setAuthor(String author) {
		System.out.println("情報：BookDTO#setAuthor：" + author);
		this.author = author;
	}

	/**
	 * priceのゲッター
	 * @return priceを返す。セットされていない場合は0。
	 */
	public int getPrice() {
		System.out.println("情報：BookDTO#getPrice：" + price);
		return price;
	}
	/**
	 * priceのセッター
	 * @param price - 本の価格
	 */
	public void setPrice(int price) {
		System.out.println("情報：BookDTO#setPrice：" + price);
		this.price = price;
	}
}
