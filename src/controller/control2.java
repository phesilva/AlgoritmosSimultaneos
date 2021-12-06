package controller;

import java.util.concurrent.Semaphore;

public class control2 extends Thread {
	
	int[]vetor;
	Semaphore semaforo;
	
	double tempoInicial, tempoFinal, tempoTotal;
	
	public control2(int[]vetorpreenchido, Semaphore semaforo) {
		this.vetor = vetorpreenchido;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		tempoInicial = System.nanoTime();
		try {
			Thread.sleep(100);
			 quicksort(vetor, 0, vetor.length - 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			//permitindo o acesso ao recurso
			semaforo.acquire();
			
			 ordenado(vetor);
				TempoUsado();
		}catch(Exception a) {
			a.printStackTrace();
		}finally {
			semaforo.release();
		}
		


		
	}		
	static void quicksort(int[] vetor, int esquerda, int direita){
        if (esquerda < direita){
            int p = particao(vetor, esquerda, direita);
            quicksort(vetor, esquerda, p);
            quicksort(vetor, p + 1, direita);
            try {
    			Thread.sleep(60);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
        }       
    }
    
    static int particao(int[] vetor, int esquerda, int direita){
        int meio = (int) (esquerda + direita) / 2;
        int pivot = vetor[meio];
        int i = esquerda - 1;
        int j = direita + 1;
        while(true){
            do{
                i++;
            }while(vetor[i] < pivot);
            do{
                j--;
            }while(vetor[j] > pivot);
            if (i >= j){
                return j;
            }
            int aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }
    public void ordenado(int[] vetorordenado) {
    	System.out.println("_________________________________________________________________");
    	System.out.println("Vetor Ordenado com QUICK SORT com : "+vetor.length+" posições");
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
