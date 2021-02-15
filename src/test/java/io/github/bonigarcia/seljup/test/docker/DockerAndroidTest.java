/*
 * (C) Copyright 2019 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia.seljup.test.docker;

import static com.google.common.truth.Truth.assertThat;
import static io.github.bonigarcia.seljup.BrowserType.ANDROID;
import static org.junit.jupiter.api.condition.OS.LINUX;

import org.junit.jupiter.api.BeforeAll;
// tag::snippet-in-doc[]
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@EnabledOnOs(LINUX)
class DockerAndroidTest {

    @RegisterExtension
    static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

    @BeforeAll
    static void setup() {
        seleniumJupiter.getConfig().setVnc(true);
        seleniumJupiter.getConfig().setRecording(true);
        seleniumJupiter.getConfig().setAndroidDeviceStartupTimeoutSec(15);
    }

    @Test
    void testAndroid(
            @DockerBrowser(type = ANDROID, version = "9.0", deviceName = "Samsung Galaxy S6") RemoteWebDriver driver)
            throws InterruptedException {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle())
                .containsMatch("JUnit 5 extension for Selenium");

        Thread.sleep(20000);
    }

}
