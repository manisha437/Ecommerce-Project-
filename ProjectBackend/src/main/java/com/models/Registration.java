package com.models;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.OneToMany;

	@Entity
	public class  Registration 
	{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private String frstname;
		private String lastname;
		private String address;
		private String gender;
		@OneToMany(mappedBy="Registration")
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFrstname() {
			return frstname;
		}
		public void setFrstname(String frstname) {
			this.frstname = frstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
		}
		