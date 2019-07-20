package com.example.comunity.dto;

public class GithubUser {
		private String name;
		private int id;
		
		private String bioString;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getBioString() {
			return bioString;
		}

		@Override
		public String toString() {
			return "GithubUser [name=" + name + ", id=" + id + ", bioString=" + bioString + "]";
		}

		public GithubUser(String name, int id, String bioString) {
			super();
			this.name = name;
			this.id = id;
			this.bioString = bioString;
		}

		public GithubUser() {

		}

	
		

}
