package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.FacturaCabeceraHabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.FacturaDetalleHabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.ReservaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaCabeceraHabitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.FacturaDetalleHabitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Persona;
import ec.edu.ups.pw59.proyectofinal.modelo.Reserva;

/**
 * BEAN PARA GENERAR FACTURA HABITACION
 * @author luisd
 *
 */
@Named
@RequestScoped
public class clienteFacturaHabitacionBean {

	@Inject
	private FacturaCabeceraHabitacionONLocal facturaHabitacionON;

	@Inject
	private FacturaDetalleHabitacionONLocal detalleHabitacionON;

	@Inject
	private ReservaONLocal reservaON;

	@Inject
	private HabitacionONLocal habitacionON;

	private FacturaCabeceraHabitacion facturaHabitacion = new FacturaCabeceraHabitacion();

	private FacturaDetalleHabitacion detalleHabitacion = new FacturaDetalleHabitacion();

	private List<FacturaCabeceraHabitacion> facturas = new ArrayList<>();

	private List<FacturaCabeceraHabitacion> facturasCliente = new ArrayList<>();

	private List<FacturaDetalleHabitacion> detalles = new ArrayList<>();

	private List<FacturaDetalleHabitacion> detallesCliente = new ArrayList<>();

	private Reserva reserva = new Reserva();

	private Persona persona = new Persona();

	double total = 0;

	int idFactura;

	public static int codigo;

