package br.com.pedrofurtadoflores.bondedappbackend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "DTO de saída para retorno de dados do usuário")
public class UserResponseDTO {

    @Schema(description = "ID do usuário", example = "1")
    private Long id;

    @Schema(description = "Nome completo do usuário", example = "Maria Silva")
    private String name;

    @Schema(description = "E-mail do usuário", example = "maria@email.com")
    private String email;

    @Schema(description = "Gênero do usuário", example = "Feminino")
    private String gender;

    @Schema(description = "Data de nascimento do usuário", example = "1990-05-21")
    private LocalDate birthDate;

    @Schema(description = "URL do avatar do usuário", example = "https://meusite.com/avatar.jpg")
    private String avatarUrl;

    @Schema(description = "Status do usuário (ativo ou inativo)", example = "true")
    private Boolean active;

    @Schema(description = "Data de criação do usuário")
    private LocalDateTime createdAt;

    @Schema(description = "Data da última atualização do usuário")
    private LocalDateTime updatedAt;
}
