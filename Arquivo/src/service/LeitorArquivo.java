package service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Linha;
import model.Planilha;

public class LeitorArquivo {

	public static Planilha gerarPlanilha() throws IOException {
		
		String arquivo = "relatorio.txt";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"));
		
		String linha;
		
		boolean primeiraLinha = true;
		
		String nomeArquivo = null;
		
		String[] cabecalho = null;
		
		Linha[] linhas = new Linha[4];
		
		while ((linha = reader.readLine()) != null) {
			
			System.out.println(linha);
			
			if (linha.isEmpty()) {
				continue;
			}
			
			if (primeiraLinha) {
				nomeArquivo = linha;
				primeiraLinha = false;
				
				continue;
			}
			
			if (cabecalho == null) {
				
				cabecalho = new String[4];
				
				String[] split = linha.split(" ");
				
				for (int i = 0; i < 4; i++) {
					cabecalho[i] = split[i];
				}
				
				continue;
			}
			
			String[] split = linha.split(" ");
			for (int i = 0; i < 4; i++) {

				if (linhas[i] != null) {
					continue;
				}
				
				Linha linhaObj = new Linha();
				linhaObj.setCodigo(Integer.parseInt(split[0]));
				linhaObj.setProduto(split[1]);
				linhaObj.setValorUnitario(Double.parseDouble(split[2]));
				linhaObj.setQuantidadeVendida(Integer.parseInt(split[3]));
				linhas[i] = linhaObj;
				break;
			}
		}
		
		reader.close();
		
		return new Planilha(nomeArquivo, cabecalho, linhas);
	}
	
}