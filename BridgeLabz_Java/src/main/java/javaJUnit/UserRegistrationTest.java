
package javaJUnit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    // UC1: First name happy test
    @Test
    void testValidFirstName() {
        assertTrue(UserRegistration.validateFirstName("Ritika"));
    }

    // UC1: First name sad test
    @Test
    void testInvalidFirstName() {
        assertFalse(UserRegistration.validateFirstName("ri"));
    }

    // UC2: Last name happy test
    @Test
    void testValidLastName() {
        assertTrue(UserRegistration.validateLastName("Sharma"));
    }

    // UC2: Last name sad test
    @Test
    void testInvalidLastName() {
        assertFalse(UserRegistration.validateLastName("sh"));
    }

    // UC3: Email happy test
    @Test
    void testValidEmail() {
        assertTrue(UserRegistration.validateEmail("abc.xyz@bl.co.in"));
    }

    // UC3: Email sad test
    @Test
    void testInvalidEmail() {
        assertFalse(UserRegistration.validateEmail("abc@bl"));
    }

    // UC4: Mobile happy test
    @Test
    void testValidMobile() {
        assertTrue(UserRegistration.validateMobile("91 9919819801"));
    }

    // UC4: Mobile sad test
    @Test
    void testInvalidMobile() {
        assertFalse(UserRegistration.validateMobile("919919819801"));
    }

    // UC5-UC8: Password happy test
    @Test
    void testValidPassword() {
        assertTrue(UserRegistration.validatePassword("Hello123@"));
    }

    // UC5-UC8: Password sad test
    @Test
    void testInvalidPassword() {
        assertFalse(UserRegistration.validatePassword("hello123"));
    }
}
