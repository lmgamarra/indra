package com.prueba.indra.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="tipos")
public class TipoCambio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;	
	
	@Column(name="valor", nullable=false)
	private BigDecimal valor;
	
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="moneda_id", referencedColumnName="id")
	private Moneda moneda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}	

}
