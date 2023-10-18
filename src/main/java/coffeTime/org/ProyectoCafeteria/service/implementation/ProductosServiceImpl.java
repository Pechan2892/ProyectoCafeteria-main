package coffeTime.org.ProyectoCafeteria.service.implementation;

import coffeTime.org.ProyectoCafeteria.dao.entity.Productos;
import coffeTime.org.ProyectoCafeteria.repository.ProductoRepository;
import coffeTime.org.ProyectoCafeteria.service.Interface.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Productos> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Productos obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void agregarProducto(Productos nuevoProducto) {
        productoRepository.save(nuevoProducto);
    }

    @Override
    public void editarProducto(Long id, Productos productoEditado) {
        // Verificar si el producto existe antes de editarlo
        Productos productoExistente = productoRepository.findById(id).orElse(null);
        if (productoExistente != null) {
            productoEditado.setId(id);
            productoRepository.save(productoEditado);
        }
    }

    @Override
    public void borrarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Productos> obtenerProductosDestacados() {
        // Puedes implementar la lógica para obtener productos destacados según tus criterios
        return productoRepository.findFirst4ByOrderByPrecioAsc();
    }
}
