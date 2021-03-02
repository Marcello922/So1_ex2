package view;

import javax.swing.JOptionPane;

import controller.ClasseController;

public class Main {
	
	public static void main(String[] args) {
		ClasseController c = new ClasseController();
		int m = 0;
		do {
			m = Integer.parseInt(JOptionPane.showInputDialog("MENU \n 1 - Listar processos ativos. \n 2 - Matar processo pelo PID \n 3 - Matar processo pelo nome. \n 4 - Sair."));
			switch(m) {
			case 1:
				c.procAtivos(c.so());
				break;
			case 2:
				c.mataProcessoPID(c.so(),Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo: ")));
				break;
			case 3:
				c.mataProcessoNome(c.so(), JOptionPane.showInputDialog("Digite o nome do processo: "));
				break;
			case 4:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Número inválido!");
			}
		}while(m != 4);
	}
}
