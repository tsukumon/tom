package model;

import java.io.Serializable;
public class ProductList implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String id;
	private int price;
	private String e_id;

public ProductList(String id, String name,int price) {
	this.id = id;
	this.name = name;
	this.price = price;
}
public ProductList(String id, String name,int price, String e_id) {
	this.id = id;
	this.name = name;
	this.price = price;
	this.e_id = e_id;
}

public String getId() {
	return id;
}

public String getName() {
	return name;
}

public int getPrice() {
	return price;
}
public String getEid() {
	return e_id;
}


}