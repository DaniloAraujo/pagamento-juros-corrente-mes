package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contrato;
import entities.Parcelamento;

public class ServicoContrato {
	
	private ServicoPagamentoOnline servicoPagamentoOnline;
	
	public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}

	public void processoContrato(Contrato contrato, int meses) {
		double parcelaBasica = contrato.getValorTotal() / meses;
		for(int i=1; i <= meses; i++) {
			double parcelaAtt = parcelaBasica + servicoPagamentoOnline.juros(parcelaBasica, i);
			double parcelaTotal = parcelaAtt + servicoPagamentoOnline.taxaPagamento(parcelaAtt);
			Date dataVencimento = addMeses(contrato.getData(), i);
			contrato.getParcelas().add(new Parcelamento(dataVencimento, parcelaTotal));
		}
	}
	
	private Date addMeses(Date data, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(calendar.MONTH, N);
		return calendar.getTime();
	}
}
