/*
 * Lapin.java
 * 
 * Copyright 2018 vvolpei <vvolpei@PC106-025-16>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */


public class Lapin {
	private static int nbLapin = 1;
	
	//les attributs
	
	int nbreLapin;
	double poidsLapin;
	int xLapin;
	int yLapin;
	
	//Les contructeurs
	
	public Lapin(int lNbre, double lPoids, int lX, int lY){
		//nbreLapin = lNbre;
		//poidsLapin = lPoids;
		xLapin = lX;
		yLapin = lY;
		this(lNbre, lPoids);
	}
	//Les Accesseurs
	
	public int getNombreLapin(){
		return nbreLapin;
		}
	public double getPoidsLapin(){
		return poidsLapin;
		}
	public int getXLapin(){
		return xLapin;
		}
	public int getYLapin(){
		return yLapin;
		}
	//Les Mutateurs
	
	public void setNombreLapin(int lNbre){
		nbreLapin = lNbre;
		}
	public void setPoidsLapin(double lPoids){
		poidsLapin = lPoids;
		}
	public void setXLapin(int lX){
		xLapin = lX;
		}
	public void setYLapin(int lY){
		yLapin = lY;
		}
		
		
	public void mourir(int tour){ //méthode mourir
        
        if (tour > 5){ 
			
           
            
        
        
        System.out.println(nom + " age et prend " + age + " tour");
        
		}
}

