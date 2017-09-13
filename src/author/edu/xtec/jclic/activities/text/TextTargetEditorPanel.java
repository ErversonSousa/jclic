/*
 * File    : TextTargetEditorPanel.java
 * Created : 23-mai-2003 10:25
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

package edu.xtec.jclic.activities.text;

import edu.xtec.jclic.bags.MediaBagEditor;
import edu.xtec.jclic.beans.SmallIntEditor;
import edu.xtec.jclic.beans.TextListEditor;
import edu.xtec.jclic.boxes.ActiveBoxContent;
import edu.xtec.jclic.boxes.ActiveBoxContentEditor;
import edu.xtec.jclic.boxes.JPanelActiveBox;
import edu.xtec.util.Options;
import edu.xtec.util.Resizer;
import edu.xtec.util.ResizerPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;

/**
 *
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.09.16
 */
public class TextTargetEditorPanel extends javax.swing.JPanel implements java.beans.PropertyChangeListener, java.awt.event.ActionListener, Resizer.ResizerListener {
    
    protected Options options;
    TextTarget textTarget;
    //protected boolean modified;
    JPanelActiveBox jpab;
    Resizer resizer;
    //TextActivityEditorTextPanel parentPanel;
    MediaBagEditor mbe;
    
    protected static final int[] popValues={TextTarget.NO_INFO, 
    TextTarget.INFO_ALWAYS, TextTarget.INFO_ON_ERROR, TextTarget.INFO_ON_DEMAND};
    protected static final String[] popKeys={"no", "always", "onError", "onDemand"};
    protected String[] popItems;
    
    protected static final Map<Options, TextTargetEditorPanel> panels=new HashMap<Options, TextTargetEditorPanel>(1);
    
