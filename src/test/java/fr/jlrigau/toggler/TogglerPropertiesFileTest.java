package fr.jlrigau.toggler;

import com.google.common.io.Resources;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static org.fest.assertions.api.Assertions.assertThat;

public class TogglerPropertiesFileTest {

    private Toggler toggler;

    @Before
    public void setUp() throws IOException {
        Properties features = new Properties();

        features.load(Resources.getResource("features.properties").openStream());

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
