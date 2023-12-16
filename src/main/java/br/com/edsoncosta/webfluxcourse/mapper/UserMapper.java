package br.com.edsoncosta.webfluxcourse.mapper;

import br.com.edsoncosta.webfluxcourse.entity.User;
import br.com.edsoncosta.webfluxcourse.model.request.UserRequest;
import br.com.edsoncosta.webfluxcourse.model.response.UserResponse;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(final UserRequest request);

    @Mapping(target = "id", ignore = true)
    User toEntity(final UserRequest request, @MappingTarget final User entity);

    UserResponse toResponse(final User entity);

}
