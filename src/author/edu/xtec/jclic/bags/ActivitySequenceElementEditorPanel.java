/*
 * File    : ActivitySequenceElementEditorPanel.java
 * Created : 08-apr-2003 17:24
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

package edu.xtec.jclic.bags;

import edu.xtec.jclic.beans.NullableObject;
import edu.xtec.jclic.beans.SmallIntEditor;
import edu.xtec.jclic.edit.Editor;
import edu.xtec.jclic.edit.EditorPanel;
import edu.xtec.jclic.project.JClicProjectEditor;
import edu.xtec.util.ListComboModel;
import edu.xtec.util.Options;
import edu.xtec.util.ResourceManager;
import edu.xtec.util.StrUtils;
import java.awt.Component;
import java.awt.Container;
import java.util.EventObject;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.DocumentEvent;


/**
 *
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.08.09
 */
public class ActivitySequenceElementEditorPanel extends EditorPanel {
    
    String[] fwdOptions, backOptions;
    Icon[] fwdIcons, backIcons;
    
    protected ListComboModel actModel, jmpTagModel;
    protected JComboBox<Object> tagCombo;
    protected JTextField prjEdit;
    protected JComponent[] prompt_objects;
    protected String[] prompt_keys, prompt_msg;
    
    /** Creates new form ActivitySequenceElementEditorPanel */
    public ActivitySequenceElementEditorPanel(Options options) {
        super(options);
        initObjects();
        //ActivitySequenceElementEditor.createActions(options);
        initComponents();
        postInit(250, false, false);
        setEnabled(false);
    }
    
    private static final String[]
    FWD_OPTIONS_KEYS={"edit_seq_action_fwd", "edit_seq_action_jump", "edit_seq_action_stop", "edit_seq_action_return", "edit_seq_action_exit"},
    FWD_OPTIONS_ICONS={"seq_next", "seq_next_jump", "seq_next_stop", "seq_next_return", "seq_exit"},
    BACK_OPTIONS_KEYS={"edit_seq_action_back", "edit_seq_action_jump", "edit_seq_action_stop", "edit_seq_action_return", "edit_seq_action_exit"},
    BACK_OPTIONS_ICONS={"seq_prev", "seq_prev_jump", "seq_prev_stop", "seq_prev_return", "seq_exit"};
    
