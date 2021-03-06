/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package model;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class NameGroup extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"NameGroup\",\"namespace\":\"model\",\"fields\":[{\"name\":\"group\",\"type\":\"int\"},{\"name\":\"SlStudenr\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public int group;
  @Deprecated public int SlStudenr;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public NameGroup() {}

  /**
   * All-args constructor.
   */
  public NameGroup(java.lang.Integer group, java.lang.Integer SlStudenr) {
    this.group = group;
    this.SlStudenr = SlStudenr;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return group;
    case 1: return SlStudenr;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: group = (java.lang.Integer)value$; break;
    case 1: SlStudenr = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'group' field.
   */
  public java.lang.Integer getGroup() {
    return group;
  }

  /**
   * Sets the value of the 'group' field.
   * @param value the value to set.
   */
  public void setGroup(java.lang.Integer value) {
    this.group = value;
  }

  /**
   * Gets the value of the 'SlStudenr' field.
   */
  public java.lang.Integer getSlStudenr() {
    return SlStudenr;
  }

  /**
   * Sets the value of the 'SlStudenr' field.
   * @param value the value to set.
   */
  public void setSlStudenr(java.lang.Integer value) {
    this.SlStudenr = value;
  }

  /** Creates a new NameGroup RecordBuilder */
  public static model.NameGroup.Builder newBuilder() {
    return new model.NameGroup.Builder();
  }
  
  /** Creates a new NameGroup RecordBuilder by copying an existing Builder */
  public static model.NameGroup.Builder newBuilder(model.NameGroup.Builder other) {
    return new model.NameGroup.Builder(other);
  }
  
  /** Creates a new NameGroup RecordBuilder by copying an existing NameGroup instance */
  public static model.NameGroup.Builder newBuilder(model.NameGroup other) {
    return new model.NameGroup.Builder(other);
  }
  
  /**
   * RecordBuilder for NameGroup instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<NameGroup>
    implements org.apache.avro.data.RecordBuilder<NameGroup> {

    private int group;
    private int SlStudenr;

    /** Creates a new Builder */
    private Builder() {
      super(model.NameGroup.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(model.NameGroup.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.group)) {
        this.group = data().deepCopy(fields()[0].schema(), other.group);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.SlStudenr)) {
        this.SlStudenr = data().deepCopy(fields()[1].schema(), other.SlStudenr);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing NameGroup instance */
    private Builder(model.NameGroup other) {
            super(model.NameGroup.SCHEMA$);
      if (isValidValue(fields()[0], other.group)) {
        this.group = data().deepCopy(fields()[0].schema(), other.group);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.SlStudenr)) {
        this.SlStudenr = data().deepCopy(fields()[1].schema(), other.SlStudenr);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'group' field */
    public java.lang.Integer getGroup() {
      return group;
    }
    
    /** Sets the value of the 'group' field */
    public model.NameGroup.Builder setGroup(int value) {
      validate(fields()[0], value);
      this.group = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'group' field has been set */
    public boolean hasGroup() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'group' field */
    public model.NameGroup.Builder clearGroup() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'SlStudenr' field */
    public java.lang.Integer getSlStudenr() {
      return SlStudenr;
    }
    
    /** Sets the value of the 'SlStudenr' field */
    public model.NameGroup.Builder setSlStudenr(int value) {
      validate(fields()[1], value);
      this.SlStudenr = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'SlStudenr' field has been set */
    public boolean hasSlStudenr() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'SlStudenr' field */
    public model.NameGroup.Builder clearSlStudenr() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public NameGroup build() {
      try {
        NameGroup record = new NameGroup();
        record.group = fieldSetFlags()[0] ? this.group : (java.lang.Integer) defaultValue(fields()[0]);
        record.SlStudenr = fieldSetFlags()[1] ? this.SlStudenr : (java.lang.Integer) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
