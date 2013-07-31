package com.why3.questionair.entity;

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
	 * The email of the user.
	 */
	private String email;

	/**
	 * The real name of the user.
	 */
	private String name;

	/**
	 * The power bits.
	 */
	private Long power;

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

	public Long getPower() {
		return power;
	}

	public void setPower(Long power) {
		this.power = power;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

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
