package com.jsr.api.model;

public class Document {
    private String ruc_informante;
    private String razon_informante;
    private String ruc;
    private String tipo_doc_usu;
    private String razon_social;
    private String tipo_registro;
    private String tipo_comprobante;
    private String estado_comprobante;
    private String motivo_anulacion;
    private String fecha_pago;
    private String tipo_pago;
    private String moneda_extranjera;
    private String timbrado;
    private String numFactura;
    private String monto_gravado_10;
    private String iva_10;
    private String monto_gravado_5;
    private String iva_5;
    private String exento;
    private String total_comprobante;
    private String imputa_ire;
    private String imputa_iva;
    private String comprobante_asociado;
    private String comprobante_relacionado;
    private String fecha_marangatu;
    private String origen_informacion;

    public Document(){

    }
    
    public Document(String ruc_informante, String razon_informante, String ruc, String tipo_doc_usu,
    String razon_social, String tipo_registro, String tipo_comprobante, String estado_comprobante,
    String motivo_anulacion, String fecha_pago, String tipo_pago, String moneda_extranjera,
    String timbrado, String numFactura, String monto_gravado_10, String iva_10, 
    String monto_gravado_5, String iva_5, String exento, String total_comprobante, String imputa_ire,
    String imputa_iva, String comprobante_asociado, String comprobante_relacionado, String fecha_marangatu,
    String origen_informacion){
        this.ruc_informante = ruc_informante;
        this.razon_informante = razon_informante;
        this.ruc = ruc;
        this.tipo_doc_usu = tipo_doc_usu;
        this.razon_social = razon_social;
        this.tipo_registro = tipo_registro;
        this.tipo_comprobante = tipo_comprobante;
        this.estado_comprobante = estado_comprobante;
        this.motivo_anulacion = fecha_pago;
        this.tipo_pago =  tipo_pago;
        this.moneda_extranjera = moneda_extranjera;
        this.timbrado = timbrado;
        this.numFactura = numFactura;
        this.monto_gravado_10 = monto_gravado_10;
        this.iva_10 = iva_10;
        this.monto_gravado_5 = monto_gravado_5;
        this.exento = exento;
        this.total_comprobante = total_comprobante;
        this.imputa_ire = imputa_ire;
        this.imputa_iva = imputa_iva;
        this.comprobante_asociado = comprobante_asociado;
        this.comprobante_relacionado = comprobante_relacionado;
        this.fecha_marangatu = fecha_marangatu;
        this.origen_informacion = origen_informacion; 
    }

    public String getRuc_informante(){
        return ruc_informante;
    }

    public void setRuc_informante(String ruc_informante){
        this.ruc_informante = ruc_informante;
    }

    public String getRazon_informante(){
        return razon_informante;
    }
    public void setRazon_informante(String razon_informante){
        this.razon_informante = razon_informante;
    }

    public String getRuc() {
        return this.ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTipo_doc_usu() {
        return this.tipo_doc_usu;
    }

    public void setTipo_doc_usu(String tipo_doc_usu) {
        this.tipo_doc_usu = tipo_doc_usu;
    }

    public String getRazon_social() {
        return this.razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTipo_registro() {
        return this.tipo_registro;
    }

    public void setTipo_registro(String tipo_registro) {
        this.tipo_registro = tipo_registro;
    }

    public String getTipo_comprobante() {
        return this.tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public String getEstado_comprobante() {
        return this.estado_comprobante;
    }

    public void setEstado_comprobante(String estado_comprobante) {
        this.estado_comprobante = estado_comprobante;
    }

    public String getMotivo_anulacion() {
        return this.motivo_anulacion;
    }

    public void setMotivo_anulacion(String motivo_anulacion) {
        this.motivo_anulacion = motivo_anulacion;
    }

    public String getFecha_pago() {
        return this.fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getTipo_pago() {
        return this.tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getMoneda_extranjera() {
        return this.moneda_extranjera;
    }

    public void setMoneda_extranjera(String moneda_extranjera) {
        this.moneda_extranjera = moneda_extranjera;
    }

    public String getTimbrado() {
        return this.timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    public String getNumFactura() {
        return this.numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public String getMonto_gravado_10() {
        return this.monto_gravado_10;
    }

    public void setMonto_gravado_10(String monto_gravado_10) {
        this.monto_gravado_10 = monto_gravado_10;
    }

    public String getIva_10() {
        return this.iva_10;
    }

    public void setIva_10(String iva_10) {
        this.iva_10 = iva_10;
    }

    public String getMonto_gravado_5() {
        return this.monto_gravado_5;
    }

    public void setMonto_gravado_5(String monto_gravado_5) {
        this.monto_gravado_5 = monto_gravado_5;
    }

    public String getIva_5() {
        return this.iva_5;
    }

    public void setIva_5(String iva_5) {
        this.iva_5 = iva_5;
    }

    public String getExento() {
        return this.exento;
    }

    public void setExento(String exento) {
        this.exento = exento;
    }

    public String getTotal_comprobante() {
        return this.total_comprobante;
    }

    public void setTotal_comprobante(String total_comprobante) {
        this.total_comprobante = total_comprobante;
    }

    public String getImputa_ire() {
        return this.imputa_ire;
    }

    public void setImputa_ire(String imputa_ire) {
        this.imputa_ire = imputa_ire;
    }

    public String getImputa_iva() {
        return this.imputa_iva;
    }

    public void setImputa_iva(String imputa_iva) {
        this.imputa_iva = imputa_iva;
    }

    public String getComprobante_asociado() {
        return this.comprobante_asociado;
    }

    public void setComprobante_asociado(String comprobante_asociado) {
        this.comprobante_asociado = comprobante_asociado;
    }

    public String getComprobante_relacionado() {
        return this.comprobante_relacionado;
    }

    public void setComprobante_relacionado(String comprobante_relacionado) {
        this.comprobante_relacionado = comprobante_relacionado;
    }

    public String getFecha_marangatu() {
        return this.fecha_marangatu;
    }

    public void setFecha_marangatu(String fecha_marangatu) {
        this.fecha_marangatu = fecha_marangatu;
    }

    public String getOrigen_informacion() {
        return this.origen_informacion;
    }

    public void setOrigen_informacion(String origen_informacion) {
        this.origen_informacion = origen_informacion;
    }
}
