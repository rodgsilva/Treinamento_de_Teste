package aulapoo;

public class Exercicio {
	
		
	private class MyInnerClass{
		
		public void hello() {
			System.out.println("Olá, sou uma classe interna regular");
		}
		
		
	}
	public static void main(String[] args) {
		
		MyInnerClass mic = new Exercicio().new MyInnerClass();
		mic.hello();
				
	}

}
