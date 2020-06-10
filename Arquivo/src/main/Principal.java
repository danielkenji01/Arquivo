package main;

import java.io.FileWriter;
import java.io.IOException;

import model.Linha;
import model.Planilha;
import service.LeitorArquivo;

public class Principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Planilha planilha = LeitorArquivo.gerarPlanilha();

		FileWriter fileWriter = new FileWriter(planilha.getNomeFormatado());
		
		for (String cabecalho : planilha.getCabecalho()) {
			fileWriter.append(cabecalho);
			fileWriter.append(";");
		}
		
		fileWriter.append("\n");
		
		for (Linha linha : planilha.getLinhas()) {
			fileWriter.append(String.valueOf(linha.getCodigo()));
			fileWriter.append(";");
			
			fileWriter.append(linha.getProduto());
			fileWriter.append(";");
			
			fileWriter.append(String.valueOf(linha.getValorUnitario()));
			fileWriter.append(";");
			
			fileWriter.append(String.valueOf(linha.getQuantidadeVendida()));
			fileWriter.append(";");
			
			fileWriter.append("\n");
		}
		
		fileWriter.flush();
		fileWriter.close();
	}

}
