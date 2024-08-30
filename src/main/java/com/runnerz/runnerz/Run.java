package com.runnerz.runnerz;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
    Integer id,
    @NotEmpty
    String name,
    @Positive
    Integer length,
    Integer time
) {}
