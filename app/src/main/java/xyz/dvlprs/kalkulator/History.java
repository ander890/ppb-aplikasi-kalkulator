package xyz.dvlprs.kalkulator;

public class History {
    private int angka1, angka2, hasil;
    private String operator;

    public History(int angka1, int angka2, int hasil, String operator) {
        this.angka1 = angka1;
        this.angka2 = angka2;
        this.hasil = hasil;
        this.operator = operator;
    }

    public int getAngka1() {
        return angka1;
    }

    public void setAngka1(int angka1) {
        this.angka1 = angka1;
    }

    public int getAngka2() {
        return angka2;
    }

    public void setAngka2(int angka2) {
        this.angka2 = angka2;
    }

    public int getHasil() {
        return hasil;
    }

    public void setHasil(int hasil) {
        this.hasil = hasil;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
