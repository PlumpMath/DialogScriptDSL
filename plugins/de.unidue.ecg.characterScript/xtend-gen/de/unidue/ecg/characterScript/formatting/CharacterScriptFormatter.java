/**
 * generated by Xtext
 */
package de.unidue.ecg.characterScript.formatting;

import com.google.inject.Inject;
import de.unidue.ecg.characterScript.services.CharacterScriptGrammarAccess;
import de.unidue.ecg.characterScript.services.CharacterScriptGrammarAccess.CharacterElements;
import de.unidue.ecg.characterScript.services.CharacterScriptGrammarAccess.CharactersElements;
import de.unidue.ecg.characterScript.services.CharacterScriptGrammarAccess.GlobalsElements;
import de.unidue.ecg.characterScript.services.CharacterScriptGrammarAccess.TemplateElements;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.formatting.impl.FormattingConfig.LinewrapLocator;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
@SuppressWarnings("all")
public class CharacterScriptFormatter extends AbstractDeclarativeFormatter {
  @Inject
  @Extension
  private CharacterScriptGrammarAccess _characterScriptGrammarAccess;
  
  protected void configureFormatting(final FormattingConfig c) {
    LinewrapLocator _setLinewrap = c.setLinewrap(0, 1, 2);
    TerminalRule _sL_COMMENTRule = this._characterScriptGrammarAccess.getSL_COMMENTRule();
    _setLinewrap.before(_sL_COMMENTRule);
    LinewrapLocator _setLinewrap_1 = c.setLinewrap(0, 1, 2);
    TerminalRule _mL_COMMENTRule = this._characterScriptGrammarAccess.getML_COMMENTRule();
    _setLinewrap_1.before(_mL_COMMENTRule);
    LinewrapLocator _setLinewrap_2 = c.setLinewrap(0, 1, 1);
    TerminalRule _mL_COMMENTRule_1 = this._characterScriptGrammarAccess.getML_COMMENTRule();
    _setLinewrap_2.after(_mL_COMMENTRule_1);
    LinewrapLocator _setLinewrap_3 = c.setLinewrap();
    CharactersElements _charactersAccess = this._characterScriptGrammarAccess.getCharactersAccess();
    Assignment _importsAssignment_0 = _charactersAccess.getImportsAssignment_0();
    _setLinewrap_3.after(_importsAssignment_0);
    LinewrapLocator _setLinewrap_4 = c.setLinewrap();
    CharactersElements _charactersAccess_1 = this._characterScriptGrammarAccess.getCharactersAccess();
    RuleCall _importsImportParserRuleCall_0_0 = _charactersAccess_1.getImportsImportParserRuleCall_0_0();
    _setLinewrap_4.after(_importsImportParserRuleCall_0_0);
    TemplateElements _templateAccess = this._characterScriptGrammarAccess.getTemplateAccess();
    Keyword _templateKeyword_0 = _templateAccess.getTemplateKeyword_0();
    TemplateElements _templateAccess_1 = this._characterScriptGrammarAccess.getTemplateAccess();
    Assignment _nameAssignment_1 = _templateAccess_1.getNameAssignment_1();
    TemplateElements _templateAccess_2 = this._characterScriptGrammarAccess.getTemplateAccess();
    Keyword _endKeyword_5 = _templateAccess_2.getEndKeyword_5();
    TemplateElements _templateAccess_3 = this._characterScriptGrammarAccess.getTemplateAccess();
    Keyword _endKeyword_5_1 = _templateAccess_3.getEndKeyword_5();
    TemplateElements _templateAccess_4 = this._characterScriptGrammarAccess.getTemplateAccess();
    Assignment _defaultsAssignment_2 = _templateAccess_4.getDefaultsAssignment_2();
    TemplateElements _templateAccess_5 = this._characterScriptGrammarAccess.getTemplateAccess();
    Assignment _customsAssignment_3 = _templateAccess_5.getCustomsAssignment_3();
    TemplateElements _templateAccess_6 = this._characterScriptGrammarAccess.getTemplateAccess();
    Assignment _customsAssignment_4 = _templateAccess_6.getCustomsAssignment_4();
    this.setDefaultBlockLayout(c, _templateKeyword_0, _nameAssignment_1, _endKeyword_5, _endKeyword_5_1, _defaultsAssignment_2, _customsAssignment_3, _customsAssignment_4);
    GlobalsElements _globalsAccess = this._characterScriptGrammarAccess.getGlobalsAccess();
    Keyword _globalKeyword_0 = _globalsAccess.getGlobalKeyword_0();
    GlobalsElements _globalsAccess_1 = this._characterScriptGrammarAccess.getGlobalsAccess();
    Keyword _attributesKeyword_1 = _globalsAccess_1.getAttributesKeyword_1();
    GlobalsElements _globalsAccess_2 = this._characterScriptGrammarAccess.getGlobalsAccess();
    Keyword _endKeyword_4 = _globalsAccess_2.getEndKeyword_4();
    GlobalsElements _globalsAccess_3 = this._characterScriptGrammarAccess.getGlobalsAccess();
    Keyword _endKeyword_4_1 = _globalsAccess_3.getEndKeyword_4();
    GlobalsElements _globalsAccess_4 = this._characterScriptGrammarAccess.getGlobalsAccess();
    Assignment _customsAssignment_2 = _globalsAccess_4.getCustomsAssignment_2();
    GlobalsElements _globalsAccess_5 = this._characterScriptGrammarAccess.getGlobalsAccess();
    Assignment _customsAssignment_3_1 = _globalsAccess_5.getCustomsAssignment_3();
    this.setDefaultBlockLayout(c, _globalKeyword_0, _attributesKeyword_1, _endKeyword_4, _endKeyword_4_1, _customsAssignment_2, _customsAssignment_3_1);
    CharacterElements _characterAccess = this._characterScriptGrammarAccess.getCharacterAccess();
    Keyword _characterKeyword_0 = _characterAccess.getCharacterKeyword_0();
    CharacterElements _characterAccess_1 = this._characterScriptGrammarAccess.getCharacterAccess();
    Assignment _nameAssignment_1_1 = _characterAccess_1.getNameAssignment_1();
    CharacterElements _characterAccess_2 = this._characterScriptGrammarAccess.getCharacterAccess();
    Keyword _endKeyword_4_2 = _characterAccess_2.getEndKeyword_4();
    CharacterElements _characterAccess_3 = this._characterScriptGrammarAccess.getCharacterAccess();
    Keyword _endKeyword_4_3 = _characterAccess_3.getEndKeyword_4();
    CharacterElements _characterAccess_4 = this._characterScriptGrammarAccess.getCharacterAccess();
    Assignment _propertiesAssignment_3 = _characterAccess_4.getPropertiesAssignment_3();
    this.setDefaultBlockLayout(c, _characterKeyword_0, _nameAssignment_1_1, _endKeyword_4_2, _endKeyword_4_3, _propertiesAssignment_3);
  }
  
  public void setDefaultBlockLayout(final FormattingConfig c, final Keyword start, final AbstractElement indentStart, final AbstractElement indentEnd, final Keyword end, final AbstractElement... content) {
    LinewrapLocator _setLinewrap = c.setLinewrap(2);
    _setLinewrap.before(start);
    c.setIndentation(indentStart, indentEnd);
    final Procedure1<AbstractElement> _function = new Procedure1<AbstractElement>() {
      public void apply(final AbstractElement it) {
        LinewrapLocator _setLinewrap = c.setLinewrap();
        _setLinewrap.before(it);
      }
    };
    IterableExtensions.<AbstractElement>forEach(((Iterable<AbstractElement>)Conversions.doWrapArray(content)), _function);
    LinewrapLocator _setLinewrap_1 = c.setLinewrap();
    _setLinewrap_1.before(end);
  }
}
