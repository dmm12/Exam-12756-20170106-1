package com.ssm.pojo;

public class Film {
	private String film_id;
	private String title;
	private String description;
	private String name;
	private int languageId;
	public String getFilm_id() {
		return film_id;
	}
	public void setFilm_id(String film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public Film(String film_id, String title, String description, int languageId) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.description = description;
		this.languageId = languageId;
	}
	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", title=" + title + ", description=" + description + ", name=" + name
				+ ", languageId=" + languageId + "]";
	}
	
	
	
}
