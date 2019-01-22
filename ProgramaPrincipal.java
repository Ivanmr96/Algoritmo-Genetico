import java.util.ArrayList;
import java.util.Scanner;

/* Inicio
 * 	Poblar la poblacion
 * 	Mientras que no exista ningun elemento en la poblacion con la forma maxima
 * 		Calcular la forma de cada elemento
 * 		Mientras la siguienteGeneracion no este poblada al 100%
 * 			Escoger dos padres
 * 			Cruzar los padres para crear el hijo
 * 			Mutar
 * 			Introducir el hijo en la siguienteGeneracion
 *		FinMientras
 * 		Reemplazar poblacion con la siguienteGeneracion
 * 	FinMientras
 */
public class ProgramaPrincipal
{
	public static void main (String[] args)
	{
		String fraseObjetivo = "Prueba de frase";
		int mutacionProbabilidad = 10;
		Scanner teclado = new Scanner(System.in);
		char respuesta;
		int generaciones = 0;

		Generacion poblacion = new Generacion(fraseObjetivo, 1000);
		
		//Poblar la poblacion
		poblacion.poblar();
		
		while (poblacion.getElementoConMasForma().getForma() < fraseObjetivo.length())
		{
			//Calcular la forma de cada elemento
			
			//poblacion.imprimirForma();
			
			ArrayList<Elemento> apareamiento = new ArrayList<Elemento>();
			
			for(int i = 0 ; i < poblacion.length() ; i++)
			{
				for(int j = 0 ; j < Math.pow(poblacion.getElemento(i).getForma(), 3) ; j++)
				{
					apareamiento.add(poblacion.getElemento(i));
					//System.out.print("Anhadido: ");
					//sSystem.out.println(poblacion.getElemento(i).getADN());
				}
			}
			
			System.out.println();
			
			Elemento hijo = new Elemento(fraseObjetivo);

			Generacion siguienteGeneracion = new Generacion(fraseObjetivo, 100);
			
			//Mientras la siguienteGeneracion no este poblada al 100%
			for(int j = 0 ; j < siguienteGeneracion.length() ; j++)
			{
				//Escoger dos padres
				Elemento padre1 = apareamiento.get((int)(Math.random() * apareamiento.size()));
				Elemento padre2 = apareamiento.get((int)(Math.random() * apareamiento.size()));
				
				//Cruzar los padres para crear el hijo
			
				hijo = padre1.cruzarCon(padre2);
				
				//Mutar
				int mutacion = (int)(Math.random() * 100 + 1);

				if (mutacion <= mutacionProbabilidad)
					hijo.setADNPart((char)((int)(Math.random() * 95 + 32)), (int)(Math.random() * hijo.getADN().length));
				
				//Introducir el hijo en la siguienteGeneracion

				siguienteGeneracion.setElemento(hijo, j);

			}
			
			poblacion = siguienteGeneracion;
			generaciones++;
			System.out.print("Mejor elemento de la generacion " + generaciones + ": ");
			System.out.println(poblacion.getElementoConMasForma().getADN());
		}
		
		System.out.print("RESULTADO FINAL: ");
		System.out.println(poblacion.getElementoConMasForma().getADN());
	}
}
