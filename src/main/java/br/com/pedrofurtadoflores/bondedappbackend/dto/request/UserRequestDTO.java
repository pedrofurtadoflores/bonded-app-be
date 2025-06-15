package br.com.pedrofurtadoflores.bondedappbackend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO de entrada para criação ou atualização de usuário")
public class UserRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    @Schema(description = "Nome completo do usuário", example = "Maria Silva")
    private String name;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    @Schema(description = "E-mail do usuário", example = "maria@email.com")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Size(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres")
    @Schema(description = "Senha do usuário", example = "senhaSegura123")
    private String password;

    @Schema(description = "Gênero do usuário", example = "Feminino")
    private String gender;

    @Schema(description = "Data de nascimento", example = "1990-05-21")
    private LocalDate birthDate;

    @Schema(description = "URL do avatar do usuário", example = "https://meusite.com/avatar.jpg")
    private String avatarUrl;
}
