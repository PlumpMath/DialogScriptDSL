/**
 * generated by Xtext
 */
package de.unidue.ecg.characterScript.ui.quickfix;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import de.unidue.ecg.characterScript.characterScript.Age;
import de.unidue.ecg.characterScript.characterScript.AttributeType;
import de.unidue.ecg.characterScript.characterScript.CharacterScriptFactory;
import de.unidue.ecg.characterScript.characterScript.CharacterScriptPackage;
import de.unidue.ecg.characterScript.characterScript.Characters;
import de.unidue.ecg.characterScript.characterScript.CustomAttribute;
import de.unidue.ecg.characterScript.characterScript.CustomAttributeName;
import de.unidue.ecg.characterScript.characterScript.CustomProperty;
import de.unidue.ecg.characterScript.characterScript.Description;
import de.unidue.ecg.characterScript.characterScript.EnumValue;
import de.unidue.ecg.characterScript.characterScript.FullName;
import de.unidue.ecg.characterScript.characterScript.Import;
import de.unidue.ecg.characterScript.characterScript.Property;
import de.unidue.ecg.characterScript.characterScript.Sex;
import de.unidue.ecg.characterScript.characterScript.Template;
import de.unidue.ecg.characterScript.characterScript.Type;
import de.unidue.ecg.characterScript.validation.CharacterScriptValidator;
import de.unidue.ecg.common.linking.CustomLinkingDiagnosticMessageProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Custom quickfixes.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
@SuppressWarnings("all")
public class CharacterScriptQuickfixProvider extends DefaultQuickfixProvider {
  @Inject
  private CustomLinkingDiagnosticMessageProvider customLinkingDiagnosticMessageProvider;
  
  @Fix(CharacterScriptValidator.UNRESOLVED_TEMPLATE)
  public void createImport(final Issue issue, final IssueResolutionAcceptor acceptor) {
    String[] _data = issue.getData();
    final String linkText = _data[0];
    boolean _notEquals = (!Objects.equal(linkText, null));
    if (_notEquals) {
      String _plus = ("Import \'" + linkText);
      String _plus_1 = (_plus + "\'");
      String _plus_2 = ("Import \'" + linkText);
      String _plus_3 = (_plus_2 + "\'");
      final ISemanticModification _function = new ISemanticModification() {
        public void apply(final EObject element, final IModificationContext context) throws Exception {
          if ((element instanceof de.unidue.ecg.characterScript.characterScript.Character)) {
            final Characters root = EcoreUtil2.<Characters>getContainerOfType(element, Characters.class);
            final Import import_ = CharacterScriptFactory.eINSTANCE.createImport();
            import_.setImportedNamespace(linkText);
            EList<Import> _imports = root.getImports();
            _imports.add(import_);
          }
        }
      };
      acceptor.accept(issue, _plus_1, _plus_3, null, _function);
    }
  }
  
