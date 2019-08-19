package com.napp.api.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorMessage {
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm:ss");
	
	private String dataHora;
	private String mensagem;
	private String detalhes;

	public ErrorMessage() {
	}

	public ErrorMessage(Date timestamp, String message, String details) {
		this.dataHora = formatter.format(timestamp);
		this.mensagem = message;
		this.detalhes = details;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String timestamp) {
		this.dataHora = timestamp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String message) {
		this.mensagem = message;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String details) {
		this.detalhes = details;
	}
}