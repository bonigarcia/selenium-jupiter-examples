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

import static com.codeborne.selenide.Condition.visible;
import static io.github.bonigarcia.seljup.BrowserType.OPERA;
import static org.openqa.selenium.By.linkText;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;

import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@Tag("docker")
class DockerSelenideTest {

    @RegisterExtension
    static SeleniumJupiter seleniumJupiter = new SeleniumJupiter();

    @BeforeAll
    static void setup() {
        seleniumJupiter.getConfig().setVnc(true);
        seleniumJupiter.getConfig().setRecording(true);
        seleniumJupiter.getConfig().setRecordingVideoScreenSize("1920x1080");
    }

    @Test
    void testDockerSelenide(@DockerBrowser(type = OPERA) SelenideDriver driver)
            throws InterruptedException {
        driver.open("https://bonigarcia.github.io/selenium-jupiter/");
        SelenideElement about = driver.$(linkText("About"));
        about.shouldBe(visible);
        about.click();

        Thread.sleep(20000);
    }

}
