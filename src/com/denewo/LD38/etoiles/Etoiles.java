package com.denewo.LD38.etoiles;

import java.util.Random;

public class Etoiles {
	
//public int map [][] = new int [1000/32] [600/32];
public int etoiles [][] = new int [1000/32] [600/32];
private int total = 0;
private int aleatoire = 0;
Random rand = new Random();
public static int pas [][] = new int [1000/32] [600/32];
public static int pas2 [][] = new int [1000/32] [600/32];
public static int size [][] = new int [1000/32] [600/32];
public Etoiles()
{
	total = 0;
	for(int i = 0; i<1001/32; i++)
	{
		for(int j = 0; j<601/32; j++)
		{
			pas[i][j] = rand.nextInt(20-0+1) + 12;
			pas2[i][j] = rand.nextInt(20-0+1) + 12;
			size[i][j] = rand.nextInt(2-0+1);
			if(!(i == 0) && !(j == 0))
			{
				total = 0;
				aleatoire = rand.nextInt(100-1+1);
				if(i > 0)
				{
					total += etoiles[i-1][j];
				}
				if((i > 0) && (j > 0))
				{
					total += etoiles[i-1][j-1];
				}
				if(j>0)
				{
					total += etoiles[i][j-1];
				}
				if((i>0) && (j<9))
				{
					total += etoiles[i-1][j+1];
				}
				switch(total)
				{
				case 0:
					if(aleatoire <= 30)//10% de chance
						etoiles[i][j] = 1;//une plateforme
					else
						etoiles[i][j] = 0;//pas de plateforme
					break;
				case 1:
					if(aleatoire <= 2.5)//10% de chance
						etoiles[i][j] = 1;
					else
						etoiles[i][j] = 0;
					break;
				case 2:
					if(aleatoire <= 1)//10% de chance
						etoiles[i][j] = 1;
					else
						etoiles[i][j] = 0;
					break;
				case 3:
					if(aleatoire <= 1)//10% de chance
						etoiles[i][j] = 1;
					else
						etoiles[i][j] = 0;
					break;
				case 4:
					etoiles[i][j] = 0;
					break;
				default:
					//System.out.println(aleatoire);
					break;					
				}
			}
			else
				etoiles[i][j] = rand.nextInt(1-0+1);
		}
	}
}
}
