package com.example.jogodavelha;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Jogo jogo;
	private Jogador jogadorAtual = Jogador.JOGADOR1;
	private Vencedor vencedor = Vencedor.NENHUM;
	private Button[] botoes;
	private CliqueBotao cliqueBotao;
	private int count = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		jogo = new Jogo();
		botoes = new Button[9];
		cliqueBotao = new CliqueBotao();
		
		int[] idsBotoes = {R.id.btn1, R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
		
		for (int i = 0 ; i < 9 ; i++) {
			botoes[i] = (Button) findViewById(idsBotoes[i]);
			botoes[i].setOnClickListener(cliqueBotao);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private class CliqueBotao implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			Button btn = (Button)v;
			int i = 0,j = 0;
			
			switch (Integer.parseInt(btn.getText().toString())) {
			case 1:
				i = 0 ; j = 0;
				break;
			case 2:
				i = 0 ; j = 1;
				break;
			case 3:
				i = 0 ; j = 2;
				break;
			case 4:
				i = 1; j = 0;
				break;
			case 5: 
				i = 1; j = 1;
			break;
			case 6:
				i = 1 ; j = 2;
				break;
			case 7:
				i = 2; j = 0;
				break;
			case 8:
				i = 2; j = 1;
				break;
			case 9:
				i = 2; j = 2;
				break;
				
			}
			jogo.setarJogada(i, j, jogadorAtual);
			count++;
			if (jogadorAtual == Jogador.JOGADOR1) {
				btn.setBackgroundColor(Color.RED);
				jogadorAtual = Jogador.JOGADOR2;
			} else {
				btn.setBackgroundColor(Color.GREEN);
				jogadorAtual = Jogador.JOGADOR1;
			}
			
			
			vencedor = jogo.computarJogadas();
			
			if (vencedor == Vencedor.JOGADOR1) {
				Toast.makeText(MainActivity.this, "O jogador 1 venceu!", Toast.LENGTH_LONG).show();
				
			} else if (vencedor == Vencedor.JOGADOR2) {
				Toast.makeText(MainActivity.this, "O jogador 2 venceu!", Toast.LENGTH_LONG).show();
			} else if (vencedor == Vencedor.NENHUM && count == 9) {
				Toast.makeText(MainActivity.this, "Ninguém venceu!", Toast.LENGTH_LONG).show();
			}
			
			
		}
		
	}

}
