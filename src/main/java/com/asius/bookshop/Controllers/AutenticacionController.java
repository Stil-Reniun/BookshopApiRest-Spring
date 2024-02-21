package com.asius.bookshop.Controllers;
import com.asius.bookshop.Config.JwtUtilies;
import com.asius.bookshop.Entity.UsersEntity;
import com.asius.bookshop.Entity.jwtRequest;
import com.asius.bookshop.Entity.jwtResponse;
import com.asius.bookshop.Services.implement.UserDetailsServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@RequestMapping("/authentication")
@CrossOrigin("*")
public class AutenticacionController {
    @Autowired
    private UserDetailsServicesImpl userDetail;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilies jwtUtiles;

    @GetMapping("/userloggin")
    public UsersEntity getUser (Principal principal){
        return (UsersEntity) userDetail.loadUserByUsername(principal.getName());
    }

    @PostMapping("/generateToken")
    public ResponseEntity<?> generateToken(@RequestBody jwtRequest jwtR) throws Exception{
        try {
            this.autenticar(jwtR.getUsername(),jwtR.getPassword());
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception ("User incorrectly registered");
        }

        UserDetails userDetails = userDetail.loadUserByUsername(jwtR.getUsername());
        String token = jwtUtiles.generateToken(userDetails);

        return ResponseEntity.ok(new jwtResponse(token));
    }

    public void autenticar (String username,String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("User Disabled" + e.getMessage());
        }catch (BadCredentialsException be){
            throw new Exception("Wrong Credential" + be.getMessage());
        }
    }


}
