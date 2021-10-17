package com.anz.sb.model;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestBlock {
    @Min(value = 1, message = "Minimum Length of a Block must be 1")
    @Max(value = 100, message = "Maximum Length of a Block must be 100")
    private int length;
    @Min(value = 1, message = "Minimum Width of a Block must be 1")
    @Max(value = 100, message = "Maximum Width of a Block must be 100")
    private int width;
    @Min(value = 1, message = "Minimum height of a Block must be 1")
    @Max(value = 100, message = "Maximum height of a Block must be 100")
    private int height;
}
