package com.yourapp.app.impl.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")
@MappedSuperclass
public class Identifier implements Serializable {
	/** Identyfikator. */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * @return Identyfikator.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            Identyfikator.
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
