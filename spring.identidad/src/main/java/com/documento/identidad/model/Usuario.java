package com.documento.identidad.model;

public class Usuario {
	private String usuario;
	private String password;
	private String token;

	public String getUser() {
		return usuario;
	}

	public void setUser(String usuario) {
		this.usuario = usuario;
	}

	public String getPwd() {
		return password;
	}

	public void setPwd(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
