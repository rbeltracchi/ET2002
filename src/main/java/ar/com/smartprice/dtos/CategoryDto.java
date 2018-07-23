/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.dtos;

import java.util.List;

/**
 *
 * @author Andres
 */
public class CategoryDto {
    
    private int id=0;
    private String name;
    //TODO revisar esto?
    private CategoryDto fatherCategory=null;
    private List<CategoryDto> categories; 

    public CategoryDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDto getCategoriaPadre() {
        return fatherCategory;
    }

    public void setCategoriaPadre(CategoryDto fatherCategory) {
        this.fatherCategory = fatherCategory;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }
    
    
    @Override
    public String toString() {
        return "CategoryDto{" + "id=" + id + ", name=" + name + ", fatherCategory=" + fatherCategory + '}';
    }
    
    
    
}
