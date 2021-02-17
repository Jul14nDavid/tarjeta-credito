package cc.nuvu.tarjetacredito.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import cc.nuvu.tarjetacredito.business.impl.TarjetaCreditoBusinessImpl;
import cc.nuvu.tarjetacredito.model.TarjetaCredito;

public class TarjetaCreditoControllerTest {

	@Mock
	TarjetaCreditoBusinessImpl tarjetaCreditoBusinessImpl;
	
	@InjectMocks
	TarjetaCreditoController tarjetaCreditoController;
	
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void whenGuardarTarjetaCreditoThenReturnVoid() {
		// Arrange
		TarjetaCredito tarjetaCredito = TarjetaCredito.builder()
			.id(1L)
			.idPersona(1L)
			.numero("1234567890123456")
			.fechaVencimiento(new Date())
			.banco("Bancolombia")
		.build();
		
		// Act
		doNothing().when(this.tarjetaCreditoBusinessImpl).guardarTarjetaCredito(Mockito.any());
		this.tarjetaCreditoController.guardarTarjetaCredito(tarjetaCredito);
		
		// Assert
		verify(this.tarjetaCreditoBusinessImpl, times(1)).guardarTarjetaCredito(tarjetaCredito);
	}
	
	@Test
	public void whenConsultarTarjetaCreditosThenReturnTarjetaCreditoList() {
		// Arrange
		TarjetaCredito tarjetaCredito = TarjetaCredito.builder()
			.id(1L)
			.idPersona(1L)
			.numero("1234567890123456")
			.fechaVencimiento(new Date())
			.banco("Bancolombia")
		.build();
		List<TarjetaCredito> tarjetaCreditos = new ArrayList<>();
		tarjetaCreditos.add(tarjetaCredito);
		
		// Act
		when(this.tarjetaCreditoBusinessImpl.consultarTarjetaCreditos()).thenReturn(tarjetaCreditos);
		List<TarjetaCredito> tarjetaCreditosConsultadas = this.tarjetaCreditoController.consultarTarjetaCreditos();
		
		// Assert
		assertNotNull(tarjetaCreditosConsultadas);
	}
	
	@Test
	public void whenConsultarTarjetaCreditoPorIdThenReturnTarjetaCredito() {
		// Arrange
		long id = 1L;
		TarjetaCredito tarjetaCredito = TarjetaCredito.builder()
			.id(1L)
			.idPersona(1L)
			.numero("1234567890123456")
			.fechaVencimiento(new Date())
			.banco("Bancolombia")
		.build();
		
		// Act
		when(this.tarjetaCreditoBusinessImpl.consultarTarjetaCreditoPorId(Mockito.any())).thenReturn(tarjetaCredito);
		TarjetaCredito tarjetaCreditoConsultada = this.tarjetaCreditoController.consultarTarjetaCreditoPorId(id);
		
		// Assert
		assertNotNull(tarjetaCreditoConsultada);
	}
	
	@Test
	public void whenActualizarTarjetaCreditoThenReturnVoid() {
		// Arrange
		TarjetaCredito tarjetaCredito = TarjetaCredito.builder()
			.id(1L)
			.idPersona(1L)
			.numero("1234567890123456")
			.fechaVencimiento(new Date())
			.banco("Bancolombia")
		.build();
		
		// Act
		doNothing().when(this.tarjetaCreditoBusinessImpl).actualizarTarjetaCredito(Mockito.any());
		this.tarjetaCreditoController.actualizarTarjetaCredito(tarjetaCredito);
		
		// Assert
		verify(this.tarjetaCreditoBusinessImpl, times(1)).actualizarTarjetaCredito(tarjetaCredito);
	}
	
	@Test
	public void whenEliminarTarjetaCreditoThenReturnVoid() {
		// Arrange
		Long id = 1L;
		
		// Act
		doNothing().when(this.tarjetaCreditoBusinessImpl).eliminarTarjetaCredito(Mockito.any());
		this.tarjetaCreditoController.eliminarTarjetaCredito(id);
		
		// Assert
		verify(this.tarjetaCreditoBusinessImpl, times(1)).eliminarTarjetaCredito(id);
	}
	
}
