package javaJUnit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorParameterizedTest {

    // UC11: Test multiple email addresses
    @ParameterizedTest

    // Email input and expected validation result
    @CsvSource({
            "abc.xyz@bl.co.in, true",
            "abc@bl.co, true",
            "abc.xyz@bl.co, true",
            "abc@bl.co.in, true",
            "abc@bl, false",
            "abc.bl.co.in, false",
            "abc@bl.c, false",
            "abc@bl.co.in.extra, false",
            "'abc xyz@bl.co.in', false"
    })

    void testMultipleEmails(String email, boolean expected) {

        // Compare actual validation result with expected result
        assertEquals(
                expected,
                UserRegistration.validateEmail(email)
        );
    }
}
