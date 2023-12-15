package br.com.edsoncosta.webfluxcourse.service;

import br.com.edsoncosta.webfluxcourse.entity.User;
import br.com.edsoncosta.webfluxcourse.mapper.UserMapper;
import br.com.edsoncosta.webfluxcourse.model.request.UserRequest;
import br.com.edsoncosta.webfluxcourse.repository.UserRepository;
import br.com.edsoncosta.webfluxcourse.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
//cmd + shift + seta
    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest request) {
        return repository.save(mapper.toEntity(request));
    }

    public Mono<User> findById(final String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(
                        new ObjectNotFoundException(String.format("Object not found. Id: %s, Type: %s ", id, User.class.getSimpleName()))
                ));
    }

    public Flux<User> findAll() {
        return repository.findAll();
    }
}
