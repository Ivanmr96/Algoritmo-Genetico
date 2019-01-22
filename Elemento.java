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
	
	public Elemento cruzarCon(Elemento otroPadre)
	{
		Elemento hijo = new Elemento(fraseObjetivo);
		
		for(int i = 0 ; i < fraseObjetivo.length() ; i++)
			{
				if(i % 2 == 0)
					hijo.setADNPart(this.getADN()[i], i);
				else
					hijo.setADNPart(otroPadre.getADN()[i], i);
			}
		
		return hijo;
	}
	
	public void mutar()
	{
		this.setADNPart((char)((int)(Math.random() * 95 + 32)), (int)(Math.random() * this.getADN().length));
	}
}
