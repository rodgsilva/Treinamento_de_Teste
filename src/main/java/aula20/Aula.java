package aula20;

public class Aula {

	public static void main(String[] args) {
		
		Calculo c =new Calculo();
		
		System.out.println("Somar: " + c.somar(10, 5));
		System.out.println("Multiplcar: "+ c.multiplicar(4,8));
		
		Aula a = new Aula();
		
		System.out.println("My Somar: "+ a.mySoma(20, 60));
		
		a.imprime(new Executa() {
			
			public void executar() {
				Calculo c =new Calculo();
				
				System.out.println("Somar: " + c.somar(14, 5));
				System.out.println("Multiplcar: "+ c.multiplicar(54,8));
				
			}
		});

	}
	
	void imprime(Executa executa) {
		executa.executar();
	}
	
	int mySoma(int z, int y) {
		
		Adicao adicao = new Adicao() {
			
			public int somar(int a, int b) {
				// TODO Auto-generated method stub
				return b + a;
			}
		};
		
		return adicao.somar(z , y);
		
	}
	

}
