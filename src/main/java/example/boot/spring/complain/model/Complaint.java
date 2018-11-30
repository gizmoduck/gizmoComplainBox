package example.boot.spring.complain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="complaints")
@EntityListeners(AuditingEntityListener.class)  //createdAt and updatedAt will auto populated when ever create and update happens using AuditingEntityListener. @EnableJpaAuditing annotation should be done in main class.
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters=true) //@JsonIgnoreProperties annotation is a Jackson annotation. Spring Boot uses Jackson for Serializing and Deserializing Java objects to and from JSON.
public class Complaint implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank			//@NotBlank annotation is used to validate that the annotated field is not null or empty.
	private String title;
	
	@NotBlank
	private String content;
	
	@Column(nullable=false, updatable=false)		//@Column annotation is used to define the properties of the column that will be mapped to the annotated field. You can define several properties like name, length, nullable, updateable etc.
	@Temporal(TemporalType.TIMESTAMP)	//@Temporal annotation is used with java.util.Date and java.util.Calendar classes. It converts the date and time values from Java Object to compatible database type and vice versa.
	@CreatedDate			//By default, a field named createdAt is mapped to a column named created_at in the database table. i.e. all camel cases are replaced with underscores.
	private Date createdAt;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Complaint() {
		super();
	}
	
	
	
}
