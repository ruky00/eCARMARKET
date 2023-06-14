package com.example.eCARMARKET.Backend.controllers;

import com.example.eCARMARKET.Backend.models.Client;
import com.example.eCARMARKET.Backend.services.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.security.Principal;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api")
public class ClientRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @PostMapping("/clients/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> createMemberClient(@RequestBody Client client) {
        try{
        client.setEncodedPassword(passwordEncoder.encode(client.getEncodedPassword()));
        userService.save(client);
        URI location = fromCurrentRequest().path("/clients/{id}")
                .buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(location).body(client);}
        catch (Exception e){
            return new  ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    //private void setClientImage(Client client, String classpathResource){
       // try {
        //    Resource image = new ClassPathResource(classpathResource);
        //    client.setImage("Default");
         //   client.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
      //  } catch(Exception e){
      //      System.out.println(e.getMessage());
      //  }
   // }

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
    public ResponseEntity<Client> userLoged(HttpServletRequest request) {
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
        return new ResponseEntity(HttpStatus.OK);
    }

}