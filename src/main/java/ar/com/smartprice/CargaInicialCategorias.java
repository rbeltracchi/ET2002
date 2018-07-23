/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice;

import ar.com.smartprice.dtos.AdministratorDto;
import ar.com.smartprice.dtos.CategoryDto;
import ar.com.smartprice.dtos.CredentialsDto;
import ar.com.smartprice.models.services.AdministratorService;
import ar.com.smartprice.models.services.CategoriesService;

/**
 *
 * @author Usuario
 */
public class CargaInicialCategorias {

    public static void main(String[] args) {

        if (CategoriesService.getArbol() != null) {
            System.out.println("Existen categorias en el sistema");
            return;
        }
        AdministratorService adminService = new AdministratorService();

        CredentialsDto credentials = new CredentialsDto("admin@smartprice.com.ar", "admin");
        AdministratorDto admin = adminService.logIn(credentials);
        cargarCategorias(admin);
        System.out.println("Se termino de cargar las categorias al sistema");
    }

    public static void cargarCategorias(String padre, String[] hijos, AdministratorDto admin) {
        CategoryDto catPadre = new CategoryDto();
        catPadre.setName(padre);

        for (int i = 0; i < hijos.length; i++) {
            CategoryDto hijo = new CategoryDto();
            hijo.setName(hijos[i]);
            hijo.setCategoriaPadre(catPadre);
            CategoriesService.create(hijo, admin);
        }
    }

    public static void cargarCategorias(AdministratorDto admin) {

        String[] hijosMercado = {
            "Carnes",
            "Frutas y Verduras",
            "Panadería y Dulces",
            "Lacteos y Huevos",
            "Almacen",
            "Conservas y comida preparada",
            "Bebidas y jugos",
            "Snacks",
            "Cuidado personal",
            "Fiambres"
        };
        cargarCategorias("Mercado", hijosMercado, admin);

        String[] hijosTecnologia = {
            "Celulares y accesorios",
            "Computacion",
            "Camaras y accesorios",
            "Audio y Video",
            "Consolas"
        };
        cargarCategorias("Tecnologia", hijosTecnologia, admin);

        String[] hijosAccesoriosVehiculos = {
            "Neumaticos",
            "Repuestos Automotor",
            "Audio vehiculos",
            "Acc Motos",
            "Acc Auto",
            "Tunning"
        };
        cargarCategorias("Acc Vehiculos", hijosAccesoriosVehiculos, admin);

        String[] hijosJuguetesYBebes = {
            "Bebe",
            "Disfraces y cotillon",
            "Juguetes",
            "Juegos",
            "Vehiculos para niños",
            "Muñecos"
        };
        cargarCategorias("Juguetes y Bebes", hijosJuguetesYBebes, admin);

        String[] hijosHogarYElect = {
            "Electrodomesticos",
            "Climatizacion",
            "Jardineria y exteriores",
            "Bazar",
            "Decoracion",
            "Living",
            "Dormitorio"
        };
        cargarCategorias("Hogar y Electrodomesticos", hijosHogarYElect, admin);

        String[] hijosHerramientas = {
            "Herramientas",
            "Electricidad",
            "Construccion",
            "Industrias y Oficinas"
        };
        cargarCategorias("Herramientas y Oficinas", hijosHerramientas, admin);

        String[] hijosLibreria = {
            "Utiles escolares",
            "Novelas y Cuentos",
            "Comics e Historietas",
            "Revistas",
            "Manuales",
            "Ciencias"
        };
        cargarCategorias("Libreria", hijosLibreria, admin);

        String[] moda = {
            "Mujer",
            "Hombre",
            "Niños"
        };
        cargarCategorias("Moda", moda, admin);

        String[] hijosServicios = {
            "Alquileres",
            "Cafeteria",
            "Heladeria",
            "Delivery",
            "Plomero-Gasista",
            "Electricista",
            "Serv. Tecnico PC"
        };
        cargarCategorias("Servicios", hijosServicios, admin);

    }
}
