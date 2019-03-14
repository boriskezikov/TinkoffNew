package tihkoff.taxi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
public class CarEntityDTO {
    private Long id;

    private Long manufacturerId;

    @NotNull
    private Integer techCondition;

    @NotNull
    private Integer category;

    @NotNull
    @Length (max = 100)
    private String modelInfo;



}
