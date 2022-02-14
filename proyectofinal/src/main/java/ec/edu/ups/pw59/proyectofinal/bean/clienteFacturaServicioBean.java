package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.FacturaCabeceraServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.business.FacturaDetalleServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.business.ServicioONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraServicio;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleServicio;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Named
@RequestScoped
public class clienteFacturaServicioBean {
	
	@Inject
	private FacturaCabeceraServicioONLocal facturaServicioON;
	
	@Inject
	private FacturaDetalleServicioONLocal detalleServicioON;
	
	@Inject
	private ServicioONLocal servicioON;
	
	private FacturaCabeceraServicio facturaServicio = new FacturaCabeceraServicio();
	
	private FacturaDetalleServicio detalleServicio = new FacturaDetalleServicio();
	
	private List<FacturaCabeceraServicio> facturas = new ArrayList<>();
	
	private List<FacturaCabeceraServicio> facturasCliente = new ArrayList<>();

	private List<FacturaDetalleServicio> detalles = new ArrayList<>();

	private List<FacturaDetalleServicio> detallesCliente = new ArrayList<>();
	
	private Servicio servicio = new Servicio();
	
	private Persona persona = new Persona();
	
	double total = 0;
	
	int idFactura;
	
	private int codigo;
	
	public clienteFacturaServicioBean() {
		
	}
	
	@PostConstruct
	public void init() {
		this.cargar();
	}

	public FacturaCabeceraServicioONLocal getFacturaServicioON() {
		return facturaServicioON;
	}

	public void setFacturaServicioON(FacturaCabeceraServicioONLocal facturaServicioON) {
		this.facturaServicioON = facturaServicioON;
	}

	public FacturaDetalleServicioONLocal getDetalleServicioON() {
		return detalleServicioON;
	}

	public void setDetalleServicioON(FacturaDetalleServicioONLocal detalleServicioON) {
		this.detalleServicioON = detalleServicioON;
	}

	public ServicioONLocal getServicioON() {
		return servicioON;
	}

	public void setServicioON(ServicioONLocal servicioON) {
		this.servicioON = servicioON;
	}

	public FacturaCabeceraServicio getFacturaServicio() {
		return facturaServicio;
	}

	public void setFacturaServicio(FacturaCabeceraServicio facturaServicio) {
		this.facturaServicio = facturaServicio;
	}

	public FacturaDetalleServicio getDetalleServicio() {
		return detalleServicio;
	}

	public void setDetalleServicio(FacturaDetalleServicio detalleServicio) {
		this.detalleServicio = detalleServicio;
	}

	public List<FacturaCabeceraServicio> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaCabeceraServicio> facturas) {
		this.facturas = facturas;
	}

	public List<FacturaCabeceraServicio> getFacturasCliente() {
		return facturasCliente;
	}

	public void setFacturasCliente(List<FacturaCabeceraServicio> facturasCliente) {
		this.facturasCliente = facturasCliente;
	}

	public List<FacturaDetalleServicio> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<FacturaDetalleServicio> detalles) {
		this.detalles = detalles;
	}

	public List<FacturaDetalleServicio> getDetallesCliente() {
		return detallesCliente;
	}

	public void setDetallesCliente(List<FacturaDetalleServicio> detallesCliente) {
		this.detallesCliente = detallesCliente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String generarFactura(int codigo) {//GENERAR FACTURA
		
		System.out.println("GENERAR FACTURA");
		
		this.persona = clienteLoginBean.logueo.getPersona();
		this.codigo = codigo;
		System.out.println(this.codigo);
		
		try {
			this.servicio = servicioON.read(codigo);
			System.out.println("SE ENCONTRÓ SERVICIO: " + codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("NO SE ENCONTRÓ SERVICIO");
			e.printStackTrace();
		}
		
		//CABECERA
		this.facturas = facturaServicioON.getFacturas();
		this.facturaServicio.setFecha("15-02-2022");
		this.facturaServicio.setPersona(this.persona);
		
		try {
			facturaServicioON.insert(this.facturaServicio);
			System.out.println("FACTURA CABECERA AGREGADA");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR AL INSERTAR FACTURA CABECERA");
			e.printStackTrace();
		}
		
		//DETALLE
		this.detalles = detalleServicioON.getFacturas();
		this.detalleServicio.setDescuento(0);
		
		this.total = this.servicio.getPrecio();
		this.detalleServicio.setTotal(this.total);
		this.detalleServicio.setIva(((this.total * 12) / 100) + this.total);
		
		this.detalleServicio.setFacturaCabeceraServicio(this.facturaServicio);
		this.detalleServicio.setServicio(this.servicio);
		
		try {
			detalleServicioON.insert(this.detalleServicio);
			System.out.println("DETALLE AGREGADO");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR AL INSERTAR DETALLE");
			e.printStackTrace();
		}
		
		return "cliente-factura-servicio?faces-redirect=true";
		
	}//GENERAR FACTURA
	
	public void cargar() {//CARGAR FACTURA
		
		this.facturas = facturaServicioON.getFacturas();
		this.detalles = detalleServicioON.getFacturas();
		
		int numero = this.facturas.size();
		
		if(numero < 1) {
			
			System.out.println("NO HAY FACTURAS QUE MOSTRAR");

		} else {
			
			this.facturasCliente.add(this.facturas.get(numero - 1));
			this.idFactura = this.facturas.get(numero - 1).getNumero();
			
			for (int i = 0; i < this.detalles.size(); i++) {
				if(this.detalles.get(i).getFacturaCabeceraServicio().getNumero() == this.idFactura) {
					this.detallesCliente.add(this.detalles.get(i));
				}
			}
		}
		

		
	}//CARGAR FACTURA

	

}
