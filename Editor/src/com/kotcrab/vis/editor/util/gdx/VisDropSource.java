/*
 * Copyright 2014-2015 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kotcrab.vis.editor.util.gdx;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;
import com.badlogic.gdx.utils.Align;
import com.kotcrab.vis.editor.scene.EditorObject;
import com.kotcrab.vis.editor.util.EditorObjectProvider;
import com.kotcrab.vis.ui.widget.VisLabel;

public class VisDropSource extends Source {
	private final DragAndDrop dragAndDrop;
	private EditorObject object;

	private boolean disposeOnNullTarget;

	private String viewText;
	private EditorObjectProvider provider;

	public VisDropSource (DragAndDrop dragAndDrop, Actor actor) {
		super(actor);
		this.dragAndDrop = dragAndDrop;
	}

	public VisDropSource defaultView (String text) {
		this.viewText = text;
		return this;
	}

	public VisDropSource setObjectProvider (EditorObjectProvider provider) {
		this.provider = provider;
		return this;
	}

	public VisDropSource disposeOnNullTarget () {
		disposeOnNullTarget = true;
		return this;
	}

	@Override
	public Payload dragStart (InputEvent event, float x, float y, int pointer) {
		Payload payload = new Payload();

		object = provider.newInstance();
		payload.setObject(object);

		Label label = new VisLabel(viewText);
		label.setAlignment(Align.center);
		payload.setDragActor(label);

		dragAndDrop.setDragActorPosition(-label.getWidth() / 2, label.getHeight() / 2);

		return payload;
	}

	@Override
	public void dragStop (InputEvent event, float x, float y, int pointer, Payload payload, Target target) {
		if (target == null && disposeOnNullTarget)
			object.dispose();
	}
}
