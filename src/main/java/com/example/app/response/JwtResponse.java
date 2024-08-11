package com.example.app.response;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dungn
 */
@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
}