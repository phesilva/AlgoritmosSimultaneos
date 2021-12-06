package view;

import java.util.concurrent.Semaphore;

import controller.control;
import controller.control2;

public class main {
	private static final Semaphore semaforo = new Semaphore(1);

	public static void main(String[] args) {
		
		int tamanho = 0;
		//looping para preencher o vetor e inicializar as threads
		    for(int i = 1; i<=3;i++) {
			//primeira inicialização
					if(i==1) {
					tamanho = 50;
				
					int[] vetor = new int[tamanho];
				
					int[] vetorpreenchido = PreencherVetor(vetor);
						
						Thread printar = new control(vetorpreenchido,semaforo);
						printar.start();
						Thread printar2 = new control2(vetorpreenchido,semaforo);
						printar2.start();
					}
					if(i==2) {
						tamanho = 1000;
					
						int[] vetor = new int[tamanho];
					
						int[] vetorpreenchido = PreencherVetor(vetor);
							
							Thread printar = new control(vetorpreenchido,semaforo);
							printar.start();
							Thread printar2 = new control2(vetorpreenchido,semaforo);
							printar2.start();
						}if(i==3) {
							tamanho = 10000;
							
							int[] vetor = new int[tamanho];
						
							int[] vetorpreenchido = PreencherVetor(vetor);
								
								Thread printar = new control(vetorpreenchido,semaforo);
								printar.start();
								Thread printar2 = new control2(vetorpreenchido,semaforo);
								printar2.start();
							}
		    }
	}
	//metodo que preenche o vetor
	public static int[]PreencherVetor(int[] vetor){
		
		for(int i=0;i<vetor.length;i++) {
			vetor[i] = (int)(Math.random() * 1000 ) + 1;
		}
		return vetor;
	}
	
}
