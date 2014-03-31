/**
 * generated by Xtext
 */
package de.unidue.ecg.characterScript.validation;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import de.unidue.ecg.characterScript.characterScript.Age;
import de.unidue.ecg.characterScript.characterScript.AttributeType;
import de.unidue.ecg.characterScript.characterScript.CharacterScriptPackage;
import de.unidue.ecg.characterScript.characterScript.Characters;
import de.unidue.ecg.characterScript.characterScript.CustomAttribute;
import de.unidue.ecg.characterScript.characterScript.CustomAttributeName;
import de.unidue.ecg.characterScript.characterScript.CustomProperty;
import de.unidue.ecg.characterScript.characterScript.DefaultProperty;
import de.unidue.ecg.characterScript.characterScript.Description;
import de.unidue.ecg.characterScript.characterScript.EnumValue;
import de.unidue.ecg.characterScript.characterScript.FullName;
import de.unidue.ecg.characterScript.characterScript.Import;
import de.unidue.ecg.characterScript.characterScript.Property;
import de.unidue.ecg.characterScript.characterScript.Sex;
import de.unidue.ecg.characterScript.characterScript.Template;
import de.unidue.ecg.characterScript.characterScript.Type;
import de.unidue.ecg.characterScript.util.LanguageUtil;
import de.unidue.ecg.characterScript.validation.AbstractCharacterScriptValidator;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
@SuppressWarnings("all")
public class CharacterScriptValidator extends AbstractCharacterScriptValidator {
  public final static String INVALID_ATTRIBUTE_TYPE = "invalidAttributeType";
  
  public final static String INVALID_ATTRIBUTE = "invalidAttribute";
  
  public final static String INVALID_ENUM_VALUE = "invalidEnumValue";
  
  public final static String INVALID_PROPERTY = "invalidProperty";
  
  public final static String UNRESOLVED_TEMPLATE = "unresolvedTemplate";
  
  public final static String MISSING_REQUIRED_DEFAULT = "missingRequiredDefault";
  
  public final static String MISSING_REQUIRED_CUSTOM = "missingRequiredCustom";
  
