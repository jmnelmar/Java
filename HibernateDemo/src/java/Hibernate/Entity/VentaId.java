package Hibernate.Entity;
// Generated Dec 9, 2017 11:47:12 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VentaId generated by hbm2java
 */
@Embeddable
public class VentaId  implements java.io.Serializable {


     private int idFactura;
     private int idCliente;

    public VentaId() {
    }

    public VentaId(int idFactura, int idCliente) {
       this.idFactura = idFactura;
       this.idCliente = idCliente;
    }
   


    @Column(name="id_factura", nullable=false)
    public int getIdFactura() {
        return this.idFactura;
    }
    
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }


    @Column(name="id_cliente", nullable=false)
    public int getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VentaId) ) return false;
		 VentaId castOther = ( VentaId ) other; 
         
		 return (this.getIdFactura()==castOther.getIdFactura())
 && (this.getIdCliente()==castOther.getIdCliente());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdFactura();
         result = 37 * result + this.getIdCliente();
         return result;
   }   


}


