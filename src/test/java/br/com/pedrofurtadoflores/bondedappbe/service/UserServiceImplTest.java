package br.com.pedrofurtadoflores.bondedappbe.service;

import br.com.pedrofurtadoflores.bondedappbackend.dto.request.UserRequestDTO;
import br.com.pedrofurtadoflores.bondedappbackend.dto.response.UserResponseDTO;
import br.com.pedrofurtadoflores.bondedappbackend.model.User;
import br.com.pedrofurtadoflores.bondedappbackend.repository.UserRepository;
import br.com.pedrofurtadoflores.bondedappbackend.service.UserServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserRepository repository;
    private UserServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = mock(UserRepository.class);
        service = new UserServiceImpl(repository);
    }

    @Test
    void testGetAll() {
        List<User> users = Arrays.asList(
            User.builder().name("Alice").email("alice@email.com").password("123456").build(),
            User.builder().name("Bob").email("bob@email.com").password("abcdef").build()
        );
        when(repository.findAll()).thenReturn(users);

        List<UserResponseDTO> result = service.getAll();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testGetById_Success() {
        User user = User.builder().name("Alice").email("alice@email.com").password("123456").build();
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        UserResponseDTO result = service.getById(1L);

        assertEquals("Alice", result.getName());
        verify(repository).findById(1L);
    }

    @Test
    void testGetById_NotFound() {
        when(repository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> service.getById(999L));
    }

    @Test
    void testCreate() {
        UserRequestDTO dto = UserRequestDTO.builder()
                .name("Alice")
                .email("alice@email.com")
                .password("123456")
                .gender("Feminino")
                .birthDate(LocalDate.of(1995, 5, 20))
                .build();

        User saved = User.builder()
                .name("Alice")
                .email("alice@email.com")
                .password("123456")
                .gender("Feminino")
                .birthDate(LocalDate.of(1995, 5, 20))
                .build();

        when(repository.save(any(User.class))).thenReturn(saved);

        UserResponseDTO result = service.create(dto);

        assertEquals("Alice", result.getName());
        verify(repository).save(any(User.class));
    }

    @Test
    void testUpdate_Success() {
        User existing = User.builder()
                .name("Old Name")
                .email("old@email.com")
                .password("oldpass")
                .build();

        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        UserRequestDTO dto = UserRequestDTO.builder()
                .name("New Name")
                .email("new@email.com")
                .password("newpass")
                .gender("Outro")
                .birthDate(LocalDate.of(1990, 1, 1))
                .avatarUrl("https://avatar.com/img.png")
                .build();

        UserResponseDTO result = service.update(1L, dto);

        assertEquals("New Name", result.getName());
        assertEquals("new@email.com", result.getEmail());
        verify(repository).save(existing);
    }

    @Test
    void testUpdate_NotFound() {
        when(repository.findById(999L)).thenReturn(Optional.empty());

        UserRequestDTO dto = UserRequestDTO.builder()
                .name("New")
                .email("email@email.com")
                .password("pass")
                .build();

        assertThrows(EntityNotFoundException.class, () -> service.update(999L, dto));
    }

    @Test
    void testDelete_Success() {
        when(repository.existsById(1L)).thenReturn(true);
        service.delete(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void testDelete_NotFound() {
        when(repository.existsById(999L)).thenReturn(false);
        assertThrows(EntityNotFoundException.class, () -> service.delete(999L));
    }
}