  @Check
  public void checkIfRequiredAttributeIsMissing(final de.unidue.ecg.characterScript.characterScript.Character c) {
    final Template t = c.getTemplate();
    boolean _notEquals = (!Objects.equal(t, null));
    if (_notEquals) {
      EList<String> _defaults = t.getDefaults();
      final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String default_) {
          EList<Property> _properties = c.getProperties();
          Iterable<DefaultProperty> _filter = Iterables.<DefaultProperty>filter(_properties, DefaultProperty.class);
          final Function1<DefaultProperty,Boolean> _function = new Function1<DefaultProperty,Boolean>() {
            public Boolean apply(final DefaultProperty prop) {
              EClass _eClass = prop.eClass();
              String _keywordValueFor = LanguageUtil.getKeywordValueFor(_eClass);
              boolean _equals = default_.equals(_keywordValueFor);
              return Boolean.valueOf(_equals);
            }
          };
          boolean _exists = IterableExtensions.<DefaultProperty>exists(_filter, _function);
          boolean _not = (!_exists);
          if (_not) {
            String _name = t.getName();
            String _plus = ((("The attribute " + default_) + " is missing for the use of template ") + _name);
            CharacterScriptValidator.this.error(_plus, c, 
              CharacterScriptPackage.Literals.CHARACTER__TEMPLATE, CharacterScriptValidator.MISSING_REQUIRED_DEFAULT, default_);
          }
        }
      };
      IterableExtensions.<String>forEach(_defaults, _function);
      EList<CustomAttribute> _customs = t.getCustoms();
      final Function1<CustomAttribute,Boolean> _function_1 = new Function1<CustomAttribute,Boolean>() {
        public Boolean apply(final CustomAttribute it) {
          String _required = it.getRequired();
          boolean _isNullOrEmpty = Strings.isNullOrEmpty(_required);
          boolean _not = (!_isNullOrEmpty);
          return Boolean.valueOf(_not);
        }
      };
      Iterable<CustomAttribute> _filter = IterableExtensions.<CustomAttribute>filter(_customs, _function_1);
      final Procedure1<CustomAttribute> _function_2 = new Procedure1<CustomAttribute>() {
        public void apply(final CustomAttribute custom) {
          EList<Property> _properties = c.getProperties();
          Iterable<CustomProperty> _filter = Iterables.<CustomProperty>filter(_properties, CustomProperty.class);
          final Function1<CustomProperty,Boolean> _function = new Function1<CustomProperty,Boolean>() {
            public Boolean apply(final CustomProperty prop) {
              boolean _xblockexpression = false;
              {
                CustomAttributeName _customAttributeRef = prop.getCustomAttributeRef();
                EObject _eContainer = _customAttributeRef.eContainer();
                final CustomAttribute ca = ((CustomAttribute) _eContainer);
                boolean _equals = EcoreUtil2.equals(ca, custom);
                _xblockexpression = (_equals);
              }
              return Boolean.valueOf(_xblockexpression);
            }
          };
          boolean _exists = IterableExtensions.<CustomProperty>exists(_filter, _function);
          boolean _not = (!_exists);
          if (_not) {
            CustomAttributeName _caName = custom.getCaName();
            String _name = _caName.getName();
            String _plus = ("The attribute " + _name);
            String _plus_1 = (_plus + " is missing for the use of template ");
            String _name_1 = t.getName();
            String _plus_2 = (_plus_1 + _name_1);
            CustomAttributeName _caName_1 = custom.getCaName();
            String _name_2 = _caName_1.getName();
            String _createValueExpression = CharacterScriptValidator.this.createValueExpression(custom);
            CharacterScriptValidator.this.error(_plus_2, c, 
              CharacterScriptPackage.Literals.CHARACTER__TEMPLATE, CharacterScriptValidator.MISSING_REQUIRED_CUSTOM, _name_2, _createValueExpression);
          }
        }
      };
      IterableExtensions.<CustomAttribute>forEach(_filter, _function_2);
    }
  }
  
  private int numberTemplateCounter = 0;
  
  public String createValueExpression(final CustomAttribute attribute) {
    EList<EnumValue> _enumValues = attribute.getEnumValues();
    boolean _isEmpty = _enumValues.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<EnumValue> _enumValues_1 = attribute.getEnumValues();
      EnumValue _get = null;
      if (_enumValues_1!=null) {
        _get=_enumValues_1.get(0);
      }
      String _name = _get.getName();
      String _plus = ("(${" + _name);
      return (_plus + ":Enum(\'value\')})");
    }
    AttributeType _type = attribute.getType();
    String _name_1 = _type.getName();
    final String _switchValue = _name_1;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"NUMBER")) {
        _matched=true;
        int _numberTemplateCounter = this.numberTemplateCounter = (this.numberTemplateCounter + 1);
        return Integer.valueOf(_numberTemplateCounter).toString();
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"TEXT")) {
        _matched=true;
        CustomAttributeName _caName = attribute.getCaName();
        String _name_2 = _caName.getName();
        return _name_2.replaceAll("\\s+", "");
      }
    }
    return null;
  }
  
  @Check
  public void checkIfAttributeTypeIsEnum(final CustomProperty cp) {
    CustomAttributeName _customAttributeRef = cp.getCustomAttributeRef();
    EObject _eContainer = _customAttributeRef.eContainer();
    final CustomAttribute ca = ((CustomAttribute) _eContainer);
    boolean _and = false;
    EList<EnumValue> _enumValues = null;
    if (ca!=null) {
      _enumValues=ca.getEnumValues();
    }
    boolean _isEmpty = _enumValues.isEmpty();
    if (!_isEmpty) {
      _and = false;
    } else {
      EnumValue _enumValue = cp.getEnumValue();
      boolean _notEquals = (!Objects.equal(_enumValue, null));
      _and = (_isEmpty && _notEquals);
    }
    if (_and) {
      EnumValue _enumValue_1 = cp.getEnumValue();
      String _name = _enumValue_1.getName();
      String _plus = ("The value " + _name);
      String _plus_1 = (_plus + " is not available for the property ");
      CustomAttributeName _customAttributeRef_1 = cp.getCustomAttributeRef();
      String _name_1 = null;
      if (_customAttributeRef_1!=null) {
        _name_1=_customAttributeRef_1.getName();
      }
      String _plus_2 = (_plus_1 + _name_1);
      this.error(_plus_2, CharacterScriptPackage.Literals.CUSTOM_PROPERTY__ENUM_VALUE, 
        CharacterScriptValidator.INVALID_ATTRIBUTE_TYPE);
    }
  }
  
  @Check
  public void checkIfEnumValueIsValid(final CustomProperty cp) {
    CustomAttributeName _customAttributeRef = cp.getCustomAttributeRef();
    EObject _eContainer = _customAttributeRef.eContainer();
    final CustomAttribute ca = ((CustomAttribute) _eContainer);
    boolean _and = false;
    EList<EnumValue> _enumValues = ca.getEnumValues();
    boolean _isEmpty = _enumValues.isEmpty();
    boolean _not = (!_isEmpty);
    if (!_not) {
      _and = false;
    } else {
      EList<EnumValue> _enumValues_1 = ca.getEnumValues();
      EnumValue _enumValue = cp.getEnumValue();
      boolean _contains = _enumValues_1.contains(_enumValue);
      boolean _not_1 = (!_contains);
      _and = (_not && _not_1);
    }
    if (_and) {
      CustomAttributeName _customAttributeRef_1 = cp.getCustomAttributeRef();
      String _name = null;
      if (_customAttributeRef_1!=null) {
        _name=_customAttributeRef_1.getName();
      }
      String _plus = ("This value is not available for the property " + _name);
      this.error(_plus, 
        CharacterScriptPackage.Literals.CUSTOM_PROPERTY__ENUM_VALUE, CharacterScriptValidator.INVALID_ENUM_VALUE);
    }
  }
  
  @Check
  public void checkCharacterAttributes(final de.unidue.ecg.characterScript.characterScript.Character c) {
    Template _template = c.getTemplate();
    boolean _equals = Objects.equal(_template, null);
    if (_equals) {
      EList<Property> _properties = c.getProperties();
      final Procedure2<Property,Integer> _function = new Procedure2<Property,Integer>() {
        public void apply(final Property it, final Integer i) {
          boolean _matched = false;
          if (!_matched) {
            if (it instanceof CustomProperty) {
              _matched=true;
              CustomAttributeName _customAttributeRef = ((CustomProperty)it).getCustomAttributeRef();
              EObject _eContainer = _customAttributeRef.eContainer();
              EObject _eContainer_1 = _eContainer.eContainer();
              if ((_eContainer_1 instanceof Template)) {
                CustomAttributeName _customAttributeRef_1 = ((CustomProperty)it).getCustomAttributeRef();
                EObject _eContainer_2 = _customAttributeRef_1.eContainer();
                EObject _eContainer_3 = _eContainer_2.eContainer();
                final Template template = ((Template) _eContainer_3);
                CustomAttributeName _customAttributeRef_2 = ((CustomProperty)it).getCustomAttributeRef();
                String _name = null;
                if (_customAttributeRef_2!=null) {
                  _name=_customAttributeRef_2.getName();
                }
                String _plus = ("The property " + _name);
                String _plus_1 = (_plus + " is defined in the template ");
                String _name_1 = template.getName();
                String _plus_2 = (_plus_1 + _name_1);
                String _plus_3 = (_plus_2 + ". In order to use it, explicitly refer to this template.");
                CharacterScriptValidator.this.error(_plus_3, 
                  CharacterScriptPackage.Literals.CHARACTER__PROPERTIES, (i).intValue(), CharacterScriptValidator.INVALID_ATTRIBUTE);
              }
            }
          }
        }
      };
      IterableExtensions.<Property>forEach(_properties, _function);
    }
  }
  
  @Check
  public void checkTemplateAccordance(final de.unidue.ecg.characterScript.characterScript.Character c) {
    Template _template = c.getTemplate();
    boolean _notEquals = (!Objects.equal(_template, null));
    if (_notEquals) {
      final Template template = c.getTemplate();
      final EList<CustomAttribute> allowedCustoms = template.getCustoms();
      EList<Property> _properties = c.getProperties();
      final Procedure2<Property,Integer> _function = new Procedure2<Property,Integer>() {
        public void apply(final Property it, final Integer i) {
          boolean _matched = false;
          if (!_matched) {
            if (it instanceof CustomProperty) {
              boolean _isValidCustom = CharacterScriptValidator.this.isValidCustom(((CustomProperty)it), allowedCustoms);
              boolean _not = (!_isValidCustom);
              if (_not) {
                _matched=true;
                String _name = template.getName();
                String _plus = ("The used template " + _name);
                String _plus_1 = (_plus + " does not provide this property");
                CharacterScriptValidator.this.error(_plus_1, 
                  CharacterScriptPackage.Literals.CHARACTER__PROPERTIES, (i).intValue(), CharacterScriptValidator.INVALID_PROPERTY);
              }
            }
          }
        }
      };
      IterableExtensions.<Property>forEach(_properties, _function);
    }
  }
  
  @Check
  public void checkForDoubledAttributes(final de.unidue.ecg.characterScript.characterScript.Character c) {
    EList<Property> _properties = c.getProperties();
    final Procedure1<Property> _function = new Procedure1<Property>() {
      public void apply(final Property it) {
        boolean _matched = false;
        if (!_matched) {
          if (it instanceof DefaultProperty) {
            _matched=true;
            final DefaultProperty outer = ((DefaultProperty)it);
            EList<Property> _properties = c.getProperties();
            Iterable<DefaultProperty> _filter = Iterables.<DefaultProperty>filter(_properties, DefaultProperty.class);
            final Function1<DefaultProperty,Boolean> _function = new Function1<DefaultProperty,Boolean>() {
              public Boolean apply(final DefaultProperty it) {
                boolean _equals = EcoreUtil2.equals(it, outer);
                boolean _not = (!_equals);
                return Boolean.valueOf(_not);
              }
            };
            Iterable<DefaultProperty> _filter_1 = IterableExtensions.<DefaultProperty>filter(_filter, _function);
            final Function1<DefaultProperty,Boolean> _function_1 = new Function1<DefaultProperty,Boolean>() {
              public Boolean apply(final DefaultProperty it) {
                EClass _eClass = it.eClass();
                EClass _eClass_1 = outer.eClass();
                boolean _equals = Objects.equal(_eClass, _eClass_1);
                return Boolean.valueOf(_equals);
              }
            };
            final DefaultProperty doubled = IterableExtensions.<DefaultProperty>findFirst(_filter_1, _function_1);
            boolean _notEquals = (!Objects.equal(doubled, null));
            if (_notEquals) {
              EList<Property> _properties_1 = c.getProperties();
              final int index = _properties_1.indexOf(doubled);
              CharacterScriptValidator.this.error("You cannot use a property twice", 
                CharacterScriptPackage.Literals.CHARACTER__PROPERTIES, index, CharacterScriptValidator.INVALID_PROPERTY);
            }
          }
        }
        if (!_matched) {
          if (it instanceof CustomProperty) {
            _matched=true;
            final CustomProperty outer = ((CustomProperty)it);
            EList<Property> _properties = c.getProperties();
            Iterable<CustomProperty> _filter = Iterables.<CustomProperty>filter(_properties, CustomProperty.class);
            final Function1<CustomProperty,Boolean> _function = new Function1<CustomProperty,Boolean>() {
              public Boolean apply(final CustomProperty it) {
                boolean _equals = EcoreUtil2.equals(it, outer);
                boolean _not = (!_equals);
                return Boolean.valueOf(_not);
              }
            };
            Iterable<CustomProperty> _filter_1 = IterableExtensions.<CustomProperty>filter(_filter, _function);
            final Function1<CustomProperty,Boolean> _function_1 = new Function1<CustomProperty,Boolean>() {
              public Boolean apply(final CustomProperty it) {
                CustomAttributeName _customAttributeRef = it.getCustomAttributeRef();
                CustomAttributeName _customAttributeRef_1 = outer.getCustomAttributeRef();
                boolean _equals = EcoreUtil2.equals(_customAttributeRef, _customAttributeRef_1);
                return Boolean.valueOf(_equals);
              }
            };
            final CustomProperty doubled = IterableExtensions.<CustomProperty>findFirst(_filter_1, _function_1);
            boolean _notEquals = (!Objects.equal(doubled, null));
            if (_notEquals) {
              EList<Property> _properties_1 = c.getProperties();
              final int index = _properties_1.indexOf(doubled);
              CharacterScriptValidator.this.error("You cannot use a property twice", 
                CharacterScriptPackage.Literals.CHARACTER__PROPERTIES, index, CharacterScriptValidator.INVALID_PROPERTY);
            }
          }
        }
      }
    };
    IterableExtensions.<Property>forEach(_properties, _function);
  }
  
  @Check
  public void checkImports(final de.unidue.ecg.characterScript.characterScript.Character c) {
    Template _template = c.getTemplate();
    boolean _notEquals = (!Objects.equal(_template, null));
    if (_notEquals) {
      final Template template = c.getTemplate();
      EObject _eContainer = c.eContainer();
      final Characters root = ((Characters) _eContainer);
      final EList<Import> imports = root.getImports();
      final Function1<Import,Boolean> _function = new Function1<Import,Boolean>() {
        public Boolean apply(final Import it) {
          String _importedNamespace = it.getImportedNamespace();
          String _name = template.getName();
          boolean _equals = _importedNamespace.equals(_name);
          return Boolean.valueOf(_equals);
        }
      };
      final Import matchedImport = IterableExtensions.<Import>findFirst(imports, _function);
      boolean _equals = Objects.equal(matchedImport, null);
      if (_equals) {
        final EList<Template> templates = root.getTemplates();
        final Function1<Template,Boolean> _function_1 = new Function1<Template,Boolean>() {
          public Boolean apply(final Template it) {
            String _name = it.getName();
            String _name_1 = template.getName();
            boolean _equals = _name.equals(_name_1);
            return Boolean.valueOf(_equals);
          }
        };
        final Template matchedTemplate = IterableExtensions.<Template>findFirst(templates, _function_1);
        boolean _equals_1 = Objects.equal(matchedTemplate, null);
        if (_equals_1) {
          String _name = template.getName();
          String _plus = ("Missing import for template " + _name);
          String _name_1 = template.getName();
          this.error(_plus, 
            CharacterScriptPackage.Literals.CHARACTER__TEMPLATE, CharacterScriptValidator.UNRESOLVED_TEMPLATE, _name_1);
        }
      }
    }
  }
  
  public boolean isValidCustom(final CustomProperty property, final EList<CustomAttribute> list) {
    boolean _xblockexpression = false;
    {
      CustomAttributeName _customAttributeRef = property.getCustomAttributeRef();
      EObject _eContainer = _customAttributeRef.eContainer();
      boolean _contains = list.contains(_eContainer);
      if (_contains) {
        return true;
      }
      _xblockexpression = (false);
    }
    return _xblockexpression;
  }
  
  protected boolean _isValidDefault(final FullName property, final EList<String> list) {
    boolean _xblockexpression = false;
    {
      boolean _contains = list.contains("full name");
      if (_contains) {
        return true;
      }
      _xblockexpression = (false);
    }
    return _xblockexpression;
  }
  
  protected boolean _isValidDefault(final Age property, final EList<String> list) {
    boolean _xblockexpression = false;
    {
      boolean _contains = list.contains("age");
      if (_contains) {
        return true;
      }
      _xblockexpression = (false);
    }
    return _xblockexpression;
  }
  
  protected boolean _isValidDefault(final Sex property, final EList<String> list) {
    boolean _xblockexpression = false;
    {
      boolean _contains = list.contains("sex");
      if (_contains) {
        return true;
      }
      _xblockexpression = (false);
    }
    return _xblockexpression;
  }
  
  protected boolean _isValidDefault(final Description property, final EList<String> list) {
    boolean _xblockexpression = false;
    {
      boolean _contains = list.contains("description");
      if (_contains) {
        return true;
      }
      _xblockexpression = (false);
    }
    return _xblockexpression;
  }
  
  protected boolean _isValidDefault(final Type property, final EList<String> list) {
    boolean _xblockexpression = false;
    {
      boolean _contains = list.contains("type");
      if (_contains) {
        return true;
      }
      _xblockexpression = (false);
    }
    return _xblockexpression;
  }
  
  protected boolean _isValidDefault(final DefaultProperty property, final EList<String> list) {
    Class<? extends DefaultProperty> _class = property.getClass();
    String _plus = ("Missing evaluation for this default property: " + _class);
    RuntimeException _runtimeException = new RuntimeException(_plus);
    throw _runtimeException;
  }
  
  public boolean isValidDefault(final DefaultProperty property, final EList<String> list) {
    if (property instanceof Age) {
      return _isValidDefault((Age)property, list);
    } else if (property instanceof Description) {
      return _isValidDefault((Description)property, list);
    } else if (property instanceof FullName) {
      return _isValidDefault((FullName)property, list);
    } else if (property instanceof Sex) {
      return _isValidDefault((Sex)property, list);
    } else if (property instanceof Type) {
      return _isValidDefault((Type)property, list);
    } else if (property != null) {
      return _isValidDefault(property, list);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(property, list).toString());
    }
  }
}
