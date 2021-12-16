package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contrato;
import entities.Parcelamento;
import services.PaypalService;
import services.ServicoContrato;

public class ProgramPagamento {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com o contrato");
		System.out.print("Numero: ");
		Integer numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy(: ");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		Double valorTotal = sc.nextDouble();
		
		Contrato contrato = new Contrato(numero, data, valorTotal);
		
		System.out.print("Entre com a quantidade de parcelas: ");
		int N = sc.nextInt();
		
		ServicoContrato cs = new ServicoContrato(new PaypalService());
		
		cs.processoContrato(contrato, N);
		
		System.out.println("Parcelamento:");
		for(Parcelamento parcela : contrato.getParcelas()) {
			System.out.println(parcela);
		}
		
		sc.close();
	}

}
