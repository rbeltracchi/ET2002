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
public class BrandDto {
    
    private byte[] brandLogo;
    private int brandId;
    private String brandName;

    public BrandDto() {
    }

    public byte[] getLogo() {
        return brandLogo;
    }

    public void setLogo(byte[] logo) {
        this.brandLogo = logo;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "BrandDto{" + "logo=" + brandLogo + ", brandId=" + brandId + ", brandName=" + brandName + '}';
    } 
    
}
