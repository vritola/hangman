import java.io.*;
import java.util.*;

public class Main
{
	public static final Scanner lukija = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		String tiedostonNimi = "sanalista.txt";
		Sanalista sanalista_par = new Sanalista (tiedostonNimi);
		Hirsipuu peli = new Hirsipuu (sanalista_par, 10);
		
		System.out.println("Hirsipuu\n");
		
		String tuloste = peli.peitetty();
		System.out.println("Tassa on arvattava sana:" + tuloste);	
		System.out.println("Saat kymmenen yritysta.");
		
		while (true)
		{
			System.out.println("Arvaa kirjain >");
			String arvaus_string;
			while (true)
			{
				arvaus_string = lukija.nextLine();
			
				if (arvaus_string.length() == 1)
				{
					break;
				}
				else
				{
					System.out.println("Syotteen tulee olla vain yksi merkki! Yritä uudelleen >");
				}
			}
			char arvaus_char = arvaus_string.charAt(0);
			boolean oikein = peli.arvaa(arvaus_char);
		
			if (oikein == true)
			{
				System.out.println("Oikein! Arvaus loytyi sanasta!");
			}
			else
			{
				System.out.println("Arvasit vaarin!");
			}
		
			tuloste = peli.peitetty();
			System.out.println("Pelitilanne:");
			System.out.println(tuloste);
		
			if (peli.onLoppu() == true)
			{
				break;
			}
			else if (peli.arvaustenMaara() == 0)
			{
				break;
			}
			
			System.out.println("Arvauksia jaljella:" + peli.arvaustenMaara());
		}
		
		if (peli.arvaustenMaara() == 0)
		{
			System.out.println("Havisit pelin!");
			System.out.println("Arvattava sana olisi ollut " + peli.sana());
		}
		else
		{
			System.out.println("Voitit pelin!");
		}
		
	}
}