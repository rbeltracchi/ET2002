package ar.com.smartprice.models.mappers;

import ar.com.smartprice.dtos.CategoryDto;
import ar.com.smartprice.models.entities.Categoria;

/**
 * Clase mapeadora de Categoria
 * Categoria a CategoryDto
 * CategoryDto a Categoria
 * @author LuCho
 */
public class CategoryMapper {

    /**
     * Mapea los datos de un CategoryDto a Categoria
     * @param c CategoryDto
     * @return Categoria 
     */
    public static Categoria CategoryDtoToCategoria(CategoryDto c) {
        if (c == null) {
            return null;
        }
        Categoria categoria;
        categoria = new Categoria();
        categoria.setIdCategoria((int) c.getId());
        categoria.setNombre(c.getName());
        categoria.setCategoriaPadre(CategoryDtoToCategoria(c.getCategoriaPadre()));
        return categoria;
    }
/**
     * Mapea los datos de un Categoria a CategoryDto
     * @param c Categoria
     * @return CategoryDto 
     */
    public static CategoryDto CategoriaToCategoryDto(Categoria c) {
        if (c == null) {
            return null;
        }
        CategoryDto categoriaDto;
        categoriaDto = new CategoryDto();
        categoriaDto.setId(c.getIdCategoria());
        categoriaDto.setName(c.getNombre());
        categoriaDto.setCategoriaPadre(CategoriaToCategoryDto(c.getCategoriaPadre()));
        return categoriaDto;
    }
}
