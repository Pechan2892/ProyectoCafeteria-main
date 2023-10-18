package coffeTime.org.ProyectoCafeteria.repository;

import coffeTime.org.ProyectoCafeteria.dao.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Productos, Long> {
    List<Productos> findByIdNot(Long id);

    List<Productos> findFirst4ByOrderByPrecioAsc();
}
