package cc.nuvu.tarjetacredito.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@ApiModel
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name="tarjeta_credito")
public class TarjetaCredito {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(name = "id", accessMode = AccessMode.READ_ONLY)
	private Long id;
	
	@ApiModelProperty(name = "idPersona", required = true, value = "ID de la persona")
	@NotNull(message = "El campo idPersona no puede ser nulo")
	private Long idPersona;
	
	@ApiModelProperty(name = "numero", required = true, value = "Numero de la tarjeta")
	@NotNull(message = "El campo numero no puede ser nulo")
	private String numero;
	
	@ApiModelProperty(name = "fechaVencimiento", required = true, value = "Fecha de Vencimiento de la tarjeta")
	@NotNull(message = "El campo fechaVencimiento no puede ser nulo")
	private Date fechaVencimiento;
	
	@ApiModelProperty(name = "banco", required = true, value = "Fecha de Vencimiento de la tarjeta")
	@NotNull(message = "El campo banco no puede ser nulo")
	private String banco;
	
}
