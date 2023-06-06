package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.security.config.auth;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.security.config.auth.AuthenticationRequest;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.security.config.auth.AuthenticationResponse;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.security.config.auth.AuthenticationService;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.security.config.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dicegame/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
