package modija.modija.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Result<T> {

    private String message;

    private T contents;
}
