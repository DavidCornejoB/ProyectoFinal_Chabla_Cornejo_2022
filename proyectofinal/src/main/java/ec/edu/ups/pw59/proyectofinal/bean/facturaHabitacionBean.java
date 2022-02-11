package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.FacturaCabeceraHabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.FacturaDetalleHabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraHabitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleHabitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;

@Named
@RequestScoped
public class facturaHabitacionBean {
	
	@Inject
	private FacturaCabeceraHabitacionONLocal facturaHabitacionON;
	
	@Inject
	private FacturaDetalleHabitacionONLocal detalleHabitacionON;
	
	private FacturaCabeceraHabitacion facturaHabitacion = new FacturaCabeceraHabitacion();
	
	private FacturaDetalleHabitacion detalleHabitacion = new FacturaDetalleHabitacion();
	
	private List<FacturaCabeceraHabitacion> facturasHabitaciones;
	
	private List<FacturaDetalleHabitacion> detallesHabitaciones;
	
	public facturaHabitacionBean() {
		
	}
	
	@PostConstruct
	public void init() {
		this.facturaHabitacion.setPersona(new Persona());
		
	}

	public FacturaCabeceraHabitacionONLocal getFacturaHabitacionON() {
		return facturaHabitacionON;
	}

	public void setFacturaHabitacionON(FacturaCabeceraHabitacionONLocal facturaHabitacionON) {
		this.facturaHabitacionON = facturaHabitacionON;
	}

	public FacturaCabeceraHabitacion getFacturaHabitacion() {
		return facturaHabitacion;
	}

	public void setFacturaHabitacion(FacturaCabeceraHabitacion facturaHabitacion) {
		this.facturaHabitacion = facturaHabitacion;
	}

	public List<FacturaCabeceraHabitacion> getFacturasHabitaciones() {
		return facturasHabitaciones;
	}

	public void setFacturasHabitaciones(List<FacturaCabeceraHabitacion> facturasHabitaciones) {
		this.facturasHabitaciones = facturasHabitaciones;
	}
	
	public FacturaDetalleHabitacionONLocal getDetalleHabitacionON() {
		return detalleHabitacionON;
	}

	public void setDetalleHabitacionON(FacturaDetalleHabitacionONLocal detalleHabitacionON) {
		this.detalleHabitacionON = detalleHabitacionON;
	}

	public FacturaDetalleHabitacion getDetalleHabitacion() {
		return detalleHabitacion;
	}

	public void setDetalleHabitacion(FacturaDetalleHabitacion detalleHabitacion) {
		this.detalleHabitacion = detalleHabitacion;
	}

	public List<FacturaDetalleHabitacion> getDetallesHabitaciones() {
		return detallesHabitaciones;
	}

	public void setDetallesHabitaciones(List<FacturaDetalleHabitacion> detallesHabitaciones) {
		this.detallesHabitaciones = detallesHabitaciones;
	}
	
	public boolean validarFactura() {
		
		List<FacturaCabeceraHabitacion> facturasHabitaciones = new ArrayList<FacturaCabeceraHabitacion>();
		
		facturasHabitaciones = facturaHabitacionON.getFacturas();
				
		for(int i = 0; i <facturasHabitaciones.size(); i++) {
			if(facturasHabitaciones.get(i).getNumero() == this.facturaHabitacion.getNumero()) {
				System.out.println("YA EXISTE UNA FACTURA CON ESA ID");
				return false;
			}
		}
		System.out.println("VALIDACION DE FACTURA CORRECTA. LISTA PARA INGRESAR");
		return true;
	}

	public void insertarFactura() {
		
		boolean validator = validarFactura();
		
		if(validator == true) {
			try {
				facturaHabitacionON.insert(this.facturaHabitacion);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 


				
	}

}
