package com.cucumber;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriverService;

import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestRunStarted;
import cucumber.api.formatter.Formatter;

public class MSChromeDriverServiceHandler implements Formatter {
	private boolean enablePlugin;
	public static ChromeDriverService CHROME_DRIVER_SERVICE;

	public MSChromeDriverServiceHandler(String enablePlugin) {
		this.enablePlugin = Boolean.valueOf(enablePlugin);
	}

	public void handleRunStartedEvent(TestRunStarted runStartedEvent) {
		if (CHROME_DRIVER_SERVICE != null && CHROME_DRIVER_SERVICE.isRunning()) {
			return;
		}

		CHROME_DRIVER_SERVICE = new ChromeDriverService.Builder().build();
		try {
			CHROME_DRIVER_SERVICE.start();
		} catch (IOException e) {
			System.out.println("Error Occured while starting ChromeDriver making it as null");
			System.out.println("Error is :: " + e.getMessage());
			CHROME_DRIVER_SERVICE = null;
			throw new RuntimeException("Error Occured while Starting Chrome", e);
		}
	}

	@Override
	public void setEventPublisher(EventPublisher arg0) {
		// TODO Auto-generated method stub
		if (this.enablePlugin) {
			arg0.registerHandlerFor(TestRunStarted.class, this::handleRunStartedEvent);
			arg0.registerHandlerFor(TestRunFinished.class, this::handleRunCompletedEvent);
		}
	}

	public void handleRunCompletedEvent(TestRunFinished runFinishedEvent) {
		if (CHROME_DRIVER_SERVICE != null && CHROME_DRIVER_SERVICE.isRunning()) {
			CHROME_DRIVER_SERVICE.stop();
		}
	}
}
