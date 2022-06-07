package com.localhost.utilitiesinfo;

import com.localhost.productinfo.UtilitiesSteps;
import com.localhost.testbase.TestBase;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class UtilitiesCURDTestWithSteps extends TestBase {
@Steps
    UtilitiesSteps utilitiesSteps;
    @Test
    public void test001() {
        utilitiesSteps.getVersiondetal().statusCode(200);
        utilitiesSteps.getHealthcheckupDetail().statusCode(200);
    }


}
