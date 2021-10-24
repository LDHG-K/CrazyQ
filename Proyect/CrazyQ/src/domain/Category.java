package domain;

import java.io.Serializable;

import java.util.List;




public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer idCategory;

	
	private String categoryName;

	
	private List<Question> questions;

	public Category() {
	}

	public Integer getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setCategory(this);

		return question;
	}
	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setCategory(null);

		return question;
	}

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", categoryName=" + categoryName + "]";
	}
	

}