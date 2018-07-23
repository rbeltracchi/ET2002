/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.models.services;

import ar.com.smartprice.dtos.BrandDto;
import ar.com.smartprice.models.entities.Marca;
import ar.com.smartprice.models.mappers.BrandMapper;
import ar.com.smartprice.models.persistence.Brand_DBAdmin;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Andres
 */
public class BrandsService {

    private static Brand_DBAdmin brandDB = new Brand_DBAdmin();

    public static boolean create(BrandDto brand) {
       
        Marca marca = BrandMapper.BrandDtoToMarca(brand);

        return brandDB.create(marca);
    }

    public static BrandDto getMarca(String marca) {
        BrandDto brand;

        brand = BrandMapper.MarcaToBrandDto(brandDB.getMarca(marca));

        if (brand.getBrandName() == null) {
            System.out.println("Error al recuperar la marca");
            return null;
        }

        return brand;
    }

    public static BrandDto getMarcaPorId(int id) {
        BrandDto brand = BrandMapper.MarcaToBrandDto(brandDB.getMarcaPorId(id));

        if (brand.getBrandName() == null) {
            System.out.println("Error al recuperar la marca por id");
            return null;
        }

        return brand;
    }

    public static boolean actualizarMarca(BrandDto brand) {

        boolean success = brandDB.actualizarMarca(BrandMapper.BrandDtoToMarca(brand));

        return success;
    }

    public static boolean borrarMarca(BrandDto brand) {

        boolean success = brandDB.borrarMarca(BrandMapper.BrandDtoToMarca(brand));

        return success;
    }

}
