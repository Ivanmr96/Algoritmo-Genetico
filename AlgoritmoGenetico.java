/* ANALISIS
 * Programa que ejecutará un algoritmo genético que tendrá como objetivo una frase.
 * 
 * Un algoritmo genetico hace evolucionar una población de elementos, sometiendola a 
 * una selección, decidiendo cuales son los elementos mejores adaptados, hasta llegar a un objetivo.
 * 
 * El algoritmo tiene los siguientes pasos:
 * 
 * 	1. Inicialización: Se genera una población inicial aleatoria. En este caso de cadena de caracteres.
 *  2. Evaluación: Se determinará una puntuación de aptitud a cada elemento de la población. (Cuáles son los más fuertes)
 * 		En este caso, los elementos más fuertes serán las cadenas de caracteres que más se parezcan a la frase objetivo.
 *  3. Selección: Se escogen dos (pueden ser dos o más) padres.
 * 			¿Cómo se escogen los padres?
 * 			Cada elemento tendrá una probabilidad de ser elegido como padre según su aptitud, a más aptitud, más probabilidad de
 * 			tener descendencia. En este caso la probabilidad aumentará de forma exponencial.
 * 	4. Reproducción: Una vez se han cogido los padres, se deben cruzar sus "genes" para crear un elemento hijo.
 * 			En este caso los "genes" serán las letras del elemento.
 * 			Se cogerán las letras pares de un padre y las impares del otro para dar lugar a un nuevo elemento.
 * 	5. Mutación: Debe existir una probabilidad (baja) de que se aplique una mutación al nuevo elemento,
 * 			En este caso, la mutación será cambiar un caracter de forma completamente aleatoria por otro.
 * 
 *  Entrada:
 *  Salida:
 *  Restricciones:
 */
/* PSEUCODOGIO GENERALIZADO
 * Inicio
 * 	Leer frase objetivo
 * 	Poblar la poblacion
 * 	Mientras que no exista ningun elemento en la poblacion con la forma maxima
 * 		Crear lista con los posibles padres
 * 		Mientras la siguienteGeneracion no este poblada al 100%
 * 			Escoger dos padres
 * 			Cruzar los padres para crear el hijo
 * 			Mutar
 * 			Introducir el hijo en la siguienteGeneracion
 *		FinMientras
 * 		Reemplazar poblacion con la siguienteGeneracion
 * 	FinMientras
 * 	Mostrar resultado final
 * Fin
 */
 
import java.util.ArrayList;
import java.util.Scanner;
public class AlgoritmoGenetico
{
	public static void main (String[] args)
	{
		String fraseObjetivo;
		int mutacionProbabilidad = 15;
		char respuesta;
		int generaciones = 0;
		int cantidadPoblacion = 250;
		Scanner teclado = new Scanner(System.in);
		
		//Leer frase objetivo
		System.out.print("Introduce la frase objetivo: ");
		fraseObjetivo = teclado.nextLine();


		Generacion poblacion = new Generacion(fraseObjetivo, cantidadPoblacion);
		
		//Poblar la poblacion
		poblacion.poblar();
		
		while (poblacion.elementoConMasForma().getForma() < fraseObjetivo.length())		//Mientras que no exista ningun elemento en la poblacion con la forma maxima
		{
			System.out.println("-------------------------------------------------");
			System.out.println("GENERACION " + generaciones);
			
			//Crear lista con los posibles padres
			ArrayList<Elemento> posiblesPadres = poblacion.listaPosiblesPadres();
			
			//System.out.println("Posibles padres: " + posiblesPadres.size());
			//System.out.println("Poblacion: " + poblacion.tamanho());
			//System.out.println("Forma total: " + poblacion.totalForma());
			Generacion siguienteGeneracion = new Generacion(fraseObjetivo, cantidadPoblacion);
			
			//Mientras la siguienteGeneracion no este poblada al 100%
			for(int j = 0 ; j < siguienteGeneracion.tamanho() ; j++)
			{
				//Escoger dos padres
				Elemento padre1 = posiblesPadres.get((int)(Math.random() * posiblesPadres.size()));
				Elemento padre2 = posiblesPadres.get((int)(Math.random() * posiblesPadres.size()));
				
				//Cruzar los padres para crear el hijo
				Elemento hijo = poblacion.cruzar(padre1, padre2);
				
				//Mutar
				int mutacion = (int)(Math.random() * 100 + 1);

				if (mutacion <= mutacionProbabilidad)
					hijo.setADNPart((char)((int)(Math.random() * 95 + 32)), (int)(Math.random() * hijo.getADN().length));
				
				//Introducir el hijo en la siguienteGeneracion
				siguienteGeneracion.setElemento(hijo, j);

			}
			
			//Reemplazar poblacion con la siguienteGeneracion
			poblacion = siguienteGeneracion;
			generaciones++;
			
			System.out.print("Mejor elemento de la generacion " + generaciones + ": ");
			System.out.println(poblacion.elementoConMasForma().getADN());
		}
		
		//Mostrar resultado final
		System.out.println("-------------------------------------------------");
		System.out.println("RESULTADO FINAL");
		System.out.print("Elemento ganador: ");
		System.out.println(poblacion.elementoConMasForma().getADN());
		System.out.println("Conseguido en " + generaciones + " generaciones.");
	}
}
