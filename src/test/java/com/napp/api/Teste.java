package com.napp.api;

public class Teste {

	public static void main(String[] args) {
		int multiplo = 2;
		int quantidade = 5;
		
		Double resto = new Double(quantidade %  multiplo);
		logger(resto);

	}

	static void logger(Object object) {
		System.out.println(object);
	}
}
