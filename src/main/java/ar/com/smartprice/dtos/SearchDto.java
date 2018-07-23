/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.dtos;

/**
 *
 * @author Andres
 */
public class SearchDto {
    private String searchWord;
    private String userLocation;
    private CategoryDto categoria;
    private UserDto oferente;
    private boolean soloDelOferente;

    public SearchDto() {
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public CategoryDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoryDto categoria) {
        this.categoria = categoria;
    }

    public UserDto getOferente() {
        return oferente;
    }

    public void setOferente(UserDto oferente) {
        this.oferente = oferente;
    }

    public boolean isSoloDelOferente() {
        return soloDelOferente;
    }

    public void setSoloDelOferente(boolean soloDelOferente) {
        this.soloDelOferente = soloDelOferente;
    }
    
    
}
