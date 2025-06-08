package co.com.neurotrak.model.franchise;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Franchise {
    private String uuid;
    private String name;
    private Date createAt;
    private Date updateAt;
    private Integer quantity = 0;

    @Builder.Default
    private Set<Subsidiary> subsidiaries = new HashSet<>();
}
