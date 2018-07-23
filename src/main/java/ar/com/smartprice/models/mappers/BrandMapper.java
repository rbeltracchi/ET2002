package ar.com.smartprice.models.mappers;

import ar.com.smartprice.dtos.BrandDto;
import ar.com.smartprice.models.entities.Marca;

/**
 * Clase mapeadora de Marca
 * Marca a BrandDto
 * BrandDto a Marca
 * @author Andress
 */
public class BrandMapper {

    /**
     * Mapea los datos de un Marca a BrandDto
     *
     * @param marca Marca
     * @return BrandDto
     */
    public static BrandDto MarcaToBrandDto(Marca marca) {
        BrandDto brandDto = new BrandDto();
        brandDto.setBrandId(marca.getIdmarca());
        brandDto.setLogo(marca.getLogotipo());
        brandDto.setBrandName(marca.getNombre());
        return brandDto;
    }

    /**
     * Mapea los datos de un BrandDto a Marca
     *
     * @param brand BrandDto
     * @return Marca
     */
    public static Marca BrandDtoToMarca(BrandDto brand) {
        Marca marca = new Marca();
        marca.setIdMarca(brand.getBrandId());
        marca.setLogotipo(brand.getLogo());
        marca.setNombre(brand.getBrandName());
        return marca;
    }
}
