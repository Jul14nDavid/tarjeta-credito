package cc.nuvu.tarjetacredito.business;

import java.util.List;

import cc.nuvu.tarjetacredito.model.TarjetaCredito;

public interface TarjetaCreditoBusiness {

	void guardarTarjetaCredito(TarjetaCredito tarjetaCredito);
	void guardarTarjetasCredito(List<TarjetaCredito> tarjetasCredito);
	List<TarjetaCredito> consultarTarjetaCreditos();
	TarjetaCredito consultarTarjetaCreditoPorId(Long id);
	void actualizarTarjetaCredito(TarjetaCredito tarjetaCredito);
	void eliminarTarjetaCredito(Long id);
	
}
