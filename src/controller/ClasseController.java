package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class ClasseController {
	
	public String so() {
		String so = System.getProperty("os.name");
		return so;
	}
	
	public void procAtivos(String so) {
		String comando = "";
		
		if(so.contains("Windows")) {
			comando = "tasklist";
		}
		else if (so.contains("Linux")) {
			comando = "ps";
		}
		try {
			
			Process p = Runtime.getRuntime().exec(comando);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mataProcessoPID(String so, int PID) {
		StringBuffer b = new StringBuffer();
		if(so.contains("Windows")) {
			b.append("TASKKILL /PID ");
		}
		else if (so.contains("Linux")) {
			b.append("kill");
		}
		b.append(PID);
		try {
			Runtime.getRuntime().exec(b.toString());
			JOptionPane.showMessageDialog(null, "Operação efetuada com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mataProcessoNome(String so, String nome){
		
		StringBuffer b = new StringBuffer();
		if(so.contains("Windows")) {
			b.append("TASKKILL /IM ");
		}
		else if (so.contains("Linux")) {
			b.append("pkill");
		}
		b.append(nome);
		try {
			Runtime.getRuntime().exec(b.toString());
			JOptionPane.showMessageDialog(null, "Operação efetuada com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
