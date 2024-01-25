package entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //La opci�n m�s usada con MySQL
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String tittle;
	
	@Column(name="publication_date")
	private LocalDate publication_date;
	
	@Column(name="genre")
	private String genre;
	
	@ManyToOne
	@JoinColumn (name = "author_id")
	private Author author_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public LocalDate getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(LocalDate publication_date) {
		this.publication_date = publication_date;
	}

	public Author getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Author author_id) {
		this.author_id = author_id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
