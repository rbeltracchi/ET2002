
package ar.com.smartprice.models.mappers;

import ar.com.smartprice.dtos.ProductDto;
import ar.com.smartprice.models.entities.Categoria;
import ar.com.smartprice.models.entities.Marca;
import ar.com.smartprice.models.entities.ProductoYServicio;

/**
 * Clase mapeadora de ProductoYServicio
 * ProductoYServicio a ProductDto
 * ProductDto a ProductoYServicio
 * @author Andres
 */
public class ProductMapper {
    /**
     * Mapea los datos de un ProductDto a ProductoYServicio
     * @param dto ProductDto
     * @return ProductoYServicio 
     */
    public static ProductoYServicio dtoTOproduct(ProductDto dto){
        if (dto==null)
            return null;
        ProductoYServicio pys = new ProductoYServicio();
        pys.setIdproductosYServicios(dto.getId());
        pys.setNombre(dto.getNombre());
        pys.setDescripcion(dto.getDescripcion());
        Categoria cat = CategoryMapper.CategoryDtoToCategoria(dto.getCategoria());
        pys.setCategoria(cat);
        pys.setMarca(new Marca(dto.getMarca()));
        return pys;
    }
    
    /**
     * Mapea los datos de un ProductoYServicio a ProductDto
     * @param dto ProductDto
     * @return ProductoYServicio 
     */
    public static ProductDto productToDto(ProductoYServicio producto){
        if (producto==null)
            return null;
       
        ProductDto pdto = new ProductDto(producto);
        return pdto;
    }
    
}
