package Utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConfigTest {

    @Test
    void shouldReturnDefaultBaseUrlWhenNoSystemPropertyIsSet() {
        assertEquals("https://www.google.com/ncr", Config.getBaseUrl());
    }
}
