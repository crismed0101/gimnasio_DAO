package interfaces;

import logica.Gimnasio;

public interface DAOGimnasio {

    public void registar(Gimnasio gimnasio);
    public void modificar(Gimnasio gimnasio);
    public void eliminar(Gimnasio gimnasio);
    public void  buscar(Gimnasio gimnasio);
}
