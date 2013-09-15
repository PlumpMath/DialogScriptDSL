/*
 * generated by Xtext
 */
package de.unidue.ecg.dialogScript.ui;

import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalComparator;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.SimpleResourceSetProvider;
import org.eclipse.xtext.ui.wizard.IProjectCreator;

import de.unidue.ecg.dialogScript.ui.editor.syntaxcoloring.MyHighlightingConfiguration;
import de.unidue.ecg.dialogScript.ui.editor.syntaxcoloring.MySemanticHighlightingCalculator;
import de.unidue.ecg.common.ui.contentassist.TemplatePreferringCompletionProposalProvider;
import de.unidue.ecg.dialogScript.ui.editor.templates.TerminalRuleAwareTemplateContextTypeRegistry;
import de.unidue.ecg.dialogScript.ui.editor.templates.TerminalRuleAwareTemplateProposalProvider;
import de.unidue.ecg.dialogScript.ui.wizard.CustomDialogScriptProjectCreator;


/**
 * Use this class to register components to be used within the IDE.
 */
public class DialogScriptUiModule extends de.unidue.ecg.dialogScript.ui.AbstractDialogScriptUiModule {
	public DialogScriptUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	public Class<? extends IProjectCreator> bindIProjectCreator() {
		return CustomDialogScriptProjectCreator.class;
	}
	
	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return MyHighlightingConfiguration.class;
	}
	
	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator>bindISemanticHighlightingCalculator() {
		return MySemanticHighlightingCalculator.class;
	}
	
	@Override
	public Class<? extends ContextTypeRegistry> bindContextTypeRegistry() {
		return TerminalRuleAwareTemplateContextTypeRegistry.class;
	}
	
	@Override
	public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
		return TerminalRuleAwareTemplateProposalProvider.class;
	}
	
	public Class<? extends ICompletionProposalComparator> bindICompletionProposalComparator() {
		return TemplatePreferringCompletionProposalProvider.class;
	}
	
	@Override
	public Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		return SimpleResourceSetProvider.class;
	}
}
