/* ESTUDIO DE INTERFAZ
 * 
 * 	Propiedades:
 * 		-> Básicas:
 * 			* ADN: char[], consultable, modificable
 * 			* fraseObjetivo: String, consultable, modificable
 * 	
 * 		-> Derivadas:
 * 			* forma: int, consultable (Depende de su ADN y su fraseObjetivo)
 * 
 * 		-> Compartidas: No hay
 * 
 * 	Restricciones: No hay
 * 
 * 	Funcionalidades añadidas:
 * 		- Cruzar el elemento con otro
 * 		- Mutar el elemento
 */
 
 /* INTERFAZ
  * 
  * public String getFraseObjetivo();
  * public void setFraseObjetivo(String fraseObjetivo);
  * 
  * public char[] getADN(); 			//Devolverá el array entero, y a partir de él se podrá consultar la posicion del array deseada.
  * 
  * public void setADNPart(char caracter, int index);
  * 
  * public int getForma();
  */
  
 /* METODOS AÑADIDOS
  *
  * public void mutar();
  */
  
public class Elemento
{
	private char[] ADN;
	private String fraseObjetivo;
	//private int forma;
	
	public Elemento(String fraseObjetivo)
	{
		this.fraseObjetivo = fraseObjetivo;
		this.ADN = new char[fraseObjetivo.length()];
		
		for(int i = 0 ; i < fraseObjetivo.length() ; i++)
		{
			//32 a 126
			this.ADN[i] = (char)((int)(Math.random() * 95 + 32));
		}
	}
	
	public String getFraseObjetivo()
	{
		return this.fraseObjetivo;
	}
	
	public char[] getADN()
	{
		return this.ADN;
	}
	
	public void setADNPart(char caracter, int index)
	{
		this.ADN[index] = caracter;
	}
	
	public void setFraseObjetivo(String fraseObjetivo)
	{
		this.fraseObjetivo = fraseObjetivo;
	}
	
	public int getForma()
	{
		int ret = 0;
		
		for(int i = 0 ; i < this.ADN.length ; i++)
		{
			if(this.ADN[i] == this.fraseObjetivo.charAt(i)) { ret++; }
		}
		
		return ret;
	}
	
	/* INTERFAZ
	 * Comentario: Hace mutar al elemento, cambiando de forma aleatoria un caracter por otro completamente aleatorio.
	 * Prototipo: public void mutar()
	 * Entrada: No hay
	 * Precondiciones: No hay
	 * Salida: No hay
	 * Postcondiciones: No devuelve nada, pero cambia el estado del Elemento, uno de sus caracteres será cambiado de forma aleatoria por otro.
	 */
	public void mutar()
	{
		this.setADNPart((char)((int)(Math.random() * 95 + 32)), (int)(Math.random() * this.getADN().length));
	}
}
