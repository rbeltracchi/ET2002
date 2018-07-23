package ar.com.smartprice.models.services;

import ar.com.smartprice.models.persistence.PyS_DBAdmin;
import ar.com.smartprice.models.persistence.Search_DBAdmin;
import ar.com.smartprice.dtos.ListadoDePreciosDto;
import ar.com.smartprice.dtos.ListadoDeProductDto;
import ar.com.smartprice.dtos.PrecioDto;
import ar.com.smartprice.dtos.ProductDto;
import ar.com.smartprice.dtos.SearchDto;
import ar.com.smartprice.dtos.UserDto;
import ar.com.smartprice.models.entities.Categoria;
import ar.com.smartprice.models.entities.Oferente;
import ar.com.smartprice.models.entities.Oferta;
import ar.com.smartprice.models.entities.PrecioRegular;
import ar.com.smartprice.models.entities.ProductoYServicio;
import ar.com.smartprice.models.mappers.CategoryMapper;
import ar.com.smartprice.models.mappers.ProductMapper;
import ar.com.smartprice.models.mappers.UsersMapper;
import ar.com.smartprice.models.persistence.Precios_DBAdmin;
import ar.com.smartprice.models.persistence.Users_DBAdmin;
import java.util.List;

/**
 *
 * @author Agustin
 */
public class SearchService {
    private static PyS_DBAdmin productosDba = new PyS_DBAdmin();
    private static Search_DBAdmin searchDba = new Search_DBAdmin();
    private static GmapService gmaps = new GmapService();
    private static Users_DBAdmin userDba = new Users_DBAdmin();
    private static Precios_DBAdmin preciosDba = new Precios_DBAdmin();


