package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Semaphore;
public class control extends Thread {
	
	int[]vetor;
	Semaphore semaforo;

	double tempoInicial, tempoFinal, tempoTotal,tempoGeral,geral;
	
	public control(int[]vetorpreenchido,Semaphore semaforo) {
		this.vetor = vetorpreenchido;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		tempoInicial = System.nanoTime();
		try {
			Thread.sleep(100);
			Bubblesort(vetor);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		try {
			//permitindo o acesso ao recurso
			semaforo.acquire();
			
			Mostrar(vetor);
			TempoUsado();
			
		}catch(Exception a) {
			a.printStackTrace();
		}finally {
			semaforo.release();
		}
		
		
	}
	//algoritmo do bubble sort
	public void Bubblesort(int vetor[]) {
		//Ordenação com Bubble sort
		for(int i = 0; i<vetor.length;i++) {
			for(int j = i+1; j <vetor.length; j++) {
				if(vetor[i]>vetor[j]) {
					int aux = vetor[j];
					vetor[j] =  vetor[i];
					vetor[i] = aux;
				}
			}
		}

		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
    }
	public void Mostrar(int[] vetor) {
		System.out.println("_________________________________________________________________");
    	System.out.println("Vetor Ordenado com BUBBLE SORT com : "+vetor.length+" posições");
		for(int i =0; i <vetor.length; i++) {
		System.out.println("Valores ordenados: "+vetor[i]+" posição no vetor: "+i);
		}
	}
	private void TempoUsado() {
		tempoFinal = System.nanoTime();
		tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal / Math.pow(10, 9);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("O tempo usado foi: "+tempoTotal+" segundos");
		System.out.println("_________________________________________________________________");
	}

}
