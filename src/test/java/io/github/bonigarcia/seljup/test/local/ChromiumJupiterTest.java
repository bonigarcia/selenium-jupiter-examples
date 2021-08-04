/*
 * (C) Copyright 2021 Boni Garcia (http://bonigarcia.github.io/)
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

import java.nio.file.Path;
import java.util.Optional;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.seljup.Options;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;

@Tag("local")
@ExtendWith(SeleniumJupiter.class)
class ChromiumJupiterTest {

    @Options
    ChromeOptions options = new ChromeOptions();
    {
        Optional<Path> browserPath = WebDriverManager.chromiumdriver()
                .getBrowserPath();
        assumeThat(browserPath).isPresent();
        options.setBinary(browserPath.get().toFile());
    }

    @Test
    void test(ChromeDriver driver) {
        driver.get("https://bonigarcia.org/selenium-jupiter/");
        assertThat(driver.getTitle()).contains("Selenium-Jupiter");
    }

}
