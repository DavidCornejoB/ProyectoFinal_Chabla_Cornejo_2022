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

/**
 * BEAN PARA GENERAR FACTURAS DE SERVICIOS
 * @author luisd
 *
 */
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
	
	/**
	 * METODO POST CONSTRUCT
	 */
	@PostConstruct
	public void init() {
		this.cargar();
	}

	/**
	 * 
	 * @return entidad de negocio facturaServicioON
	 */
	public FacturaCabeceraServicioONLocal getFacturaServicioON() {
		return facturaServicioON;
	}

	/**
	 * 
	 * @param entidad de negocio facturaServicioON
	 */
	public void setFacturaServicioON(FacturaCabeceraServicioONLocal facturaServicioON) {
		this.facturaServicioON = facturaServicioON;
	}

	/**
	 * 
	 * @return entidad de negocio detalleServicioON
	 */
	public FacturaDetalleServicioONLocal getDetalleServicioON() {
		return detalleServicioON;
	}

	/**
	 * 
	 * @param entidad de negocio detalleServicioON
	 */
	public void setDetalleServicioON(FacturaDetalleServicioONLocal detalleServicioON) {
		this.detalleServicioON = detalleServicioON;
	}

	/**
	 * 
	 * @return entidad de negocio servicioON
	 */
	public ServicioONLocal getServicioON() {
		return servicioON;
	}

	/**
	 * 
	 * @param entidad de negocio servicioON
	 */
	public void setServicioON(ServicioONLocal servicioON) {
		this.servicioON = servicioON;
	}

	/**
	 * 
	 * @return entidad factura servicio
	 */
	public FacturaCabeceraServicio getFacturaServicio() {
		return facturaServicio;
	}

	/**
	 * 
	 * @param entidad facturaServicio
	 */
	public void setFacturaServicio(FacturaCabeceraServicio facturaServicio) {
		this.facturaServicio = facturaServicio;
	}

	/**
	 * 
	 * @return entidad detalleServicio
	 */
	public FacturaDetalleServicio getDetalleServicio() {
		return detalleServicio;
	}

	/**
	 * 
	 * @param entidad detalleServicio
	 */
	public void setDetalleServicio(FacturaDetalleServicio detalleServicio) {
		this.detalleServicio = detalleServicio;
	}

	/**
	 * 
	 * @return lista de facturas
	 */
	public List<FacturaCabeceraServicio> getFacturas() {
		return facturas;
	}

	/**
	 * 
	 * @param lista de facturas
	 */
	public void setFacturas(List<FacturaCabeceraServicio> facturas) {
		this.facturas = facturas;
	}

	/**
	 * 
	 * @return lista de facturasCliente
	 */
	public List<FacturaCabeceraServicio> getFacturasCliente() {
		return facturasCliente;
	}

	/**
	 * 
	 * @param lista de facturasCliente
	 */
	public void setFacturasCliente(List<FacturaCabeceraServicio> facturasCliente) {
		this.facturasCliente = facturasCliente;
	}

	/**
	 * 
	 * @return lista de detalles
	 */
	public List<FacturaDetalleServicio> getDetalles() {
		return detalles;
	}

	/**
	 * 
	 * @param lista de detalles
	 */
	public void setDetalles(List<FacturaDetalleServicio> detalles) {
		this.detalles = detalles;
	}

	/**
	 * 
	 * @return lista de detallesCliente
	 */
	public List<FacturaDetalleServicio> getDetallesCliente() {
		return detallesCliente;
	}

	/**
	 * 
	 * @param lista de detallesCliente
	 */
	public void setDetallesCliente(List<FacturaDetalleServicio> detallesCliente) {
		this.detallesCliente = detallesCliente;
	}

	/**
	 * 
	 * @return entidad servicio
	 */
	public Servicio getServicio() {
		return servicio;
	}

	/**
	 * 
	 * @param entidad servicio
	 */
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	/**
	 * 
	 * @return entidad persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * 
	 * @param entidad persona
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * 
	 * @return atributo total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * 
	 * @param atributo total
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * 
	 * @return atributo idFactura
	 */
	public int getIdFactura() {
		return idFactura;
	}

	/**
	 * 
	 * @param atributo idFactura
	 */
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	/**
	 * 
	 * @return atributo codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param atributo codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * METODO PARA GENERAR FACTURAS DE SERVICIOS
	 * @param codigo de factura
	 * @return formulario cliente-factura-servicio
	 */
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
	
	/**
	 * METODO PARA CARGAR LISTAS DE FACTURAS
	 */
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
