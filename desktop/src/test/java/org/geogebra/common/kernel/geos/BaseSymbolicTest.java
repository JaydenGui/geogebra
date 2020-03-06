package org.geogebra.common.kernel.geos;

import org.geogebra.common.jre.headless.AppCommon;
import org.geogebra.common.kernel.StringTemplate;
import org.geogebra.common.kernel.arithmetic.SymbolicMode;
import org.geogebra.common.kernel.commands.AlgebraProcessor;
import org.geogebra.common.kernel.commands.AlgebraTest;
import org.geogebra.common.kernel.commands.EvalInfo;
import org.geogebra.common.kernel.kernelND.GeoElementND;
import org.geogebra.common.main.settings.AppConfigCas;
import org.geogebra.test.TestErrorHandler;
import org.geogebra.test.commands.AlgebraTestHelper;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaseSymbolicTest {
    protected AppCommon app;
    protected AlgebraProcessor ap;

    /**
     * Create the app
     */
    @Before
    public void setup() {
        app = AlgebraTest.createApp();
        app.getKernel().setSymbolicMode(SymbolicMode.SYMBOLIC_AV);
        app.getKernel().getParser().setHighPrecisionParsing(true);
        app.setRounding("10");
        ap = app.getKernel().getAlgebraProcessor();
        app.getKernel().getGeoGebraCAS().evaluateGeoGebraCAS("1+1", null,
                StringTemplate.defaultTemplate, app.getKernel());
        app.setConfig(new AppConfigCas());
    }

    public void t(String input, String... expected) {
        AlgebraTestHelper.testSyntaxSingle(input, expected, ap,
                StringTemplate.testTemplate);
    }

	public void t(String input, EvalInfo info, String... expected) {
		GeoElementND result = ap.processAlgebraCommandNoExceptionHandling(input,
				false, TestErrorHandler.INSTANCE, info, null)[0];
		AlgebraTestHelper.assertOneOf(result, expected,
				StringTemplate.testTemplate);
	}

	protected<T extends GeoElement> T add(String text) {
		return (T) ap.processAlgebraCommandNoExceptionHandling(text, false, null, false, null)[0];
	}
}
