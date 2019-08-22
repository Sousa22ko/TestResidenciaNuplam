package param;

public class CalculoImpostoRenda {

	/**
	 * Este método calcula o imposto a ser pago baseado no valor de uma dada compra.
	 * 
	 * Se 1201 <= valor <= 5000 deve pagar 10% de imposto Se 5001 <= valor <= 10000
	 * deve pagar 15% de imposto Se valor > 10000 deve pagar 20% de imposto Se valor
	 * < 1201 deve pagar 0% de imposto
	 * 
	 * @param valor
	 */
	public static double calculaImposto(double valor) throws IllegalArgumentException{
		// Declaração de Variáveis
		if(valor <= 0)
			throw new IllegalArgumentException();
		
		double imposto = 0;
		double impostotot = 0;
		String porcento = "0%";

		if(valor > 0 && valor <= 1200) {
			imposto = 0;
			porcento = "0%";
		}if (valor >= 1201 && valor <= 5000) {
			imposto = 0.1 * valor;
			porcento = "10%";
		} else if (valor >= 5001 && valor <= 10000) {
			imposto = 0.15 * valor;
			porcento = "15%";
		} else if(valor > 10000){
			imposto = 0.2 * valor;
			porcento = "20%";
		}
		impostotot = valor + imposto;

		// Saída de dados
		System.out.println("Valor em Dinheiro: R$" + valor + " + " + porcento + " de imposto. Total:" + impostotot);
		return impostotot;
	}

	public static void main(String[] args) {
		calculaImposto(200.5);
	}
}
