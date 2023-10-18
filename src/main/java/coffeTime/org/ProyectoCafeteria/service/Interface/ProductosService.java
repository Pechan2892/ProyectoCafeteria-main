package coffeTime.org.ProyectoCafeteria.service.Interface;

import coffeTime.org.ProyectoCafeteria.dao.entity.Productos;

import java.util.List;

public interface ProductosService {

    List<Productos> obtenerTodosLosProductos();

    Productos obtenerProductoPorId(Long id);

    void agregarProducto(Productos nuevoProducto);

    void editarProducto(Long id, Productos productoEditado);

    void borrarProducto(Long id);

    List<Productos> obtenerProductosDestacados();
}
