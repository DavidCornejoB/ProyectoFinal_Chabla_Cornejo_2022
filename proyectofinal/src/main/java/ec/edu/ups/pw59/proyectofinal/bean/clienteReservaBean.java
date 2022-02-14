package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.HabitacionONLocal;
import ec.edu.ups.pw59.proyectofinal.business.ReservaONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Reserva;

@Named
@RequestScoped
public class clienteReservaBean {
	
	@Inject
	private ReservaONLocal reservaON;
	
	@Inject
	private HabitacionONLocal habitacionON;
	
	private Reserva reserva = new Reserva();
	
	private Habitacion habitacion = new Habitacion();
	
	private List<Reserva> reservas = new ArrayList<>();
	
	public clienteReservaBean() {
		
	}
	
	@PostConstruct
	public void init() {
		
	}

	public ReservaONLocal getReservaON() {
		return reservaON;
	}

	public void setReservaON(ReservaONLocal reservaON) {
		this.reservaON = reservaON;
	}

	public HabitacionONLocal getHabitacionON() {
		return habitacionON;
	}

	public void setHabitacionON(HabitacionONLocal habitacionON) {
		this.habitacionON = habitacionON;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public String generarReserva(int numero) {//GENERAR RESERVA
		int num = 0;
		int num2 = 0;
		try {
			this.habitacion = habitacionON.read(numero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(this.habitacion.getEstado().equals("Ocupada")) {
			System.out.println("LA HABITACION YA ESTA OCUPADA");
			return "error-habitacion-ocupada";
			
		} else {			
			num = reservaON.getReservas().size();
			
			if(num < 1) {
				System.out.println("NUMERO *********** " + num);
				this.reserva.setCodigo(num);

				
			} else {
				
				num2 = reservaON.getReservas().get(num - 1).getCodigo();
				this.reserva.setCodigo(num2 + 1);
			}
			
			this.reserva.setEntrada("7 am");
			this.reserva.setSalida("pendiente");
			this.habitacion.setEstado("Ocupada");
			this.reserva.setHabitacion(this.habitacion);

			try {
				habitacionON.update(this.habitacion);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				reservaON.insert(this.reserva);
				
				clienteFacturaHabitacionBean.setCodigo(this.reserva.getCodigo());
				
				this.reservas.add(this.reserva);
				
				System.out.println("RESERVA EXITOSA");
				
				return "cliente-reserva";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("ERROR AL RESERVAR");
				e.printStackTrace();
				return "";
			}
		}
	}//GENERAR RESERVA

}
