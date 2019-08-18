package com.marcosbarbero.lab.sec.oauth.jwt.ds.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/me")
public class UserController {
	
	
	// curl localhost:9100/me -H "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTY1ODQyNjU1LCJhdXRob3JpdGllcyI6WyJST0xFX0NMSUVOVCJdLCJqdGkiOiJkMzU2MzA3MC0zMmJkLTRiNGMtYTM2My1iM2M3ZDU0MDAyYzkiLCJjbGllbnRfaWQiOiJjbGllbnRJZCJ9.Thq2uSV8oJ_283t6rI5YJ2WXqWeKCHzSHzIjP00PNKe6nYBiNHOvjMPH7Quo7sZFXW5AuCFoV-uZFg3lPRkqcO4c2F0j0vVoKkZIYpVRr0kb6iwI30fjQHlpVRCXxuuGSX_pAqSkoBJ4q4jIhuYZ0cKf9ri0pms_9ClTyyGiSXHyP8p-y0i_1R_a-9QFCKxdRpVl7ArrHoW-TBI0ZR3RIusL8p7rgRgx3Mn-2cUh3ymqa_hAvh9ZdFYTJag-UaadFBUKqJ8dHx5f60D8JPaLHsjm3TMgzRdB2pnc2iFNZyxoqMhKkSqFZEEBswRv6lUhKfXz8agTb8dk3ezcBACsjQ"

    @GetMapping
    //@PreAuthorize("hasRole('ROLE_USER')")
    @PreAuthorize("#oauth2.hasScope('read')")
    //#oauth2.hasScope('read')
    //@PreAuthorize("hasRole('ROLE_CLIENT')")
    public ResponseEntity<Principal> get(final Principal principal) {
        return ResponseEntity.ok(principal);
    }
    
    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping("/test")
    public ResponseEntity<String> test() {
    	return ResponseEntity.ok("this is testing");
    }

}
