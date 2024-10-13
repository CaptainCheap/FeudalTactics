// SPDX-License-Identifier: GPL-3.0-or-later

package de.sesu8642.feudaltactics.menu.information.ui;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.google.common.eventbus.EventBus;

import de.sesu8642.feudaltactics.events.ScreenTransitionTriggerEvent;
import de.sesu8642.feudaltactics.events.ScreenTransitionTriggerEvent.ScreenTransitionTarget;
import de.sesu8642.feudaltactics.menu.common.dagger.MenuCamera;
import de.sesu8642.feudaltactics.menu.common.dagger.MenuViewport;
import de.sesu8642.feudaltactics.menu.common.ui.ExceptionLoggingChangeListener;
import de.sesu8642.feudaltactics.menu.common.ui.GameScreen;

@Singleton
public class InformationMenuPage2Screen extends GameScreen {

	@Inject
	public InformationMenuPage2Screen(EventBus eventBus, @MenuCamera OrthographicCamera camera,
			@MenuViewport Viewport viewport, InformationMenuPage2Stage menuStage) {
		super(camera, viewport, menuStage);
		List<TextButton> buttons = menuStage.getButtons();
		buttons.get(0).addListener(new ExceptionLoggingChangeListener(
				() -> eventBus.post(new ScreenTransitionTriggerEvent(ScreenTransitionTarget.CHANGELOG_SCREEN))));
		buttons.get(1).addListener(new ExceptionLoggingChangeListener(() -> eventBus
				.post(new ScreenTransitionTriggerEvent(ScreenTransitionTarget.DEPENDENCY_LICENSES_SCREEN))));
		buttons.get(2).addListener(new ExceptionLoggingChangeListener(() -> Gdx.net
				.openURI("https://raw.githubusercontent.com/Sesu8642/FeudalTactics/master/privacy_policy.txt")));
		buttons.get(3).addListener(new ExceptionLoggingChangeListener(() -> eventBus
				.post(new ScreenTransitionTriggerEvent(ScreenTransitionTarget.INFORMATION_MENU_SCREEN))));
		buttons.get(4).addListener(new ExceptionLoggingChangeListener(
				() -> eventBus.post(new ScreenTransitionTriggerEvent(ScreenTransitionTarget.MAIN_MENU_SCREEN))));
	}

}
