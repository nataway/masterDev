/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package model;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Customer extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Customer\",\"namespace\":\"model\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"num_order\",\"type\":\"int\"},{\"name\":\"Age\",\"type\":\"int\"},{\"name\":\"tel\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence id;
  @Deprecated public int num_order;
  @Deprecated public int Age;
  @Deprecated public java.lang.CharSequence tel;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public Customer() {}

  /**
   * All-args constructor.
   */
  public Customer(java.lang.CharSequence id, java.lang.Integer num_order, java.lang.Integer Age, java.lang.CharSequence tel) {
    this.id = id;
    this.num_order = num_order;
    this.Age = Age;
    this.tel = tel;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return num_order;
    case 2: return Age;
    case 3: return tel;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: num_order = (java.lang.Integer)value$; break;
    case 2: Age = (java.lang.Integer)value$; break;
    case 3: tel = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'num_order' field.
   */
  public java.lang.Integer getNumOrder() {
    return num_order;
  }

  /**
   * Sets the value of the 'num_order' field.
   * @param value the value to set.
   */
  public void setNumOrder(java.lang.Integer value) {
    this.num_order = value;
  }

  /**
   * Gets the value of the 'Age' field.
   */
  public java.lang.Integer getAge() {
    return Age;
  }

  /**
   * Sets the value of the 'Age' field.
   * @param value the value to set.
   */
  public void setAge(java.lang.Integer value) {
    this.Age = value;
  }

  /**
   * Gets the value of the 'tel' field.
   */
  public java.lang.CharSequence getTel() {
    return tel;
  }

  /**
   * Sets the value of the 'tel' field.
   * @param value the value to set.
   */
  public void setTel(java.lang.CharSequence value) {
    this.tel = value;
  }

  /** Creates a new Customer RecordBuilder */
  public static model.Customer.Builder newBuilder() {
    return new model.Customer.Builder();
  }
  
  /** Creates a new Customer RecordBuilder by copying an existing Builder */
  public static model.Customer.Builder newBuilder(model.Customer.Builder other) {
    return new model.Customer.Builder(other);
  }
  
  /** Creates a new Customer RecordBuilder by copying an existing Customer instance */
  public static model.Customer.Builder newBuilder(model.Customer other) {
    return new model.Customer.Builder(other);
  }
  
  /**
   * RecordBuilder for Customer instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Customer>
    implements org.apache.avro.data.RecordBuilder<Customer> {

    private java.lang.CharSequence id;
    private int num_order;
    private int Age;
    private java.lang.CharSequence tel;

    /** Creates a new Builder */
    private Builder() {
      super(model.Customer.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(model.Customer.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.num_order)) {
        this.num_order = data().deepCopy(fields()[1].schema(), other.num_order);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Age)) {
        this.Age = data().deepCopy(fields()[2].schema(), other.Age);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.tel)) {
        this.tel = data().deepCopy(fields()[3].schema(), other.tel);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Customer instance */
    private Builder(model.Customer other) {
            super(model.Customer.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.num_order)) {
        this.num_order = data().deepCopy(fields()[1].schema(), other.num_order);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.Age)) {
        this.Age = data().deepCopy(fields()[2].schema(), other.Age);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.tel)) {
        this.tel = data().deepCopy(fields()[3].schema(), other.tel);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.CharSequence getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public model.Customer.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'id' field */
    public model.Customer.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'num_order' field */
    public java.lang.Integer getNumOrder() {
      return num_order;
    }
    
    /** Sets the value of the 'num_order' field */
    public model.Customer.Builder setNumOrder(int value) {
      validate(fields()[1], value);
      this.num_order = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'num_order' field has been set */
    public boolean hasNumOrder() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'num_order' field */
    public model.Customer.Builder clearNumOrder() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'Age' field */
    public java.lang.Integer getAge() {
      return Age;
    }
    
    /** Sets the value of the 'Age' field */
    public model.Customer.Builder setAge(int value) {
      validate(fields()[2], value);
      this.Age = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'Age' field has been set */
    public boolean hasAge() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'Age' field */
    public model.Customer.Builder clearAge() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'tel' field */
    public java.lang.CharSequence getTel() {
      return tel;
    }
    
    /** Sets the value of the 'tel' field */
    public model.Customer.Builder setTel(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.tel = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'tel' field has been set */
    public boolean hasTel() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'tel' field */
    public model.Customer.Builder clearTel() {
      tel = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public Customer build() {
      try {
        Customer record = new Customer();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.num_order = fieldSetFlags()[1] ? this.num_order : (java.lang.Integer) defaultValue(fields()[1]);
        record.Age = fieldSetFlags()[2] ? this.Age : (java.lang.Integer) defaultValue(fields()[2]);
        record.tel = fieldSetFlags()[3] ? this.tel : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
