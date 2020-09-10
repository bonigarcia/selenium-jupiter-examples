var webdriver = require("selenium-webdriver");

async function basicTest() {
	var seleniumServerUrl = "http://localhost:4042/wd/hub";
	var capabilities = {
		browserName : "chrome",
		version: "85.0"
	};

	try {
		var driver = await new webdriver.Builder().usingServer(seleniumServerUrl)
				.withCapabilities(capabilities).build();

		var sutUrl = "https://bonigarcia.github.io/selenium-jupiter/";
		await driver.get(sutUrl);

		await driver.getTitle().then(function(title) {
			console.log("The title of " + sutUrl + " is '" + title + "'")
		});

	} catch (err) {
		console.error("Something went wrong!\n", err.stack);

	} finally {
		if (driver) {
			driver.quit();
		}
	}
}

basicTest();