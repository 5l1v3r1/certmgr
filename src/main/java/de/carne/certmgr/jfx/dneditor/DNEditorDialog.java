/*
 * Copyright (c) 2015-2020 Holger de Carne and contributors, All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.carne.certmgr.jfx.dneditor;

import java.io.IOException;

import javax.security.auth.x500.X500Principal;

import de.carne.jfx.stage.StageController;
import javafx.scene.control.Dialog;

/**
 * DN editor dialog.
 */
public class DNEditorDialog extends Dialog<X500Principal> {

	private DNEditorDialog(DNEditorController controller) {
		setResultConverter(controller);
	}

	/**
	 * Load the preferences dialog.
	 *
	 * @param owner The stage controller owning this dialog.
	 * @return The constructed controller which is bound to the newly created dialog.
	 * @throws IOException if an I/O error occurs during dialog loading.
	 */
	public static DNEditorController load(StageController owner) throws IOException {
		return owner.loadDialog((c) -> new DNEditorDialog(c), DNEditorController.class);
	}

}
