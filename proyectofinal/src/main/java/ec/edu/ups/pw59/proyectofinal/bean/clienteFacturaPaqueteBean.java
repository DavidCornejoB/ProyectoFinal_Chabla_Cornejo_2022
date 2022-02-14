package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.FacturaCabeceraPaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.business.FacturaDetallePaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.PaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.business.ServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraPaquete;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetallePaquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Named
@RequestScoped
public class clienteFacturaPaqueteBean {
	
	@Inject
	private FacturaCabeceraPaqueteONLocal facturaPaqueteON;
	
	@Inject
	private FacturaDetallePaqueteONLocal detallePaqueteON;
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	@Inject
	private ServicioONLocal servicioON;
	
	@Inject
	private PaqueteONLocal paqueteON;
	
	private FacturaCabeceraPaquete facturaPaquete = new FacturaCabeceraPaquete();
	
	private FacturaDetallePaquete detallePaquete = new FacturaDetallePaquete();
	
	private List<FacturaCabeceraPaquete> facturas = new ArrayList<>();
	
	private List<FacturaCabeceraPaquete> facturasCliente = new ArrayList<>();

	private List<FacturaDetallePaquete> detalles = new ArrayList<>();

	private List<FacturaDetallePaquete> detallesCliente = new ArrayList<>();
	
	private Servicio servicio = new Servicio();
	
	private Habitacion habitacion = new Habitacion();
	
	private Paquete paquete = new Paquete();
	
	private Persona persona = new Persona();
	
	double total = 0;
	
	int idFactura;
	
	private int codigo;
	
	public clienteFacturaPaqueteBean() {
		
	}
	
	@PostConstruct
	public void init() {
		this.cargar();
	}

	public FacturaCabeceraPaqueteONLocal getFacturaPaqueteON() {
		return facturaPaqueteON;
	}

	public void setFacturaPaqueteON(FacturaCabeceraPaqueteONLocal facturaPaqueteON) {
		this.facturaPaqueteON = facturaPaqueteON;
	}

	public FacturaDetallePaqueteONLocal getDetallePaqueteON() {
		return detallePaqueteON;
	}

	public void setDetallePaqueteON(FacturaDetallePaqueteONLocal detallePaqueteON) {
		this.detallePaqueteON = detallePaqueteON;
	}

	public HabitacionONLocal getHabitacionON() {
		return habitacionON;
	}

	public void setHabitacionON(HabitacionONLocal habitacionON) {
		this.habitacionON = habitacionON;
	}

	public ServicioONLocal getServicioON() {
		return servicioON;
	}

	public void setServicioON(ServicioONLocal servicioON) {
		this.servicioON = servicioON;
	}

	public FacturaCabeceraPaquete getFacturaPaquete() {
		return facturaPaquete;
	}

	public void setFacturaPaquete(FacturaCabeceraPaquete facturaPaquete) {
		this.facturaPaquete = facturaPaquete;
	}

	public FacturaDetallePaquete getDetallePaquete() {
		return detallePaquete;
	}

	public void setDetallePaquete(FacturaDetallePaquete detallePaquete) {
		this.detallePaquete = detallePaquete;
	}

	public List<FacturaCabeceraPaquete> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaCabeceraPaquete> facturas) {
		this.facturas = facturas;
	}

	public List<FacturaCabeceraPaquete> getFacturasCliente() {
		return facturasCliente;
	}

	public void setFacturasCliente(List<FacturaCabeceraPaquete> facturasCliente) {
		this.facturasCliente = facturasCliente;
	}

	public List<FacturaDetallePaquete> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<FacturaDetallePaquete> detalles) {
		this.detalles = detalles;
	}

	public List<FacturaDetallePaquete> getDetallesCliente() {
		return detallesCliente;
	}

	public void setDetallesCliente(List<FacturaDetallePaquete> detallesCliente) {
		this.detallesCliente = detallesCliente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public PaqueteONLocal getPaqueteON() {
		return paqueteON;
	}

	public void setPaqueteON(PaqueteONLocal paqueteON) {
		this.paqueteON = paqueteON;
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String generarFactura(int codigo) {//GENERAR FACTURA
		
		this.persona = clienteLoginBean.logueo.getPersona();
		this.codigo = codigo;
		
		try {
			this.paquete = paqueteON.read(this.codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//CABECERA
		this.facturas = facturaPaqueteON.getFacturas();
		this.facturaPaquete.setFecha("15-02-2022");
		this.facturaPaquete.setPersona(this.persona);
		
		try {
			facturaPaqueteON.insert(this.facturaPaquete);
			System.out.println("FACTURA CABECERA AGREGADA");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR AL INSERTAR FACTURA CABECERA");
			e.printStackTrace();
		}
		
		//DETALLE
		this.detalles = detallePaqueteON.getFacturas();
		this.detallePaquete.setDescuento(10);
		
		this.total = this.paquete.getPrecio();
		this.detallePaquete.setTotal(this.total - 10);
		this.detallePaquete.setIva((((this.total - 10) * 12) / 100) + (this.total - 10));
		
		this.detallePaquete.setFacturaCabeceraPaquete(this.facturaPaquete);
		this.detallePaquete.setPaquete(this.paquete);
		
		try {
			detallePaqueteON.insert(this.detallePaquete);
			System.out.println("DETALLE AGREGADO");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR AL INSERTAR DETALLE");
			e.printStackTrace();
		}
		
		return "cliente-factura-paquete?faces-redirect=true";
			
		
	}//GENERAR FACTURA
	
	public void cargar() {//CARGAR FACTURA
		this.facturas = facturaPaqueteON.getFacturas();
		this.detalles = detallePaqueteON.getFacturas();
		
		int numero = this.facturas.size();
		
		if(numero < 1) {
			
			System.out.println("NO HAY FACTURAS QUE MOSTRAR");
			
		} else {
			
			this.facturasCliente.add(this.facturas.get(numero - 1));
			this.idFactura = this.facturas.get(numero - 1).getNumero();
			
			for(int i = 0; i < this.detalles.size(); i++) {
				if(this.detalles.get(i).getFacturaCabeceraPaquete().getNumero() == this.idFactura) {
					this.detallesCliente.add(this.detalles.get(i));
				}
			}
			
		}
		
	}//CARGAR FACTURA


}
