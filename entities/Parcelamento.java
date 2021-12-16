package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcelamento {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date vencimento;
	private Double quantia;
	
	public Parcelamento() {
	}

	public Parcelamento(Date vencimento, Double quantia) {
		super();
		this.vencimento = vencimento;
		this.quantia = quantia;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Double getQuantia() {
		return quantia;
	}

	public void setQuantia(Double quantia) {
		this.quantia = quantia;
	}

	@Override
	public String toString() {
		return sdf.format(vencimento) + " - " + String.format("%.2f", quantia);
	}
}
