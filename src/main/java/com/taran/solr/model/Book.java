package com.taran.solr.model;

import java.io.Serializable;

/**
 * The Class Book.
 */
public class Book implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The category. */
	private String category;

	/** The name. */
	private String name;

	/** The price. */
	private Double price;

	/** The in stock. */
	private boolean inStock;

	/** The author. */
	private String author;

	/**
	 * Instantiates a new book.
	 *
	 * @param category the category
	 * @param name the name
	 * @param price the price
	 * @param inStock the in stock
	 * @param author the author
	 */
	public Book(String category, String name, Double price, boolean inStock, String author) {
		super();
		this.category = category;
		this.name = name;
		this.price = price;
		this.inStock = inStock;
		this.author = author;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price            the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Checks if is in stock.
	 *
	 * @return the inStock
	 */
	public boolean isInStock() {
		return inStock;
	}

	/**
	 * Sets the in stock.
	 *
	 * @param inStock            the inStock to set
	 */
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author.
	 *
	 * @param author            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [category=");
		builder.append(category);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", inStock=");
		builder.append(inStock);
		builder.append(", author=");
		builder.append(author);
		builder.append("]");
		return builder.toString();
	}
}