    /** Creates new form TextTargetPanel */
    public TextTargetEditorPanel(Options options, MediaBagEditor mbe) {
        this.options=options;
        this.mbe=mbe;
        popItems=new String[popKeys.length];
        for(int i=0; i<popItems.length; i++)
            popItems[i]=options.getMsg("edit_text_act_popup_"+popKeys[i]);
        
        initComponents();
        jpab=new JPanelActiveBox(null, null, popupPreview);
        jpab.catchMouseEvents=false;
        jpab.setPreferredSize(popupPreview.getPreferredSize());
        popupPreview.setBounds(0, 0, popupPreview.getPreferredSize().width, popupPreview.getPreferredSize().height);
        popupPreview.add(jpab);
        resizer=new Resizer(jpab, null, true, this);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    popupOptions = new javax.swing.ButtonGroup();
    javax.swing.JPanel formatPanel = new javax.swing.JPanel();
    answerLb = new javax.swing.JLabel();
    answerListEditor = new TextListEditor(options);
    maxlenLb = new javax.swing.JLabel();
    maxLenEditor = new edu.xtec.jclic.beans.SmallIntEditor();
    fillingChLb = new javax.swing.JLabel();
    fillingCh = new javax.swing.JTextField();
    iniLenLb = new javax.swing.JLabel();
    iniLenEditor = new edu.xtec.jclic.beans.SmallIntEditor();
    iniTextLb = new javax.swing.JLabel();
    iniText = new javax.swing.JTextField();
    listChk = new javax.swing.JCheckBox();
    listEditor = new TextListEditor(options);
    javax.swing.JPanel popupPanel = new javax.swing.JPanel();
    typeCombo = new javax.swing.JComboBox<Object>(popItems);
    cardPanel = new javax.swing.JPanel();
    javax.swing.JPanel nullPanel = new javax.swing.JPanel();
    javax.swing.JPanel editPanel = new javax.swing.JPanel();
    javax.swing.JScrollPane popupPreviewScroll = new javax.swing.JScrollPane();
    popupPreview = new ResizerPanel();
    onlyPlayChk = new javax.swing.JCheckBox();
    delayLb = new javax.swing.JLabel();
    delayEditor = new edu.xtec.jclic.beans.SmallIntEditor();
    maxTimeLb = new javax.swing.JLabel();
    maxTimeEditor = new edu.xtec.jclic.beans.SmallIntEditor();

    setLayout(new java.awt.GridBagLayout());

    formatPanel.setLayout(new java.awt.GridBagLayout());

    answerLb.setText(options.getMsg("edit_text_act_answer_label"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    formatPanel.add(answerLb, gridBagConstraints);

    answerListEditor.setPreferredSize(new java.awt.Dimension(180, 100));
    answerListEditor.addPropertyChangeListener(TextListEditor.PROP_LIST, this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 1.0;
    formatPanel.add(answerListEditor, gridBagConstraints);

    maxlenLb.setText(options.getMsg("edit_text_act_maxLen"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    formatPanel.add(maxlenLb, gridBagConstraints);

    maxLenEditor.setToolTipText(options.getMsg("edit_text_act_maxLen_tooltip"));
    maxLenEditor.setMax(999);
    maxLenEditor.setMin(1);
    maxLenEditor.addPropertyChangeListener(SmallIntEditor.PROP_VALUE, this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    formatPanel.add(maxLenEditor, gridBagConstraints);

    fillingChLb.setText(options.getMsg("edit_text_act_fillingChar"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    formatPanel.add(fillingChLb, gridBagConstraints);

    fillingCh.setToolTipText(options.getMsg("edit_text_act_maxLen_tooltip"));
    fillingCh.setColumns(1);
    fillingCh.setText("_");
    fillingCh.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    formatPanel.add(fillingCh, gridBagConstraints);

    iniLenLb.setText(options.getMsg("edit_text_act_iniLen"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    formatPanel.add(iniLenLb, gridBagConstraints);

    iniLenEditor.setToolTipText(options.getMsg("edit_text_act_iniLen_tooltip"));
    iniLenEditor.setMax(999);
    iniLenEditor.setMin(1);
    iniLenEditor.addPropertyChangeListener(SmallIntEditor.PROP_VALUE, this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    formatPanel.add(iniLenEditor, gridBagConstraints);

    iniTextLb.setText(options.getMsg("edit_text_act_iniText"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    formatPanel.add(iniTextLb, gridBagConstraints);

    iniText.setToolTipText(options.getMsg("edit_text_act_iniText_tooltip"));
    iniText.setPreferredSize(new java.awt.Dimension(140, 21));
    iniText.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    formatPanel.add(iniText, gridBagConstraints);

    listChk.setToolTipText(options.getMsg("edit_text_act_list_tooltip"));
    listChk.setText(options.getMsg("edit_text_act_list"));
    listChk.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 0, 2);
    formatPanel.add(listChk, gridBagConstraints);

    listEditor.setPreferredSize(new java.awt.Dimension(180, 100));
    listEditor.setEnabled(false);
    listEditor.addPropertyChangeListener(TextListEditor.PROP_LIST, this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    formatPanel.add(listEditor, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    add(formatPanel, gridBagConstraints);

    popupPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(options.getMsg("edit_text_act_popup")));
    popupPanel.setLayout(new java.awt.GridBagLayout());

    typeCombo.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    popupPanel.add(typeCombo, gridBagConstraints);

    cardPanel.setLayout(new java.awt.CardLayout());
    cardPanel.add(nullPanel, "card2");

    editPanel.setLayout(new java.awt.GridBagLayout());

    popupPreviewScroll.setPreferredSize(new java.awt.Dimension(200, 40));

    popupPreview.setPreferredSize(new java.awt.Dimension(300, 300));
    popupPreview.setLayout(null);
    popupPreviewScroll.setViewportView(popupPreview);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    editPanel.add(popupPreviewScroll, gridBagConstraints);

    onlyPlayChk.setText(options.getMsg("edit_text_act_popup_onlyPlay"));
    onlyPlayChk.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    editPanel.add(onlyPlayChk, gridBagConstraints);

    delayLb.setText(options.getMsg("edit_text_act_popup_delay"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    editPanel.add(delayLb, gridBagConstraints);

    delayEditor.setMax(9999);
    delayEditor.addPropertyChangeListener(SmallIntEditor.PROP_VALUE, this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 2, 4, 2);
    editPanel.add(delayEditor, gridBagConstraints);

    maxTimeLb.setText(options.getMsg("edit_text_act_popup_maxTime"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    editPanel.add(maxTimeLb, gridBagConstraints);

    maxTimeEditor.setMax(9999);
    maxTimeEditor.addPropertyChangeListener(SmallIntEditor.PROP_VALUE, this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 2, 4, 2);
    editPanel.add(maxTimeEditor, gridBagConstraints);

    cardPanel.add(editPanel, "card3");

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    popupPanel.add(cardPanel, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    add(popupPanel, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

    /** Getter for property textTarget.
     * @return Value of property textTarget.
     */
    public edu.xtec.jclic.activities.text.TextTarget getTextTarget() {
        collectData();
        return textTarget;
    }    
    
    /** Setter for property textTarget.
     * @param textTarget New value of property textTarget.
     */
    public void setTextTarget(edu.xtec.jclic.activities.text.TextTarget textTarget) {
        //if(textTarget!=this.textTarget){
            //collectData();
            this.textTarget = textTarget;
            answerListEditor.setTextList(textTarget!=null ? textTarget.answer : null);
            listChk.setSelected(textTarget!=null && textTarget.isList);
            maxLenEditor.setValue(textTarget!=null ? textTarget.maxLenResp : 1);
            fillingCh.setText(textTarget!=null ? new String(new char[]{textTarget.iniChar}) : "_");
            iniLenEditor.setValue(textTarget!=null ? textTarget.numIniChars : 1);
            iniText.setText(textTarget!=null ? (textTarget.iniText!=null ? textTarget.iniText : "") : "");
            listEditor.setTextList(textTarget!=null ? textTarget.options : null);
            
            int v=0;
            if(textTarget!=null)
                v=Math.max(Arrays.binarySearch(popValues, textTarget.infoMode), 0);
            typeCombo.setSelectedIndex(v);
            
            delayEditor.setValue(textTarget!=null ? textTarget.popupDelay : 0);
            maxTimeEditor.setValue(textTarget!=null ? textTarget.popupMaxTime : 0);
            onlyPlayChk.setSelected(textTarget!=null && textTarget.onlyPlay);
            ActiveBoxContent abc=textTarget!=null ? textTarget.popupContent : null;
            if(abc==null && textTarget!=null){
                abc=new ActiveBoxContent();
                abc.setDimension(new Dimension(100, 40));
            }
            jpab.setActiveBoxContent(abc);
            if(abc!=null && abc.dimension!=null){
                jpab.setBounds(0, 0, abc.dimension.width, abc.dimension.height);
            }
            checkEnabled();
            //setModified(false);
        //}
    }
    
    /*
    public boolean isModified(){
        return modified ||  answerListEditor.isModified() || listEditor.isModified();
    }
    
    public void setModified(boolean value){
        modified=value;
        if(value)
            parentPanel.setModified(true);
    }
     */
    
    public void propertyChange(java.beans.PropertyChangeEvent ev) {
        //setModified(true);
    }    
    
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if(evt!=null){
            checkEnabled();
            //setModified(true);
        }
    }
    
    public void checkEnabled(){
        answerListEditor.setEnabled(textTarget!=null);
        maxLenEditor.setEnabled(textTarget!=null && !listChk.isSelected());
        fillingCh.setEnabled(textTarget!=null && !listChk.isSelected());
        iniLenEditor.setEnabled(textTarget!=null && !listChk.isSelected());
        iniText.setEnabled(textTarget!=null);
        listChk.setEnabled(textTarget!=null);
        listEditor.setEnabled(textTarget!=null && listChk.isSelected());
        
        typeCombo.setEnabled(textTarget!=null);
        
        int v=typeCombo.getSelectedIndex();
        
        delayEditor.setEnabled(textTarget!=null && v>0);
        maxTimeEditor.setEnabled(textTarget!=null && v>0);
        onlyPlayChk.setEnabled(textTarget!=null && v>0);
        resizer.setEnabled(textTarget!=null && v>0);
        
        if(typeCombo.isEnabled() && typeCombo.getSelectedIndex()>0)
            ((CardLayout)cardPanel.getLayout()).last(cardPanel);
        else
            ((CardLayout)cardPanel.getLayout()).first(cardPanel);
        
    }
    
    public void collectData(){
        if(textTarget!=null /*&& isModified()*/){
            String[] answers=answerListEditor.getTextList();
            if(answers.length>0)
                textTarget.answer=answers;
            if(listChk.isSelected()){
                String[] textList=listEditor.getTextList();
                if(textList.length>0){
                    textTarget.isList=true;
                    textTarget.options=textList;
                }
            }
            else{
                textTarget.isList=false;
                textTarget.options=null;
                textTarget.numIniChars=Math.max(1, iniLenEditor.getValue());
                textTarget.maxLenResp=Math.max(1, maxLenEditor.getValue());
                textTarget.iniText=edu.xtec.util.StrUtils.nullableString(iniText.getText());
                String s=fillingCh.getText();
                textTarget.iniChar= (s!=null && s.length()>0) ? s.charAt(0) : '_';
            }
            /*
            textTarget.infoMode
            = popupAlwaysOption.isSelected() ? TextTarget.INFO_ALWAYS
            : popupOnErrorOption.isSelected() ? TextTarget.INFO_ON_ERROR
            : popupOnDemandOption.isSelected() ? TextTarget.INFO_ON_DEMAND
            : TextTarget.NO_INFO;
             **/
            
            textTarget.infoMode=popValues[Math.max(0, typeCombo.getSelectedIndex())];
            textTarget.popupDelay=delayEditor.getValue();
            textTarget.popupMaxTime=maxTimeEditor.getValue();
            textTarget.onlyPlay=onlyPlayChk.isSelected();            
            if(textTarget.infoMode!=TextTarget.NO_INFO){
                textTarget.popupContent=jpab.getActiveBoxContent();
            }
        }
    }
    
    public void resizeObjectTo(Rectangle r, JComponent jc){
        if(jc==jpab){
            jpab.setBounds(r.x, r.y, r.width, r.height);
            Dimension d=new Dimension(r.width, r.height);
            jpab.getActiveBoxContent().setDimension(d);
            jpab.setPreferredSize(d);
            jpab.setMaximumSize(d);
            //setModified(true);
        }       
    }
    
    public void editObject(Rectangle r, JComponent jc, Point pt){
        if(jc==jpab){
            ActiveBoxContent abc=ActiveBoxContentEditor.getActiveBoxContent(
            jpab.ab.getContent(), jpab, options,
            mbe, jpab.ab);
            if(abc!=null){
                Dimension d=abc.getDimension();
                jpab.setActiveBoxContent(abc);                
                if(d!=null)
                    jpab.setBounds(0, 0, d.width, d.height);
                //setModified(true);
            }
        }
    }
    
    
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel answerLb;
  private edu.xtec.jclic.beans.TextListEditor answerListEditor;
  private javax.swing.JPanel cardPanel;
  private edu.xtec.jclic.beans.SmallIntEditor delayEditor;
  private javax.swing.JLabel delayLb;
  private javax.swing.JTextField fillingCh;
  private javax.swing.JLabel fillingChLb;
  private edu.xtec.jclic.beans.SmallIntEditor iniLenEditor;
  private javax.swing.JLabel iniLenLb;
  private javax.swing.JTextField iniText;
  private javax.swing.JLabel iniTextLb;
  private javax.swing.JCheckBox listChk;
  private edu.xtec.jclic.beans.TextListEditor listEditor;
  private edu.xtec.jclic.beans.SmallIntEditor maxLenEditor;
  private edu.xtec.jclic.beans.SmallIntEditor maxTimeEditor;
  private javax.swing.JLabel maxTimeLb;
  private javax.swing.JLabel maxlenLb;
  private javax.swing.JCheckBox onlyPlayChk;
  private javax.swing.ButtonGroup popupOptions;
  private javax.swing.JPanel popupPreview;
  private javax.swing.JComboBox<Object> typeCombo;
  // End of variables declaration//GEN-END:variables

    public static boolean editTextTarget(TextTarget tt, Options options, MediaBagEditor mbe, Component parent){
        TextTargetEditorPanel ttep=panels.get(options);
        if(ttep==null){
            ttep=new TextTargetEditorPanel(options, mbe);
            panels.put(options, ttep);
        }
        ttep.setTextTarget(tt);        
        boolean result=options.getMessages().showInputDlg(parent, ttep, "edit_text_act_target");
        if(result)
            ttep.collectData();
        ttep.setTextTarget(null);
        return result;
    }
    
}
