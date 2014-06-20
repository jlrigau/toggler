package fr.jlrigau.toggler;

import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.fest.assertions.api.Assertions.assertThat;

public class TogglerPropertiesTest {

    private Toggler toggler;

    @Before
    public void setUp() {
        Properties features = new Properties();

        features.setProperty("activeFeature", "true");
        features.setProperty("notActiveFeature", "false");

        toggler = new Toggler(features);
    }

    @Test
    public void should_check_if_feature_is_active() {
        // Given
        String feature = "activeFeature";

        // When
        boolean active = toggler.isActive(feature);

        // Then
        assertThat(active).isTrue();
    }

    @Test
    public void should_check_if_feature_is_not_active() {
        // Given
        String feature = "notActiveFeature";

        // When
        boolean active = toggler.isActive(feature);

        // Then
        assertThat(active).isFalse();
    }

}
