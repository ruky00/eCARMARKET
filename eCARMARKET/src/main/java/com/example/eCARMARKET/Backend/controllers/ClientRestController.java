package com.example.eCARMARKET.Backend.controllers;

import com.example.eCARMARKET.Backend.models.Client;
import com.example.eCARMARKET.Backend.models.ConfirmationToken;
import com.example.eCARMARKET.Backend.models.ProfileForm;
import com.example.eCARMARKET.Backend.repositories.ProfileFormRepository;
import com.example.eCARMARKET.Backend.services.ClientService;
import com.example.eCARMARKET.Backend.services.ConfirmationTokenService;
import com.example.eCARMARKET.Backend.services.ProfileFormService;
import com.example.eCARMARKET.Backend.services.RegistrationService;
import com.example.eCARMARKET.Backend.services.email.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api")
public class ClientRestController {

    @Autowired
    private ClientService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ProfileFormService profileFormService;

    @Operation(summary = "Post a new client")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Forbidden",
                    content = @Content
            )
    })

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> createMemberClient(@RequestBody Client client) {
        try{
        client.setEncodedPassword(passwordEncoder.encode(client.getEncodedPassword()));
        userService.save(client);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),client);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        //SEND EMAIL
        String link = "http://localhost:8080/api/register/confirm?token="+token;
        emailService.send(client.getEmail(), registrationService.buildEmail(client.getName(),link));
        URI location = fromCurrentRequest().path("/clients/{id}")
                .buildAndExpand(client.getId()).toUri();

        return ResponseEntity.created(location).body(client);}
        catch (Exception e){
            return new  ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/register/confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }

    //GET USER INFO
    @Operation(summary = "Get user logged in the application")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the user",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)
                    )}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            )
    })

    @GetMapping("/me")
    public ResponseEntity<Client> userLogged(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            return ResponseEntity.ok(userService.findByEmail(principal.getName()).orElseThrow());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/me/")
    public ResponseEntity<Optional<Client>> updateUser(HttpServletRequest request, @RequestBody Client updated){
        Principal principal = request.getUserPrincipal();
        Client user = userService.findByEmail(principal.getName()).orElseThrow();
        if (!updated.getName().equals("")){
            user.setName(updated.getName());
        }if (!updated.getSurname().equals("")){
            user.setSurname(updated.getSurname());
        }if (!updated.getEmail().equals("")){
            user.setEmail(updated.getEmail());
        }if (!updated.getEncodedPassword().equals("")){
            String pass= passwordEncoder.encode(updated.getEncodedPassword());
            user.setEncodedPassword(pass);
        }
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   //POST PROFILE_FORM DUE TO GENERATE PERSONAL INFO
    @PostMapping("/me/profile/")
    public ResponseEntity<ProfileForm> postFormulary(@RequestBody ProfileForm profileForm,HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        profileFormService.save(profileForm);
        if(principal != null){
            Client client = userService.findByEmail(principal.getName()).orElseThrow();
            client.setProfileForm(profileForm);
        }  URI location = fromCurrentRequest().path("")
                .buildAndExpand(profileForm.getId()).toUri();
        return ResponseEntity.created(location).body(profileForm);
    }

    @GetMapping("/me/profile")
    public ResponseEntity<ProfileForm> getFormulary(HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        Client client = userService.findByEmail(principal.getName()).orElseThrow();
        return new ResponseEntity<>(client.getProfileForm(),HttpStatus.OK);
    }

}