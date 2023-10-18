package coffeTime.org.ProyectoCafeteria.dao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String precio;

    public Productos() {
    }

    public Productos(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = String.valueOf(precio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = String.valueOf(precio);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
