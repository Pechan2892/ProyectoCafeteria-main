package coffeTime.org.ProyectoCafeteria.controller;

import coffeTime.org.ProyectoCafeteria.dao.entity.Productos;
import coffeTime.org.ProyectoCafeteria.dao.entity.Usuario;
import coffeTime.org.ProyectoCafeteria.repository.ProductoRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class ControlerProducto {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/productos")
    public String mostrarProductoPage(HttpServletRequest request, Model model, Pageable pageable) {
        Usuario usuario = obtenerUsuarioDesdeSesion(request);
        if (usuario == null) {
            return "redirect:/logear";
        }

        // Obtener la lista de productos (aquí puedes ajustar según tu lógica)
        List<Productos> listaProductos = productoRepository.findFirst4ByOrderByPrecioAsc();

        // Agregar la lista de productos al modelo
        model.addAttribute("productos", listaProductos);

        return "Producto";
    }

    @GetMapping("/productos/agregar")
    public String mostrarFormularioAgregar(Model model) {
        // Lógica para mostrar el formulario de agregar producto
        model.addAttribute("nuevoProducto", new Productos());
        return "FormularioAgregarProducto";
    }

    @PostMapping("/productos/agregar")
    public String agregarProducto(@ModelAttribute Productos nuevoProducto) {
        // Lógica para agregar el nuevo producto a la base de datos
        productoRepository.save(nuevoProducto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/borrar/{id}")
    public String mostrarConfirmacionBorrar(@PathVariable Long id, Model model) {
        // Lógica para mostrar una confirmación antes de borrar
        Productos producto = productoRepository.findById(id).orElse(null);
        model.addAttribute("producto", producto);
        return "ConfirmacionBorrarProducto";
    }

    @PostMapping("/productos/borrar/{id}")
    public String borrarProductoConfirmado(@PathVariable Long id) {
        // Lógica para borrar el producto de la base de datos
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        // Lógica para obtener el producto por ID y agregarlo al modelo
        Productos producto = productoRepository.findById(id).orElse(null);
        model.addAttribute("producto", producto);
        return "FormularioEdicionProducto";
    }

    @PostMapping("/productos/editar/{id}")
    public String editarProducto(@PathVariable Long id, @ModelAttribute Productos productoEditado) {
        // Lógica para editar el producto en la base de datos
        productoRepository.save(productoEditado);
        return "redirect:/productos";
    }

    private Usuario obtenerUsuarioDesdeSesion(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Usuario) session.getAttribute("usuario");
    }
}


