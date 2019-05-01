package com.dominio.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ViagemDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String localDeDestino;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd")
	private Date DataPartida;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd")
	private Date DataRetorno;
	
	private String acompanhante;
	
	public ViagemDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataPartida() {
		return DataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		DataPartida = dataPartida;
	}

	public Date getDataRetorno() {
		return DataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		DataRetorno = dataRetorno;
	}

	public String getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(String acompanhante) {
		this.acompanhante = acompanhante;
	}
	
	@NotNull(message = "Local de Destino é uma informação obrigatória")
	@Length(min = 3, max = 40, message = "Local de Destino deve estar entre 3 e 40 caracteres")
	public String getLocalDeDestino() {
		return localDeDestino;
	}

	public void setLocalDeDestino(String localDeDestino) {
		this.localDeDestino = localDeDestino;
	}

	@Override
	public String toString() {
		return "ViagemDTO [id=" + id + ", localDeDestino=" + localDeDestino + ", DataPartida=" + DataPartida
				+ ", DataRetorno=" + DataRetorno + ", acompanhante=" + acompanhante + "]";
	}
}
