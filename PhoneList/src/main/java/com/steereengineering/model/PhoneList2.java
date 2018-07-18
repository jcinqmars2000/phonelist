package com.steereengineering.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class PhoneList2 {
	private static final String str1 = "class=\"btn btn-link \" row_id=\"";
	private static final String str2 = "\" > Edit</a> </span> <span class=\"btn_save\"> <a href=\"#\" class=\"btn btn-link\"  row_id=\"";
	private static final String str3 = "\"> Save</a> | </span><span class=\"btn_cancel\"> <a href=\"#\" class=\"btn btn-link\" row_id=\"";
	private static final String str4 ="\"> Cancel</a> | </span>";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull 
	private String firstname;
	@NotNull 
	private String lastname;
	@Column(unique=true)
	private String email;
	private String extension;
	private String cellphone;
	@Column(length = 512)
	private String options;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		StringBuffer options = new StringBuffer();
		options.append(str1);
		options.append(id);
		options.append(str2);
		options.append(id);
		options.append(str3);
		options.append(id);
		options.append(str4);
		setOptions(options.toString());
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellphone == null) ? 0 : cellphone.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneList2 other = (PhoneList2) obj;
		if (cellphone == null) {
			if (other.cellphone != null)
				return false;
		} else if (!cellphone.equals(other.cellphone))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "PhoneList [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", extension=" + extension + ", cellphone=" + cellphone + ", options=" + options + "]";
	}
	
}
