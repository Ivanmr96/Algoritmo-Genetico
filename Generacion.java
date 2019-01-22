public class Generacion
{
	private Elemento[] poblacion;
	private String fraseObjetivo;
	
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
	
	public Generacion(Elemento[] poblacion)
	{
		this.poblacion = poblacion;
		this.fraseObjetivo = poblacion[1].getFraseObjetivo();
	}
	
	public Generacion(Generacion gen)
	{
		this.poblacion = gen.poblacion;
		this.fraseObjetivo = gen.fraseObjetivo;
	}
	
	public int length()
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
	
	public void setFraseObjetivo(String fraseObjetivo)
	{
		this.fraseObjetivo = fraseObjetivo;
	}
	
	public Elemento getElemento(int index)
	{
		return this.poblacion[index];
	}
	
	public void setElemento(Elemento e, int index)
	{
		this.poblacion[index] = e;
	}
	
	public void poblar()
	{
		for(int i = 0 ; i < poblacion.length ; i++)
		{
			this.poblacion[i] = new Elemento(fraseObjetivo);
		}
	}
	
	public void imprimir()
	{
		for(int i = 0 ; i < this.poblacion.length ; i++)
			{
				System.out.print("Elemento " + i + " ");
				System.out.println(this.poblacion[i].getADN());
			}
	}
	
	public void imprimirForma()
	{
		for(int i = 0 ; i < poblacion.length ; i++)
			{
				System.out.println(poblacion[i].getADN());
				System.out.println("Forma: " + poblacion[i].getForma());
				System.out.println();
			}
	}
	
	public Elemento getElementoConMasForma()
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
}
