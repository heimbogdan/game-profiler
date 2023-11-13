package ro.helator.gameprofiler.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.helator.gameprofiler.service.TestService;

import java.util.Set;
import java.util.UUID;

@RestController
@AllArgsConstructor
@Tag(name = "test", description = "Test controller")
@RequestMapping("/test")
public class TestController {

    private TestService testService;

    @PostMapping("/reset-campaigns")
    public ResponseEntity<Object> resetCampaigns(@RequestBody Set<UUID> ids) {
        this.testService.resetCampaigns(ids);
        return ResponseEntity.ok().build();
    }
}