	public clienteFacturaHabitacionBean() {
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
	 * @return objeto de negocio factura habitacion
	 */
	public FacturaCabeceraHabitacionONLocal getFacturaHabitacionON() {
		return facturaHabitacionON;
	}

	/**
	 * 
	 * @param objeto de negocio facturaHabitacionON
	 */
	public void setFacturaHabitacionON(FacturaCabeceraHabitacionONLocal facturaHabitacionON) {
		this.facturaHabitacionON = facturaHabitacionON;
	}

	/**
	 * 
	 * @return objeto de negocio detalle habitacion
	 */
	public FacturaDetalleHabitacionONLocal getDetalleHabitacionON() {
		return detalleHabitacionON;
	}

	/**
	 * 
	 * @param objeto de negocio detalleHabitacionON
	 */
	public void setDetalleHabitacionON(FacturaDetalleHabitacionONLocal detalleHabitacionON) {
		this.detalleHabitacionON = detalleHabitacionON;
	}

	/**
	 * 
	 * @return entidad factura habitacion
	 */
	public FacturaCabeceraHabitacion getFacturaHabitacion() {
		return facturaHabitacion;
	}

	/**
	 * 
	 * @param entidad facturaHabitacion
	 */
	public void setFacturaHabitacion(FacturaCabeceraHabitacion facturaHabitacion) {
		this.facturaHabitacion = facturaHabitacion;
	}

	/**
	 * 
	 * @return entidad detalle habitacion
	 */
	public FacturaDetalleHabitacion getDetalleHabitacion() {
		return detalleHabitacion;
	}

	/**
	 * 
	 * @param entidad detalleHabitacion
	 */
	public void setDetalleHabitacion(FacturaDetalleHabitacion detalleHabitacion) {
		this.detalleHabitacion = detalleHabitacion;
	}

	/**
	 * 
	 * @return objeto de negocio reserva
	 */
	public ReservaONLocal getReservaON() {
		return reservaON;
	}

	/**
	 * 
	 * @param objeto de negocio reservaON
	 */
	public void setReservaON(ReservaONLocal reservaON) {
		this.reservaON = reservaON;
	}

	/**
	 * 
	 * @return entidad reserva
	 */
	public Reserva getReserva() {
		return reserva;
	}

	/**
	 * 
	 * @param entidad reserva
	 */
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	/**
	 * 
	 * @return lista de facturas
	 */
	public List<FacturaCabeceraHabitacion> getFacturas() {
		return facturas;
	}

	/**
	 * 
	 * @param lista de facturas
	 */
	public void setFacturas(List<FacturaCabeceraHabitacion> facturas) {
		this.facturas = facturas;
	}

	/**
	 * 
	 * @return lista de detalles
	 */
	public List<FacturaDetalleHabitacion> getDetalles() {
		return detalles;
	}

	/**
	 * 
	 * @param lista de detalles
	 */
	public void setDetalles(List<FacturaDetalleHabitacion> detalles) {
		this.detalles = detalles;
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
	 * @return atributo codigo
	 */
	public static int getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param atributo codigo
	 */
	public static void setCodigo(int codigo) {
		clienteFacturaHabitacionBean.codigo = codigo;
	}

	/**
	 * 
	 * @return lista de facturas cliente
	 */
	public List<FacturaCabeceraHabitacion> getFacturasCliente() {
		return facturasCliente;
	}

	/**
	 * 
	 * @param lista de facturasCliente
	 */
	public void setFacturasCliente(List<FacturaCabeceraHabitacion> facturasCliente) {
		this.facturasCliente = facturasCliente;
	}

	/**
	 * 
	 * @return lista de detalles cliente
	 */
	public List<FacturaDetalleHabitacion> getDetallesCliente() {
		return detallesCliente;
	}

	/**
	 * 
	 * @param lista de detallesCliente
	 */
	public void setDetallesCliente(List<FacturaDetalleHabitacion> detallesCliente) {
		this.detallesCliente = detallesCliente;
	}

	/**
	 * METODO QUE GENERA FACTURA. TOMA LOS DATOS DEL LOGIN
	 * @return formulario cliente-factura-habitacion
	 */
	public String generarFactura() {// GENERAR FACTURA

		// DATOS DE PERSONA
		this.persona = clienteLoginBean.logueo.getPersona();

		// DATOS DE RESERVA
		try {
			this.reserva = reservaON.read(codigo);
			System.out.println("SE ENCONTRÓ RESERVA: " + codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("NO SE ENCONTRÓ RESERVA");
			e.printStackTrace();
		}

		// CABECERA
		this.facturas = facturaHabitacionON.getFacturas();
		this.facturaHabitacion.setFecha("15-02-2022");
		this.facturaHabitacion.setPersona(this.persona);

		try {
			facturaHabitacionON.insert(this.facturaHabitacion);
			System.out.println("FACTURA CABECERA AGREGADA");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR AL INGRESAR FACTURA CABECERA");
			e.printStackTrace();
		}

		// DETALLE
		this.detalles = detalleHabitacionON.getFacturas();
		this.detalleHabitacion.setDescuento(0);

		this.total = this.reserva.getHabitacion().getCategoria().getPrecio();
		this.detalleHabitacion.setTotal(this.total);
		this.detalleHabitacion.setIva(((this.total * 12) / 100) + this.total);

		this.detalleHabitacion.setFacturaCabeceraHabitacion(this.facturaHabitacion);
		this.detalleHabitacion.setReserva(this.reserva);

		try {
			detalleHabitacionON.insert(this.detalleHabitacion);
			System.out.println("DETALLE AGREGADO");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR AL INSERTAR DETALLE");
			e.printStackTrace();

		}
		return "cliente-factura-habitacion?faces-redirect=true";
	}// GENERAR FACTURA

	/**
	 * MÉTODO QUE CARGA LAS FACTURAS
	 */
	public void cargar() {// CARGAR

		this.facturas = facturaHabitacionON.getFacturas();
		this.detalles = detalleHabitacionON.getFacturas();
		
		int numero = this.facturas.size();
		System.out.println(numero);
		
		if(numero < 1) {
			
			System.out.println("NO HAY FACTURAS QUE MOSTRAR");

		} else {
			
			this.facturasCliente.add(this.facturas.get(numero - 1));
			this.idFactura = this.facturas.get(numero - 1).getNumero();

			for (int i = 0; i < this.detalles.size(); i++) {
				if (this.detalles.get(i).getFacturaCabeceraHabitacion().getNumero() == this.idFactura) {
					this.detallesCliente.add(this.detalles.get(i));
					System.out.println(
							"ID DETALLE ENCONTRADO " + this.detalles.get(i).getFacturaCabeceraHabitacion().getNumero());
				}
			}
		}
	}// CARGAR

}
