package com.prueba.indra.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="montos")
public class Monto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;	
	
	@Column(name="actual", nullable=false)
	private BigDecimal actual;
	
	@Column(name="convertido", nullable=false)
	private BigDecimal convertido;
	
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="tipo_id", referencedColumnName="id")
	private TipoCambio tipoCambio;
	
	@ManyToOne
	@JoinColumn(name="moneda_origen_id", referencedColumnName="id")
	private Moneda moneda;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getActual() {
		return actual;
	}

	public void setActual(BigDecimal actual) {
		this.actual = actual;
	}

	public BigDecimal getConvertido() {
		return convertido;
	}

	public void setConvertido(BigDecimal convertido) {
		this.convertido = convertido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TipoCambio getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(TipoCambio tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}	
	
}
