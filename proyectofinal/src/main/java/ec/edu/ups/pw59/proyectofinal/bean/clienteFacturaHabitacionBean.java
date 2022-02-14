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

	@PostConstruct
	public void init() {
		this.cargar();

	}

	public FacturaCabeceraHabitacionONLocal getFacturaHabitacionON() {
		return facturaHabitacionON;
	}

	public void setFacturaHabitacionON(FacturaCabeceraHabitacionONLocal facturaHabitacionON) {
		this.facturaHabitacionON = facturaHabitacionON;
	}

	public FacturaDetalleHabitacionONLocal getDetalleHabitacionON() {
		return detalleHabitacionON;
	}

	public void setDetalleHabitacionON(FacturaDetalleHabitacionONLocal detalleHabitacionON) {
		this.detalleHabitacionON = detalleHabitacionON;
	}

	public FacturaCabeceraHabitacion getFacturaHabitacion() {
		return facturaHabitacion;
	}

	public void setFacturaHabitacion(FacturaCabeceraHabitacion facturaHabitacion) {
		this.facturaHabitacion = facturaHabitacion;
	}

	public FacturaDetalleHabitacion getDetalleHabitacion() {
		return detalleHabitacion;
	}

	public void setDetalleHabitacion(FacturaDetalleHabitacion detalleHabitacion) {
		this.detalleHabitacion = detalleHabitacion;
	}

	public ReservaONLocal getReservaON() {
		return reservaON;
	}

	public void setReservaON(ReservaONLocal reservaON) {
		this.reservaON = reservaON;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<FacturaCabeceraHabitacion> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<FacturaCabeceraHabitacion> facturas) {
		this.facturas = facturas;
	}

	public List<FacturaDetalleHabitacion> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<FacturaDetalleHabitacion> detalles) {
		this.detalles = detalles;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public HabitacionONLocal getHabitacionON() {
		return habitacionON;
	}

	public void setHabitacionON(HabitacionONLocal habitacionON) {
		this.habitacionON = habitacionON;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public static int getCodigo() {
		return codigo;
	}

	public static void setCodigo(int codigo) {
		clienteFacturaHabitacionBean.codigo = codigo;
	}

	public List<FacturaCabeceraHabitacion> getFacturasCliente() {
		return facturasCliente;
	}

	public void setFacturasCliente(List<FacturaCabeceraHabitacion> facturasCliente) {
		this.facturasCliente = facturasCliente;
	}

	public List<FacturaDetalleHabitacion> getDetallesCliente() {
		return detallesCliente;
	}

	public void setDetallesCliente(List<FacturaDetalleHabitacion> detallesCliente) {
		this.detallesCliente = detallesCliente;
	}

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
		this.facturaHabitacion.setNumero(this.facturas.size() + 1);
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
		this.detalleHabitacion.setCodigo(this.detalles.size() + 1);
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

	public void cargar() {// CARGAR

		this.facturas = facturaHabitacionON.getFacturas();
		this.detalles = detalleHabitacionON.getFacturas();
		
		int numero = this.facturas.size();
		System.out.println(numero);
		
		if(numero < 1) {
			
			this.facturasCliente.add(this.facturas.get(numero));
			this.idFactura = this.facturas.get(numero).getNumero();

			for (int i = 0; i < this.detalles.size(); i++) {
				if (this.detalles.get(i).getFacturaCabeceraHabitacion().getNumero() == this.idFactura) {
					this.detallesCliente.add(this.detalles.get(i));
					System.out.println(
							"ID DETALLE ENCONTRADO " + this.detalles.get(i).getFacturaCabeceraHabitacion().getNumero());
				}
			}
			
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
