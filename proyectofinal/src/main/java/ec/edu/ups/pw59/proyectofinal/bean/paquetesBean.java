package ec.edu.ups.pw59.proyectofinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.pw59.proyectofinal.business.PaqueteONLocal;
import ec.edu.ups.pw59.proyectofinal.modelo.Habitacion;
import ec.edu.ups.pw59.proyectofinal.modelo.Hotel;
import ec.edu.ups.pw59.proyectofinal.modelo.Paquete;
import ec.edu.ups.pw59.proyectofinal.modelo.Servicio;

@Named //ETIQUETA DE MANAGED BEANS
@RequestScoped
public class paquetesBean {
	
	//LLAMAMOS AL OBJETO DE NEGOCIO LOCAL QUE CONTIENE LOS MÉTODOS INSERT, UPDATE, READ Y DELETE
	@Inject
	private PaqueteONLocal paqueteON;
	
	//CREAMOS EL OBJETO PAQUETE. COMO ESTÁ INSTANCIADO, ESTARÁN SUS VALORES VACÍOS, Y PODREMOS MODIFICARLOS DESDE EL FORMULARIO
	private Paquete paquete = new Paquete();
	
	//LISTA DE PAQUETES
	private List<Paquete> paquetes;
	
	//CONSTRUCTOR
	public paquetesBean() {
		
	}
	
	//UTILIZAMOS LA ETIQUETA POSTCONSTRUCT POR SI QUEREMOS LISTAR ANTES DE TENER ELEMENTOS EN LA LISTA.
	@PostConstruct
	public void init() {
		this.paquete.setHabitacion(new Habitacion());
		this.paquete.setHotel(new Hotel());
		this.paquete.setServicio(new Servicio());
		this.cargar();
	}

	//METODOS GET() Y SET()
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

	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}
	
	//MÉTODO PARA GUARDAR PAQUETES
	public String guardar() {
		
		System.out.println("GUARDANDO PAQUETE: " + this.paquete.getNombre());
		
		try {
			//USAMOS EL MÉTODO INSERT DE LA ENTIDAD DE NEGOCIO DE PAQUETE
			paqueteON.insert(this.paquete);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//UNA VEZ SE HA INGRESADO UNA PAQUETE, SE REDIRIGIRÁ AL FORMULARIO DE LISTAR PAQUETES
		return "listado-paquetes?faces-redirect=true";
	}
	
	//MÉTODO PARA LISTAR PAQUETES
	public void cargar() {
		//LLAMAMOS AL MÉTODO GETPAQUETES() DEL OBJETO DE NEGOCIO
		this.paquetes = paqueteON.getPaquetes();
	}
	
	public String cargarHabitacion() {
		
		int id = this.paquete.getHabitacion().getNumero();
		
		Habitacion h = paqueteON.getHabitacion(id);
		this.paquete.setHabitacion(h);
		
		return null;
	}
	
	public String cargarHotel() {
		
		int id = this.paquete.getHotel().getCodigo();
		
		Hotel h = paqueteON.getHotel(id);
		this.paquete.setHotel(h);
		
		return null;
		
	}
	
	public String cargarServicio() {
		
		int id = this.paquete.getServicio().getCodigo();
		
		Servicio s = paqueteON.getServicio(id);
		this.paquete.setServicio(s);
		
		return null;
		
	}
	
	

}
