/*
* generated by Xtext
*/
package de.unidue.ecg.characterScript.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import de.unidue.ecg.characterScript.services.CharacterScriptGrammarAccess;

public class CharacterScriptParser extends AbstractContentAssistParser {
	
	@Inject
	private CharacterScriptGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected de.unidue.ecg.characterScript.ui.contentassist.antlr.internal.InternalCharacterScriptParser createParser() {
		de.unidue.ecg.characterScript.ui.contentassist.antlr.internal.InternalCharacterScriptParser result = new de.unidue.ecg.characterScript.ui.contentassist.antlr.internal.InternalCharacterScriptParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getDefaultAttributeAccess().getAlternatives(), "rule__DefaultAttribute__Alternatives");
					put(grammarAccess.getCustomAttributeAccess().getAlternatives_2(), "rule__CustomAttribute__Alternatives_2");
					put(grammarAccess.getPropertyAccess().getAlternatives(), "rule__Property__Alternatives");
					put(grammarAccess.getDefaultPropertyAccess().getAlternatives(), "rule__DefaultProperty__Alternatives");
					put(grammarAccess.getCustomPropertyAccess().getAlternatives_1(), "rule__CustomProperty__Alternatives_1");
					put(grammarAccess.getAttributeTypeAccess().getAlternatives(), "rule__AttributeType__Alternatives");
					put(grammarAccess.getCharaTypeAccess().getAlternatives(), "rule__CharaType__Alternatives");
					put(grammarAccess.getCharaSexAccess().getAlternatives(), "rule__CharaSex__Alternatives");
					put(grammarAccess.getCharactersAccess().getGroup(), "rule__Characters__Group__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getTemplateAccess().getGroup(), "rule__Template__Group__0");
					put(grammarAccess.getCustomAttributeAccess().getGroup(), "rule__CustomAttribute__Group__0");
					put(grammarAccess.getCustomAttributeAccess().getGroup_2_1(), "rule__CustomAttribute__Group_2_1__0");
					put(grammarAccess.getCustomAttributeAccess().getGroup_2_1_2(), "rule__CustomAttribute__Group_2_1_2__0");
					put(grammarAccess.getCustomsAccess().getGroup(), "rule__Customs__Group__0");
					put(grammarAccess.getCharacterAccess().getGroup(), "rule__Character__Group__0");
					put(grammarAccess.getCharacterAccess().getGroup_2(), "rule__Character__Group_2__0");
					put(grammarAccess.getFullNameAccess().getGroup(), "rule__FullName__Group__0");
					put(grammarAccess.getDescriptionAccess().getGroup(), "rule__Description__Group__0");
					put(grammarAccess.getTypeAccess().getGroup(), "rule__Type__Group__0");
					put(grammarAccess.getAgeAccess().getGroup(), "rule__Age__Group__0");
					put(grammarAccess.getSexAccess().getGroup(), "rule__Sex__Group__0");
					put(grammarAccess.getCustomPropertyAccess().getGroup(), "rule__CustomProperty__Group__0");
					put(grammarAccess.getCharactersAccess().getImportsAssignment_0(), "rule__Characters__ImportsAssignment_0");
					put(grammarAccess.getCharactersAccess().getTemplatesAssignment_1(), "rule__Characters__TemplatesAssignment_1");
					put(grammarAccess.getCharactersAccess().getCustomsAssignment_2(), "rule__Characters__CustomsAssignment_2");
					put(grammarAccess.getCharactersAccess().getCharactersAssignment_3(), "rule__Characters__CharactersAssignment_3");
					put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
					put(grammarAccess.getTemplateAccess().getNameAssignment_1(), "rule__Template__NameAssignment_1");
					put(grammarAccess.getTemplateAccess().getDefaultsAssignment_2(), "rule__Template__DefaultsAssignment_2");
					put(grammarAccess.getTemplateAccess().getCustomsAssignment_3(), "rule__Template__CustomsAssignment_3");
					put(grammarAccess.getCustomAttributeAccess().getCaNameAssignment_0(), "rule__CustomAttribute__CaNameAssignment_0");
					put(grammarAccess.getCustomAttributeAccess().getTypeAssignment_2_0(), "rule__CustomAttribute__TypeAssignment_2_0");
					put(grammarAccess.getCustomAttributeAccess().getEnumValuesAssignment_2_1_1(), "rule__CustomAttribute__EnumValuesAssignment_2_1_1");
					put(grammarAccess.getCustomAttributeAccess().getEnumValuesAssignment_2_1_2_1(), "rule__CustomAttribute__EnumValuesAssignment_2_1_2_1");
					put(grammarAccess.getCustomAttributeNameAccess().getNameAssignment(), "rule__CustomAttributeName__NameAssignment");
					put(grammarAccess.getEnumValueAccess().getNameAssignment(), "rule__EnumValue__NameAssignment");
					put(grammarAccess.getCustomsAccess().getCustomAttributesAssignment_2(), "rule__Customs__CustomAttributesAssignment_2");
					put(grammarAccess.getCustomsAccess().getCustomAttributesAssignment_3(), "rule__Customs__CustomAttributesAssignment_3");
					put(grammarAccess.getCharacterAccess().getNameAssignment_1(), "rule__Character__NameAssignment_1");
					put(grammarAccess.getCharacterAccess().getTemplateAssignment_2_1(), "rule__Character__TemplateAssignment_2_1");
					put(grammarAccess.getCharacterAccess().getPropertiesAssignment_3(), "rule__Character__PropertiesAssignment_3");
					put(grammarAccess.getFullNameAccess().getValueAssignment_1(), "rule__FullName__ValueAssignment_1");
					put(grammarAccess.getFullNameAccess().getCommentAssignment_2(), "rule__FullName__CommentAssignment_2");
					put(grammarAccess.getDescriptionAccess().getValueAssignment_1(), "rule__Description__ValueAssignment_1");
					put(grammarAccess.getDescriptionAccess().getCommentAssignment_2(), "rule__Description__CommentAssignment_2");
					put(grammarAccess.getTypeAccess().getValueAssignment_1(), "rule__Type__ValueAssignment_1");
					put(grammarAccess.getTypeAccess().getCommentAssignment_2(), "rule__Type__CommentAssignment_2");
					put(grammarAccess.getAgeAccess().getValueAssignment_1(), "rule__Age__ValueAssignment_1");
					put(grammarAccess.getAgeAccess().getCommentAssignment_2(), "rule__Age__CommentAssignment_2");
					put(grammarAccess.getSexAccess().getValueAssignment_1(), "rule__Sex__ValueAssignment_1");
					put(grammarAccess.getSexAccess().getCommentAssignment_2(), "rule__Sex__CommentAssignment_2");
					put(grammarAccess.getCustomPropertyAccess().getCustomAttributeRefAssignment_0(), "rule__CustomProperty__CustomAttributeRefAssignment_0");
					put(grammarAccess.getCustomPropertyAccess().getStringValueAssignment_1_0(), "rule__CustomProperty__StringValueAssignment_1_0");
					put(grammarAccess.getCustomPropertyAccess().getIntValueAssignment_1_1(), "rule__CustomProperty__IntValueAssignment_1_1");
					put(grammarAccess.getCustomPropertyAccess().getEnumValueAssignment_1_2(), "rule__CustomProperty__EnumValueAssignment_1_2");
					put(grammarAccess.getCustomPropertyAccess().getCommentAssignment_2(), "rule__CustomProperty__CommentAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			de.unidue.ecg.characterScript.ui.contentassist.antlr.internal.InternalCharacterScriptParser typedParser = (de.unidue.ecg.characterScript.ui.contentassist.antlr.internal.InternalCharacterScriptParser) parser;
			typedParser.entryRuleCharacters();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public CharacterScriptGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CharacterScriptGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}