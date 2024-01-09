package org.example.model;

public final class Software extends Product implements Printable{

    private String version;

    public Software() {
        super();
        version = "";
    }

    public Software(String code, String description, double price, String version) {
        super(code, description, price);
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Software{" +
                "version='" + version + '\'' +
                '}' + super.toString();
    }

    @Override
    public void print() {
        System.out.println("Software: " + getDescription() + ", v" + getVersion());
    }
}
