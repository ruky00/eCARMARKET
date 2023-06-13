package com.example.eCARMARKET.Backend.controllers;

import com.example.eCARMARKET.Backend.models.Client;
import com.example.eCARMARKET.Backend.models.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Calendar;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
public class ClientRestController {
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
    @PostMapping("/client/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> createMemberClient(@RequestBody Client client) {
        if (client.getType().equals("client")) {
            Calendar c1 = Calendar.getInstance();
            int month = c1.get(Calendar.MONTH);
            client.setEntryDate(month);
            setUserImage(client, new ClassPathResource("static/images/undraw_profile.jpg”).getPath()");
            client.setEncodedPassword(passwordEncoder.encode(client.getEncodedPassword()));
            userService.save(client);
            URI location = fromCurrentRequest().path("/client/{id}")
                .buildAndExpand(client.getId()).toUri();
            return ResponseEntity.created(location).body(client);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private void setUserImage(Client client, String classpathResource){
        try {
            Resource image = new ClassPathResource(classpathResource);
            client.setImage("Default");
            client.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}