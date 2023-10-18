package coffeTime.org.ProyectoCafeteria.dao.Dto;

public class ProductoDto {
    private String nombre;
    private Double precio;

    public ProductoDto() {
        // Constructor vacío
    }

    public ProductoDto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
