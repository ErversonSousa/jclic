/*
 * File    : TagReplaceEditor.java
 * Created : 02-oct-2006 18:30
 * By      : fbusquets
 *
 * JClic - Authoring and playing system for educational activities
 *
 * Copyright (C) 2000 - 2018 Francesc Busquets & Departament
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

package edu.xtec.jclic.automation.tagreplace;

import edu.xtec.jclic.automation.AutoContentProviderEditor;
import edu.xtec.jclic.edit.EditorPanel;
import edu.xtec.util.Options;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.09.16
 */
public class TagReplaceEditor extends AutoContentProviderEditor {

  /** Creates a new instance of TagReplaceEditor */
  public TagReplaceEditor(TagReplace tagReplace) {
    super(tagReplace);
  }

  private static Map<Options, EditorPanel> panels = new HashMap<Options, EditorPanel>();

  public EditorPanel createEditorPanel(Options options) {
    EditorPanel panel = panels.get(options);
    if (panel == null) {
      panel = new TagReplaceEditorPanel(options);
      panels.put(options, panel);
    }
    return panel;
  }

  public Class getEditorPanelClass() {
    return TagReplaceEditorPanel.class;
  }
}
