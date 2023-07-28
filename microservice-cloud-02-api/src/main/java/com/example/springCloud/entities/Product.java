package com.example.springCloud.entities;

import java.io.Serializable;

/**
 * @Auther:
 */
public class Product implements Serializable {

    private Long  pid;   //主鍵

    private String  productName;   //產品名稱

    // 來自那個數據庫，因為微服務架構可以一個服務對應一個數據庫，同一個信息被存儲到不同數據庫
    private String  dbSource;

    public Product() {
    }

    public Product(String productName) {
        this.productName = productName;
    }

    public Product(Long pid, String productName, String dbSource) {
        this.pid = pid;
        this.productName = productName;
        this.dbSource = dbSource;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}
