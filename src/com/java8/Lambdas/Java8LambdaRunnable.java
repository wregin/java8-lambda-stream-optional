package com.java8.Lambdas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Java8LambdaRunnable {

	public static void main(String[] args) {
		
		// código padrão, que normalmente nós fazemos 
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("teste");
			}
		}).run();
		
		// expressão utilziando lambda
		new Thread(() -> System.out.println("teste, utilizando lambda")).run();
		
		// código padrão, que normalmente nós fazemos
		JButton jButton = new JButton();
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Olá");
				
			}
		});

		// expressão utilziando lambda
		JButton jButton2 = new JButton();
		jButton2.addActionListener(e -> System.out.println("Teste lambda"));
		
		/** O que se passa aqui é o seguinte, o padrão SAM
		 *  é chamado de SAM = Single Abstract Method
		 *  verifique que ao abrir a interface do runnable, ou actionlistner
		 *  essa tem apenas um método, é dai que havendo apenas 1, é exatamente
		 *  esse que será utilizado para a expressão lambda
		 *  o () é o parametro que será recebido, no caso do runnable é vazio
		 *  no caso do ActionListener do JButton utilizamos o 'e' por exemplo
		 */
	}
	
}
