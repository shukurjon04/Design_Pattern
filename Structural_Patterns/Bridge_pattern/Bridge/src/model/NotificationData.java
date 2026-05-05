package model;

public class NotificationData {

    private String id;
    private String mahsulot;
    private double summa;
    private String holat;

    public NotificationData(String id, String mahsulot,
                             double summa, String holat) {
        this.id       = id;
        this.mahsulot = mahsulot;
        this.summa    = summa;
        this.holat    = holat;
    }

    public String getId()       { return id; }
    public String getMahsulot() { return mahsulot; }
    public double getSumma()    { return summa; }
    public String getHolat()    { return holat; }
}