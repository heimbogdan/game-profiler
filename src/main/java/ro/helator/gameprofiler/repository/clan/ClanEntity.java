package ro.helator.gameprofiler.repository.clan;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "CLANS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClanEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
}
