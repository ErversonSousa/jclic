/*
 * File    : ComplexAssociationEditor.java
 * Created : 10-oct-2002 15:40
 * By      : fbusquets
 *
 * JClic - Authoring and playing system for educational activities
 *
 * Copyright (C) 2000 - 2005 Francesc Busquets & Departament
 * d'Educacio de la Generalitat de Catalunya
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details (see the LICENSE file).
 */

package edu.xtec.jclic.activities.associations;

import edu.xtec.jclic.Activity;
import edu.xtec.jclic.ActivityEditorPanel;

/**
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.08.29
 */
public class ComplexAssociationEditor extends SimpleAssociationEditor {

  /** Creates a new instance of ComplexAssociationEditor */
  public ComplexAssociationEditor(Activity act) {
    super(act);
  }

  @Override
  protected void createPanels(ActivityEditorPanel panel) {
    panel.addInternalPanel(ActivityEditorPanel.DOUBLE_REL_ALT, null, null);
  }
}
