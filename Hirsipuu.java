import java.io.*;
import java.util.*;

public class Hirsipuu
{
	private Sanalista sanalista;
	private int arvaukset;
	private String oikea_sana;
	private List<Character> arvauslista = new ArrayList<>();
	
	public Hirsipuu (Sanalista sanalista_par, int arvaukset_par)
	{
		Random rand = new Random();
		int valinta = rand.nextInt(12);
		
		sanalista = sanalista_par;
		arvaukset = arvaukset_par;
		
		List<String> sanat = sanalista.annaSanat();
		oikea_sana = sanat.get(valinta);
	}
	
	public boolean arvaa (Character merkki)
	{
		arvauslista.add(merkki);
		int oikein = oikea_sana.indexOf(merkki);
		
		if (oikein >= 0)
		{
			return true;
		}
		else
		{
			arvaukset--;
			return false;
		}
	}
	
	public List<Character> arvaukset()
	{
		return arvauslista;
	}
	
	public String sana()
	{
		return oikea_sana;
	}
	
	public String peitetty()
	{
		String peitetty_sana = oikea_sana;
		
		for (int i=0; i<peitetty_sana.length(); i++)
		{
			if (arvauslista.isEmpty())
			{
				peitetty_sana = peitetty_sana.replace(peitetty_sana.charAt(i), '_');
			}
			else if (arvauslista.contains(peitetty_sana.charAt(i)) == false)
			{
				peitetty_sana = peitetty_sana.replace(peitetty_sana.charAt(i), '_');
			}
		}
		
		return peitetty_sana;
	}
	public boolean onLoppu()
	{
		for (int i=0; i<oikea_sana.length(); i++)
		{
			if (arvauslista.contains(oikea_sana.charAt(i)) == false)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public int arvaustenMaara()
	{
		return arvaukset;
	}
}