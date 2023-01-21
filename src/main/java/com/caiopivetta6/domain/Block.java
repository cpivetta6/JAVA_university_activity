package com.caiopivetta6.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Block")
public class Block implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Instant date_start;
	private Instant date_end;
	
	public Block() {
		
	}

	public Block(Integer id, Instant date_start, Instant date_end) {
		super();
		this.id = id;
		this.date_start = date_start;
		this.date_end = date_end;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getDate_start() {
		return date_start;
	}

	public void setDate_start(Instant date_start) {
		this.date_start = date_start;
	}

	public Instant getDate_end() {
		return date_end;
	}

	public void setDate_end(Instant date_end) {
		this.date_end = date_end;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
