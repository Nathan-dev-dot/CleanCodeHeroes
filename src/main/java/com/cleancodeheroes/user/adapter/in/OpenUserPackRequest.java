package com.cleancodeheroes.user.adapter.in;

import com.cleancodeheroes.user.domain.PackType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OpenUserPackRequest {

    @NotNull
    @NotEmpty
    public String packType;
}
