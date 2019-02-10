import java.util.ArrayList;
public class Generacion
{
	private Elemento[] poblacion;
	private String fraseObjetivo;
	
	public Generacion()
	{
		this.poblacion = new Elemento[0];
		this.fraseObjetivo = " ";
	}
	
	public Generacion(String fraseObjetivo)
	{
		this.poblacion = new Elemento[0];
		this.fraseObjetivo = fraseObjetivo;
	}
	
	public Generacion(String fraseObjetivo, int size)
	{
		this.poblacion = new Elemento[size];
		this.fraseObjetivo = fraseObjetivo;
	}
	
	public Generacion(Elemento[] poblacion)			//Constructor a partir de una poblacion de elementos, obtendrá de el la frase objetivo.
	{
		this.poblacion = poblacion;
		this.fraseObjetivo = poblacion[1].getFraseObjetivo();
	}
	
	public Generacion(Generacion gen)				//Constructor de copia
	{
		this.poblacion = gen.poblacion;
		this.fraseObjetivo = gen.fraseObjetivo;
	}
	
	public int tamanho()
	{
		return this.poblacion.length;
	}
	
	public Elemento[] getPoblacion()
	{
		return this.poblacion;
	}
	
	public String getFraseObjetivo()
	{
		return this.fraseObjetivo;
	}
	
	public Elemento getElemento(int index)
	{
		return this.poblacion[index];
	}
	
	public void setElemento(Elemento e, int index)
	{
		this.poblacion[index] = e;
	}
	
	/* INTERFAZ
	 * Comentario: puebla la generación con Elementos aleatorios.
	 * Prototipo: public void poblar()
	 * Entrada: No hay
	 * Precondiciones: No hay
	 * Salida: No hay
	 * Postcondicionees: No devuelve nada. La población de la generación estará completamente poblada con elementos generados aleatoriamente.
	 */
	public void poblar()
	{
		for(int i = 0 ; i < poblacion.length ; i++)
		{
			this.poblacion[i] = new Elemento(fraseObjetivo);
		}
	}
	
	/* INTERFAZ
	 * Comentario: Muestra en pantalla todos los elementos de la poblacion.
	 * Prototipo: public void imprimir()
	 * Entrada: No hay
	 * Precondiciones: No hay
	 * Salida: No hay
	 * Postcondiciones: No hay, solo imprime en pantalla.
	 */
	public void imprimir()
	{
		for(int i = 0 ; i < this.poblacion.length ; i++)
			{
				System.out.print("Elemento " + i + " ");
				System.out.println(this.poblacion[i].getADN());
			}
	}
	
	/* INTERFAZ
	 * Comentario: Muestra en pantalla todos los elementos de la poblacion con su forma
	 * Prototipo: imprimirForma()
	 * Entrada: No hay
	 * Precondiciones: No hay
	 * Salida: No hay
	 * Postcondiciones: No hay, solo imprime en pantalla
	 */
	public void imprimirForma()
	{
		for(int i = 0 ; i < poblacion.length ; i++)
			{
				System.out.println(poblacion[i].getADN());
				System.out.println("Forma: " + poblacion[i].getForma());
				System.out.println();
			}
	}
	
	/* INTERFAZ
	 * Comentario: Devuelve el elemento con más forma de la población.
	 * Prototipo: public Elemento elementoConMasForma()
	 * Entrada: No hay
	 * Precondiciones: No hay
	 * Salida: el Elemento con más forma de la población
	 * Postcondiciones: Asociado al nombre devuelve el elemento con más forma de la población.
	 * 					Si hay más de un elemento que tienen la misma forma, devolverá el primero que haya encontrado.
	 */
	public Elemento elementoConMasForma()
	{
		Elemento ElementoConMasForma = new Elemento(fraseObjetivo);
		int mejorForma = 0;
		for(int i = 0 ; i < poblacion.length ; i++)
		{
			if(this.poblacion[i].getForma() > mejorForma)
			{
				ElementoConMasForma = this.poblacion[i];
				mejorForma = ElementoConMasForma.getForma();
			}
		}
		
		return ElementoConMasForma;
	}
	
	/* INTERFAZ
	 * Comentario: Realiza una lista que representa las probabilidades de cada elemento de ser padre
	 * Prototipo: public ArrayList<Elemento> listaPosiblesPadres()
	 * Entrada: No hay
	 * Precondiciones: No hay
	 * Salida: Una lista (ArrayList) de Elementos que representa las probabilidades de cada elemento de ser padre
	 * Postcondiciones: Asociado al nombre devuelve una lista de Elementos,
	 * 					El elemento aparecerá repetido de forma exponencial, a mas forma, mas veces aparecerá.
	 */
	public ArrayList<Elemento> listaPosiblesPadres()
	{
		ArrayList<Elemento> posiblesPadres = new ArrayList<Elemento>();
			
			
			for(int i = 0 ; i < this.tamanho() ; i++)
			{
				for(int j = 0 ; j < Math.pow(this.getElemento(i).getForma(), 3) ; j++)
				{
					posiblesPadres.add(this.getElemento(i));
				}
			}
			
		return posiblesPadres;
	}
	
	/* INTERFAZ
	 * Comentario: cruza un elemento con otro para dar lugar a un elemento hijo con caracteristicas heredadas de ambos
	 * Prototipo: public Elemento cruzar(Elemento padre1, Elemento padre2)
	 * Entrada: dos Elementos padre
	 * Precondiciones: No hay
	 * Salida: Un Elemento hijo
	 * Postcondiciones: Asociado al nombre devuelve un Elemento que tendrá una combinación de la información genetica de sus padres.
	 */
	public Elemento cruzar(Elemento padre1, Elemento padre2)
	{
		Elemento hijo = new Elemento(fraseObjetivo);
		
		for(int i = 0 ; i < fraseObjetivo.length() ; i++)
			{
				if(i % 2 == 0)
					hijo.setADNPart(padre1.getADN()[i], i);
				else
					hijo.setADNPart(padre2.getADN()[i], i);
			}
		
		return hijo;
	}
}
