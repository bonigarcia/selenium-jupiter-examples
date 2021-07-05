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
package io.github.bonigarcia.seljup.test.local;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.linkText;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;

import io.github.bonigarcia.seljup.SelenideConfiguration;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@Tag("local")
@ExtendWith(SeleniumJupiter.class)
class SelenideTest {

    @Test
    void testWithSelenideAndChrome(SelenideDriver driver) {
        driver.open("https://bonigarcia.github.io/selenium-jupiter/");
        SelenideElement about = driver.$(linkText("About"));
        about.shouldBe(visible);
        about.click();
    }

    @Test
    void testWithSelenideAndFirefox(
            @SelenideConfiguration(browser = FIREFOX) SelenideDriver driver) {
        driver.open("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.title()).contains("JUnit 5 extension for Selenium");
    }

}
