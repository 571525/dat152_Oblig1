package model;

public class Product {

    private int pno;
    private String name;
    private double priceInEuros;

    public Product(int pno, String name, double priceInEuros) {
        this.pno = pno;
        this.name = name;
        this.priceInEuros = priceInEuros;
    }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceInEuros() {
        return priceInEuros;
    }

    public void setPriceInEuros(double priceInEuros) {
        this.priceInEuros = priceInEuros;
    }
}
