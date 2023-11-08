package ro.helator.gameprofiler.service.model;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Device {
    private int id;
    private String model;
    private String carrier;
    private String firmware;
}