    public static ListadoDeProductDto buscar(SearchDto search) {
        String userLocation = search.getUserLocation();
        Categoria categoria = CategoryMapper.CategoryDtoToCategoria(search.getCategoria());
        List<ProductoYServicio> list = searchDba.getProductosByKeys(search.getSearchWord(),categoria);
        ListadoDeProductDto resultado = new ListadoDeProductDto();
        if (list!=null){            
            for (ProductoYServicio p : list){
                ProductDto pDto =new ProductDto(p);
                ListadoDePreciosDto precios = SearchService.buscarPrecios(pDto, userLocation);
                if (precios!=null && precios.size()>0){
                    pDto.setPrecios(precios);
                }
                resultado.addProducto(pDto);
            }
        }
        return resultado;
    }
/*    
    public static ListadoDeProductDto buscarPreciosDelOferente(SearchDto search) {
        String userLocation = search.getUserLocation();
        UserDto oferente = search.getOferente();
        List<ProductoYServicio> list = searchDba.getProductosByKeys(search.getSearchWord());
        ListadoDeProductDto resultado = new ListadoDeProductDto();
        if (list!=null){            
            for (ProductoYServicio p : list){
                ProductDto pDto =new ProductDto(p);
                ListadoDePreciosDto precios = SearchService.getPreciosPorOferenteYProducto(oferente,pDto);
                if (precios!=null && precios.size()>0){
                    pDto.setPrecios(precios);
                }
                resultado.addProducto(pDto);
            }
        }
        return resultado;
    }
    
    public static ListadoDeProductDto buscarProductos(SearchDto search){
        List<ProductoYServicio> list = searchDba.getProductosByKeys(search.getSearchWord());
        
        if (list!=null){
            ListadoDeProductDto resultado = new ListadoDeProductDto();
            for (ProductoYServicio p : list){
                ProductDto pDto =new ProductDto(p);
                resultado.addProducto(pDto);
            }
            return resultado;
        }
        return null;
        
    }
*/    
    public static ListadoDePreciosDto buscarPrecios(ProductDto p, String userLocation){

        int idProducto= p.getId();
        
        ProductoYServicio productoSeleccionado = productosDba.getProductoById(idProducto);
        ListadoDePreciosDto retorno = new ListadoDePreciosDto();
        retorno.setUserLocation(userLocation);
        List<PrecioRegular> preciosEncontrados = searchDba.getPrecios(productoSeleccionado);
        List<Oferta> ofertasEncontradas = searchDba.getOfertas(productoSeleccionado);
        
        if (preciosEncontrados!=null){
            for (PrecioRegular precio:preciosEncontrados){
                PrecioDto pDto = new PrecioDto(precio);
                //GmapsDto mapa = gmaps.mapsData(userLocation, pDto.getOferente().getDireccion());
                //pDto.setGmap(mapa);
                retorno.addPrecio(pDto);            
            }
        }
        if (ofertasEncontradas!=null){
            for (Oferta oferta:ofertasEncontradas){
                PrecioDto pDto = new PrecioDto(oferta);
                //GmapsDto mapa = gmaps.mapsData(userLocation, pDto.getOferente().getDireccion());
                //pDto.setGmap(mapa);
                retorno.addPrecio(pDto);          
            }
        }
        return retorno;
    }
    /*
        public static ListadoDePreciosDto buscarPreciosParaOferente(ProductDto p, UserDto user){
        int idProducto= p.getId();
        String emailUser= user.getEmail();
        ProductoYServicio productoSeleccionado = productosDba.getProductoById(idProducto);
        Usuario usuarioseleccionado = userdba.getUsuarioByEmail(emailUser);
        ListadoDePreciosDto retorno = new ListadoDePreciosDto();
        List<PrecioRegular> preciosEncontrados = searchDba.getPreciosForOfferer(usuarioseleccionado);
        List<Oferta> ofertasEncontradas = searchDba.getOfertas(productoSeleccionado);
        
        if (preciosEncontrados!=null){
            for (PrecioRegular precio:preciosEncontrados){
                PrecioDto pDto = new PrecioDto(precio);
                retorno.addPrecio(pDto);            
            }
        }
        if (ofertasEncontradas!=null){
            for (Oferta oferta:ofertasEncontradas){
                PrecioDto pDto = new PrecioDto(oferta);
                retorno.addPrecio(pDto);          
            }
        }
        return retorno;
    }
*/
    public static ListadoDePreciosDto getOfrecidos(UserDto o){
        ListadoDePreciosDto retorno = new ListadoDePreciosDto();
        Oferente oferente = (Oferente) UsersMapper.userDtoToUsuario(o);
        List<PrecioRegular> preciosPublicados = searchDba.getPreciosForOfferer(oferente);
        if (preciosPublicados!=null && !preciosPublicados.isEmpty()){
            for (PrecioRegular precio : preciosPublicados){
                retorno.addPrecio(new PrecioDto(precio));
            }
        }
        List<Oferta> ofertasPublicadas = searchDba.getOfertasByOferente(oferente);
        if (ofertasPublicadas!=null && !ofertasPublicadas.isEmpty()){
            for (Oferta oferta : ofertasPublicadas){
                retorno.addPrecio(new PrecioDto(oferta));
            }
        }
        
        return retorno;
    }
    
    private static ListadoDePreciosDto getPreciosPorOferenteYProducto(UserDto oferenteDto, ProductDto productoDto){
        ListadoDePreciosDto retorno = new ListadoDePreciosDto();
        Oferente oferente = (Oferente) UsersMapper.userDtoToUsuario(oferenteDto);
        ProductoYServicio producto = ProductMapper.dtoTOproduct(productoDto);
        PrecioRegular precioPublicado = new PrecioRegular();
        precioPublicado.setOferente(oferente);
        precioPublicado.setProductoYServicio(producto);
        precioPublicado = preciosDba.getByConstraint(precioPublicado);
        if (precioPublicado!=null)
            retorno.addPrecio(new PrecioDto(precioPublicado));
        // Ya tenemos si tiene un precioRegular, ahora hay que meter las ofertas tambien
        List<Oferta> ofertasPublicadas = searchDba.ofertasOferenteProducto(oferente, producto);
        if (ofertasPublicadas!=null){
            for (Oferta oferta : ofertasPublicadas){
                retorno.addPrecio(new PrecioDto(oferta));
            }
        }
        
        return retorno;
    }

}
