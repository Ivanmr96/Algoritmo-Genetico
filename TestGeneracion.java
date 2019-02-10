public class TestGeneracion
{
	public static void main(String[] args)
	{
		Generacion poblacion = new Generacion("Hola, me llamo Ivan", 20);
		
		poblacion.poblar();
		
		poblacion.imprimirForma();
		
		System.out.println();
		System.out.println();
		
		System.out.println("hola");
		poblacion.imprimir();
		
		Elemento elementoConMasForma = poblacion.elementoConMasForma();
		
		System.out.println();
		System.out.print("elementoConMasForma: ");
		System.out.println(elementoConMasForma.getADN());
		System.out.println("Forma: " + elementoConMasForma.getForma());
	}
}
