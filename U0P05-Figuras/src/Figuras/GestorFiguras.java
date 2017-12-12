package Figuras;

import java.util.ArrayList;

public class GestorFiguras {

	ArrayList<Figura>figuras;

	public GestorFiguras() {
		this.figuras=new ArrayList<Figura>();
	}
	
	public boolean añadirFigura(Figura figura){
		
		for(Figura f : figuras){
			if(f.titulo.equalsIgnoreCase(figura.titulo)){
				System.out.println("No se puede aï¿½adir la figura porque ya existe");
				return false;
			}
		}
		System.out.println("Aï¿½adimos la figura al arraylist");
		figuras.add(figura);
		return true;
		
	}
	public void eliminarFigura(String titulo){
		for(int i=0;i<figuras.size();i++){
			if(figuras.get(i).titulo.equalsIgnoreCase(titulo)){
				System.out.println("Procedemos a borrar la figura");
				figuras.remove(i);
			}else{
				System.out.println("No se puede eliminar la figura porque no existe");
			}
		}
	}
	public void mostrarFiguras(){
		
		for(int i=0;i<figuras.size();i++){
			System.out.println(figuras.get(i).toString());
		}
	}
	
	
}

	
	
