package com.learn.payloads;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryDTO {
	private Integer category_id;

	@NotNull(message = "Category Title should not be empty ")
	@Size(min = 4, message = "Category Title should be atleast 4 ")
	private String categoryTitle;

	@NotNull(message = "Category Desc should not be empty ")
	@Size(min = 10, message = "Category Desc should be atleast 10 ")
	private String categoryDesc;

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
