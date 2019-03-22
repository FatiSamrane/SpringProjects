package org.conferencesproject.com.entites;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
public class article {
  
	 @Id @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long   idArticle;
	 private String titreArticle;
	 @Lob
	 private String resumeArticle;
	 
	 @Enumerated(EnumType.STRING)
     private categorie category;
	 @Lob
	 private byte[] artcilepdf;
	 /* i will use in reviewer action
	  * */
	 private boolean status;    
	 /* author he can add 
		 * one or many of articles  
		 * */
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="code_user")
	private User user;
	 
	public article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    public article(String titreArticle, String resumeArticle, categorie cat_article, byte[] artcilepdf) {
		super();
		this.titreArticle = titreArticle;
		this.resumeArticle = resumeArticle;
		this.category = cat_article;
		this.artcilepdf = artcilepdf;
	}

	public article(String titreArticle, String resumeArticle, categorie category, byte[] artcilepdf, User user) {
		super();
		this.titreArticle = titreArticle;
		this.resumeArticle = resumeArticle;
		this.category = category;
		this.artcilepdf = artcilepdf;
		this.user = user;
	}
	
	public article(String titreArticle, String resumeArticle, categorie category, byte[] artcilepdf, boolean status,
			User user) {
		super();
		this.titreArticle = titreArticle;
		this.resumeArticle = resumeArticle;
		this.category = category;
		this.artcilepdf = artcilepdf;
		this.status = status;
		this.user = user;
	}

	public boolean isStatus() {
		return status;
	}

	public categorie getCategory() {
		return category;
	}

	public void setCategory(categorie category) {
		this.category = category;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public categorie getCat_article() {
		return category;
	}



	public void setCat_article(categorie cat_article) {
		this.category = cat_article;
	}



	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public String getTitreArticle() {
		return titreArticle;
	}

	public void setTitreArticle(String titreArticle) {
		this.titreArticle = titreArticle;
	}

	public String getResumeArticle() {
		return resumeArticle;
	}

	public void setResumeArticle(String resumeArticle) {
		this.resumeArticle = resumeArticle;
	}

	public byte[] getArtcilepdf() {
		return artcilepdf;
	}

	public void setArtcilepdf(byte[] artcilepdf) {
		this.artcilepdf = artcilepdf;
	}
	 
	 
}
