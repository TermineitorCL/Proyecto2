/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Matia
 */
public class UnidadMedida {
    private String producto;
    private String unidad_medida;
    private Integer producion_kl;
    private int año;
    private int mes;
    private int dia;

    public UnidadMedida() {
    }

    public UnidadMedida(String producto, String unidad_medida, Integer producion_kl, int año, int mes, int dia) {
        this.producto = producto;
        this.unidad_medida = unidad_medida;
        this.producion_kl = producion_kl;
        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public void setProducion_kl(Integer producion_kl) {
        this.producion_kl = producion_kl;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getProducto() {
        return producto;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public Integer getProducion_kl() {
        return producion_kl;
    }

    public int getAño() {
        return año;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }
    
    public boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, añoCorrecto;
        añoCorrecto = año > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        switch (mes) {
            case 2:
                if (esBisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && añoCorrecto;
    }
    
    private boolean esBisiesto() {
        return (año % 4 == 0 && año % 100 != 0 || año % 400 == 0);
    }
}


