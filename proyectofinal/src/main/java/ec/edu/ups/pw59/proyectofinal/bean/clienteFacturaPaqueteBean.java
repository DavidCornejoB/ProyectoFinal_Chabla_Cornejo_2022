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

/**
 * BEAN QUE GENERA FACTURAS PAQUETE
 * @author luisd
 *
 */
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
	
	/**
	 * METODO POST CONSTRUCT
	 */
	@PostConstruct
	public void init() {
		this.cargar();
	}

	/**
	 * 
	 * @return objeto de negocio facturaPaqueteON
	 */
	public FacturaCabeceraPaqueteONLocal getFacturaPaqueteON() {
		return facturaPaqueteON;
	}

	/**
	 * 
	 * @param objeto de negocio facturaPaqueteON
	 */
	public void setFacturaPaqueteON(FacturaCabeceraPaqueteONLocal facturaPaqueteON) {
		this.facturaPaqueteON = facturaPaqueteON;
	}

	/**
	 * 
	 * @return objeto de negocio detallePaqueteON
	 */
	public FacturaDetallePaqueteONLocal getDetallePaqueteON() {
		return detallePaqueteON;
	}

	/**
	 * 
	 * @param objeto de negocio detallePaqueteON
	 */
	public void setDetallePaqueteON(FacturaDetallePaqueteONLocal detallePaqueteON) {
		this.detallePaqueteON = detallePaqueteON;
	}

	/**
	 * 
	 * @return objeto de negocio habitacionON
	 */
	public HabitacionONLocal getHabitacionON() {
		return habitacionON;
	}

	/**
	 * 
	 * @param objeto de negocio habitacionON
	 */
	public void setHabitacionON(HabitacionONLocal habitacionON) {
		this.habitacionON = habitacionON;
	}

	/**
	 * 
	 * @return ovjeto de negocio servicioON
	 */
	public ServicioONLocal getServicioON() {
		return servicioON;
	}

	/**
	 * 
	 * @param objeto de negocio servicioON
	 */
	public void setServicioON(ServicioONLocal servicioON) {
		this.servicioON = servicioON;
	}

	/**
	 * 
	 * @return entidad facturaPaquete
	 */
	public FacturaCabeceraPaquete getFacturaPaquete() {
		return facturaPaquete;
	}

	/**
	 * 
	 * @param entidad facturaPaquete
	 */
	public void setFacturaPaquete(FacturaCabeceraPaquete facturaPaquete) {
		this.facturaPaquete = facturaPaquete;
	}

	/**
	 * 
	 * @return entidad detallePaquete
	 */
	public FacturaDetallePaquete getDetallePaquete() {
		return detallePaquete;
	}

	/**
	 * 
	 * @param entidad detallePaquete
	 */
	public void setDetallePaquete(FacturaDetallePaquete detallePaquete) {
		this.detallePaquete = detallePaquete;
	}

	/**
	 * 
	 * @return lista de facturas
	 */
	public List<FacturaCabeceraPaquete> getFacturas() {
		return facturas;
	}

	/**
	 * 
	 * @param lista de facturas
	 */
	public void setFacturas(List<FacturaCabeceraPaquete> facturas) {
		this.facturas = facturas;
	}

	/**
	 * 
	 * @return lista de clientes
	 */
	public List<FacturaCabeceraPaquete> getFacturasCliente() {
		return facturasCliente;
	}

	/**
	 * 
	 * @param lista de facturasCliente
	 */
	public void setFacturasCliente(List<FacturaCabeceraPaquete> facturasCliente) {
		this.facturasCliente = facturasCliente;
	}

	/**
	 * 
	 * @return lista de detalles
	 */
	public List<FacturaDetallePaquete> getDetalles() {
		return detalles;
	}

	/**
	 * 
	 * @param lista detalles
	 */
	public void setDetalles(List<FacturaDetallePaquete> detalles) {
		this.detalles = detalles;
	}

	/**
	 * 
	 * @return lista de detallesCliente
	 */
	public List<FacturaDetallePaquete> getDetallesCliente() {
		return detallesCliente;
	}

	/**
	 * 
	 * @param lista detallesCliente
	 */
	public void setDetallesCliente(List<FacturaDetallePaquete> detallesCliente) {
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
	 * @return entidad habitacion
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/**
	 * 
	 * @param entidad habitacion
	 */
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
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
	 * @return objeto de negocio paqueteON
	 */
	public PaqueteONLocal getPaqueteON() {
		return paqueteON;
	}

	/**
	 * 
	 * @param objeto de negocio paqueteON
	 */
	public void setPaqueteON(PaqueteONLocal paqueteON) {
		this.paqueteON = paqueteON;
	}

	/**
	 * 
	 * @return entidad paquete
	 */
	public Paquete getPaquete() {
		return paquete;
	}

	/**
	 * 
	 * @param entidad paquete
	 */
	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	/**
	 * 
	 * @return entidad codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param entidad codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * METODO QUE GENERA FACTURA DE PAQUETES
	 * @param codigo de la factura
	 * @return formulario cliente-factura-paquete
	 */
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
	
	/**
	 * METODO PARA CARGAR LISTA DE FACTURAS
	 */
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
