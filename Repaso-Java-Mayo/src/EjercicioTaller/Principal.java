package EjercicioTaller;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//creamos el objeto taller:
				Taller t= new Taller();
				
				//cremaos algunas averias
					Averias a1= new Averias();
					Averias a2= new Averias();
					Averias a3= new Averias();
					Averias a4= new Averias();
					t.listaAverias.add(a1);
					t.listaAverias.add(a2);
					t.listaAverias.add(a3);
					t.listaAverias.add(a4);
					
					//creamos un coche
					
					Vehiculos c1 = new Vehiculos("3232ghg");
					
					//Mecanicos:
						Mecanicos m1= new Mecanicos("Luis", 1200, c1);
						Mecanicos m2= new Mecanicos("Alberto", 1500, null);
						Mecanicos m3= new Mecanicos("Roberto", 850, null);
						Mecanicos m4= new Mecanicos("Maria", 1500, null);
						t.listaMecanicos.add(m1);
						t.listaMecanicos.add(m2);
						t.listaMecanicos.add(m3);
						t.listaMecanicos.add(m4);
						String respuesta="";
						int x;
						System.out.println(t.listaAverias);
						do{
							System.out.println("Elige una opci�n:");
							System.out.println("1.Recepci�n de Veh�culo");
							System.out.println("2.Terminaci�n de una reparaci�n");
							System.out.println("3.Entrega de Veh�culos reparados");
							System.out.println("4.Alta Mec�nico");
							x=LeerTeclado.readInteger();
							switch (x) {
							case 1:
								t.altaVehiculo();
								break;
							case 2:
								System.out.println("Escribe el codigo del mecánico");
								int ans = LeerTeclado.readInteger();
								t.terminarReparacion(ans);

							
				}System.out.println("\n�Quieres repetir?si|no");
				respuesta=LeerTeclado.readString();
			}while(respuesta.equalsIgnoreCase("si"));
						
						}
	

}

