package ar.com.smartprice.models.services;

import ar.com.smartprice.dtos.AdministratorDto;
import ar.com.smartprice.dtos.ArbolCategoriesDto;
import ar.com.smartprice.models.persistence.Category_DBAdmin;
import ar.com.smartprice.dtos.CategoryDto;
import ar.com.smartprice.models.entities.Categoria;
import static ar.com.smartprice.models.mappers.CategoryMapper.CategoriaToCategoryDto;
import java.util.ArrayList;
import java.util.List;
import static ar.com.smartprice.models.mappers.CategoryMapper.CategoryDtoToCategoria;
import ar.com.smartprice.utils.Authentication;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author Andres
 */
public class CategoriesService {

    private static Category_DBAdmin c = new Category_DBAdmin();

    public CategoriesService() {
        
    }

    public static Categoria create(CategoryDto category, AdministratorDto requester) {
        if (requester == null || !Authentication.verifyAdministrator(requester)) {
            System.out.println("Administrador invalido");
            return null;
        }
        if (category == null) {
            return null;
        }
        Categoria persistida;
        if (category.getCategoriaPadre() != null) {
            persistida = c.cargarCategoria(category.getName(), category.getCategoriaPadre().getName());
        } else {
            persistida = c.cargarCategoria(category.getName(), null);
        }

        return persistida;
    }

    public static CategoryDto readAlla() {
        CategoryDto categ = new CategoryDto();

        List result = new ArrayList();
        List<Categoria> listaCategorias;
        listaCategorias = c.obtenerTodasCategorias();
        for (Categoria listaCategoria : listaCategorias) {
            result.add(CategoriaToCategoryDto(listaCategoria));
        }

        categ.setCategories(result);

        return categ;
    }
    public static ArbolCategoriesDto getArbol(){
        List<Categoria> listaCategorias = c.obtenerTodasCategorias();
        if (listaCategorias==null || listaCategorias.isEmpty())
            return null;
        Vector<String> padres = new Vector<>();
        Hashtable<String,Vector<CategoryDto>> hijos = new Hashtable();
        for (Categoria cat: listaCategorias){
            cargarArbol(CategoriaToCategoryDto(cat),padres,hijos);
        }
        ArbolCategoriesDto retorno = new ArbolCategoriesDto();
        retorno.setPadres(padres);
        retorno.setHijos(hijos);
        return retorno;
    }
    private static void cargarArbol(CategoryDto c, Vector<String> padres, Hashtable<String,Vector<CategoryDto>> hijos){
        if (c.getCategoriaPadre()==null){
            if (!padres.contains(c.getName())){
                padres.add(c.getName());
            }
        }
        else{
            CategoryDto padre = c.getCategoriaPadre();
             cargarArbol(padre, padres, hijos);
             if (hijos.get(padre.getName())==null){
                    Vector<CategoryDto> aux = new Vector<>();
                    aux.add(c);
                    hijos.put(padre.getName(), aux);
                }
             else{
                 hijos.get(padre.getName()).add(c);
             }
            }        
    }

    public static List<CategoryDto> readall() {
        List<CategoryDto> result;
        result = new ArrayList();
        List<Categoria> listaCategorias;
        listaCategorias = c.obtenerTodasCategorias();
        for (Categoria listaCategoria : listaCategorias) {
            result.add(CategoriaToCategoryDto(listaCategoria));
        }
        return result;
    }

    public static CategoryDto getCategoryByName(String name) {
        return CategoriaToCategoryDto(c.getCategoria(name));
    }

    public static CategoryDto getCategoryById(int id) {
        //TODO retornar una categoria
        return CategoriaToCategoryDto(c.getCategoriaPorID(id));
    }

    public static boolean update(CategoryDto category) {
        return c.actualizarCategoria(CategoryDtoToCategoria(category));
    }

    public static boolean delete(CategoryDto category) {
        return c.borrarCategoria(CategoryDtoToCategoria(category));
    }
}
