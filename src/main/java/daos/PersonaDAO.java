package daos;

import java.util.List;
import models.Persona;

public interface PersonaDAO {
	public void save(Persona persona);
	public void delete(Integer idPersona);
	public void update(Persona persona);
	public List<Persona> findAll();
	public Persona findById(Integer idPersona);

}
