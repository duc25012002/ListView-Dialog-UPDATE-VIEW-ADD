package eu.tutorials.dialoglistview.model;

public class PhanMem {
    private String tenPhienBan;
    private String tenBanh;
    private int anhBanh;


    public PhanMem(String tenPhienBan, String tenBanh, int anhBanh) {
        this.tenPhienBan = tenPhienBan;
        this.tenBanh = tenBanh;
        this.anhBanh = anhBanh;
    }

    public String getTenPhienBan() {
        return tenPhienBan;
    }

    public void setTenPhienBan(String tenPhienBan) {
        this.tenPhienBan = tenPhienBan;
    }

    public String getTenBanh() {
        return tenBanh;
    }

    public void setTenBanh(String tenBanh) {
        this.tenBanh = tenBanh;
    }

    public int getAnhBanh() {
        return anhBanh;
    }

    public void setAnhBanh(int anhBanh) {
        this.anhBanh = anhBanh;
    }
}
