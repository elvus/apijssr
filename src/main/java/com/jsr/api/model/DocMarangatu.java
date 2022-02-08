package com.jsr.api.model;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import org.springframework.util.StringUtils;

@Entity
@SqlResultSetMapping(
    name="marangatumap",
    classes = {
        @ConstructorResult(
            targetClass = DocMarangatu.class,
            columns = {
                @ColumnResult(name="TIPO_REGISTRO",              type=String.class),
                @ColumnResult(name="TIPO_IDENTICADOR_COMPRADOR", type=String.class),
                @ColumnResult(name="NRO_IDENT_COMPRADOR",        type=String.class),
                @ColumnResult(name="razon_social",               type=String.class),
                @ColumnResult(name="TIPO_COMPROBANTE",           type=String.class),
                @ColumnResult(name="fecha_pago",                 type=String.class),
                @ColumnResult(name="TIMBRADO",                   type=String.class),
                @ColumnResult(name="numFactura",                 type=String.class),
                @ColumnResult(name="TOTAL_10",                   type=String.class),
                @ColumnResult(name="TOTAL_5",                    type=String.class),
                @ColumnResult(name="EXENTO",                     type=String.class),
                @ColumnResult(name="total_comprobante",          type=String.class),
                @ColumnResult(name="CONDICION_VENTA",            type=String.class),
                @ColumnResult(name="MONEDA_EXTRANJERA",          type=String.class),
                @ColumnResult(name="IMPUTA_IVA",                 type=String.class),
                @ColumnResult(name="IMPUTA_IRE",                 type=String.class),
                @ColumnResult(name="IMPUTA_IRP",                 type=String.class),
                @ColumnResult(name="COMPROBANTE_ASOCIADO",       type=String.class),
                @ColumnResult(name="TIMBRADO_ASOCIADO",          type=String.class)
            }
        )
    }
) 
@NamedNativeQuery(
    name="DocMarangatu.GenerateDocument", 
    query="SELECT"+
            "'1' TIPO_REGISTRO "+
            ",CASE u.tipo_doc_usu "+
                "WHEN 'RUC' THEN "+ 
                    "'11' "+
                "ELSE "+ 
                    "'12' "+
                "END TIPO_IDENTICADOR_COMPRADOR "+
            ",CASE u.tipo_doc_usu "+
                "WHEN 'RUC' THEN "+
                    "SUBSTRING_INDEX(u.num_doc_usu,'-',1) "+
                "ELSE "+
                    "u.num_doc_usu "+
                "END NRO_IDENT_COMPRADOR "+
            ",CONCAT(u.nombre_usu, ' ', u.apellido_usu) razon_social "+
            ",'109' TIPO_COMPROBANTE "+
            ",p.fecha_pago "+
            ",? TIMBRADO "+
            ",p.numFactura "+
            ",c.impTotal TOTAL_10 "+
            ",0 TOTAL_5 "+
            ",0 EXENTO "+
            ",c.impTotal total_comprobante "+
            ",CASE p.tipo_pago "+
                "WHEN 'CRÉDITO' THEN "+ 
                "'2' "+
                "ELSE "+ 
                "'1' "+
            "END CONDICION_VENTA "+
            ",'N' MONEDA_EXTRANJERA "+
            ",'S' IMPUTA_IVA "+
            ",'N' IMPUTA_IRE "+
            ",'N' IMPUTA_IRP "+
            ",'' COMPROBANTE_ASOCIADO "+
            ",'' TIMBRADO_ASOCIADO "+
        "FROM "+
            "usuarios u, "+
            "comprobantes c, "+
            "pagos_por_comprobantes ppc, "+
            "detalle_pago dp,  "+
            "pagos p "+
        "where "+
            "u.id_usuario = c.id_usuario "+
            "AND c.id_comprobante = ppc.id_comprobante "+
            "AND ppc.id_detalle = dp.iddetalle "+
            "AND dp.id_pago = p.id_pago "+
            "AND p.fecha_pago BETWEEN ? AND ?",
    resultSetMapping="marangatumap")

public class DocMarangatu {
    @EmbeddedId Long id;
    String tipo_registro; 
    String tipo_identicador_comprador;
    String nro_ident_comprador;
    String razon_social;
    String tipo_comprobante;
    String fecha_pago;
    String timbrado;
    String numfactura;
    String total_10;
    String total_5;
    String exento;
    String total_comprobante;
    String condicion_venta;
    String moneda_extranjera;
    String imputa_iva;
    String imputa_ire;
    String imputa_irp;
    String comprobante_asociado;
    String timbrado_asociado;

