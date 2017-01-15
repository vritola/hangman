import java.io.*;
import java.util.*;

public class Sanalista
{
	private List<String> sanat = new ArrayList<>();
	
	public Sanalista (String tiedostonNimi)
	{
		try (BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(tiedostonNimi))))
		{
			String rivi;
			while ((rivi = file.readLine()) != null)
			{
				sanat.add(rivi);
			}
		}
		catch (IOException ioe)
		{
			System.out.println("Virhe tiedoston lukemisessa.");
		}
	}
	public Sanalista (List<String> sanat_par)
	{
		sanat = sanat_par;
	}
	
	public List<String> annaSanat()
	{
		return sanat;
	}
	
	public Sanalista sanatJoidenPituusOn (int pituus)
	{		
		Iterator<String> iter = sanat.iterator();
		while (iter.hasNext())
		{
			String sana = iter.next();
			if (sana.length() !=  pituus)
			{
				sanat.remove(sana);
			}
		}
		
		List<String> sanat_par = sanat;
		Sanalista uusi = new Sanalista (sanat_par);
		return uusi;
	}
	
	public Sanalista sanatJoissaMerkit (String mjono)
	{		
		Iterator<String> iter = sanat.iterator();
		while (iter.hasNext())
		{
			String sana = iter.next();
			for (int i=0; i<sana.length(); i++)
			{
				if ((sana.charAt(i) != mjono.charAt(i)) && (mjono.charAt(i) != '_'))
				{
					sanat.remove(sana);
				}
			}
		}
		List<String> sanat_par = sanat;
		Sanalista uusi = new Sanalista (sanat_par);
		return uusi;
	}
}