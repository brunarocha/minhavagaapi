package com.puc.minhavaga.infrastructure.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profiles")
public class ProfileEntity implements Serializable {

	private static final long serialVersionUID = 7834640568656676379L;
	
	@Id
	@Column(name = "Profile")
	private String profile;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getProfile() {
		return profile;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
}
