package cc.nuvu.tarjetacredito.business.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.nuvu.tarjetacredito.business.TarjetaCreditoBusiness;
import cc.nuvu.tarjetacredito.model.TarjetaCredito;
import cc.nuvu.tarjetacredito.repository.TarjetaCreditoRepository;


@Service
public class TarjetaCreditoBusinessImpl implements TarjetaCreditoBusiness {
	
	@Autowired
	private TarjetaCreditoRepository tarjetaCreditoRepository;
	

	@Override
	public void guardarTarjetaCredito(TarjetaCredito tarjetaCredito) {
		this.tarjetaCreditoRepository.save(tarjetaCredito);
	}

	@Override
	public List<TarjetaCredito> consultarTarjetaCreditos() {
		return (List<TarjetaCredito>) this.tarjetaCreditoRepository.findAll();
	}

	@Override
	public TarjetaCredito consultarTarjetaCreditoPorId(Long id) {
		Optional<TarjetaCredito> tarjetaCreditoConsultada = this.tarjetaCreditoRepository.findById(id);
		
		if (tarjetaCreditoConsultada.isPresent()) {
			return tarjetaCreditoConsultada.get();
		}
		
		return null;
	}

	@Override
	public void actualizarTarjetaCredito(TarjetaCredito tarjetaCredito) {
		this.tarjetaCreditoRepository.save(tarjetaCredito);
	}

	@Override
	public void eliminarTarjetaCredito(Long id) {
		this.tarjetaCreditoRepository.deleteById(id);
		
	}

}
