package com.cleancodeheroes.user.adapter.in;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public final class CreateUserRequest {
    @NotNull
    @NotEmpty
    public String username;
}
