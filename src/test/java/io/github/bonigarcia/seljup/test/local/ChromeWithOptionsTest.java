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

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.seljup.Arguments;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
class ChromeWithOptionsTest {
    @Test
    void webrtcTest(
            @Arguments({ "--use-fake-device-for-media-stream",
                    "--use-fake-ui-for-media-stream" }) ChromeDriver driver)
            throws InterruptedException {
        driver.get(
                "https://webrtc.github.io/samples/src/content/devices/input-output/");
        assertThat(driver.findElement(By.id("video")).getTagName())
                .isEqualTo("video");

        Thread.sleep(5000);
    }

    @Test
    void headlessTest(@Arguments("--headless") ChromeDriver driver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle())
                .containsMatch("JUnit 5 extension for Selenium");
    }
}
