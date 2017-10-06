

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Gravador {
	
	public LinkedList<String> load(String nomeArquivo) throws IOException {
		
		BufferedReader leitor = null;
		
		LinkedList<String> textoLido = new LinkedList<String>();
		
		try {
			
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			
			String texto = null;
			
			do{
				
				texto = leitor.readLine();
				
				if(texto != null){
					
					textoLido.add(texto);
					
				}
				
			}while(texto!=null);
			
		}finally{
			
			if(leitor!=null){
				
				leitor.close();
				
			}
			
		}
		
		return textoLido;
		
	}
	
	public void save(LinkedList<String> texto, String nomeArquivo) throws IOException {
		
		BufferedWriter gravador = null;
		
		try {
			
			gravador = new BufferedWriter( new FileWriter (nomeArquivo));
			
			for (String s: texto){
				
				gravador.write(s+"\n");
				
			}
			
		}finally{
			
			if(gravador!=null){
				
				gravador.close();
				
			}
			
		}
		
	}

}
