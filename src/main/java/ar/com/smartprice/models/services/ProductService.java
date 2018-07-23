package ar.com.smartprice.models.services;

import ar.com.smartprice.dtos.BrandDto;
import ar.com.smartprice.dtos.CategoryDto;
import ar.com.smartprice.models.persistence.PyS_DBAdmin;
import ar.com.smartprice.models.persistence.Precios_DBAdmin;
import ar.com.smartprice.dtos.ProductDto;
import ar.com.smartprice.models.entities.ProductoYServicio;
import ar.com.smartprice.models.mappers.BrandMapper;
import ar.com.smartprice.models.mappers.CategoryMapper;
import ar.com.smartprice.models.mappers.ProductMapper;

/**
 *
 * @author Usuario
 */
public class ProductService {

    private static PyS_DBAdmin productPersistence = new PyS_DBAdmin();
    private static Precios_DBAdmin preciosPersistence = new Precios_DBAdmin();

    public void insertarProducto(ProductDto producto) {

        BrandDto brand = new BrandDto();
        brand.setBrandName(producto.getMarca());

        boolean success = BrandsService.create(brand);
        if (!success) {
            System.out.println("La marca ya existe");
        }
        brand = BrandsService.getMarca(producto.getMarca());
        CategoryDto cat = producto.getCategoria();

        ProductoYServicio pys = new ProductoYServicio(producto.getNombre(),
                BrandMapper.BrandDtoToMarca(brand),
                CategoryMapper.CategoryDtoToCategoria(cat),
                producto.getDescripcion());

        boolean exito = productPersistence.insertarProducto(pys);
        if (exito) {
            producto.setId(pys.getIdproductosYServicios());
        } else {
            //TODO Codigo de ingresar error al productDTO aca
        }
    }

    public void actualizarProducto(ProductDto producto) {
        ProductoYServicio pys = ProductMapper.dtoTOproduct(producto);
        productPersistence.acualizarProducto(pys);
    }

    public void borrarProducto(ProductDto producto) {
        ProductoYServicio pys = ProductMapper.dtoTOproduct(producto);
        productPersistence.borrarProducto(pys);
    }

}
