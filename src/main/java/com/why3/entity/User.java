package com.why3.entity;

import java.io.Serializable;

/**
 * The user entity in the system.
 * 
 * @author plux
 * 
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * The ID of the user(mainly used by database).
	 */
	private int userId;

	/**
	 * The username of the system.
	 */
	private String username;

	/**
	 * The password.
	 */
	private String password;

	/**
	 * The power bits.
	 */
	private int power;

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}
}
