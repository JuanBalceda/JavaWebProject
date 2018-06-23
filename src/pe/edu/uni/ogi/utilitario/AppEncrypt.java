package pe.edu.uni.ogi.utilitario;

public class AppEncrypt {

	public AppEncrypt() {
	}

	public static void main(String[] args) {

		try {
			
			Encrypt.init("J4v4");
			
			System.out.println(Encrypt.encrypt("2906"));
			
			//fS+nooIQXiSVDk=== (J4v4)
			System.out.println(Encrypt.decrypt("nooIQXiSVDk="));
			System.out.println(Encrypt.decrypt("s0cyBg9h+8w="));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
