package Hibernate.Entity;
// Generated Dec 9, 2017 11:47:12 AM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Venta generated by hbm2java
 */
@Entity
@Table(name="venta"
    ,catalog="customers"
)
public class Venta  implements java.io.Serializable {


     private VentaId id;
     private Integer cantidad;

    public Venta() {
    }

	
    public Venta(VentaId id) {
        this.id = id;
    }
    public Venta(VentaId id, Integer cantidad) {
       this.id = id;
       this.cantidad = cantidad;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idFactura", column=@Column(name="id_factura", nullable=false) ), 
        @AttributeOverride(name="idCliente", column=@Column(name="id_cliente", nullable=false) ) } )
    public VentaId getId() {
        return this.id;
    }
    
    public void setId(VentaId id) {
        this.id = id;
    }

    
    @Column(name="cantidad")
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }




}


