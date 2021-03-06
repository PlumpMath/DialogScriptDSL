/**
 * generated by Xtext
 */
package de.unidue.ecg.characterScript.ui.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import de.unidue.ecg.characterScript.characterScript.AttributeType;
import de.unidue.ecg.characterScript.characterScript.CharacterScriptPackage;
import de.unidue.ecg.characterScript.characterScript.CustomAttribute;
import de.unidue.ecg.characterScript.characterScript.CustomAttributeName;
import de.unidue.ecg.characterScript.characterScript.CustomProperty;
import de.unidue.ecg.characterScript.characterScript.DefaultProperty;
import de.unidue.ecg.characterScript.characterScript.EnumValue;
import de.unidue.ecg.characterScript.characterScript.Property;
import de.unidue.ecg.characterScript.characterScript.Template;
import de.unidue.ecg.characterScript.ui.contentassist.AbstractCharacterScriptProposalProvider;
import de.unidue.ecg.characterScript.util.LanguageUtil;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("all")
public class CharacterScriptProposalProvider extends AbstractCharacterScriptProposalProvider {
  public void completeCustomProperty_EnumValue(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final CustomProperty cp = ((CustomProperty) model);
    CustomAttributeName _customAttributeRef = cp.getCustomAttributeRef();
    EObject _eContainer = _customAttributeRef.eContainer();
    final CustomAttribute ca = ((CustomAttribute) _eContainer);
    EList<EnumValue> _enumValues = null;
    if (ca!=null) {
      _enumValues=ca.getEnumValues();
    }
    boolean _isEmpty = _enumValues.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      super.completeCustomProperty_EnumValue(model, assignment, context, acceptor);
    }
  }
  
  public void completeCustomProperty_CustomAttributeRef(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    AbstractElement _terminal = assignment.getTerminal();
    final Predicate<IEObjectDescription> _function = new Predicate<IEObjectDescription>() {
      public boolean apply(final IEObjectDescription ieod) {
        EList<Property> _properties = ((de.unidue.ecg.characterScript.characterScript.Character) model).getProperties();
        Iterable<CustomProperty> _filter = Iterables.<CustomProperty>filter(_properties, CustomProperty.class);
        final Function1<CustomProperty,Boolean> _function = new Function1<CustomProperty,Boolean>() {
          public Boolean apply(final CustomProperty cp) {
            EObject _eObjectOrProxy = ieod.getEObjectOrProxy();
            CustomAttributeName _customAttributeRef = cp.getCustomAttributeRef();
            boolean _equals = Objects.equal(_eObjectOrProxy, _customAttributeRef);
            return Boolean.valueOf(_equals);
          }
        };
        boolean _exists = IterableExtensions.<CustomProperty>exists(_filter, _function);
        boolean _not = (!_exists);
        return _not;
      }
    };
    this.lookupCrossReference(((CrossReference) _terminal), context, acceptor, _function);
  }
  
  public void complete_INT(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    if ((model instanceof CustomProperty)) {
      final CustomProperty cp = ((CustomProperty) model);
      CustomAttributeName _customAttributeRef = cp.getCustomAttributeRef();
      EObject _eContainer = _customAttributeRef.eContainer();
      final CustomAttribute ca = ((CustomAttribute) _eContainer);
      boolean _or = false;
      EList<EnumValue> _enumValues = ca.getEnumValues();
      boolean _isEmpty = _enumValues.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _or = true;
      } else {
        AttributeType _type = ca.getType();
        String _name = _type.getName();
        boolean _equals = _name.equals("NUMBER");
        boolean _not_1 = (!_equals);
        _or = (_not || _not_1);
      }
      if (_or) {
        return;
      }
    }
    super.complete_INT(model, ruleCall, context, acceptor);
  }
  
  public void complete_STRING(final EObject model, final RuleCall ruleCall, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    if ((model instanceof CustomProperty)) {
      final CustomProperty cp = ((CustomProperty) model);
      CustomAttributeName _customAttributeRef = cp.getCustomAttributeRef();
      EObject _eContainer = _customAttributeRef.eContainer();
      final CustomAttribute ca = ((CustomAttribute) _eContainer);
      boolean _or = false;
      EList<EnumValue> _enumValues = ca.getEnumValues();
      boolean _isEmpty = _enumValues.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _or = true;
      } else {
        AttributeType _type = ca.getType();
        String _name = _type.getName();
        boolean _equals = _name.equals("TEXT");
        boolean _not_1 = (!_equals);
        _or = (_not || _not_1);
      }
      if (_or) {
        return;
      }
    }
    super.complete_STRING(model, ruleCall, context, acceptor);
  }
  
  public void completeImport_ImportedNamespace(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    IScopeProvider _scopeProvider = this.getScopeProvider();
    EObject _rootModel = context.getRootModel();
    final IScope scope = _scopeProvider.getScope(_rootModel, CharacterScriptPackage.Literals.CHARACTER__TEMPLATE);
    Iterable<IEObjectDescription> _allElements = scope.getAllElements();
    final Function1<IEObjectDescription,Boolean> _function = new Function1<IEObjectDescription,Boolean>() {
      public Boolean apply(final IEObjectDescription ieod) {
        EObject _eObjectOrProxy = ieod.getEObjectOrProxy();
        return Boolean.valueOf((_eObjectOrProxy instanceof Template));
      }
    };
    Iterable<IEObjectDescription> _filter = IterableExtensions.<IEObjectDescription>filter(_allElements, _function);
    final Procedure1<IEObjectDescription> _function_1 = new Procedure1<IEObjectDescription>() {
      public void apply(final IEObjectDescription element) {
        QualifiedName _qualifiedName = element.getQualifiedName();
        String _string = _qualifiedName.toString();
        ICompletionProposal _createCompletionProposal = CharacterScriptProposalProvider.this.createCompletionProposal(_string, context);
        acceptor.accept(_createCompletionProposal);
      }
    };
    IterableExtensions.<IEObjectDescription>forEach(_filter, _function_1);
  }
  
  public void completeKeyword(final Keyword keyword, final ContentAssistContext contentAssistContext, final ICompletionProposalAcceptor acceptor) {
    final EObject model = contentAssistContext.getCurrentModel();
    boolean _matched = false;
    if (!_matched) {
      if (model instanceof de.unidue.ecg.characterScript.characterScript.Character) {
        _matched=true;
        boolean _filter = this.filter(keyword, ((de.unidue.ecg.characterScript.characterScript.Character)model));
        if (_filter) {
          return;
        }
      }
    }
    super.completeKeyword(keyword, contentAssistContext, acceptor);
  }
  
  private boolean filter(final Keyword keyword, final de.unidue.ecg.characterScript.characterScript.Character character) {
    boolean _equals = Objects.equal(character, null);
    if (_equals) {
      return false;
    }
    final ArrayList<String> filterList = CollectionLiterals.<String>newArrayList();
    EList<Property> _properties = character.getProperties();
    Iterable<DefaultProperty> _filter = Iterables.<DefaultProperty>filter(_properties, DefaultProperty.class);
    final Procedure1<DefaultProperty> _function = new Procedure1<DefaultProperty>() {
      public void apply(final DefaultProperty it) {
        EClass _eClass = it.eClass();
        String _keywordValueFor = LanguageUtil.getKeywordValueFor(_eClass);
        filterList.add(_keywordValueFor);
      }
    };
    IterableExtensions.<DefaultProperty>forEach(_filter, _function);
    String _value = keyword.getValue();
    boolean _contains = filterList.contains(_value);
    if (_contains) {
      return true;
    }
    return false;
  }
}
