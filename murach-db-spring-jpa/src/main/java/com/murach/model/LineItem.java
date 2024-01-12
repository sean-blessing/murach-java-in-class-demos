package com.murach.model;

public class LineItem {
    private int lineItemId;
    private int invoiceId;
    private String productCode;
    private int quantity;

    public LineItem(int lineItemId, int invoiceId, String productCode, int quantity) {
        this.lineItemId = lineItemId;
        this.invoiceId = invoiceId;
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public int getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(int lineItemId) {
        this.lineItemId = lineItemId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
