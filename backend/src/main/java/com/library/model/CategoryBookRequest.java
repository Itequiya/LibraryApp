package com.library.model;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CategoryBookRequest {

    @NotNull
    private Long bookId;
    @NotNull
    private List<Long> categoriesId;

}
