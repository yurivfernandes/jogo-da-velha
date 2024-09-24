package com.example.jogodavelha;

public class Jogo {
	private int[][] m;
	
	public Jogo() {
		m = new int[3][3];
		
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				m[i][j] = 0;
			}
		}
	}
	
	public void setarJogada(int i, int j, Jogador jogador) {
		if (jogador == Jogador.JOGADOR1) {
			m[i][j] = 1;
		} else {
			m[i][j] = 2;
		}
	}
	
	public Vencedor computarJogadas() {
		Vencedor vencedor = Vencedor.NENHUM;
		int produto = 1;
		boolean abortar = false;
		//percorrer linhas
		
		
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				produto *= m[i][j];
			}
			
			if (produto == 1) {
				vencedor = Vencedor.JOGADOR1;
				abortar = true;
				break;
			} else if (produto == 8) {
				vencedor = Vencedor.JOGADOR2;
				abortar = true;
				break;
			}
			
			produto = 1;
		}
		
		produto = 1;
		//percorrer colunas
		if (!abortar) {
			for (int i = 0 ; i < 3 ; i++) {
				for (int j = 0 ; j < 3 ; j++) {
					produto *= m[j][i];
				}
				
				if (produto == 1) {
					vencedor = Vencedor.JOGADOR1;
					abortar = true;
					break;
				} else if (produto == 8) {
					vencedor = Vencedor.JOGADOR2;
					abortar = true;
					break;
				}
				
				produto = 1;
			}
		}
		
		produto = 1;
		
		//percorrer diagonal principal
		if (!abortar) {
			for (int i = 0 ; i < 3 ; i++) {
				produto *= m[i][i];
			}
			
			if (produto == 1) {
				vencedor = Vencedor.JOGADOR1;
				abortar = true;
			} else if (produto == 8) {
				vencedor = Vencedor.JOGADOR2;
				abortar = true;
			}
		}
		
		produto = 1;
		//percorrer diagonal secundária
		if (!abortar) {
			for (int i = 2 ; i >= 0 ; i--) {
				produto *= m[2-i][i];
			}
			
			if (produto == 1) {
				vencedor = Vencedor.JOGADOR1;
			} else if (produto == 8) {
				vencedor = Vencedor.JOGADOR2;
			}
		}
		
		return vencedor;
		
	}
}
