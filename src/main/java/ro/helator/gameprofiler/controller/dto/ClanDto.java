package ro.helator.gameprofiler.controller.dto;

import lombok.*;
import ro.helator.gameprofiler.repository.clan.ClanEntity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClanDto {
    private String id;
    private String name;

    public static ClanDto fromEntity(ClanEntity clan) {
        if(clan == null) {
            return null;
        }
        return ClanDto.builder().id(clan.getId()).name(clan.getName()).build();
    }
}
