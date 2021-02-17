package cc.nuvu.tarjetacredito.business;

import java.util.List;

import cc.nuvu.tarjetacredito.model.TarjetaCredito;

public interface TarjetaCreditoBusiness {

	void guardarTarjetaCredito(TarjetaCredito TarjetaCredito);
	List<TarjetaCredito> consultarTarjetaCreditos();
	TarjetaCredito consultarTarjetaCreditoPorId(Long id);
	void actualizarTarjetaCredito(TarjetaCredito TarjetaCredito);
	void eliminarTarjetaCredito(Long id);
	
}
