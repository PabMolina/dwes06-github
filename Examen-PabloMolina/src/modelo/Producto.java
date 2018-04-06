package modelo;

public class Producto {
	
	private int id, stock;
	private String nombre, marca;
	private double precio;
	public Producto(int id, int stock, String nombre, String marca, double precio) {
		super();
		this.id = id;
		this.stock = stock;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", stock=" + stock + ", nombre=" + nombre + ", marca=" + marca + ", precio="
				+ precio + "]";
	}
	
	
}
