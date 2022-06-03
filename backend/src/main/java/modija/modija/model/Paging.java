package modija.modija.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Paging {
    protected Integer page = 0;
    protected Integer size = 10;
    protected String sort = "id";
    protected String direction = "desc";

    public Sort sort() {
        return Sort.by(direction.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sort);
    }
}
