package br.com.pedrofurtadoflores.bondedappbackend.service;

import br.com.pedrofurtadoflores.bondedappbackend.dto.request.UserRequestDTO;
import br.com.pedrofurtadoflores.bondedappbackend.dto.response.UserResponseDTO;
import br.com.pedrofurtadoflores.bondedappbackend.model.User;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getAll();

    UserResponseDTO getById(Long id);

    UserResponseDTO create(UserRequestDTO dto);

    UserResponseDTO update(Long id, UserRequestDTO dto);

    void delete(Long id);

    User findByEmail(String email);
}
