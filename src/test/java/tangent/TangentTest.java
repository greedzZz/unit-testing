package tangent;

import greedzZz.tangent.Tangent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TangentTest {
    @ParameterizedTest(name = "tan({0})")
    @ValueSource(doubles = {-Math.PI / 3, -Math.PI / 4, -Math.PI / 6, 0, Math.PI / 6, Math.PI / 4, Math.PI / 3})
    void checkTableValues(double param) {
        assertAll(
                () -> assertEquals(Math.tan(param), Tangent.tangent(param), 0.0001)
        );
    }

    @ParameterizedTest(name = "tan({0})")
    @ValueSource(doubles = {-Math.PI / 2, Math.PI / 2})
    void checkUndefinedValues(double param) {
        assertAll(
                () -> assertEquals(Double.NaN, Tangent.tangent(param))
        );
    }

    @ParameterizedTest(name = "tan({0})")
    @ValueSource(doubles = {1.3, 0.9, 0.6, 0.25, 0, -0.25, -0.6, -0.9, -1.3})
    void checkBetweenTableValues(double param) {
        assertAll(
                () -> assertEquals(Math.tan(param), Tangent.tangent(param), 0.0001)
        );
    }
}
