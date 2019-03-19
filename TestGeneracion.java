public class TestGeneracion
{
	public static void main(String[] args)
	{
		Generacion poblacion = new Generacion("Hola Mundo", 20);
		
		poblacion.poblar();
		
		poblacion.imprimirForma();
		
		System.out.println();
		
		poblacion.imprimir();
		
		Elemento elementoConMasForma = poblacion.elementoConMasForma();
		
		System.out.println();
		System.out.print("elementoConMasForma: ");
		System.out.println(elementoConMasForma.getADN());
		System.out.println("Forma: " + elementoConMasForma.getForma());
	}
}