  @Fix(Diagnostic.LINKING_DIAGNOSTIC)
  public void createTemplate(final Issue issue, final IssueResolutionAcceptor acceptor) {
    EClass _template = CharacterScriptPackage.eINSTANCE.getTemplate();
    final String linkText = this.customLinkingDiagnosticMessageProvider.getLinkText(issue, _template);
    boolean _notEquals = (!Objects.equal(linkText, null));
    if (_notEquals) {
      String _plus = ("Create template \'" + linkText);
      String _plus_1 = (_plus + "\'");
      String _plus_2 = ("Create template \'" + linkText);
      String _plus_3 = (_plus_2 + "\'");
      final ISemanticModification _function = new ISemanticModification() {
        public void apply(final EObject element, final IModificationContext context) throws Exception {
          if ((element instanceof de.unidue.ecg.characterScript.characterScript.Character)) {
            final Characters model = EcoreUtil2.<Characters>getContainerOfType(element, Characters.class);
            final Template template = CharacterScriptFactory.eINSTANCE.createTemplate();
            template.setName(linkText);
            final de.unidue.ecg.characterScript.characterScript.Character character = ((de.unidue.ecg.characterScript.characterScript.Character) element);
            EList<Property> _properties = character.getProperties();
            final Procedure1<Property> _function = new Procedure1<Property>() {
              public void apply(final Property it) {
                boolean _matched = false;
                if (!_matched) {
                  if (it instanceof FullName) {
                    final FullName _fullName = (FullName)it;
                    _matched=true;
                    EList<String> _defaults = template.getDefaults();
                    _defaults.add("full name");
                  }
                }
                if (!_matched) {
                  if (it instanceof Age) {
                    final Age _age = (Age)it;
                    _matched=true;
                    EList<String> _defaults = template.getDefaults();
                    _defaults.add("age");
                  }
                }
                if (!_matched) {
                  if (it instanceof Description) {
                    final Description _description = (Description)it;
                    _matched=true;
                    EList<String> _defaults = template.getDefaults();
                    _defaults.add("description");
                  }
                }
                if (!_matched) {
                  if (it instanceof Sex) {
                    final Sex _sex = (Sex)it;
                    _matched=true;
                    EList<String> _defaults = template.getDefaults();
                    _defaults.add("sex");
                  }
                }
                if (!_matched) {
                  if (it instanceof Type) {
                    final Type _type = (Type)it;
                    _matched=true;
                    EList<String> _defaults = template.getDefaults();
                    _defaults.add("type");
                  }
                }
                if (!_matched) {
                  if (it instanceof CustomProperty) {
                    final CustomProperty _customProperty = (CustomProperty)it;
                    _matched=true;
                    final ICompositeNode nodeForCARef = NodeModelUtils.findActualNodeFor(_customProperty);
                    BidiTreeIterable<INode> _asTreeIterable = nodeForCARef.getAsTreeIterable();
                    Iterable<LeafNode> _filter = Iterables.<LeafNode>filter(_asTreeIterable, LeafNode.class);
                    final Function1<LeafNode,Boolean> _function = new Function1<LeafNode,Boolean>() {
                      public Boolean apply(final LeafNode it) {
                        boolean _not = (!(it instanceof HiddenLeafNode));
                        return Boolean.valueOf(_not);
                      }
                    };
                    final Iterable<LeafNode> nodeCandidates = IterableExtensions.<LeafNode>filter(_filter, _function);
                    int _length = ((Object[])Conversions.unwrapArray(nodeCandidates, Object.class)).length;
                    boolean _lessEqualsThan = (_length <= 2);
                    if (_lessEqualsThan) {
                      final CustomAttribute ca = CharacterScriptFactory.eINSTANCE.createCustomAttribute();
                      final CustomAttributeName caName = CharacterScriptFactory.eINSTANCE.createCustomAttributeName();
                      LeafNode _get = ((LeafNode[])Conversions.unwrapArray(nodeCandidates, LeafNode.class))[0];
                      String _text = _get.getText();
                      caName.setName(_text);
                      ca.setCaName(caName);
                      EnumValue _enumValue = _customProperty.getEnumValue();
                      boolean _notEquals = (!Objects.equal(_enumValue, null));
                      if (_notEquals) {
                        LeafNode _get_1 = ((LeafNode[])Conversions.unwrapArray(nodeCandidates, LeafNode.class))[1];
                        boolean _notEquals_1 = (!Objects.equal(_get_1, null));
                        if (_notEquals_1) {
                          final EnumValue ev = CharacterScriptFactory.eINSTANCE.createEnumValue();
                          LeafNode _get_2 = ((LeafNode[])Conversions.unwrapArray(nodeCandidates, LeafNode.class))[1];
                          String _text_1 = _get_2.getText();
                          ev.setName(_text_1);
                          EList<EnumValue> _enumValues = ca.getEnumValues();
                          _enumValues.add(ev);
                        }
                      } else {
                        String _stringValue = _customProperty.getStringValue();
                        boolean _notEquals_2 = (!Objects.equal(_stringValue, null));
                        if (_notEquals_2) {
                          ca.setType(AttributeType.TEXT);
                        } else {
                          ca.setType(AttributeType.NUMBER);
                        }
                      }
                      EList<CustomAttribute> _customs = template.getCustoms();
                      _customs.add(ca);
                    }
                  }
                }
              }
            };
            IterableExtensions.<Property>forEach(_properties, _function);
            EList<Template> _templates = model.getTemplates();
            _templates.add(template);
          }
        }
      };
      acceptor.accept(issue, _plus_1, _plus_3, null, _function);
    }
  }
}
