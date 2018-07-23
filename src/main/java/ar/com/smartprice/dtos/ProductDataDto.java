/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.smartprice.dtos;

import java.util.List;

/**
 *
 * @author Lucho
 */
public class ProductDataDto {
    //marca
    private Long brandId;
    private String brandName;
    private String brandLogo;
    
    //producto
    //de aca sacamos el id de la marca
    //id de la categoria
    private String productName;
    private String productDescription;
    private String productLogo;
     private Object[] header;
    //precio regular
    private long productId;
    private double productPrice;
    
    //Categoria
    private Long categoryId;
    private String categoryName;
    //Oferta
    private int offerId;
    private String oferStartDate;
    private String offerndDate;
    private double offerPrice;
    private int offerMinimunAmount;
    private String offerescription;       
            
            
    
    private List<ProductDataDto> listPrductDataDto;
    
    public ProductDataDto() {
    }
    
    public List<ProductDataDto> getListProducts() {
        return listPrductDataDto;
    }

    public void setListHdp(List<ProductDataDto> listHdp) {
        this.listPrductDataDto = listHdp;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProuctPrice() {
        return productPrice;
    }

    public void setProuctPrice(double prouctPrice) {
        this.productPrice = prouctPrice;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getProductLogo() {
        return productLogo;
    }

    public void setProductLogo(String productLogo) {
        this.productLogo = productLogo;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.categoryName = CategoryName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "ProductDataDto{" + "brandId=" + brandId + ", brandName=" + brandName + ", brandLogo=" + brandLogo + ", productName=" + productName + ", productDescription=" + productDescription + ", productLogo=" + productLogo + ", header=" + header + ", productId=" + productId + ", productPrice=" + productPrice + ", categoryId=" + categoryId + ", categoryName=" + categoryName + ", offerId=" + offerId + ", oferStartDate=" + oferStartDate + ", offerndDate=" + offerndDate + ", offerPrice=" + offerPrice + ", offerMinimunAmount=" + offerMinimunAmount + ", offerescription=" + offerescription + ", listPrductDataDto=" + listPrductDataDto + '}';
    }

   

    

    public Object[] getHeader() {
        
        return this.header;
    }

    public void setHeader(Object[] result) {
       this.header = result;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getOferStartDate() {
        return oferStartDate;
    }

    public void setOferStartDate(String oferStartDate) {
        this.oferStartDate = oferStartDate;
    }

    public String getOfferndDate() {
        return offerndDate;
    }

    public void setOfferndDate(String offerndDate) {
        this.offerndDate = offerndDate;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public int getOfferMinimunAmount() {
        return offerMinimunAmount;
    }

    public void setOfferMinimunAmount(int offerMinimunAmount) {
        this.offerMinimunAmount = offerMinimunAmount;
    }

    public String getOfferescription() {
        return offerescription;
    }

    public void setOfferescription(String offerescription) {
        this.offerescription = offerescription;
    }
    
    
}
