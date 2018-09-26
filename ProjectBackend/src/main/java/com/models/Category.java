package com.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String categoryname;
private String cdesc;

private transient MultipartFile image;
//@OneToMany(mappedBy="Category")
//private List<Product> products;

public MultipartFile getImage() {
	return image;
}

public void setImage(MultipartFile image) {
	this.image = image;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCategoryname() {
	return categoryname;
}

public void setCategoryname(String categoryname) {
	this.categoryname = categoryname;
}

public String getCdesc() {
	return cdesc;
}

public void setCdesc(String cdesc) {
	this.cdesc = cdesc;
}


}