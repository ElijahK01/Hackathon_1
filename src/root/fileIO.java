package root;

import java.util.*;
import java.io.*;
import items.*;

public class fileIO
{
	public MaterialProperties getMaterial(String name) throws Exception
	{
		File file;
		Scanner s;
		//open 1, parsing, nothing else
		//String name;
		double d = 0, ts = 0, ss = 0, cs = 0;
		try
		{
			file = new File("C:\\Users\\schei\\Documents\\College\\Hackathon\\Mat.txt");
			s = new Scanner(file);
		}
		catch(Exception e)
		{
			System.out.println("I have done an oopsie! 1");
			throw e;
		}
		
		String input;
			
		while(name.equals(s.next()))
		{
			//this is a loop to find the the correct material in the file.
			//this loop needs no code, so I will continue to write paragraphs of text.
			//this is fun...
			//we should do this more often.
			//PRAISE JESUS!!!
		}
				
		double in;
		for(int c = 0; c < 4; c++)
		{
			input = s.next(); 
			in = StoD(input);
					
			if(c == 0)
				d = in;
			else if(c == 1)
				ts = in;
			else if(c == 2)
				ss = in;
			else
				cs = in;
		}
		
		s.close();
		
		MaterialProperties m = new MaterialProperties(name, d, ts, ss, cs);
		return m;
	}
	
	public void write(MaterialProperties m)
	{
		
	}
	
	public double StoD(String s)
	{
		int pAt = s.length();
		double d = 0;
		
		for(int n = 0; n < s.length(); n++)
		{
			if(s.charAt(n) == 46)
				pAt = n;
		}
		
		for(int c = 0; c < s.length(); c++)
		{
			//. = 46
			//numbers = 49 - 57
			
			if(c < pAt)
			{
				double mul = Math.pow(10, pAt - c -1);
				double num = s.charAt(c) - 49;
				d += num * mul;
			}
			else if(c > pAt)
			{
				double mul = Math.pow(10, pAt - c);
				double num = s.charAt(c) - 49;
				d += num * mul;
			}
		}
		return d;
	}
}
