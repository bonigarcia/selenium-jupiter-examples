/*
 * (C) Copyright 2019 Boni Garcia (https://bonigarcia.github.io/)
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
package io.github.bonigarcia.seljup.test.remote;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@Tag("remote")
@ExtendWith(SeleniumJupiter.class)
class SauceLabsTest {

    @DriverUrl
    String url = "https://ondemand.eu-central-1.saucelabs.com/wd/hub";

    @DriverCapabilities
    DesiredCapabilities capabilities = new DesiredCapabilities();
    {
        String sauceLabsUser = System.getProperty("sauceLabsUser");
        String sauceLabsKey = System.getProperty("sauceLabsKey");

        capabilities.setCapability("username", sauceLabsUser);
        capabilities.setCapability("accessKey", sauceLabsKey);
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "59.0");
        capabilities.setCapability("name", "selenium-jupiter-and-saucelabs");
    }

    @Test
    void test(RemoteWebDriver driver) throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertThat(driver.getTitle()).contains("Selenium WebDriver");

        Thread.sleep(5000);
    }

}
