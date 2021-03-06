package com.sing3demons.products_backend.mapper;

import com.sing3demons.products_backend.entity.User;
import com.sing3demons.products_backend.model.MRegisterResponse;
import com.sing3demons.products_backend.model.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    MRegisterResponse toRegisterResponse(User user);

    UserResponse toUserResponse(User user);
}
