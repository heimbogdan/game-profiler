package ro.helator.gameprofiler.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.helator.gameprofiler.service.PlayerProfilerService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@Tag(name = "assets", description = "Assets controller")
@RequestMapping("/assets")
public class PlayerProfilerController {

    private PlayerProfilerService profilerService;

    @GetMapping("/get_client_config/{player_id}")
    public ResponseEntity<Object> getProfile(@PathVariable("player_id") UUID playerId) {
        Object response = this.profilerService.getProfile(playerId);
        if(response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