    public DocMarangatu() {
    
    }

    public DocMarangatu(String tipo_registro, String tipo_identicador_comprador, String nro_ident_comprador, String razon_social, String tipo_comprobante, String fecha_pago, String timbrado, String numfactura, String total_10, String total_5, String exento, String total_comprobante, String condicion_venta, String moneda_extranjera, String imputa_iva, String imputa_ire, String imputa_irp, String comprobante_asociado, String timbrado_asociado) {
        this.tipo_registro = tipo_registro;
        this.tipo_identicador_comprador = tipo_identicador_comprador;
        this.nro_ident_comprador = nro_ident_comprador;
        this.razon_social = razon_social;
        this.tipo_comprobante = tipo_comprobante;
        this.fecha_pago = fecha_pago;
        this.timbrado = timbrado;
        this.numfactura = numfactura;
        this.total_10 = total_10;
        this.total_5 = total_5;
        this.exento = exento;
        this.total_comprobante = total_comprobante;
        this.condicion_venta = condicion_venta;
        this.moneda_extranjera = moneda_extranjera;
        this.imputa_iva = imputa_iva;
        this.imputa_ire = imputa_ire;
        this.imputa_irp = imputa_irp;
        this.comprobante_asociado = comprobante_asociado;
        this.timbrado_asociado = timbrado_asociado;
    }

    public String getTipo_registro() {
        return this.tipo_registro;
    }

    public void setTipo_registro(String tipo_registro) {
        this.tipo_registro = tipo_registro;
    }

    public String getTipo_identicador_comprador() {
        return this.tipo_identicador_comprador;
    }

    public void setTipo_identicador_comprador(String tipo_identicador_comprador) {
        this.tipo_identicador_comprador = tipo_identicador_comprador;
    }

    public String getNro_ident_comprador() {
        return this.nro_ident_comprador;
    }

    public void setNro_ident_comprador(String nro_ident_comprador) {
        this.nro_ident_comprador = nro_ident_comprador;
    }

    public String getRazon_social() {
        return StringUtils.capitalize(this.razon_social.toLowerCase()) ;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTipo_comprobante() {
        return this.tipo_comprobante;
    }

    public void setTipo_comprobante(String tipo_comprobante) {
        this.tipo_comprobante = tipo_comprobante;
    }

    public String getFecha_pago() {
        return this.fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getTimbrado() {
        return this.timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    public String getNumfactura() {
        return this.numfactura;
    }

    public void setNumfactura(String numfactura) {
        this.numfactura = numfactura;
    }

    public String getTotal_10() {
        return this.total_10;
    }

    public void setTotal_10(String total_10) {
        this.total_10 = total_10;
    }

    public String getTotal_5() {
        return this.total_5;
    }

    public void setTotal_5(String total_5) {
        this.total_5 = total_5;
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

    public String getCondicion_venta() {
        return this.condicion_venta;
    }

    public void setCondicion_venta(String condicion_venta) {
        this.condicion_venta = condicion_venta;
    }

    public String getMoneda_extranjera() {
        return this.moneda_extranjera;
    }

    public void setMoneda_extranjera(String moneda_extranjera) {
        this.moneda_extranjera = moneda_extranjera;
    }

    public String getImputa_iva() {
        return this.imputa_iva;
    }

    public void setImputa_iva(String imputa_iva) {
        this.imputa_iva = imputa_iva;
    }

    public String getImputa_ire() {
        return this.imputa_ire;
    }

    public void setImputa_ire(String imputa_ire) {
        this.imputa_ire = imputa_ire;
    }

    public String getImputa_irp() {
        return this.imputa_irp;
    }

    public void setImputa_irp(String imputa_irp) {
        this.imputa_irp = imputa_irp;
    }

    public String getComprobante_asociado() {
        return this.comprobante_asociado;
    }

    public void setComprobante_asociado(String comprobante_asociado) {
        this.comprobante_asociado = comprobante_asociado;
    }

    public String getTimbrado_asociado() {
        return this.timbrado_asociado;
    }

    public void setTimbrado_asociado(String timbrado_asociado) {
        this.timbrado_asociado = timbrado_asociado;
    }

    
}