    private void initObjects(){
        
        int l=FWD_OPTIONS_KEYS.length;
        fwdOptions=new String[l]; fwdIcons=new Icon[l];
        backOptions=new String[l]; backIcons=new Icon[l];
        for(int i=0; i<FWD_OPTIONS_KEYS.length; i++){
            fwdOptions[i]=options.getMsg(FWD_OPTIONS_KEYS[i]);
            fwdIcons[i]=ResourceManager.getImageIcon("icons/"+FWD_OPTIONS_ICONS[i]+".gif");
            backOptions[i]=options.getMsg(BACK_OPTIONS_KEYS[i]);
            backIcons[i]=ResourceManager.getImageIcon("icons/"+BACK_OPTIONS_ICONS[i]+".gif");
        }
        
        tagCombo=new JComboBox<Object>();
        tagCombo.setEditable(true);
        tagCombo.addActionListener(this);
        prjEdit=new JTextField();
        prompt_objects=new JComponent[] {tagCombo, prjEdit};
        prompt_keys=new String[] {"edit_seq_tag", "edit_seq_project"};
        prompt_msg=new String[] {"edit_seq_jump_msg"};
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    mainPanel = new javax.swing.JPanel();
    javax.swing.JLabel actLabel = new javax.swing.JLabel();
    actCombo = new javax.swing.JComboBox<>();
    editActBtn = new javax.swing.JButton();
    editActBtn.addActionListener(this);
    javax.swing.JLabel tagLabel = new javax.swing.JLabel();
    tagText = new javax.swing.JTextField();
    javax.swing.JLabel descLabel = new javax.swing.JLabel();
    scroll = new javax.swing.JScrollPane();
    descText = new javax.swing.JTextArea();
    javax.swing.JPanel fwdPanel = new javax.swing.JPanel();
    javax.swing.JLabel fwIcon = new javax.swing.JLabel();
    fwdEnabledChk = new javax.swing.JCheckBox();
    javax.swing.JLabel fwdActionLb = new javax.swing.JLabel();
    fwdActionCombo = new javax.swing.JComboBox<Object>(fwdOptions);
    fwdJumpBtn = new javax.swing.JButton();
    fwdJumpLb = new javax.swing.JLabel();
    autoChk = new javax.swing.JCheckBox();
    javax.swing.JLabel delayLabel = new javax.swing.JLabel();
    delayEditor = new edu.xtec.jclic.beans.SmallIntEditor();
    javax.swing.JPanel condJumpPanel = new javax.swing.JPanel();
    javax.swing.JLabel upperLb = new javax.swing.JLabel();
    upperBtn = new CondJumpBtn(true);
    javax.swing.JLabel lowerLb = new javax.swing.JLabel();
    lowerBtn = new CondJumpBtn(false);
    javax.swing.JPanel backPanel = new javax.swing.JPanel();
    javax.swing.JLabel bkIcon = new javax.swing.JLabel();
    backEnabledChk = new javax.swing.JCheckBox();
    javax.swing.JLabel backActionLb = new javax.swing.JLabel();
    backActionCombo = new javax.swing.JComboBox<Object>(backOptions);
    backJumpBtn = new javax.swing.JButton();
    backJumpLb = new javax.swing.JLabel();
    javax.swing.JLabel spacer = new javax.swing.JLabel();

    setLayout(new java.awt.BorderLayout());

    mainPanel.setLayout(new java.awt.GridBagLayout());

    actLabel.setText(options.getMsg("edit_seq_activity"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mainPanel.add(actLabel, gridBagConstraints);

    actCombo.setToolTipText(options.getMsg("edit_seq_activity_tooltip"));
    actCombo.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mainPanel.add(actCombo, gridBagConstraints);

    editActBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/miniclic.png"))); // NOI18N
    editActBtn.setToolTipText(options.getMsg("edit_act_editActivity_tooltip"));
    editActBtn.setText(options.getMsg("edit_act_editActivity"));
    editActBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mainPanel.add(editActBtn, gridBagConstraints);

    tagLabel.setText(options.getMsg("edit_seq_tag"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mainPanel.add(tagLabel, gridBagConstraints);

    tagText.setToolTipText(options.getMsg("edit_seq_tag_tooltip"));
    tagText.setPreferredSize(new java.awt.Dimension(130, 21));
    tagText.setMinimumSize(new java.awt.Dimension(130, 21));
    tagText.getDocument().addDocumentListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mainPanel.add(tagText, gridBagConstraints);

    descLabel.setText(options.getMsg("edit_seq_description"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mainPanel.add(descLabel, gridBagConstraints);

    scroll.setPreferredSize(new java.awt.Dimension(200, 60));
    scroll.setMinimumSize(new java.awt.Dimension(200, 40));

    descText.setWrapStyleWord(true);
    descText.setToolTipText(options.getMsg("edit_seq_description_tooltip"));
    descText.setLineWrap(true);
    descText.setRows(2);
    descText.getDocument().addDocumentListener(this);
    scroll.setViewportView(descText);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mainPanel.add(scroll, gridBagConstraints);

    fwdPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(options.getMsg("edit_seq_arrow_fwd")));
    fwdPanel.setLayout(new java.awt.GridBagLayout());

    fwIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/next.gif"))); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    fwdPanel.add(fwIcon, gridBagConstraints);

    fwdEnabledChk.setToolTipText(options.getMsg("edit_seq_button_enabled_tooltip"));
    fwdEnabledChk.setText(options.getMsg("edit_seq_button_enabled"));
    fwdEnabledChk.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    fwdPanel.add(fwdEnabledChk, gridBagConstraints);

    fwdActionLb.setText(options.getMsg("edit_seq_action"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    fwdPanel.add(fwdActionLb, gridBagConstraints);

    fwdActionCombo.setToolTipText(options.getMsg("edit_seq_action_tooltip_fw"));
    fwdActionCombo.setRenderer(new edu.xtec.util.CustomListCellRenderer(fwdOptions, fwdIcons));
    fwdActionCombo.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    fwdPanel.add(fwdActionCombo, gridBagConstraints);

    fwdJumpBtn.setToolTipText(options.getMsg("edit_seq_jump_tooltip"));
    fwdJumpBtn.setText("...");
    fwdJumpBtn.setMargin(new java.awt.Insets(0, 3, 0, 3));
    fwdJumpBtn.setEnabled(false);
    fwdJumpBtn.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    fwdPanel.add(fwdJumpBtn, gridBagConstraints);

    fwdJumpLb.setText(" ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    fwdPanel.add(fwdJumpLb, gridBagConstraints);

    autoChk.setText(options.getMsg("edit_seq_auto"));
    autoChk.setToolTipText(options.getMsg("edit_seq_auto_tooltip"));
    autoChk.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    fwdPanel.add(autoChk, gridBagConstraints);

    delayLabel.setText(options.getMsg("edit_seq_delay"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    fwdPanel.add(delayLabel, gridBagConstraints);

    delayEditor.setToolTipText(options.getMsg("edit_seq_delay_tooltip"));
    delayEditor.setMax(999);
    delayEditor.setMin(1);
    delayEditor.addPropertyChangeListener(SmallIntEditor.PROP_VALUE, this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    fwdPanel.add(delayEditor, gridBagConstraints);

    condJumpPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(options.getMsg("edit_seq_condJump")));
    condJumpPanel.setToolTipText(options.getMsg("edit_seq_condJump_tooltip"));
    condJumpPanel.setLayout(new java.awt.GridBagLayout());

    upperLb.setLabelFor(upperBtn);
    upperLb.setText(options.getMsg("edit_seq_condJump_upper"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    condJumpPanel.add(upperLb, gridBagConstraints);

    upperBtn.setToolTipText(options.getMsg("edit_seq_condJump_upper_tooltip"));
    upperBtn.setText("<Not Set>");
    upperBtn.addPropertyChangeListener(NullableObject.PROP_CUSTOM_OBJECT, this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    condJumpPanel.add(upperBtn, gridBagConstraints);

    lowerLb.setLabelFor(lowerBtn);
    lowerLb.setText(options.getMsg("edit_seq_condJump_lower"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    condJumpPanel.add(lowerLb, gridBagConstraints);

    lowerBtn.setToolTipText(options.getMsg("edit_seq_condJump_lower_tooltip"));
    lowerBtn.setText("<Not Set>");
    lowerBtn.addPropertyChangeListener(NullableObject.PROP_CUSTOM_OBJECT, this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    condJumpPanel.add(lowerBtn, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    fwdPanel.add(condJumpPanel, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mainPanel.add(fwdPanel, gridBagConstraints);

    backPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(options.getMsg("edit_seq_arrow_back")));
    backPanel.setLayout(new java.awt.GridBagLayout());

    bkIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/xtec/resources/icons/prev.gif"))); // NOI18N
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    backPanel.add(bkIcon, gridBagConstraints);

    backEnabledChk.setToolTipText(options.getMsg("edit_seq_button_enabled_tooltip"));
    backEnabledChk.setText(options.getMsg("edit_seq_button_enabled"));
    backEnabledChk.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    backPanel.add(backEnabledChk, gridBagConstraints);

    backActionLb.setText(options.getMsg("edit_seq_action"));
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    backPanel.add(backActionLb, gridBagConstraints);

    backActionCombo.setToolTipText(options.getMsg("edit_seq_action_tooltip_bk"));
    backActionCombo.setRenderer(new edu.xtec.util.CustomListCellRenderer(backOptions, backIcons));
    backActionCombo.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    backPanel.add(backActionCombo, gridBagConstraints);

    backJumpBtn.setText("...");
    backJumpBtn.setToolTipText(options.getMsg("edit_seq_jump_tooltip"));
    backJumpBtn.setMargin(new java.awt.Insets(0, 3, 0, 3));
    backJumpBtn.setEnabled(false);
    backJumpBtn.addActionListener(this);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    backPanel.add(backJumpBtn, gridBagConstraints);

    backJumpLb.setText(" ");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
    backPanel.add(backJumpLb, gridBagConstraints);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
    mainPanel.add(backPanel, gridBagConstraints);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
    gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
    gridBagConstraints.weighty = 1.0;
    mainPanel.add(spacer, gridBagConstraints);

    add(mainPanel, java.awt.BorderLayout.WEST);
  }// </editor-fold>//GEN-END:initComponents
    
    public boolean checkIfEditorValid(Editor e) {
        return e instanceof ActivitySequenceElementEditor;
    }
    
    protected ActivitySequenceElement getActivitySequenceElement(){
        if(editor==null)
            return null;
        else
            return ((ActivitySequenceElementEditor)editor).getActivitySequenceElement();
    }
    
    protected int getRealDelayValue(){
        return autoChk.isSelected() ? delayEditor.getValue() : 0;
    }
    
    protected int getBtnValue(){
        boolean fw=fwdEnabledChk.isSelected();
        boolean bk=backEnabledChk.isSelected();
        return fw
        ? (bk ? ActivitySequenceElement.NAV_BOTH : ActivitySequenceElement.NAV_FWD)
        : (bk ? ActivitySequenceElement.NAV_BACK : ActivitySequenceElement.NAV_NONE);
    }
    
    protected void fillData() {
        ActivitySequenceElement ase=getActivitySequenceElement();
        JClicProjectEditor jcpe = ase==null ? null : ((ActivitySequenceElementEditor)getEditor()).getProjectEditor();
        if(jcpe!=null){
            ListModel<Object> lm=jcpe.getActivityBagEditor().getListModel();
            if(actModel==null || actModel.getListModel()!=lm){
                actModel=new ListComboModel(lm);
                actCombo.setModel(actModel);
            }
            if(ase!=null)
                actCombo.setSelectedItem(jcpe.getActivityBagEditor().getChildByName(ase.getActivityName()));
        }
        else{
            actModel=new ListComboModel();
            actCombo.setModel(actModel);
            actCombo.setSelectedItem(null);
        }
        
        fwdEnabledChk.setSelected(ase==null ? true : (ase.navButtons & ActivitySequenceElement.NAV_FWD)!=0);
        fwdActionCombo.setSelectedIndex((ase==null || ase.fwdJump==null) ? 0 : ase.fwdJump.action+1);
        
        backEnabledChk.setSelected(ase==null ? true : (ase.navButtons & ActivitySequenceElement.NAV_BACK)!=0);
        backActionCombo.setSelectedIndex((ase==null || ase.backJump==null) ? 0 : ase.backJump.action+1);
        
        tagText.setText(StrUtils.secureString(ase==null ? null : ase.getTag()));
        descText.setText(StrUtils.secureString(ase==null ? null : ase.getDescription()));
        autoChk.setSelected(ase!=null && ase.delay>0);
        delayEditor.setValue(Math.max(1, ase==null ? 0 : ase.delay));
        
        ((CondJumpBtn)upperBtn).setConditionalJumpInfo(ase==null || ase.fwdJump==null ? null : ase.fwdJump.upperJump);
        ((CondJumpBtn)lowerBtn).setConditionalJumpInfo(ase==null || ase.fwdJump==null ? null : ase.fwdJump.lowerJump);                
        
        setJumpLabels();
        checkEnabled();
        repaint();
    }    
    
    @Override
    public boolean eventPerformed(EventObject ev){
        
        Object src=(ev==null ? null : ev.getSource());
        ActivitySequenceElement ase=getActivitySequenceElement();
        if(src==null || ase==null)
            return false;
        if(src==tagCombo){
            if(tagCombo.getSelectedIndex()>=0){
                tagCombo.getEditor().setItem(tagCombo.getSelectedItem());
            }
            return false;
        }
        else if(src==editActBtn && getEditor()!=null && actCombo.getSelectedItem()!=null){
            JClicProjectEditor prjed=((ActivitySequenceElementEditor)getEditor()).getProjectEditor();
            if(prjed!=null && prjed.getTestPlayerContainer()!=null){
                prjed.getTestPlayerContainer().editActivity(actCombo.getSelectedItem().toString());
            }
            return false;
        }
        else if(src==fwdActionCombo || src==fwdJumpBtn){
            ase.fwdJump=(ActivitySequenceJump)checkJump(ase.fwdJump, fwdActionCombo, true, src==fwdJumpBtn);
            setJumpLabels();
        }
        else if(src==backActionCombo || src==backJumpBtn){
            ase.backJump=(ActivitySequenceJump)checkJump(ase.backJump, backActionCombo, true, src==backJumpBtn);
            setJumpLabels();
        }
        
        checkEnabled();
        repaint();        
        updateTable();        
        return true;
    }
    
    @Override
    public boolean documentChangePerformed(DocumentEvent documentEvent){
        if(documentEvent!=null && documentEvent.getDocument().equals(tagText.getDocument()))
            updateTable();
        return true;
    }
        
    private void updateTable(){
        Container cnt=getAWTAncestor(ActivitySequenceEditorPanel.class);        
        if(cnt!=null){
            setInitializing(true);
            saveData();
            int row=((ActivitySequenceEditorPanel)cnt).seqTable.getSelectionModel().getAnchorSelectionIndex();
            ((ActivitySequenceEditorPanel)cnt).tableModel.fireTableDataChanged();
            ((ActivitySequenceEditorPanel)cnt).seqTable.getSelectionModel().setSelectionInterval(row, row);
            setInitializing(false);
        }        
    }
    
    protected JumpInfo checkJump(JumpInfo ji, JComboBox combo, boolean allowNull, boolean forcePrompt){
        int offset = allowNull ? 1 : 0;
        int v=combo.getSelectedIndex();
        if(v==0 && allowNull)
            ji=null;
        else{
            if(ji==null)
                ji=new ActivitySequenceJump(v-offset);
            else
                ji.action=v-offset;
            if(ji.action==JumpInfo.JUMP && (forcePrompt || (ji.sequence==null && ji.projectPath==null))){
                boolean b=promptJumpParams(ji, this);
                if(!b || (ji.sequence==null && ji.projectPath==null)){
                    if(allowNull)
                        ji=null;
                    else
                        ji.action=JumpInfo.RETURN;
                    setInitializing(true);
                    combo.setSelectedIndex(ji==null ? 0 : ji.action+offset);
                    setInitializing(false);
                }
            }
        }
        return ji;
    }
        
    @Override
    public final void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        actCombo.setEnabled(enabled);
        fwdEnabledChk.setEnabled(enabled);
        backEnabledChk.setEnabled(enabled);
        tagText.setEnabled(enabled);
        descText.setEnabled(enabled);
        autoChk.setEnabled(enabled);
        checkEnabled();
    }
    
    public void checkEnabled(){
        boolean e = isEnabled();
        boolean fw = fwdEnabledChk.isSelected() || autoChk.isSelected();
        boolean fwBtn =  fw && fwdActionCombo.getSelectedIndex()==JumpInfo.JUMP+1;
        boolean fwCond = fw && fwdActionCombo.getSelectedIndex()>0;
        boolean bk = backEnabledChk.isSelected();
        boolean bkBtn = bk && backActionCombo.getSelectedIndex()==JumpInfo.JUMP+1;
        
        fwdActionCombo.setEnabled(e && fw);
        fwdJumpBtn.setEnabled(e && fwBtn);
        delayEditor.setEnabled(e && autoChk.isSelected());
        
        backActionCombo.setEnabled(e && bk);
        backJumpBtn.setEnabled(e && bkBtn);        
        
        upperBtn.setEnabled(e && fwCond);
        lowerBtn.setEnabled(e && fwCond);        
    }
    
    protected void saveData() {
        ActivitySequenceElement ase=getActivitySequenceElement();
        ActivityBagElementEditor abed=(ActivityBagElementEditor)actCombo.getSelectedItem();
        if(ase!=null && abed!=null){
            ase.setActivityName(abed.toString());
            String tag=StrUtils.nullableString(tagText.getText());
            if(!StrUtils.compareObjects(tag, ase.getTag())){
                ActivitySequenceEditor ased=(ActivitySequenceEditor)getEditor().getEditorParent();
                if(ase.getTag()!=null && ased!=null && ased.tagList!=null)
                    ased.tagList.removeElement(ased.getTag(ase.getTag()));
                ase.setTag(tag);
                if(tag!=null && ased!=null && ased.tagList!=null)
                    ased.tagList.addElement(tag);
            }
            ase.setTag(StrUtils.nullableString(tagText.getText()));
            ase.setDescription(StrUtils.nullableString(descText.getText()));
            ase.navButtons=getBtnValue();
            ase.delay=getRealDelayValue();
            if(ase.fwdJump!=null){
                ase.fwdJump.upperJump=((CondJumpBtn)upperBtn).getConditionalJumpInfo();
                ase.fwdJump.lowerJump=((CondJumpBtn)lowerBtn).getConditionalJumpInfo();                
            }
        }
    }
    
    @Override
    protected Icon getIcon(){
        return ActivitySequenceElementEditor.getIcon();
    }
    
    @Override
    protected String getTitle(){
        return "Activity sequence element";
        //return options.getMsg("library_dlg_title");
    }
    
    protected boolean promptJumpParams(JumpInfo ji, Component parent){
        boolean result=false;
        ActivitySequenceElement ase=getActivitySequenceElement();
        if(ase!=null){
            JClicProjectEditor jcpe=((ActivitySequenceElementEditor)getEditor()).getProjectEditor();
            if(jcpe!=null){
                ListModel<Object> lm=jcpe.getActivitySequenceEditor().getTagList();
                if(jmpTagModel==null || jmpTagModel.getListModel()!=lm)
                    jmpTagModel=new ListComboModel(lm);
                
                tagCombo.setModel(jmpTagModel);
                tagCombo.setSelectedItem(ji.sequence);
                
                String tx = ji.projectPath;
                prjEdit.setText(tx==null ? "" : tx);
                
                result=options.getMessages().showInputDlg(parent
                , prompt_msg, prompt_keys, prompt_objects
                , "edit_seq_jump_title");
                
                if(result){
                    ji.sequence=StrUtils.nullableString(tagCombo.getEditor().getItem());
                    ji.projectPath=StrUtils.nullableString(prjEdit.getText());
                }
            }
        }
        return result;
    }
    
    private void setJumpLabels(){
        StringBuilder sb=new StringBuilder();
        ActivitySequenceElement ase=getActivitySequenceElement();
        if(ase!=null && ase.fwdJump!=null){
            if(ase.fwdJump.sequence!=null)
                sb.append(ase.fwdJump.sequence);
            if(ase.fwdJump.projectPath!=null)
                sb.append(" (").append(ase.fwdJump.projectPath).append(")");
        }
        fwdJumpLb.setText(sb.append(' ').substring(0));
        sb.setLength(0);
        if(ase!=null && ase.backJump!=null){
            if(ase.backJump.sequence!=null)
                sb.append(ase.backJump.sequence);
            if(ase.backJump.projectPath!=null)
                sb.append(" (").append(ase.backJump.projectPath).append(")");
        }
        backJumpLb.setText(sb.append(' ').substring(0));
    }
    
    class CondJumpBtn extends NullableObject{
        boolean upper;
        ConditionalJumpPanel cjp;
        
        CondJumpBtn(boolean upper){
            super();
            this.upper=upper;
            setOptions(ActivitySequenceElementEditorPanel.this.options);
        }
        
        ConditionalJumpInfo getConditionalJumpInfo(){
            return (ConditionalJumpInfo)getObject();
        }
        
        void setConditionalJumpInfo(ConditionalJumpInfo cji){
            setObject(cji);
            checkIcon();
        }
        
        @Override
        protected Object createObject(){
            return new ConditionalJumpInfo(JumpInfo.RETURN, null, upper ? 80 : 20);
        }
        
        @Override
        protected Object editObject(Object o){
            if(o==null)
                o=createObject();
            ConditionalJumpInfo cji=(ConditionalJumpInfo)o;
            if(cjp==null){
                cjp=new ConditionalJumpPanel(options, ActivitySequenceElementEditorPanel.this, upper);
                
            }
            cjp.setJumpInfo((ConditionalJumpInfo)o, upper);
            boolean b=options.getMessages().showInputDlg(this, cjp, "edit_seq_condJump_" + (upper ? "upper" : "lower"));
            return b ? cjp.getJumpInfo() : null;
        };
        
        @Override
        public void changeObject(Object o){
            super.changeObject(o);
            checkIcon();
        }
        
        private void checkIcon(){
            JumpInfo o=getConditionalJumpInfo();
            if(o==null || fwdIcons==null)
                setIcon(null);
            else
                setIcon(fwdIcons[o.action+1]);
            repaint();
        }
        
    }
    
    
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox<Object> actCombo;
  private javax.swing.JCheckBox autoChk;
  private javax.swing.JComboBox<Object> backActionCombo;
  private javax.swing.JCheckBox backEnabledChk;
  private javax.swing.JButton backJumpBtn;
  private javax.swing.JLabel backJumpLb;
  private edu.xtec.jclic.beans.SmallIntEditor delayEditor;
  private javax.swing.JTextArea descText;
  private javax.swing.JButton editActBtn;
  private javax.swing.JComboBox<Object> fwdActionCombo;
  private javax.swing.JCheckBox fwdEnabledChk;
  private javax.swing.JButton fwdJumpBtn;
  private javax.swing.JLabel fwdJumpLb;
  private edu.xtec.jclic.beans.NullableObject lowerBtn;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JScrollPane scroll;
  private javax.swing.JTextField tagText;
  private edu.xtec.jclic.beans.NullableObject upperBtn;
  // End of variables declaration//GEN-END:variables
    
}
