package fr.jlrigau.toggler;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.fest.assertions.api.Assertions.assertThat;

public class TogglerTest {

    private Toggler toggler;

    @Before
    public void setUp() {
        HashMap<String, Boolean> features = new HashMap<>();

        features.put("activeFeature", true);
        features.put("notActiveFeature", false);

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
