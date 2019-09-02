package Services;

import java.util.List;

import daos.PersonaDAO;
import daos.PersonaDAOImpl;
import forms.PersonaForm;
import models.Persona;

public class ServPersona {
	private final PersonaDAO personaDAO = new PersonaDAOImpl();

	public List<Persona> findAll() {
		return personaDAO.findAll();
	}

	public void delete(Integer idPersona) {
		personaDAO.delete(idPersona);
	}

	public void create(PersonaForm form) {
		Persona persona = new Persona();
		persona.setNombre(form.getNombre());
		persona.setApellido(form.getApellido());
		persona.setTipoDni(form.getTipoDocumento());
		persona.setDni(form.getNumDocumento());
		personaDAO.save(persona);
	}

	public Persona getPersona(Integer idPersona) {
		return personaDAO.findById(idPersona);
	}

	public void update(PersonaForm personaForm) {
		Persona persona = new Persona();
		persona.setIdPersona(personaForm.getIdPersona());
		persona.setNombre(personaForm.getNombre());
		persona.setApellido(personaForm.getApellido());
		persona.setTipoDni(personaForm.getTipoDocumento());
		persona.setDni(personaForm.getNumDocumento());
		personaDAO.update(persona);
	}
}
