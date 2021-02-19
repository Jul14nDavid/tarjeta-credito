package cc.nuvu.tarjetacredito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.nuvu.tarjetacredito.business.TarjetaCreditoBusiness;
import cc.nuvu.tarjetacredito.model.TarjetaCredito;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("tarjetacredito")
@Api(tags = "#TarjetaCredito")
public class TarjetaCreditoController {

	@Autowired
	private TarjetaCreditoBusiness tarjetaCreditoBusiness;
	

	@PostMapping("/guardar")
	@ApiOperation(value = "Crear Tarjeta de Credito", response = void.class, httpMethod = "POST")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Tarjeta de Credito creada."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public void guardarTarjetaCredito(@RequestBody TarjetaCredito tarjetaCredito) {
		this.tarjetaCreditoBusiness.guardarTarjetaCredito(tarjetaCredito);
	}
	
	@PostMapping("/persona/guardar")
	@ApiOperation(value = "Guardar Tarjetas de Credito asociadas a una persona", response = void.class, httpMethod = "POST")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Registros creados."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public void guardarTarjetasCredito(@RequestBody List<TarjetaCredito> tarjetasCredito) {
		this.tarjetaCreditoBusiness.guardarTarjetasCredito(tarjetasCredito);
	}
	
	@GetMapping("/consultar")
	@ApiOperation(value = "Consultar Tarjetas de Credito", response = TarjetaCredito.class, httpMethod = "GET", responseContainer = "List")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Tarjetas de Credito consultadas."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public List<TarjetaCredito> consultarTarjetaCreditos() {
		return this.tarjetaCreditoBusiness.consultarTarjetaCreditos();
	}
	
	@GetMapping("/consultar/{id}")
	@ApiOperation(value = "Consultar Tarjeta de Credito por ID", response = TarjetaCredito.class, httpMethod = "GET")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Tarjeta de Credito consultada."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public TarjetaCredito consultarTarjetaCreditoPorId(@PathVariable Long id) {
		return this.tarjetaCreditoBusiness.consultarTarjetaCreditoPorId(id);
	}
	
	@PutMapping("/actualizar")
	@ApiOperation(value = "Actualizar Tarjeta de Credito", response = void.class, httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Tarjeta de Credito actualizada."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public void actualizarTarjetaCredito(@RequestBody TarjetaCredito tarjetaCredito) {
		this.tarjetaCreditoBusiness.actualizarTarjetaCredito(tarjetaCredito);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ApiOperation(value = "Eliminar Tarjeta de Credito", response = void.class, httpMethod = "DELETE")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Tarjeta de Credito eliminada."),
		@ApiResponse(code = 400, message = "Datos de entrada incorrectos."),
		@ApiResponse(code = 500, message = "Error inesperado.")
	})
	public void eliminarTarjetaCredito(@PathVariable Long id) {
		this.tarjetaCreditoBusiness.eliminarTarjetaCredito(id);
	}
	
}
