package com.jsr.api.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import com.jsr.api.model.Document;

@Entity
@SqlResultSetMapping(
    name="documentmap",
    entities={
        @EntityResult(
           entityClass=Document.class,
              fields={
                  @FieldResult(name="ruc_informante",          column="RUC_INFORMANTE"),
                  @FieldResult(name="razon_informante",        column="RAZON_INFORMANTE"),
                  @FieldResult(name="ruc",                     column="RUC"),
                  @FieldResult(name="tipo_doc_usu",            column="tipo_doc_usu"),
                  @FieldResult(name="razon_social",            column="razon_social"),
                  @FieldResult(name="tipo_registro",           column="TIPO_REGISTRO"),
                  @FieldResult(name="tipo_comprobante",        column="TIPO_COMPROBANTE"),
                  @FieldResult(name="estado_comprobante",      column="ESTADO_COMPROBANTE"),
                  @FieldResult(name="motivo_anulacion",        column="MOTIVO_ANULACIÓN"),
                  @FieldResult(name="fecha_pago",              column="fecha_pago"),
                  @FieldResult(name="tipo_pago",               column="tipo_pago"),
                  @FieldResult(name="moneda_extranjera",       column="MONEDA_EXTRANJERA"),
                  @FieldResult(name="timbrado",                column="TIMBRADO"),
                  @FieldResult(name="numFactura",              column="numFactura"),
                  @FieldResult(name="monto_gravado_10",        column="MONTO_GRAVADO_10"),
                  @FieldResult(name="iva_10",                  column="IVA10"),
                  @FieldResult(name="monto_gravado_5",         column="MONTO_GRAVADO_5"),
                  @FieldResult(name="iva_5",                   column="IVA5"),
                  @FieldResult(name="exento",                  column="EXENTO"),
                  @FieldResult(name="total_comprobante",       column="total_comprobante"),
                  @FieldResult(name="imputa_ire",              column="IMPUTA_IRE"),
                  @FieldResult(name="imputa_iva",              column="IMPUTA_IVA"),
                  @FieldResult(name="comprobante_asociado",    column="comprobante_asociado"),
                  @FieldResult(name="comprobante_relacionado", column="comprobante_relacionado"),
                  @FieldResult(name="fecha_marangatu",         column="fecha_marangatu"),
                  @FieldResult(name="origen_informacion",      column="origen_informacion")   
              }         
        )
    }
) 
@NamedNativeQuery(
    name="DocumentEntity.GenerateDocument", 
    query="SELECT "+
            "(SELECT SUBSTRING_INDEX(e.ruc_emp,'-',1)  FROM empresa e LIMIT 1) RUC_INFORMANTE "+
            ",(SELECT e.nombre_emp FROM empresa e LIMIT 1) RAZON_INFORMANTE "+
            ",CASE u.tipo_doc_usu WHEN 'RUC' THEN SUBSTRING_INDEX(u.num_doc_usu,'-',1) ELSE u.num_doc_usu END RUC " + 
            ",u.tipo_doc_usu "+
            ",CONCAT(u.nombre_usu, ' ', u.apellido_usu) razon_social "+
            ",'VENTAS' TIPO_REGISTRO "+
            ",'FACTURA' TIPO_COMPROBANTE"+ 
            ",'ACEPTADO' ESTADO_COMPROBANTE "+
            ",CASE c.estado "+
            "WHEN 'ELIMINADO'  "+
            "THEN 'IMPRESION INCORRECTA DEL COMPROBANTE' "+
            "ELSE '' "+
            "END MOTIVO_ANULACIÓN "+
            ",p.fecha_pago "+
            ",p.tipo_pago  "+
            ",'NO' MONEDA_EXTRANJERA "+
            ",'12345678' TIMBRADO "+
            ",p.numFactura "+
            ",(c.impTotal - c.IVA10 - c.ERSSAN) MONTO_GRAVADO_10 "+
            ",c.IVA10  "+
            ",0 MONTO_GRAVADO_5 "+
            ",0 IVA5 "+
            ",0 EXENTO "+
            ",(c.impTotal - c.IVA10) total_comprobante "+
            ",'NO' IMPUTA_IRE "+
            ",'SI' IMPUTA_IVA "+
            ",'' comprobante_asociado "+
            ",'' comprobante_relacionado "+
            ",'' fecha_marangatu "+
            ",'' origen_informacion "+
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
            "AND p.fecha_pago BETWEEN '2021-12-01' AND '2021-12-31';", 
    resultSetMapping="documentmap")

public class DocumentEntity implements Serializable{ 

    private static final long serialVersionUID = -4860426805452667396L;

    public DocumentEntity()
    {

    }
}
